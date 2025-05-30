package com.example.assignment2;

import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class TableAdapter extends RecyclerView.Adapter<TableAdapter.ViewHolder> {
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    
    private final List<String[]> dataList;
    private final String[] columnNames;

    public TableAdapter(List<String[]> dataList, String[] columnNames) {
        this.dataList = dataList;
        this.columnNames = columnNames;
    }

    private String formatColumnName(String name) {
        // Convert snake_case to Title Case
        String[] words = name.split("_");
        StringBuilder formatted = new StringBuilder();
        for (String word : words) {
            if (word.length() > 0) {
                formatted.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1))
                        .append(" ");
            }
        }
        return formatted.toString().trim();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_table_row, parent, false);
        ViewHolder holder = new ViewHolder(view, columnNames.length);
        
        if (viewType == TYPE_HEADER) {
            view.setBackgroundColor(Color.parseColor("#EEEEEE"));
        }
        
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (position == 0) {
            // Header row
            for (int i = 0; i < columnNames.length; i++) {
                holder.textViews[i].setText(formatColumnName(columnNames[i]));
                holder.textViews[i].setTypeface(null, Typeface.BOLD);
            }
        } else {
            // Data rows
            String[] rowData = dataList.get(position - 1);
            for (int i = 0; i < columnNames.length; i++) {
                holder.textViews[i].setText(rowData[i]);
                holder.textViews[i].setTypeface(null, Typeface.NORMAL);
            }
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size() + 1; // +1 for header row
    }

    @Override
    public int getItemViewType(int position) {
        return position == 0 ? TYPE_HEADER : TYPE_ITEM;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView[] textViews;

        ViewHolder(View view, int columnCount) {
            super(view);
            textViews = new TextView[columnCount];
            for (int i = 0; i < columnCount; i++) {
                int id = view.getResources().getIdentifier(
                    "column" + i, "id", view.getContext().getPackageName());
                textViews[i] = view.findViewById(id);
            }
        }
    }
} 