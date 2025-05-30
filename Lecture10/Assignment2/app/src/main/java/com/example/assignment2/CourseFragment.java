package com.example.assignment2;

public class CourseFragment extends BaseTableFragment {
    @Override
    protected String getApiEndpoint() {
        return "/course";
    }

    @Override
    protected String[] getColumnNames() {
        return new String[]{"course_code", "cname"};
    }
} 