package com.momoui.beerapi2

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.momoui.beerapi2.models.BeerResponseItem

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private var data: ArrayList<BeerResponseItem>? = null


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view,) {

        private var name: TextView? = null
        private var tagline: TextView? = null
        private var description :TextView? = null
        private var image: ImageView? = null
//        private var beerLayout: ConstraintLayout

        init {
            name = view.findViewById(R.id.name)
            tagline = view.findViewById(R.id.tagline)
            description = view.findViewById(R.id.description)
            image = view.findViewById(R.id.image)

        }

        fun bind(beer: BeerResponseItem) {
            if (beer != null){
                name?.text = beer.name
                tagline?.text = beer.tagline
                description?.text = beer.description
                Glide
                    .with(image!!.rootView)
                    .load(beer.image_url)
                    .placeholder(R.drawable.download)
                    .into(image!!)


            }
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {

        return if (data == null){
            0
        } else {
            data!!.size
        }
    }




    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data?.get(position)!!)
    }


    @SuppressLint("NotifyDataSetChanged")
    fun setItem(data: ArrayList<BeerResponseItem>) {
        this.data = data
        notifyDataSetChanged()
    }


}