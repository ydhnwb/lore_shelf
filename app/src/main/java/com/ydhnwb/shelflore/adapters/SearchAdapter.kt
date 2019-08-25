package com.ydhnwb.shelflore.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.ydhnwb.shelflore.DetailActivity
import com.ydhnwb.shelflore.R
import com.ydhnwb.shelflore.models.Volume
import com.ydhnwb.shelflore.utils.Constants
import kotlinx.android.synthetic.main.list_item_search.view.*

class SearchAdapter (private var books : List<Volume>, private var context : Context) : RecyclerView.Adapter<SearchAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_search, parent, false))

    override fun getItemCount() = books.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(books[position], context)

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun bind(book : Volume, context: Context){
            itemView.item_book_name.text = book.volumeInfo.title
            itemView.item_book_image.load(Constants.getBetterThumb(book.volumeInfo.imageLink.thumbnail)){
                crossfade(true)
                crossfade(800)
            }
            itemView.item_book_ratetext.text = "(${book.volumeInfo.ratingsCount})"
            itemView.item_book_rating.rating = book.volumeInfo.averageRating
            itemView.setOnClickListener {
                context.startActivity(Intent(context, DetailActivity::class.java).apply {
                    putExtra("VOLUME", book.volumeInfo)
                })
            }
        }
    }
}