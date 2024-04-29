package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BasicSchedule implements Schedule {
    private Map<String, List<ClassSchedule>> schedule;

    public BasicSchedule() {
        this.schedule = new HashMap<>();
    }

    @Override
    public void addClass(ClassSchedule classSchedule) {
        String groupName = classSchedule.getGroupName();
        if (!schedule.containsKey(groupName)) {
            schedule.put(groupName, new ArrayList<>());
        }
        schedule.get(groupName).add(classSchedule);
    }

    @Override
    public void removeClass(String className) {
        for (List<ClassSchedule> classes : schedule.values()) {
            classes.removeIf(classSchedule -> classSchedule.getClassName().equals(className));
        }
    }

    @Override
    public List<ClassSchedule> getScheduleForGroup(String groupName) {
        return schedule.getOrDefault(groupName, new ArrayList<>());
    }

    @Override
    public List<ClassSchedule> getAllClasses() {
        List<ClassSchedule> allClasses = new ArrayList<>();
        for (List<ClassSchedule> classes : schedule.values()) {
            allClasses.addAll(classes);
        }
        return allClasses;
    }

    @Override
    public List<String> getScheduleChangeProposals() {
        // logic for proposing schedule changes
        return new ArrayList<>();
    }

    @Override
    public boolean generateSchedule() {
        // logic for automatic schedule generation
        return true;
    }
}
