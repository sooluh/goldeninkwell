package id.sooluh.muslim

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListScientistAdapter(private val listScientist: ArrayList<Scientist>) :
    RecyclerView.Adapter<ListScientistAdapter.ListViewHolder>() {
    private var lastClick: Long = 0
    private val clickDelay = 1000

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_row_scientists, parent, false)

        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listScientist.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, _, description, photo) = listScientist[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description

        holder.itemView.setOnClickListener {
            val clickTime = System.currentTimeMillis()
            if (clickTime - lastClick > clickDelay) {
                lastClick = clickTime

                val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
                intentDetail.putExtra("key_scientist", listScientist[position])
                holder.itemView.context.startActivity(intentDetail)
            }
        }
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }
}
