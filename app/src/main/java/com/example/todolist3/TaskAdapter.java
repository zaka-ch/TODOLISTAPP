package com.example.todolist3;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private List<Task> tasks;
    private Context context;

    public TaskAdapter(List<Task> tasks, Context context) {
        this.tasks = tasks;
        this.context = context;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task task = tasks.get(position);
        
        holder.cbTask.setOnCheckedChangeListener(null);
        holder.cbTask.setChecked(task.isChecked());
        holder.cbTask.setText(task.getTitle());

        if (task.getDeadline() != null && !task.getDeadline().isEmpty()) {
            holder.tvDeadline.setVisibility(View.VISIBLE);
            holder.tvDeadline.setText("Deadline: " + task.getDeadline());
        } else {
            holder.tvDeadline.setVisibility(View.GONE);
        }

        holder.cbTask.setOnCheckedChangeListener((buttonView, isChecked) -> {
            task.setChecked(isChecked);
        });

        holder.btnDelete.setOnClickListener(v -> {
            int currentPos = holder.getAdapterPosition();
            if (currentPos != RecyclerView.NO_POSITION) {
                tasks.remove(currentPos);
                notifyItemRemoved(currentPos);
                notifyItemRangeChanged(currentPos, tasks.size());
            }
        });

        holder.btnEdit.setOnClickListener(v -> {
            int currentPos = holder.getAdapterPosition();
            if (currentPos != RecyclerView.NO_POSITION) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Edit Task");

                EditText input = new EditText(context);
                input.setText(tasks.get(currentPos).getTitle());
                builder.setView(input);

                builder.setPositiveButton("Save", (dialog, which) -> {
                    tasks.get(currentPos).setTitle(input.getText().toString());
                    notifyItemChanged(currentPos);
                });

                builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());
                builder.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public static class TaskViewHolder extends RecyclerView.ViewHolder {
        CheckBox cbTask;
        TextView tvDeadline;
        Button btnDelete, btnEdit;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            cbTask = itemView.findViewById(R.id.cbTask);
            tvDeadline = itemView.findViewById(R.id.tvDeadline);
            btnDelete = itemView.findViewById(R.id.btnDelete);
            btnEdit = itemView.findViewById(R.id.btnEdit);
        }
    }
}
