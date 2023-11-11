package com.applicat.listapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.applicat.listapp.databinding.FragmentStartBinding


class StartFragment : Fragment() {
    private lateinit var binding: FragmentStartBinding
    private val list = mutableListOf(
        ModelOfFilm(
            "https://upload.wikimedia.org/wikipedia/commons/thumb/6/6c/Star_Wars_Logo.svg/1200px-Star_Wars_Logo.svg.png",
            "Star wars",
            "science fiction",
            "Star Wars is a renowned epic science fiction media franchise that narrates various conflicts and wars in a distant galaxy. Created by George Lucas, it has become a cultural phenomenon since its inception in 1977. "
        ), ModelOfFilm(
            "https://m.media-amazon.com/images/M/MV5BZmY5ZTk3ZDMtZjA1MS00NzU4LTk5ZDItYmNhOTkxMGYxMjRlXkEyXkFqcGdeQXVyMjM4MzQ4OTQ@._V1_.jpg",
            "Indiana jones",
            "Adventures",
            "Indiana Jones is a fictional character known for his adventures in archaeology and treasure hunting, created by George Lucas and Steven Spielberg."
        )
    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclers.setHasFixedSize(true)
        binding.recyclers.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclers.adapter = CustomAdapter(
            requireActivity(), list
        ) {
            val action = StartFragmentDirections.actionStartFragmentToDetailFragment2(list[it])
            findNavController().navigate(action)
        }
    }
}