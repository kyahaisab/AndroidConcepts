package com.example.myfirstapplication.workManager.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstapplication.R
import com.example.myfirstapplication.workManager.room.SystemResource
import java.util.Date

class SystemResourceAdapter : RecyclerView.Adapter<SystemResourceAdapter.SystemResourceViewHolder>() {
    private var resources = emptyList<SystemResource>()

    inner class SystemResourceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val timestampTextView: TextView = itemView.findViewById(R.id.timestampTextView)
        private val cpuUsageTextView: TextView = itemView.findViewById(R.id.cpuUsageTextView)
        private val memoryUsageTextView: TextView = itemView.findViewById(R.id.memoryUsageTextView)

        fun bind(resource: SystemResource) {
            timestampTextView.text = Date(resource.timestamp).toString()
            cpuUsageTextView.text = "CPU Usage: ${resource.cpuUsage}%"
            memoryUsageTextView.text = "Memory Usage: ${resource.memoryUsage}%"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SystemResourceViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_system_resource, parent, false)
        return SystemResourceViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SystemResourceViewHolder, position: Int) {
        holder.bind(resources[position])
    }

    override fun getItemCount() = resources.size

    fun setResources(resources: List<SystemResource>) {
        this.resources = resources
        notifyDataSetChanged()
    }
}
