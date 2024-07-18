import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<String> list = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean quit = false;
        while (!quit) {
            displayMenu();
            String choice = SafeInput.getRegExString(scanner, "Enter a choice: ", "[AaDdIiPpQq]");
            switch (choice.toUpperCase()) {
                case "A":
                    addItem();
                    break;
                case "D":
                    deleteItem();
                    break;
                case "I":
                    insertItem();
                    break;
                case "P":
                    printList();
                    break;
                case "Q":
                    quit = quitProgram();
                    break;
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nCurrent List:");
        printList();
        System.out.println("\nMenu:");
        System.out.println("A - Add an item to the list");
        System.out.println("D - Delete an item from the list");
        System.out.println("I - Insert an item into the list");
        System.out.println("P - Print the list");
        System.out.println("Q - Quit");
    }

    private static void addItem() {
        String item = SafeInput.getRegExString(scanner, "Enter an item to add: ", ".+");
        list.add(item);
    }

    private static void deleteItem() {
        if (list.isEmpty()) {
            System.out.println("The list is empty. Nothing to delete.");
            return;
        }
        int itemNumber = SafeInput.getRangedInt(scanner, "Enter the item number to delete: ", 1, list.size());
        list.remove(itemNumber - 1);
    }

    private static void insertItem() {
        if (list.isEmpty()) {
            System.out.println("The list is empty. Adding item to the start of the list.");
            addItem();
            return;
        }
        int itemNumber = SafeInput.getRangedInt(scanner, "Enter the position to insert the item: ", 1, list.size() + 1);
        String item = SafeInput.getRegExString(scanner, "Enter an item to insert: ", ".+");
        list.add(itemNumber - 1, item);
    }

    private static void printList() {
        if (list.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i + 1) + ": " + list.get(i));
            }
        }
    }

    private static boolean quitProgram() {
        return SafeInput.getYNConfirm(scanner, "Are you sure you want to quit? (Y/N): ");
    }
}
