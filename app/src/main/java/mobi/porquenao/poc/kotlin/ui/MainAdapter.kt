package mobi.porquenao.poc.kotlin.ui

import android.graphics.Color
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.bindView
import mobi.porquenao.poc.kotlin.R
import mobi.porquenao.poc.kotlin.core.Item
import mobi.porquenao.poc.kotlin.core.ItemRepository
import java.util.Calendar

public class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private val mItems: MutableList<Item>
    private val mOnClickListener: View.OnClickListener

    init {
        mItems = ItemRepository.getAll()
        mOnClickListener = object : View.OnClickListener {
            override fun onClick(v: View) {
                val item = v.getTag() as Item
                item.setUpdatedAt(Calendar.getInstance())
                item.save()
                notifyDataSetChanged()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.getContext())
        return ViewHolder(layoutInflater.inflate(R.layout.main_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mItems.get(position)
        val color = "#" + item.getUpdatedAt().getTimeInMillis().toString().substring(7)
        holder.vCard.setCardBackgroundColor(Color.parseColor(color))
        holder.vText.setText(color)
        holder.vText.setTag(item)
        holder.vText.setOnClickListener(mOnClickListener)
    }

    override fun getItemCount(): Int {
        return mItems.size()
    }

    public fun add() {
        val item = Item()
        mItems.add(0, item)
        item.save()
        notifyItemInserted(0)
    }

    public class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val vCard: CardView by bindView(R.id.card)
        val vText: TextView by bindView(R.id.text)

    }

}
