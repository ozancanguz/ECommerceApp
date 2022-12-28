package com.ozancanguz.e_commerceapp.ui.fragments.favoriteproduct

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ozancanguz.e_commerceapp.R
import com.ozancanguz.e_commerceapp.data.adapters.FavoritesProductsAdapter
import com.ozancanguz.e_commerceapp.databinding.FragmentFavoriteBinding
import com.ozancanguz.e_commerceapp.viewmodel.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : Fragment() {
    private var _binding: FragmentFavoriteBinding? = null

    private val binding get() = _binding!!

    private val productViewModel:ProductViewModel by viewModels()
   private val favoriteListAdapter=FavoritesProductsAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        val view = binding.root

        // set up rv
        binding.recyclerView.layoutManager=LinearLayoutManager(requireContext())
        binding.recyclerView.adapter=favoriteListAdapter

        // update ui
        observeLiveData()

        // set menu

        setHasOptionsMenu(true)




        return view
    }

    private fun observeLiveData() {
        productViewModel.favProductList.observe(viewLifecycleOwner, Observer {
                  favoriteListAdapter.setData(it)
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        inflater.inflate(R.menu.deleteallmenu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }




}