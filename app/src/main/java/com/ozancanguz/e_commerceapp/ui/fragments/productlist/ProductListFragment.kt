package com.ozancanguz.e_commerceapp.ui.fragments.productlist

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ozancanguz.e_commerceapp.data.adapters.ProductListAdapter
import com.ozancanguz.e_commerceapp.databinding.FragmentProductListBinding
import com.ozancanguz.e_commerceapp.viewmodel.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductListFragment : Fragment() {
    private var _binding: FragmentProductListBinding? = null

    private val binding get() = _binding!!

    private val productviewmodel:ProductViewModel by viewModels()

    private val productListAdapter=ProductListAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProductListBinding.inflate(inflater, container, false)
        val view = binding.root


        // observeLiveData
        observeLiveData()

        // set up RV
        setupRv()

        return view
    }


    private fun setupRv() {
        binding.recyclerView2.layoutManager=LinearLayoutManager(requireContext())
        binding.recyclerView2.adapter=productListAdapter
    }

    private fun observeLiveData() {
        productviewmodel.requestProductData()
        productviewmodel.productList.observe(viewLifecycleOwner, Observer { products ->
            Log.d("list",""+products)
            productListAdapter.setData(products)


        })
    }


}