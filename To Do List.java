import java.util.ArrayList;
import java.util.Scanner;

class Task {
    private String description;
    private String dueDate;
    private boolean completed;

    public Task(String description, String dueDate) {
        this.description = description;
        this.dueDate = dueDate.isEmpty() ? "No due date" : dueDate;
        this.completed = false;
    }

    public String getDescription() {
        return description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDueDate(String dueDate) {
        if (!dueDate.isEmpty()) {
            this.dueDate = dueDate;
        }
    }

    public void markCompleted() {
        this.completed = true;
    }

    @Override
    public String toString() {
        return description + " (Due: " + dueDate + ") - " + (completed ? "Completed" : "Pending");
    }
}

public class Main {
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the To-Do List Application!");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Complete");
            System.out.println("4. Edit Task");
            System.out.println("5. Delete Task");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addTask();
                    break;
                case "2":
                    viewTasks();
                    break;
                case "3":
                    markTaskComplete();
                    break;
                case "4":
                    editTask();
                    break;
                case "5":
                    deleteTask();
                    break;
                case "6":
                    System.out.println("Thank you for using the To-Do List Application. Have a Great day!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addTask() {
        System.out.print("Enter task description: ");
        String desc = scanner.nextLine().trim();
        System.out.print("Enter due date (optional, press Enter to skip): ");
        String dueDate = scanner.nextLine().trim();
        tasks.add(new Task(desc, dueDate));
        System.out.println("Task added successfully!");
    }

    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
            return;
        }
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    private static void markTaskComplete() {
        viewTasks();
        System.out.print("Enter the task number to mark as complete: ");
        try {
            int num = Integer.parseInt(scanner.nextLine()) - 1;
            if (num >= 0 && num < tasks.size()) {
                tasks.get(num).markCompleted();
                System.out.println("Task marked as complete!");
            } else {
                System.out.println("Invalid task number.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a number.");
        }
    }

    private static void editTask() {
        viewTasks();
        System.out.print("Enter the task number to edit: ");
        try {
            int num = Integer.parseInt(scanner.nextLine()) - 1;
            if (num >= 0 && num < tasks.size()) {
                Task task = tasks.get(num);
                System.out.print("Enter new description (press Enter to keep current): ");
                String newDesc = scanner.nextLine().trim();
                System.out.print("Enter new due date (press Enter to keep current): ");
                String newDate = scanner.nextLine().trim();

                if (!newDesc.isEmpty()) {
                    task.setDescription(newDesc);
                }
                if (!newDate.isEmpty()) {
                    task.setDueDate(newDate);
                }
                System.out.println("Task updated successfully!");
            } else {
                System.out.println("Invalid task number.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a number.");
        }
    }

    private static void deleteTask() {
        viewTasks();
        System.out.print("Enter the task number to delete: ");
        try {
            int num = Integer.parseInt(scanner.nextLine()) - 1;
            if (num >= 0 && num < tasks.size()) {
                tasks.remove(num);
                System.out.println("Task deleted successfully!");
            } else {
                System.out.println("Invalid task number.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a number.");
        }
    }
}
