/**
 * UC12: Strategy Pattern for Palindrome Algorithms (Advanced)
 *
 * This program demonstrates dynamic selection of
 * palindrome algorithms using Strategy Pattern.
 *
 * Concepts:
 * - Interface
 * - Polymorphism
 * - Strategy Pattern
 * - Data Structures (Stack / Deque)
 */

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Please provide a string as input.");
            return;
        }

        String input = args[0];

        // Choose strategy dynamically
        // You can change this to new DequeStrategy()
        PalindromeStrategy strategy = new StackStrategy();

        boolean result = strategy.check(input);

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + result);
    }
}


/**
 * Strategy Interface
 */
interface PalindromeStrategy {
    boolean check(String input);
}


/**
 * Stack-based implementation of PalindromeStrategy
 */
class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String input) {

        java.util.Stack<Character> stack = new java.util.Stack<>();

        // Push characters onto stack
        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        // Compare by popping
        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}


/**
 * Deque-based implementation of PalindromeStrategy
 */
class DequeStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String input) {

        java.util.Deque<Character> deque = new java.util.ArrayDeque<>();

        for (char c : input.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }

        return true;
    }
}