package com.ydhnwb.shelflore.adapters

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.ydhnwb.shelflore.DetailActivity
import com.ydhnwb.shelflore.models.Volume
import com.ydhnwb.shelflore.utils.Constants
import kotlinx.android.synthetic.main.list_item_search.view.*
import androidx.core.app.ActivityOptionsCompat
import androidx.core.content.ContextCompat.startActivity



class SearchAdapter (private var books : List<Volume>, private var context : Context) : RecyclerView.Adapter<SearchAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(LayoutInflater.from(parent.context).inflate(
        com.ydhnwb.shelflore.R.layout.list_item_search, parent, false))

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
                val activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(context as Activity, itemView.item_book_image, "image_transition")
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra("VOLUME", book.volumeInfo)
                startActivity(context, intent, activityOptionsCompat.toBundle())
            }
        }
    }
}