package com.khushal.splashscreenwithlifecycle

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.carditem.view.*

class BikeAdapter (val context:Context,var arr:ArrayList<Bike>)
    :RecyclerView.Adapter<BikeAdapter.PersonViewHolde>()

{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolde {
        var inflater=LayoutInflater.from(parent.context)
        var view= inflater.inflate(R.layout.carditem,parent,false)
        return PersonViewHolde(view)
    }

    override fun onBindViewHolder(holder: PersonViewHolde, position: Int) {
        holder.bind(arr[position])
        holder.itemView.imgDetele.setOnClickListener {
            if(context is ViewAll)
            {
                context.delete(position)
            }
        }
        holder.itemView.imgUpdate.setOnClickListener {
            if(context is ViewAll)
            {
                context.update(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return  arr.size
    }

    class PersonViewHolde(var view:View):RecyclerView.ViewHolder(view)
    {
        fun bind(p:Bike)
        {
            view.tvbikename.setText(p.bike_name)
            view.tvbikedesc.setText(p.bike_desc)
            view.tvbikeprice.setText(p.bike_price.toString())
            view.tvbikesetcap.setText(p.bike_stecap.toString())
            view.tvbikefullcap.setText(p.bike_fullcap.toString())

        }
    }
}
