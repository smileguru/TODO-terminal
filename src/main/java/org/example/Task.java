package org.example;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Task {
    private String name;
    private String title;
    private String dateTime;
    private Status status;

    public Task(String name, String title, String dateTime) {
        this.name = name;
        this.title = title;
        this.dateTime = dateTime;
        this.status = Status.TODO;
    }

    public Task(String name, String title, String dateTime, Status status) {
        this.name = name;
        this.title = title;
        this.dateTime = dateTime;
        this.status = status;
    }

    public static void main(String[] args) {
        Task task = new Task("1","1","1");
        System.out.println(task.getStatus()==Status.TODO);
    }
}
