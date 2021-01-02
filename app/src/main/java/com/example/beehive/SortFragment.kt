package com.example.beehive


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.beehive.adapters.BeehiveRecyclerAdapter
import com.example.beehive.data.BeeRepo
import com.example.beehive.data.Beehive
import com.example.beehive.databinding.FragmentSortBinding


class SortFragment : Fragment() {

    private lateinit var binding: FragmentSortBinding
    private var criteriaSelected = 0

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
        binding.filledExposedDropdown.setOnItemClickListener { _, _, position, _ ->
            criteriaSelected = position
        }
    }

    private fun onButtonPressed() {
        binding.btnSort.visibility = View.GONE
        binding.layoutCriteria.visibility = View.GONE
        binding.recSort.visibility = View.VISIBLE
        setupRecView(sortData(criteriaSelected))
    }

    private fun sortData(predicate: Int): List<Beehive> = BeeRepo.beehives.sortedBy {
        when(predicate){
            0 -> it.ownerNames
            1 -> it.beehiveId
            2 -> it.location
            else -> it.location
        }
    }

    private fun setupRecView(data: List<Beehive>) {
        val beehiveAdapter = BeehiveRecyclerAdapter(data)
        binding.recSort.apply {
            layoutManager = LinearLayoutManager(
                requireContext(),
                RecyclerView.VERTICAL,
                false
            )
            adapter = beehiveAdapter
        }

    }

}