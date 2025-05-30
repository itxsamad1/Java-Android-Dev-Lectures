package com.example.connectivityofbackend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * TeacherAdapter handles the display of teacher data in a RecyclerView
 * It converts teacher objects into ViewHolder items that can be displayed in the list
 */
public class TeacherAdapter extends RecyclerView.Adapter<TeacherAdapter.TeacherViewHolder> {
    // Data source
    private List<Teacher> teacherList;
    private Context context;

    /**
     * Constructor to initialize the adapter with data and context
     */
    public TeacherAdapter(List<Teacher> teacherList, Context context) {
        this.teacherList = teacherList;
        this.context = context;
    }

    @NonNull
    @Override
    public TeacherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout for each teacher item
        View v = LayoutInflater.from(context).inflate(R.layout.item_teacher, parent, false);
        return new TeacherViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TeacherViewHolder holder, int position) {
        // Bind teacher data to the ViewHolder
        Teacher teacher = teacherList.get(position);
        holder.teacherID.setText(String.valueOf(teacher.ID));
        holder.teacherName.setText(teacher.Name);
    }

    @Override
    public int getItemCount() {
        return teacherList.size();
    }

    /**
     * ViewHolder class to hold and manage the views for each teacher item
     */
    public class TeacherViewHolder extends RecyclerView.ViewHolder {
        // UI Components for each item
        TextView teacherID, teacherName;

        public TeacherViewHolder(@NonNull View itemView) {
            super(itemView);
            // Initialize views
            teacherID = itemView.findViewById(R.id.teacherid);
            teacherName = itemView.findViewById(R.id.teachername);
        }
    }
}
