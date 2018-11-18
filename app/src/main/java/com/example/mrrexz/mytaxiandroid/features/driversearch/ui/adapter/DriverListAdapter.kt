package com.example.mrrexz.mytaxiandroid.features.driversearch.ui.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.mrrexz.mytaxiandroid.R
import com.example.mrrexz.mytaxiandroid.databinding.DriverListItemBinding
import com.example.mrrexz.mytaxiandroid.features.driversearch.model.view.Driver

class DriverListAdapter(private val context : Context) : RecyclerView.Adapter<DriverListAdapter.DriverListViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DriverListViewHolder {
        var layoutInflater = LayoutInflater.from(context)
        val binding : DriverListItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.driver_list_item, parent, false)
        return DriverListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DriverListViewHolder, position: Int) {
        holder.bind(drivers[position])
    }

    override fun getItemCount(): Int {
        return drivers.size
    }


    private var drivers : List<Driver>  = listOf()

    fun updateDrivers(driverList : List<Driver>) {
        this.drivers = driverList
        notifyDataSetChanged()
    }

    class DriverListViewHolder(private val binding : DriverListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(driver : Driver) {
            binding.driver = driver
            binding.executePendingBindings()
        }
    }
}