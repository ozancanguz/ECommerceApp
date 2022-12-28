package com.ozancanguz.e_commerceapp.ui.fragments.productdetail

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.ozancanguz.e_commerceapp.R
import com.ozancanguz.e_commerceapp.data.db.entities.FavoritesEntity
import com.ozancanguz.e_commerceapp.databinding.FragmentProductDetailBinding
import com.ozancanguz.e_commerceapp.util.Util.Companion.loadImage
import com.ozancanguz.e_commerceapp.viewmodel.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.add_to_cart.*

@AndroidEntryPoint
class ProductDetailFragment : Fragment() {
    private var _binding: FragmentProductDetailBinding? = null

    private val binding get() = _binding!!

    private val productViewModel:ProductViewModel by viewModels()
    private val args:ProductDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProductDetailBinding.inflate(inflater, container, false)
        val view = binding.root

       // update ui
        updateUi()

        // add to card
        addCard()

        // set menu
        setHasOptionsMenu(true)

        return view
    }

    private fun updateUi() {
        binding.detailsImage.loadImage(args.currentProduct.imageUrl)
        binding.detailsTitle.text=args.currentProduct.title
        binding.detailsPrice.text=args.currentProduct.price.toString() + " USD"
        binding.detailsFullDesc.text=args.currentProduct.description
    }

    private fun addCard(){
        binding.addToCartButton.setOnClickListener {
            Toast(requireContext()).apply {
                duration=Toast.LENGTH_LONG
                setGravity(Gravity.CENTER,0,0)
                view=layoutInflater.inflate(R.layout.add_to_cart,ll)
            }.show()

        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.savetofav,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId==R.id.savetofavmenu){
          saveToFavorites(item)
          Toast.makeText(requireContext(),"Save to favorites",Toast.LENGTH_LONG).show()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun changeMenuItemColor(item: MenuItem, color: Int) {
        item.icon?.setTint(ContextCompat.getColor(requireContext(),color))
    }


    fun saveToFavorites(item: MenuItem){
        var favoritesEntity=FavoritesEntity(0,args.currentProduct)
        productViewModel.insertFavoriteProduct(favoritesEntity)
        changeMenuItemColor(item,R.color.yellow)
    }








}