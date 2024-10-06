// package week4.MyLinkedList;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Scanner;

/**
 * This program reads a list of numbers from the scanned input and
 * saves them into a Linked List sorted from the smallest to the largest (ascending order).
 * This program also shows examples of code reuse such as using LinkedList and Collections.sort().
 * I also seperated the logic of reading the input and the actual linkedlist method
 *
 * <p>Running the program:</p>
 * <ul>
 *   <li>Compiling: <code>javac MyLinkedList.java</code></li>
 *   <li>Running: <code>java MyLinkedList</code></li>
 *   <li>Generating Javadocs: <code>javadoc -d docs MyLinkedList.java</code></li>
 * </ul>
 *
 * <p>Program features:</p>
 * <ol>
 *   <li>Read a list of integers from user input</li>
 *   <li>Will validates the user input to ensure it's an integer type</li>
 *   <li>Will sorts the numbers within the LinkedList in ascending order</li>
 *   <li>Will print the sorted list to the terminal</li>
 * </ol>
 */
public class MyLinkedList {
  /**
  * This method will reads a list of integer numbers from a user, input from
  * the terminal.
  * It will then store them in a LinkedList data structure, and sorts them in
  * asc order.
  *
  * @param args cmd line arguments. These weren't used.
  */
  public static void main(String[] args) {
      // Will handle creating a LL
      LinkedList<Integer> numbers = readNumbers();

      // Will sort the LL
      sortMyLinkedList(numbers);

      // Print the linked list to terminal
      System.out.println("Your sorted linked list is the following: " + numbers);
  }

  /**
     * Handles reading the user input of integers from a terminal and store them
     * within a linkedlist.
     *
     * @return linkedlist.
     */
    public static LinkedList<Integer> readNumbers() {
      Scanner scanner = new Scanner(System.in);
      LinkedList<Integer> numbers_ll = new LinkedList<>();

      System.out.println("Enter list of numbers - (enter x to end list):");

      // Reading integer input from the user until they type "x"
      while (scanner.hasNext()) {
          String input = scanner.next();

          // Exit the loop if the input is "exit" or "x"
          if (input.equalsIgnoreCase("x") || input.equalsIgnoreCase("exit")) {
              break;
          }

         // Check if the input is a valid integer
            if (!checkIfValidInt(input)) {
             System.out.println("Invalid number, please only enter a number.");
             continue; // Prompt the user to enter again if the input is invalid
         }

         int number = Integer.parseInt(input);
         numbers_ll.add(number);
      }

      // Closing the scanner to prevent resource leak
      scanner.close();

      return numbers_ll;
  }

  /**
     * This method will sort a LinkedList in ascending order.
     * As an explicit example code reuse, this method uses the sort method from
     * Collections as an alternative to writing a sorting method from scratch.
     *
     * @param numbers_ll The LinkedList that will be sorted in ascending order.
     */
    public static void sortMyLinkedList(LinkedList<Integer> numbers_ll) {
      // Reusing the Collections framework sort method to sort the list
      Collections.sort(numbers_ll);
  }

  /**
  * This method will validate if the input a user entered is a valid number.
  *
  * @param user_input the string to check if a valid number.
  */
  public static boolean checkIfValidInt(String user_input){
    // Iterate through each character of the user_input string
       for (char ch : user_input.toCharArray()) {
        // Check if any character is not a digit, if either is not a digit, will return false
        if (!Character.isDigit(ch)) {
            return false; // If any character is not a digit, return false
        }
    }
    // If all characters are integers, will return true.
    return true;
  }
}
