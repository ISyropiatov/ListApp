package com.applicat.listapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.applicat.listapp.databinding.FragmentDetailBinding
import com.applicat.listapp.databinding.FragmentStartBinding
import com.bumptech.glide.Glide


class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val dataModel: ModelOfFilm? = arguments?.getParcelable("data")
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        binding.textViewForDetail.text= dataModel?.details
        binding.textViewForName.text= dataModel?.name
        Glide.with(requireContext())
            .load(dataModel?.image)
            .circleCrop()
            .into(binding.imageForDetail)
        return binding.root
    }
}