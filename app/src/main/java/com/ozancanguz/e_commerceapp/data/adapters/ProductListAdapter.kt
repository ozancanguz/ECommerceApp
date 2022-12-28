package com.ozancanguz.e_commerceapp.data.adapters

import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.ozancanguz.e_commerceapp.R
import com.ozancanguz.e_commerceapp.data.model.Products
import com.ozancanguz.e_commerceapp.data.model.ProductsItem
import com.ozancanguz.e_commerceapp.ui.fragments.productlist.ProductListFragmentDirections
import com.ozancanguz.e_commerceapp.util.Util.Companion.loadImage
import kotlinx.android.synthetic.main.add_to_cart.*
import kotlinx.android.synthetic.main.products_row_layout.view.*

class ProductListAdapter:RecyclerView.Adapter<ProductListAdapter.ProductViewHolder>() {

    var productList= emptyList<ProductsItem>()

    fun setData(newData:Products){
        this.productList=newData
        notifyDataSetChanged()
    }


    class ProductViewHolder(view: View):RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.products_row_layout,parent,false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
       val currentProduct=productList[position]
        holder.itemView.productName.text=currentProduct.title
        holder.itemView.productDescription.text=currentProduct.description
        holder.itemView.productPrice.text=currentProduct.price.toString() +" USD"

        // image loading with glide
        holder.itemView.productImage.loadImage(currentProduct.imageUrl)


        // sending data to details
        holder.itemView.setOnClickListener {
            val action=ProductListFragmentDirections.actionProductListFragmentToProductDetailFragment(currentProduct)
            holder.itemView.findNavController().navigate(action)
        }

        holder.itemView.view_wishlist_icon.setOnClickListener {
            holder.itemView.view_wishlist_icon.findNavController()
                .navigate(R.id.action_productListFragment_to_favoriteFragment)
        }


    }

    override fun getItemCount(): Int {
       return productList.size
    }


}