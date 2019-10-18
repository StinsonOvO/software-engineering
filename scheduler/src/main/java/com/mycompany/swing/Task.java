/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.swing;

import java.time.Duration;
import java.util.Date;

/**
 * This Task object specifies a basic task with name and description.
 * @author Stinson
 */
public class Task implements XMLizable, Comparable<Task> {
    
    private final String   name;
    private final String   description;
    private final Date     start;
    private final Duration duration;
    private final Date     deadline;
    
     /**
     * Constructs a task. To initialize a task, specify the name of the
     * the task, a description of the task, the start date for the task, 
     * the duration for the task, and the deadline for the task.
     * 
     * @param name the name of the task.
     * @param description the description of the task.
     * @param start the start date for the task.
     * @param duration the duration of the task.
     * @param deadline the deadline for the task.
     * 
     */
    public Task(String name, String description, Date start, Duration duration, Date deadline) {
        this.name = name;
        this.description = description;
        this.start = start;
        this.deadline = deadline;
        this.duration = duration;
    }

    /**
     * Converts each task to a string that adheres to XML format.
     * 
     * @return a string that represents each task in XML format.
     */
    @Override
    public String toXML() {
        return "<task name='" + name.replace("'", "\\'") + "' start='" + start.toString() + "' duration='" + duration.toString() + "' deadline='" + deadline.toString() + "' description='" + description.replace("'", "\\'") + "'/>\n";
    }

    String getName() {
       return this.name;
    }
    String getDescription() {
       return this.description;
    }
    
    Date getStart() {
       return this.start;
    }
    
    Duration getDuration() {
       return this.duration;
    }
    
    /**
     * Compares the deadlines between two tasks.
     * 
     * @return an integer that represents the priority between two tasks.
     */
    @Override
    public int compareTo(Task o) {
       return this.deadline.compareTo(o.deadline);
    }
    
}
