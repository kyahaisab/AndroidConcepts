package com.example.myfirstapplication.recyclerViews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstapplication.R

class ComplexAdapter(
    private val items: List<Item>,
    private val itemClickListener: (Item) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val VIEW_TYPE_HEADER = 0
        private const val VIEW_TYPE_CONTENT = 1
    }

    // Called Zero
    override fun getItemCount(): Int = items.size

    // called First
    override fun getItemViewType(position: Int): Int {
        return when (items[position].type) {
            ItemType.HEADER -> VIEW_TYPE_HEADER
            ItemType.CONTENT -> VIEW_TYPE_CONTENT
        }
    }

    // called Second
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_HEADER -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.header_item, parent, false)
                HeaderViewHolder(view)
            }

            VIEW_TYPE_CONTENT -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.content_item, parent, false)
                ContentViewHolder(view)
            }

            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    // Called third
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        when (holder) {
            is HeaderViewHolder -> holder.bind(item)
            is ContentViewHolder -> holder.bind(item)
        }
    }

    inner class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val headerTextView: TextView = itemView.findViewById(R.id.headerTextView)

        init {
            itemView.setOnClickListener {
                itemClickListener(items[adapterPosition])
            }
        }

        fun bind(item: Item) {
            headerTextView.text = item.text
        }
    }

    inner class ContentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val contentTextView: TextView = itemView.findViewById(R.id.contentTextView)

        init {
            itemView.setOnClickListener {
                itemClickListener(items[adapterPosition])
            }
        }

        fun bind(item: Item) {
            contentTextView.text = item.text
        }
    }

    /*
Sequence of Method Calls in a Typical Scenario:
-getItemCount(): Determine the total number of items.
For each visible item:
-getItemViewType(position): Determine the type of view for the item.
-onCreateViewHolder(parent, viewType): Create a new ViewHolder (if necessary).
-onBindViewHolder(holder, position): Bind data to the ViewHolder.
-As you scroll:
 Recycle ViewHolder instances that go off-screen.
 Reuse recycled ViewHolder instances for new items coming on-screen by calling onBindViewHolder.

 // Also add other complex functions of recycler view like onRecyclerViewCreated
     */
}