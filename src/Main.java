import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(); 
        Scanner in = new Scanner(System.in);
        boolean running = true;

        while (running) {
            displayMenu(list);

            String choice = SafeInput.getRegExString(in, "Enter choice [A/D/I/P/Q]: ", "[AaDdIiPpQq]").toUpperCase();

            switch (choice) {
                case "A":
                    String newItem = SafeInput.getNonZeroLenString(in, "Enter item to add: ");
                    list.add(newItem);
                    System.out.println("Item added!");
                    break;

                case "D":
                    if (list.isEmpty()) {
                        System.out.println("The list is empty. Nothing to delete.");
                    } else {
                        int indexToDelete = SafeInput.getRangedInt(in, "Enter item number to delete: ", 1, list.size());
                        list.remove(indexToDelete - 1);
                        System.out.println("Item deleted!");
                    }
                    break;

                case "I":
                    if (list.isEmpty()) {
                        System.out.println("The list is empty. Adding the first item...");
                        String firstItem = SafeInput.getNonZeroLenString(in, "Enter item to add: ");
                        list.add(firstItem);
                    } else {
                        int indexToInsert = SafeInput.getRangedInt(in, "Enter position to insert (1 to " + (list.size() + 1) + "): ", 1, list.size() + 1);
                        String itemToInsert = SafeInput.getNonZeroLenString(in, "Enter item to insert: ");
                        list.add(indexToInsert - 1, itemToInsert);
                        System.out.println("Item inserted!");
                    }
                    break;

                case "P":
                    displayList(list);
                    break;

                case "Q": // Quit
                    if (SafeInput.getYNConfirm(in, "Are you sure you want to quit? (Y/N): ")) {
                        running = false;
                        System.out.println("Goodbye!");
                    }
                    break;
            }
        }

        in.close();
    }


    private static void displayMenu(ArrayList<String> list) {
        System.out.println("\nCurrent List:");
        displayList(list);
        System.out.println("\nMenu:");
        System.out.println("A - Add an item");
        System.out.println("D - Delete an item");
        System.out.println("I - Insert an item");
        System.out.println("P - Print the list");
        System.out.println("Q - Quit");
    }

    private static void displayList(ArrayList<String> list) {
        if (list.isEmpty()) {
            System.out.println("[The list is empty]");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i + 1) + ". " + list.get(i));
            }
        }
    }
}
