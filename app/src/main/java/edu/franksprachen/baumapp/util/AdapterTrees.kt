package edu.franksprachen.baumapp.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import edu.franksprachen.baumapp.R
import edu.franksprachen.baumapp.model.Tree
import kotlinx.android.synthetic.main.item_trees.view.*

class AdapterTrees: RecyclerView.Adapter<AdapterTrees.ViewHolder>() {
    lateinit var items:ArrayList<Tree>

    fun setTrees(items:List<Tree>) {
        this.items = items as ArrayList<Tree>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_trees, parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = items[position]
        holder.treeName.text = model.name
        holder.treeScientificName.text = model.scientificName
        holder.treeDescription.text = model.description
        Picasso.get()
            .load(model.picture)
            //.networkPolicy(NetworkPolicy.OFFLINE)
            .resize(300,300)
            .into(holder.treePicture)
    }

    override fun getItemCount(): Int {
        return if(::items.isInitialized) {
            items.size
        } else {
            0
        }
    }

    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val treeName: TextView = view.tv_name
        val treeScientificName: TextView = view.tv_scientificName
        val treeDescription: TextView = view.tv_description
        val treePicture: ImageView = view.img_tree
    }
}