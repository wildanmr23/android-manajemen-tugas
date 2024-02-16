package com.example.myjobs.adapter

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myjobs.R
import com.example.myjobs.model.Task


class TaskAdapter: RecyclerView.Adapter<TaskAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder (view) {
        fun bind(task: Task) {

            itemView.findViewById<TextView>(R.id.tvTitleTask).text = task.mainTask?.title

            if (task.mainTask?.date != null){
                showDateTask()
                itemView.findViewById<TextView>(R.id.tvDateTask).text = task.mainTask.date.toString()
            } else {
                hideDateTask()
            }

            if (task.subtasks != null){
                showSubTask()
                val subTaskAdapter = SubTaskAdapter()
                subTaskAdapter.setData(task.subtasks)

                itemView.findViewById<RecyclerView>(R.id.rvSubTask).adapter = subTaskAdapter
            } else {
                hideSubTask()
            }

            itemView.findViewById<Button>(R.id.btnDoneTask).setOnClickListener{
                if (task.mainTask?.isComplete!!){
                    inCompleteTask()
                    task.mainTask.isComplete = false
                } else {
                    completeTask()
                    task.mainTask.isComplete = true
                }
            }

        }

        private fun completeTask() {
            itemView.findViewById<Button>(R.id.btnDoneTask).setBackgroundResource(R.drawable.ic_complete_task)
        }

        private fun inCompleteTask() {
            itemView.findViewById<Button>(R.id.btnDoneTask).setBackgroundResource(R.drawable.done_task_black)
        }

        private fun hideSubTask() {
            itemView.findViewById<View>(R.id.lineTask).visibility = View.GONE
            itemView.findViewById<RecyclerView>(R.id.rvSubTask).visibility = View.GONE
        }

        private fun showSubTask() {
            itemView.findViewById<View>(R.id.lineTask).visibility = View.VISIBLE
            itemView.findViewById<RecyclerView>(R.id.rvSubTask).visibility = View.VISIBLE
        }

        private fun hideDateTask() {
            itemView.findViewById<LinearLayout>(R.id.containerDateTask).visibility = View.GONE
        }

        private fun showDateTask() {
            itemView.findViewById<LinearLayout>(R.id.containerDateTask).visibility = View.VISIBLE
        }

    }

    private lateinit var tasks: List<Task>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false))


    override fun getItemCount(): Int = tasks.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(tasks[position])
    }

    fun setData(tasks: List<Task>){
        this.tasks = tasks
        notifyDataSetChanged()
    }

}