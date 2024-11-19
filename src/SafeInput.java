import java.util.Scanner;

public class SafeInput {


    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String response = "";
        boolean validInput = false;

        do {
            System.out.print(prompt + ": ");
            response = pipe.nextLine().trim();

            if (response.matches(regEx)) {
                validInput = true;
            } else {
                System.out.println("Input does not match the required pattern. Please try again.");
            }
        } while (!validInput);

        return response;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String response = "";
        boolean validInput = false;
        boolean result = false;

        do {
            System.out.print(prompt + " [Y/N]: ");
            response = pipe.nextLine().trim();

            if (response.equalsIgnoreCase("Y")) {
                validInput = true;
                result = true;
            } else if (response.equalsIgnoreCase("N")) {
                validInput = true;
                result = false;
            } else {
                System.out.println("You must enter 'Y' or 'N', not " + response);
            }
        } while (!validInput);

        return result;
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double retVal = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.print(prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextDouble()) {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                if (retVal >= low && retVal <= high) {
                    done = true;
                } else {
                    System.out.println("You must enter a number between " + low + " and " + high);
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter a valid number, not " + trash);
            }
        } while (!done);

        return retVal;
    }



    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int retVal = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.print(prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                pipe.nextLine();
                if (retVal >= low && retVal <= high) {
                    done = true;
                } else {
                    System.out.println("You must enter a number between " + low + " and " + high);
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter a valid integer, not " + trash);
            }
        } while (!done);

        return retVal;
    }

    public static double getDouble(Scanner pipe, String prompt) {
        double retVal = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.print(prompt + ": ");
            if (pipe.hasNextDouble()) { // Check if the input is a double
                retVal = pipe.nextDouble();
                pipe.nextLine(); // Clear the newline character
                done = true;
            } else {
                trash = pipe.nextLine(); // Consume invalid input
                System.out.println("You must enter a valid number, not " + trash);
            }
        } while (!done);

        return retVal;
    }






    public static int getInt(String prompt, Scanner pipe)
    {
        int retVal = 0;
        String trash = "";
        boolean done = false;

        do
        {
            System.out.print(prompt + ": ");
            if (pipe.hasNextInt())
            {
                retVal = pipe.nextInt();
                pipe.nextLine();
                done = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter a valid integer, not " + trash);
            }

        }while(!done);

        return retVal;

    }

    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retVal = "";

        do {
            System.out.print(prompt + ": ");
            retVal = pipe.nextLine();
            if (retVal.isEmpty()) {
                System.out.println("You must enter at least one character!");
            }

        } while (retVal.isEmpty());
        return retVal;

    }

    public static void prettyHeader(String msg) {
        final int totalWidth = 60;
        final int starsAtEnds = 3;

        // Calculate the length of the centered message
        int msgLength = msg.length();
        int totalMsgWidth = totalWidth - (starsAtEnds * 2) - 2; // Account for stars and spaces
        String formattedMsg;

        // Center the message
        if (msgLength > totalMsgWidth) {
            formattedMsg = msg.substring(0, totalMsgWidth - 3) + "..."; // Trim and add ellipsis if too long
        } else {
            int spaces = totalMsgWidth - msgLength;
            String padding = " ".repeat(spaces / 2); // Calculate padding for centering
            formattedMsg = padding + msg + padding;

            // Add one more space if the total length is odd
            if (spaces % 2 != 0) {
                formattedMsg += " ";
            }
        }

        // Print top border
        for (int i = 0; i < totalWidth; i++) {
            System.out.print("*");
        }
        System.out.println();

        // Print the centered message with stars at both ends
        System.out.printf("***%s***%n", formattedMsg);

        // Print bottom border
        for (int i = 0; i < totalWidth; i++) {
            System.out.print("*");
        }
        System.out.println();


    }



}

