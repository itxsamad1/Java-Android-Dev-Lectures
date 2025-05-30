package com.example.assignment2;

public class TeacherFragment extends BaseTableFragment {
    @Override
    protected String getApiEndpoint() {
        return "/teacher";
    }

    @Override
    protected String[] getColumnNames() {
        return new String[]{"tid", "tname"};
    }
} 