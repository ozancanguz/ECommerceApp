package com.ozancanguz.e_commerceapp.ui.fragments.productdetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.ozancanguz.e_commerceapp.R
import com.ozancanguz.e_commerceapp.databinding.FragmentFavoriteBinding
import com.ozancanguz.e_commerceapp.databinding.FragmentProductDetailBinding
import com.ozancanguz.e_commerceapp.util.Util.Companion.loadImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDetailFragment : Fragment() {
    private var _binding: FragmentProductDetailBinding? = null

    private val binding get() = _binding!!

    private val args:ProductDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProductDetailBinding.inflate(inflater, container, false)
        val view = binding.root


        updateUi()

        return view
    }

    private fun updateUi() {
        binding.detailsImage.loadImage(args.currentProduct.imageUrl)
        binding.detailsTitle.text=args.currentProduct.title
        binding.detailsPrice.text=args.currentProduct.price.toString() + " USD"
        binding.detailsFullDesc.text=args.currentProduct.description
    }


}