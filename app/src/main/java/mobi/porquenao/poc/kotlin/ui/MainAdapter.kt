package mobi.porquenao.poc.kotlin.ui

import android.graphics.Color
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.bindView
import mobi.porquenao.poc.kotlin.R
import mobi.porquenao.poc.kotlin.core.Item
import mobi.porquenao.poc.kotlin.core.ItemRepository
import java.util.*

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
        val date = item.getUpdatedAt().getTimeInMillis()

        val color = "#" + date.toString().substring(7)
        holder.card.setCardBackgroundColor(Color.parseColor(color))
        holder.text.setText(color)
        holder.date.setText(DateFormat.format("hh:mm:ss", Date(date)))

        with (holder.container) {
            setTag(item)
            setOnClickListener(mOnClickListener)
        }
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
        val card: CardView by bindView(R.id.card)
        val container: View by bindView(R.id.container)
        val text: TextView by bindView(R.id.text)
        val date: TextView by bindView(R.id.date)
    }

}
