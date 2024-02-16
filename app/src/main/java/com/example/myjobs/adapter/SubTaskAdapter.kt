package com.example.myjobs.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myjobs.R
import com.example.myjobs.model.SubTask


class SubTaskAdapter: RecyclerView.Adapter<SubTaskAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bind(subTask: SubTask) {
            itemView.findViewById<TextView>(R.id.tvTitleSubTask).text = subTask.title

            itemView.findViewById<Button>(R.id.btnDoneSubTask).setOnClickListener {
                if (subTask.isComplete){
                    inCompleteSubTask()
                    subTask.isComplete = false
                } else {
                    CompleteSubTask()
                    subTask.isComplete = true
                }
            }

        }

        private fun CompleteSubTask() {
            itemView.findViewById<Button>(R.id.btnDoneSubTask).setBackgroundResource(R.drawable.ic_complete_task)
        }


        private fun inCompleteSubTask() {
            itemView.findViewById<Button>(R.id.btnDoneSubTask).setBackgroundResource(R.drawable.done_task_black)
        }

    }

    private lateinit var subTasks: List<SubTask>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_sub_task, parent, false))

    override fun getItemCount(): Int = subTasks.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(subTasks[position])
    }

    fun setData(subTask: List<SubTask>){
        this.subTasks = subTasks
        notifyDataSetChanged()
    }
}