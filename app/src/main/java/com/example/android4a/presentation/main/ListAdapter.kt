package com.example.android4a.presentation.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android4a.R
import com.example.android4a.data.local.models.Card

class ListAdapter(private val values: List<Card?>?) :
    RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    private val listener: OnItemClickListener? =null

    interface OnItemClickListener {
        fun onItemClick(item: Card?)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var txtHeader: TextView
        var txtFooter: TextView
        init {
            // Define click listener for the ViewHolder's View.
            txtHeader = view.findViewById(R.id.firstLine)
            txtFooter = view.findViewById(R.id.secondLine)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.row_layout, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        val currentCard = values?.get(position)
        holder.txtHeader.text = currentCard?.name
        holder.txtFooter.text = currentCard?.imageUrl
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount(): Int {
        if (values != null) return this.values.size
        return 0;
    }
}
/* class ListAdapter(private val dataSet: List<Card?>?) :
    RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView

        init {
            // Define click listener for the ViewHolder's View.
            textView = view.findViewById(R.id.recycler_view)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.activity_application, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.textView.text = dataSet?.get(position) ?:
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount(): Int = dataSet?.size!!

}

    fun add(position: Int, item: Card) {
        values.add(position, item)
        notifyItemInserted(position)
    }

    fun remove(position: Int) {
        values.removeAt(position)
        notifyItemRemoved(position)
    }

    fun setListener(listener: OnItemClickListener) {
        this.listener = listener
    }


*/