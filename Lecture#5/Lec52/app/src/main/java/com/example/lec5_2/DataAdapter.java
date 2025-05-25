package com.example.lec5_2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

// Adapter class that connects data with RecyclerView
public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    // Array to hold the data that will be displayed
    private String[] data;

    // Constructor to initialize the adapter with data
    public DataAdapter(String[] data) {
        this.data = data;
    }

    // ViewHolder class to hold and manage the views for each item
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public ViewHolder(View view) {
            super(view);
            // Find and store the TextView from our item layout
            textView = view.findViewById(R.id.textView);
        }

        // Getter for the TextView
        public TextView getTextView() {
            return textView;
        }
    }

    // Called when RecyclerView needs a new ViewHolder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the item layout and create a new ViewHolder
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    // Called to bind data to a ViewHolder at a specific position
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Set the text of the TextView to the data at the current position
        holder.getTextView().setText(data[position]);
    }

    // Returns the total number of items in the data set
    @Override
    public int getItemCount() {
        return data.length;
    }

    // Method to update the data in the adapter
    public void updateData(String[] newData) {
        this.data = newData;
        notifyDataSetChanged(); // Notify the RecyclerView that the data has changed
    }
} 