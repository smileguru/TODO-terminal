package org.example;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class TodoDB {
    private List<Task> list = new ArrayList<>(){{
        add(new Task("Task 1","Eating","Time", Status.DONE));
        add(new Task("Task 2","Eating","Time", Status.IN_PROGRESS));
        add(new Task("Task 3","Eating","Time", Status.DONE));
        add(new Task("Task 4","Eating","Time", Status.TODO));
        add(new Task("Task 5","Eating","Time", Status.IN_PROGRESS));
    }};

    public void add(String name, String title, String deadline) {
        list.add(new Task(name, title, deadline));
    }

    public void edit(String name, String title, String deadline, int status, int index) {
        Task task = new Task(name, title, deadline);
        if (status==2){
            task.setStatus(Status.IN_PROGRESS);
        } else if (status==3) {
            task.setStatus(Status.DONE);
        } else{
            task.setStatus(Status.TODO);
        }
        list.set(index, task);
    }

    public void delete(int index) {
        list.remove(index);
    }
}
