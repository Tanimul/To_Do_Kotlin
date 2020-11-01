/*
 * Copyright (C) 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.todokotlin.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todokotlin.Model.Work
import com.example.todokotlin.R

class WorkListAdapter(context: Context) : RecyclerView.Adapter<WorkListAdapter.WordViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var works = emptyList<Work>()

    inner class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rc_task_name: TextView = itemView.findViewById(R.id.rc_task_name)
        val rc_textview_date: TextView = itemView.findViewById(R.id.rc_textview_date)
        val rc_textview_duetime: TextView = itemView.findViewById(R.id.rc_textview_duetime)
        val rc_ratingBar: RatingBar = itemView.findViewById(R.id.rc_ratingBar)
        val checkbox_meat: CheckBox = itemView.findViewById(R.id.checkbox_meat)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val itemView = inflater.inflate(R.layout.taskcard, parent, false)
        return WordViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val current = works[position]
        holder.rc_task_name.text = current.event_name
        holder.rc_textview_date.text = current.date
        holder.rc_textview_duetime.text = current.due_time
        holder.rc_ratingBar.rating= current.rating!!

        holder.checkbox_meat.isChecked = current.isCom==true

    }

    internal fun setWorks(works: List<Work>) {
        this.works = works
        notifyDataSetChanged()
    }

    override fun getItemCount() = works.size
}
