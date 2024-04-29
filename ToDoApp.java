import java.util.ArrayList;
import java.util.Scanner;

public class ToDoApp {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    createTask();
                    break;
                case 2:
                    editTask();
                    break;
                case 3:
                    deleteTask();
                    break;
                case 4:
                    markTaskComplete();
                    break;
                case 5:
                    displayTasks();
                    break;
                case 6:
                    System.out.println("Exiting ToDo App. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    static void displayMenu() {
        System.out.println("\n---- ToDo App Menu ----");
        System.out.println("1. Create Task"); // Stark
        System.out.println("2. Edit Task"); // Menna
        System.out.println("3. Delete Task"); // Hala
        System.out.println("4. Mark Task as Complete"); // Gemy
        System.out.println("5. Display Tasks");  // Abdelrahman
        System.out.println("6. Exit"); // Negroo
        System.out.print("Enter your choice: ");
    }

    static void createTask() {
        System.out.println("\n---- Create Task ----");
        System.out.print("Enter task title: ");
        String title = scanner.nextLine();
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        System.out.print("Enter due date: ");
        String dueDate = scanner.nextLine();
        System.out.print("Enter priority (low, medium, high): ");
        String priority = scanner.nextLine();

        Task task = new Task(title, description, dueDate, priority);
        tasks.add(task);
        System.out.println("Task created successfully!");
    }

    static void editTask() {
        System.out.println("\n---- Edit Task ----");
        System.out.print("Enter index of the task to edit: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);
            System.out.print("Enter new title: ");
            task.setTitle(scanner.nextLine());
            System.out.print("Enter new description: ");
            task.setDescription(scanner.nextLine());
            System.out.print("Enter new due date: ");
            task.setDueDate(scanner.nextLine());
            System.out.print("Enter new priority (low, medium, high): ");
            task.setPriority(scanner.nextLine());
            System.out.println("Task edited successfully!");
        } else {
            System.out.println("Invalid task index.");
        }
    }

    static void deleteTask() {
        System.out.println("\n---- Delete Task ----");
        System.out.print("Enter index of the task to delete: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("Task deleted successfully!");
        } else {
            System.out.println("Invalid task index.");
        }
    }

    static void markTaskComplete() {
        System.out.println("\n---- Mark Task as Complete ----");
        System.out.print("Enter index of the task to mark as complete: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);
            task.setCompleted(true);
            System.out.println("Task marked as complete!");
        } else {
            System.out.println("Invalid task index.");
        }
    }

    static void displayTasks() {
        System.out.println("\n---- Tasks ----");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println("Index: " + i);
            System.out.println(tasks.get(i));
        }
    }
}

class Task {
    private String title;
    private String description;
    private String dueDate;
    private String priority;
    private boolean completed;

    public Task(String title, String description, String dueDate, String priority) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.completed = false;
    }

    // Getters and setters
    // toString method to display task details
}