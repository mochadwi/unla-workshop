package id.gits.unla

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.main_item.view.*

/**
 *
 * In syaa Allah created & modified
 * by mochadwi on 11/03/19
 * dedicated to build unla
 *
 */

class MainAdapter(
    val items: ArrayList<News> = arrayListOf(),
    val context: Context,
    val clickListener: (News) -> Unit
) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    override fun getItemCount(): Int = items.size

    // Inflates the item views
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MainViewHolder =
        MainViewHolder(LayoutInflater.from(context).inflate(R.layout.main_item, p0, false))

    override fun onBindViewHolder(p0: MainViewHolder, p1: Int) {
        try {
            p0.bind(
                items[p0.adapterPosition],
                clickListener
            ) // implement clickListener on onCreateViewHolder to get correct adapter position
        } catch (e: IndexOutOfBoundsException) {
            if (BuildConfig.DEBUG) Log.d(this::class.java.simpleName, e.localizedMessage)
        }
    }

    // Implement setHasStableIds to true
    override fun getItemId(position: Int): Long {
        return items[position].id?.toLong() ?: 0L
    }

    class MainViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bind(
            item: News,
            clickListener: (News) -> Unit
        ) = containerView.apply/**/ {
            with(item) {
                tv_item_title.text = title
                tv_item_description.text = description
                setOnClickListener { clickListener(this) } // Go to detail activity
            }
        }
    }
}