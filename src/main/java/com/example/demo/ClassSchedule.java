package com.example.demo;

public class ClassSchedule {
    private final String className;
    private final String groupName;
    private final String dayOfWeek;
    private final String time;

    public ClassSchedule(String className, String groupName, String dayOfWeek, String time) {
        this.className = className;
        this.groupName = groupName;
        this.dayOfWeek = dayOfWeek;
        this.time = time;
    }

    public String getClassName() {
        return className;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public String getTime() {
        return time;
    }
}
