package com.ozancanguz.e_commerceapp.data.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ozancanguz.e_commerceapp.R
import com.ozancanguz.e_commerceapp.data.db.entities.FavoritesEntity
import com.ozancanguz.e_commerceapp.util.Util.Companion.loadImage
import kotlinx.android.synthetic.main.favproducts_row_layout.view.*

class FavoritesProductsAdapter:RecyclerView.Adapter<FavoritesProductsAdapter.FavViewHolder>() {


    class FavViewHolder(view: View):RecyclerView.ViewHolder(view) {

    }

    var favoritesList= emptyList<FavoritesEntity>()

    fun setData(newData:List<FavoritesEntity>){
        this.favoritesList=newData
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavViewHolder {
        val inflater= LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.favproducts_row_layout,parent,false)
        return FavViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavViewHolder, position: Int) {
       val currentFav=favoritesList[position]
        holder.itemView.favproductImage.loadImage(currentFav.products.imageUrl)
        holder.itemView.favproductDescription.text=currentFav.products.description
        holder.itemView.favproductName.text=currentFav.products.title
        holder.itemView.favproductPrice.text=currentFav.products.price.toString() +" USD"


    }

    override fun getItemCount(): Int {
        return favoritesList.size
    }


}