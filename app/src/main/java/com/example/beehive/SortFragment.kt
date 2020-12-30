package com.example.beehive


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.beehive.databinding.FragmentSortBinding


class SortFragment : Fragment() {

    private lateinit var binding: FragmentSortBinding
    private lateinit var criteriaSelected: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSortBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setExposedDropdownMenu()
        updateCriteriaState()
        binding.btnSort.setOnClickListener {
            onButtonPressed()
        }
    }

    private fun setExposedDropdownMenu() {
        binding.filledExposedDropdown.apply {
            setAdapter(
                ArrayAdapter(
                    requireContext(),
                    R.layout.dropdown_item,
                    resources.getStringArray(R.array.criteria)
                )
            )
        }
    }

    private fun updateCriteriaState() {
        binding.filledExposedDropdown.setOnItemClickListener { adapter, _, position, _ ->
            criteriaSelected = adapter.getItemAtPosition(position) as String
        }
    }

    private fun onButtonPressed() {
        //the criteria the user selected for sorting
        criteriaSelected
        //TODO()
    }

}