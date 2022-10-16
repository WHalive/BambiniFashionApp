package com.example.bambinifashionapp.home

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.graphics.toColorInt
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.bambinifashionapp.R
import com.example.bambinifashionapp.data.ProlineItem
import com.example.bambinifashionapp.database.PromotionEntity
import okhttp3.internal.checkDuration


class HomeViewPagerAdapter : RecyclerView.Adapter<HomeViewPagerAdapter.ViewPagerViewHolder>() {

    private val items: MutableList<ProlineItem> = mutableListOf()

    inner class ViewPagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.proline_item_view, parent, false)
        return ViewPagerViewHolder(view)
    }


    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        val currentTitle = items[position]
        holder.itemView.findViewById<TextView>(R.id.proline_text).text =
            HtmlCompat.fromHtml(currentTitle.content, HtmlCompat.FROM_HTML_MODE_COMPACT)
        currentTitle.highlight?.textColor?.let {
            holder.itemView.findViewById<TextView>(R.id.proline_text).setTextColor(
                it.toColorInt()
            )
        }
        holder.itemView.findViewById<ConstraintLayout>(R.id.constraint)
            .setBackgroundColor(if (currentTitle.highlight != null) (currentTitle.highlight!!.backgroundColor.toColorInt()) else (R.color.white))

        holder.itemView.findViewById<ConstraintLayout>(R.id.constraint).setBackgroundColor(R.color.black)
        currentTitle.highlight?.backgroundColor?.let {
            holder.itemView.findViewById<ConstraintLayout>(R.id.constraint).setBackgroundColor(
                it.toColorInt())
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setProlineItems(prolines: List<ProlineItem>) {
        items.clear()
        items.addAll(prolines)
        Log.d("ddk9499", "setProlineItems: ${items.size}")
        this.notifyDataSetChanged()
    }
}

//class ViewPagerAdapter(list: List<ProlineItem>, var context: Context) :
//    PagerAdapter() {
//
//    private val itemList = list
//
//    override fun getCount(): Int = itemList.size
//
//    override fun isViewFromObject(view: View, `object`: Any): Boolean {
//        return view == `object`
//    }
//
//    override fun instantiateItem(container: ViewGroup, position: Int): View {
//        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
//        val view = inflater.inflate(R.layout.proline_item_view, container, false)
//        val tv = view.findViewById<TextView>(R.id.proline_text)
//        tv.text = itemList[position].content
//
//        return view
//    }
//}