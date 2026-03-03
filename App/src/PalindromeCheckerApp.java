// =============================================================
// UC8 : Linked List Based Palindrome Checker App
// -------------------------------------------------------------
// Use Case 8: Linked List Based Palindrome Checker
//
// Description:
// This class checks whether a given string is a palindrome
// using a Singly Linked List.
//
// Characters are added to the list and then compared
// by reversing the second half in-place.
//
// Concepts Used:
// - Singly Linked List
// - Fast and Slow Pointer Technique
// - In-Place Reversal
// - Node Traversal
// =============================================================

public class PalindromeCheckerApp {

    // Node class for Singly Linked List
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to check palindrome using linked list
    public static boolean isPalindrome(String input) {

        if (input == null || input.length() == 0) {
            return true;
        }

        // Step 1: Convert string to linked list
        Node head = null;
        Node tail = null;

        for (char ch : input.toCharArray()) {
            Node newNode = new Node(ch);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        // Step 2: Use fast and slow pointer to find middle
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 3: Reverse second half of list
        Node prev = null;
        Node current = slow;

        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        // Step 4: Compare first half and reversed second half
        Node firstHalf = head;
        Node secondHalf = prev;

        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    // Main method (Application entry point for UC8)
    public static void main(String[] args) {

        // Define input string
        String input = "level";

        // Check palindrome
        boolean result = isPalindrome(input);

        // Output
        System.out.println("Input: " + input);
        System.out.println("Is Palindrome? " + result);
    }
}