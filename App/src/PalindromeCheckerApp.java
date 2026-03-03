/*
 * ==========================================================
 * MAIN CLASS - UseCase6PalindromeCheckerApp
 * ==========================================================
 *
 * Use Case 6: Queue + Stack Based Palindrome Check
 *
 * Description:
 * This class demonstrates palindrome validation using
 * two different data structures:
 *
 * Queue (FIFO - First In First Out)
 * Stack (LIFO - Last In First Out)
 *
 * Characters are inserted into both structures and then
 * compared by removing from the front of the queue and
 * the top of the stack.
 *
 * If all characters match, the input string is confirmed
 * as a palindrome.
 *
 * This use case helps understand how FIFO and LIFO
 * behaviors can be combined for symmetric comparison.
 *
 * Author: Developer
 * Version: 1.0
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PalindromeCheckerApp {

    /*
     * Application entry point for UC6.
     * Demonstrates palindrome validation.
     */
    public static void main(String[] args) {

        // Define the input string to validate
        String input = "civic";

        // Create Queue to store characters in FIFO order
        Queue<Character> queue = new LinkedList<>();

        // Create Stack to store characters in LIFO order
        Stack<Character> stack = new Stack<>();

        // Insert each character into both queue and stack
        for (char ch : input.toCharArray()) {
            queue.add(ch);     // Enqueue operation
            stack.push(ch);    // Push operation
        }

        // Flag to track palindrome status
        boolean isPalindrome = true;

        // Compare characters until the queue becomes empty
        while (!queue.isEmpty()) {

            char fromQueue = queue.remove();  // Dequeue
            char fromStack = stack.pop();     // Pop

            if (fromQueue != fromStack) {
                isPalindrome = false;
                break;
            }
        }

        // Display the result
        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);
    }
}