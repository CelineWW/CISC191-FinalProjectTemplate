package edu.sdccd.cisc191.template;
import java.util.Scanner;

public class TwoDArrayMenu {
    private static int[][] array;
    private static int rows;
    private static int cols;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize the array
        System.out.print("Enter number of rows: ");
        rows = scanner.nextInt();
        System.out.print("Enter number of columns: ");
        cols = scanner.nextInt();
        array = new int[rows][cols];

        boolean running = true;
        while (running) {
            printMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    getAtIndex(scanner);
                    break;
                case 2:
                    setAtIndex(scanner);
                    break;
                case 3:
                    findIndexOf(scanner);
                    break;
                case 4:
                    printAll();
                    break;
                case 5:
                    deleteAtIndex(scanner);
                    break;
                case 6:
                    expand(scanner);
                    break;
                case 7:
                    shrink(scanner);
                    break;
                case 8:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("Menu:");
        System.out.println("1. Get value at index");
        System.out.println("2. Set value at index");
        System.out.println("3. Find index of value");
        System.out.println("4. Print all values");
        System.out.println("5. Delete value at index");
        System.out.println("6. Expand array");
        System.out.println("7. Shrink array");
        System.out.println("8. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void getAtIndex(Scanner scanner) {
        System.out.print("Enter row index: ");
        int row = scanner.nextInt();
        System.out.print("Enter column index: ");
        int col = scanner.nextInt();
        if (isValidIndex(row, col)) {
            System.out.println("Value at (" + row + ", " + col + "): " + array[row][col]);
        } else {
            System.out.println("Invalid index.");
        }
    }

    private static void setAtIndex(Scanner scanner) {
        System.out.print("Enter row index: ");
        int row = scanner.nextInt();
        System.out.print("Enter column index: ");
        int col = scanner.nextInt();
        if (isValidIndex(row, col)) {
            System.out.print("Enter value: ");
            array[row][col] = scanner.nextInt();
        } else {
            System.out.println("Invalid index.");
        }
    }

    private static void findIndexOf(Scanner scanner) {
        System.out.print("Enter value to find: ");
        int value = scanner.nextInt();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (array[i][j] == value) {
                    System.out.println("Value " + value + " found at (" + i + ", " + j + ")");
                    return;
                }
            }
        }
        System.out.println("Value not found.");
    }

    private static void printAll() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void deleteAtIndex(Scanner scanner) {
        System.out.print("Enter row index: ");
        int row = scanner.nextInt();
        System.out.print("Enter column index: ");
        int col = scanner.nextInt();
        if (isValidIndex(row, col)) {
            array[row][col] = 0; // Assuming 0 as the default value for deletion
        } else {
            System.out.println("Invalid index.");
        }
    }

    private static void expand(Scanner scanner) {
        System.out.print("Enter new number of rows: ");
        int newRows = scanner.nextInt();
        System.out.print("Enter new number of columns: ");
        int newCols = scanner.nextInt();
        if (newRows <= rows || newCols <= cols) {
            System.out.println("New size must be larger.");
            return;
        }
        int[][] newArray = new int[newRows][newCols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                newArray[i][j] = array[i][j];
            }
        }
        array = newArray;
        rows = newRows;
        cols = newCols;
    }

    private static void shrink(Scanner scanner) {
        System.out.print("Enter new number of rows: ");
        int newRows = scanner.nextInt();
        System.out.print("Enter new number of columns: ");
        int newCols = scanner.nextInt();
        if (newRows >= rows || newCols >= cols) {
            System.out.println("New size must be smaller.");
            return;
        }
        int[][] newArray = new int[newRows][newCols];
        for (int i = 0; i < newRows; i++) {
            for (int j = 0; j < newCols; j++) {
                newArray[i][j] = array[i][j];
            }
        }
        array = newArray;
        rows = newRows;
        cols = newCols;
    }

    private static boolean isValidIndex(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
}
