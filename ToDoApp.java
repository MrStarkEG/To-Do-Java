import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ToDoApp {
    static Scanner scanner = new Scanner(System.in); // Agile
    static ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = getIntInput("Enter your choice: ");
            switch (choice) {
                case 1: // Stark
                    createTask();
                    break;
                case 2: // Menna
                    editTask();
                    break;
                case 3: // Hla
                    deleteTask();
                    break;
                case 4:
                    markTaskComplete();
                    break;
                case 5:
                    displayTasks();
                    break;
                case 6:
                    return;
                    
                default:
                    System.out.println("Invalid choice. Please try again.");

            }
        }
    }

    static void displayMenu() {

    }

    static void createTask() {  // Stark
        System.out.println("\n---- Create Task ----");
        String title = getStringInput("Enter task title: ");
        String description = getStringInput("Enter task description: ");
        LocalDate dueDate = getDateInput("Enter due date (DD/MM/YYYY): ");
        String priority = getPriorityInput("Enter priority (low, medium, high): ");
        tasks.add(new Task(title, description, dueDate, priority));
        System.out.println("Task created successfully!");
    }

    static void editTask() { // Menna
        System.out.println("\n---- Edit Task ----");
        int index = getIndexInput("Enter index of the task to edit: ");
        Task task = tasks.get(index);
        while (true) {
            System.out.println("Select an attribute to edit:");
            System.out.println("1. Title");
            System.out.println("2. Description");
            System.out.println("3. Due Date");
            System.out.println("4. Priority");
            System.out.println("5. Exit");
            int choice = getIntInput("Enter your choice: ");
            switch (choice) {
                case 1:
                    task.setTitle(getStringInput("Enter new title: "));
                    System.out.println("Title updated successfully!");
                    break;
                case 2:
                    task.setDescription(getStringInput("Enter new description: "));
                    System.out.println("Description updated successfully!");
                    break;
                case 3:
                    task.setDueDate(getDateInput("Enter new due date (DD/MM/YYYY): "));
                    System.out.println("Due date updated successfully!");
                    break;
                case 4:
                    task.setPriority(getStringInput("Enter new priority (low, medium, high): ").toLowerCase());
                    System.out.println("Priority updated successfully!");
                    break;
                case 5:
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    // break;
                }
            }
        
    }

    static void deleteTask() {  // Hla
        System.out.println("\n---- Delete Task ----");
        int index = getIndexInput("Enter index of the task to delete: "); // Display Tasks()
        if (isValidIndex(index)) {
            tasks.remove(index);
            System.out.println("Task deleted successfully!");
        }
    }

    static void markTaskComplete() { // Gemy
        System.out.println("\n---- Mark Task as Complete ----");
        int index = getIndexInput("Enter index of the task to mark as complete: ");   
        if (isValidIndex(index)) { 
            tasks.get(index).setCompleted(true);
            System.out.println("Task marked as complete!");
        }
    }

    static void displayTasks() { // Abdelrahman
        if (tasks.isEmpty()) {
            System.out.println("There are no tasks");
        } else {
            System.out.println("\n---- Tasks ----");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println("Index: " + (i + 1));
                tasks.get(i).printTask();
                System.out.println("-----*---*-----");
            }
        }
    }

    static int getIntInput(String message) { 
        System.out.print(message);
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            System.out.print(message);
            scanner.next(); // Consume invalid input
        }
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        return choice;
    }


    static String getStringInput(String message) {
        System.out.print(message);
        String input = scanner.nextLine().trim(); // String
        while (input.isEmpty()) { // isEmpty() 
            System.out.println("Input cannot be blank. Please enter a value.");
            System.out.print(message);
            input = scanner.nextLine().trim();
        }
        return input;
    }
    
    static LocalDate getDateInput(String message) {
        System.out.print(message);
        while (true) {
            try {
                return LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            } 
            catch (Exception e) {
                System.out.println("Invalid date format. Please enter date in format DD/MM/YYYY.");
                System.out.print(message);
            }
        }
    }

    static String getPriorityInput(String message) {
        String priority;
        do {
            System.out.println(message);
            priority = getStringInput("").toLowerCase();
            if (!isValidPriority(priority)) {
                System.out.println("Invalid priority. Please enter either 'low', 'medium', or 'high'.");
            }
        } while (!isValidPriority(priority));
        return priority;
    }

    static boolean isValidPriority(String priority) {
        return priority.equals("low") || priority.equals("medium") || priority.equals("high");
    }

    static int getIndexInput(String message) {
        int index;
        do {
            index = getIntInput(message);
        } while (!isValidIndex(index - 1));
        return index -1 ;
    }

    static boolean isValidIndex(int index) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return false;
        } else if (index < 0 || index >= tasks.size()) { 
            System.out.println("Invalid task index.");
            return false;
        }
        return true;
    }

}

class Task {
    private String title;
    private String description;
    private LocalDate dueDate;
    private String priority;
    private boolean completed; // true or false = false

    
    // Create Task 
    public Task(String title, String description, LocalDate dueDate, String priority) { 
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.completed = false;
    }
    ///////////////////////////////////////

    // edit Task ()
    public void setTitle(String title) {   
        this.title = title;
    }

    public void setDescription(String description) {     
        this.description = description;
    }

    public void setDueDate(LocalDate dueDate) {     
        this.dueDate = dueDate;
    }

    public void setPriority(String priority) {   
        this.priority = priority;
    }

    public void setCompleted(boolean completed) {    // true / false
        this.completed = completed;
    }
    ///////////////////////////////////////

    public void printTask() {  // Display Tasks()
        System.out.println("Title: " + this.title);
        System.out.println("Description: " + this.description);
        System.out.println("Due Date: " + this.dueDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("Priority Level: " + this.priority);
        System.out.println("Completed: " + this.completed);
    }
    ///////////////////////////////////////
}
