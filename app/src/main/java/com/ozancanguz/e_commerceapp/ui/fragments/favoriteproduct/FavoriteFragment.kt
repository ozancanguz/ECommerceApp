package com.ozancanguz.e_commerceapp.ui.fragments.favoriteproduct

import android.content.DialogInterface
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ozancanguz.e_commerceapp.R
import com.ozancanguz.e_commerceapp.data.adapters.FavoritesProductsAdapter
import com.ozancanguz.e_commerceapp.databinding.FragmentFavoriteBinding
import com.ozancanguz.e_commerceapp.viewmodel.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.favorites_deleted_toast.*


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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId ==R.id.delete_all_menu){


            val builder = AlertDialog.Builder(requireContext())

            builder.setMessage("Do you want to delete all favorites ?")

            builder.setTitle("Delete all favorites !")

            builder.setCancelable(false)

            builder.setPositiveButton("Yes",
                DialogInterface.OnClickListener { dialog: DialogInterface?, which: Int ->
                    productViewModel.deleteAll()
                    Toast(requireContext()).apply {
                        duration=Toast.LENGTH_LONG
                        setGravity(Gravity.CENTER,0,0)
                        view=layoutInflater.inflate(R.layout.favorites_deleted_toast,favoritesdeleted)
                    }.show()


                })

            builder.setNegativeButton("No",
                DialogInterface.OnClickListener { dialog: DialogInterface, which: Int ->

                    dialog.cancel()
                } )

            val alertDialog = builder.create()
            alertDialog.show()



        }

        return super.onOptionsItemSelected(item)
    }




}