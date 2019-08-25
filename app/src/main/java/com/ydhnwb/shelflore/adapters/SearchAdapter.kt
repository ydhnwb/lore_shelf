package com.ydhnwb.shelflore.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.ydhnwb.shelflore.R
import com.ydhnwb.shelflore.models.Volume
import kotlinx.android.synthetic.main.list_item_search.view.*

class SearchAdapter (private var books : List<Volume>, private var context : Context) : RecyclerView.Adapter<SearchAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_search, parent, false))

    override fun getItemCount() = books.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(books[position], context)

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun bind(book : Volume, context: Context){
            itemView.item_book_name.text = book.volumeInfo.title
            itemView.item_book_image.load(book.volumeInfo.imageLink?.thumbnail.toString())
            itemView.setOnClickListener {
                Toast.makeText(context, book.id, Toast.LENGTH_LONG).show()
            }
        }
    }
}