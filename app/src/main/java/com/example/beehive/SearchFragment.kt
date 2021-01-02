package com.example.beehive

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.beehive.adapters.BeehiveRecyclerAdapter
import com.example.beehive.data.BeeRepo
import com.example.beehive.data.Beehive
import com.example.beehive.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSearch.setOnClickListener {
            onButtonPressed()
        }
    }

    private fun onButtonPressed() {
        binding.btnSearch.visibility = View.GONE
        binding.edtSearch.visibility = View.GONE
        binding.recSearch.visibility = View.VISIBLE
        setupRecView(filterData(binding.edtSearch.text.toString()))
    }

    private fun filterData(predicate: String): List<Beehive> = BeeRepo.beehives.filter {
        predicate.trim().let{ pred ->
            it.area.contains(pred, true)
                    || it.location.contains(pred, true)
                    || it.ownerAddress.contains(pred, true)
                    || it.ownerNames.contains(pred, true)
                    || it.beehiveId.contains(pred, true)
        }
    }

    private fun setupRecView(data: List<Beehive>) {
        val beehiveAdapter = BeehiveRecyclerAdapter(data)
        binding.recSearch.apply {
            layoutManager = LinearLayoutManager(
                requireContext(),
                RecyclerView.VERTICAL,
                false
            )
            adapter = beehiveAdapter
        }

    }


}