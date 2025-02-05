package org.example;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    static TodoDB db = new TodoDB();
    static Scanner scanner = new Scanner(System.in);

    static Map<String, String> commands = new HashMap<>() {{
        put("add", "add a task.");
        put("list", "to display a list of tasks.");
        put("edit", "edit the task.");
        put("delete", "delete the task.");
        put("filter", "filter tasks by status.");
        put("sort", "sort the tasks.");
        put("exit", "log out of the system.");
    }};

    public static void main(String[] args) {
        String name;
        String title;
        String deadline;
        int numb;

        while (true){
            System.out.println("\nEnter the command:");
            String command = scanner.next();

            switch (command){
                case "add":
                    System.out.print("Enter the name -> ");
                    name = scanner.next();
                    System.out.print("Enter the title -> ");
                    title = scanner.next();
                    System.out.print("Enter the deadline -> ");
                    deadline = scanner.next();
//                    if(name.isEmpty() || title.isEmpty() || deadline.isEmpty()){
//                        System.out.println("\nerror in filling out!\nWill you try again(y/n)? ->");
//                        if (scanner.next().equals("y"))
//                            continue;
//                        else
//                            break;
//                    }
                    db.add(name, title, deadline);
                    System.out.println("Task added!");
                    break;

                case "list":
                    System.out.println("\nYour task list:");
                    AtomicInteger counter = new AtomicInteger(0);
                    db.getList().forEach(i-> System.out.println(counter.incrementAndGet()+". "+i.toString()));
                    break;

                case "edit":
                    System.out.println("\nEnter the issue number you want to edit");
                    numb = scanner.nextInt();
                    System.out.print("Enter the name -> ");
                    name = scanner.next();
                    System.out.print("Enter the title -> ");
                    title = scanner.next();
                    System.out.print("Enter the deadline -> ");
                    deadline = scanner.next();
                    System.out.print("Enter the Status(1-todo / 2-in progress / 3-done) -> ");
                    int status = scanner.nextInt();
                    db.edit(name, title, deadline, status, numb-1);
                    break;

                case "delete":
                    System.out.println("\nEnter the number of the task you want to delete");
                    numb = scanner.nextInt();
                    db.delete(numb-1);
                    break;

                case "filter":
                    System.out.print("Filter: 1 - todo / 2 - in progress / 3 - done \nenter the number -> ");
                    numb = scanner.nextInt();
                    if (numb==1){
                        db.getList().stream().filter(t -> t.getStatus()==Status.TODO).forEach(System.out::println);
                    } else if (numb==2) {
                        db.getList().stream().filter(t -> t.getStatus()==Status.IN_PROGRESS).forEach(System.out::println);
                    } else if (numb==3) {
                        db.getList().stream().filter(t -> t.getStatus()==Status.DONE).forEach(System.out::println);
                    } else{
                        System.out.println("Error");
                    }
                    break;

                case "sort":
                    System.out.println("Sort Task:");
                    db.getList().stream().sorted(Comparator.comparing(Task::getStatus)).forEach(System.out::println);
                    break;

                case "menu":
                    commands.forEach((key, value) -> System.out.println(key + " -> " + value));
                    System.out.println("\nEnter the command:");
                    break;

                case "exit":
                    System.out.println("Good Buy!");
                    break;

                default:
                    System.out.println("\nThere is no such command -> "+ command);
                    System.out.println("Enter the 'menu' to view the commands:");
            }

            if (command.equals("exit"))
                break;
        }
    }
}