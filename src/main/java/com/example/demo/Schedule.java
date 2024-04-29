package com.example.demo;

import java.util.List;

public interface Schedule {
    void addClass(ClassSchedule classSchedule);
    void removeClass(String className);
    List<ClassSchedule> getScheduleForGroup(String groupName);
    List<ClassSchedule> getAllClasses();
    List<String> getScheduleChangeProposals();
    boolean generateSchedule();
}
