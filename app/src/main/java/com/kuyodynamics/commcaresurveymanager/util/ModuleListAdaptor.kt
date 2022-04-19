package com.kuyodynamics.commcaresurveymanager.util

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kuyodynamics.commcaresurveymanager.R
import com.kuyodynamics.commcaresurveymanager.ui.CommCareModuleViewHolder
import com.kuyodynamics.commcaresurveymanager.database.entities.CommCareModule

class ModuleListAdaptor: RecyclerView.Adapter<CommCareModuleViewHolder>() {
    var data = listOf<CommCareModule>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommCareModuleViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view =  layoutInflater.inflate(R.layout.module_item_view,parent,false) as TextView
        return  CommCareModuleViewHolder(view);
    }

    override fun onBindViewHolder(holder: CommCareModuleViewHolder, position: Int) {
        val item = data[position]
        holder.textView.text = item.name
    }

    override fun getItemCount(): Int {
        return data.size
    }

}