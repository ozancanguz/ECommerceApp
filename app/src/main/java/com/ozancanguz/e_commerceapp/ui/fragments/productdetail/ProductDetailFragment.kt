package com.ozancanguz.e_commerceapp.ui.fragments.productdetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ozancanguz.e_commerceapp.R
import com.ozancanguz.e_commerceapp.databinding.FragmentFavoriteBinding
import com.ozancanguz.e_commerceapp.databinding.FragmentProductDetailBinding


class ProductDetailFragment : Fragment() {
    private var _binding: FragmentProductDetailBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProductDetailBinding.inflate(inflater, container, false)
        val view = binding.root


        return view
    }


}