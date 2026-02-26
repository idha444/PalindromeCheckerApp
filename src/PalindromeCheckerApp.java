import java.util.*;

public class PalindromeCheckerApp {

    // Method 1: Using Stack
    public static boolean checkUsingStack(String input) {
        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    // Method 2: Using Deque
    public static boolean checkUsingDeque(String input) {
        Deque<Character> deque = new ArrayDeque<>();

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

    // Method 3: Using String Reversal
    public static boolean checkUsingReverse(String input) {
        String reversed = new StringBuilder(input).reverse().toString();
        return input.equals(reversed);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter input: ");
        String input = sc.nextLine();

        // Stack Timing
        long start1 = System.nanoTime();
        boolean result1 = checkUsingStack(input);
        long end1 = System.nanoTime();
        long time1 = end1 - start1;

        // Deque Timing
        long start2 = System.nanoTime();
        boolean result2 = checkUsingDeque(input);
        long end2 = System.nanoTime();
        long time2 = end2 - start2;

        // Reverse Timing
        long start3 = System.nanoTime();
        boolean result3 = checkUsingReverse(input);
        long end3 = System.nanoTime();
        long time3 = end3 - start3;

        System.out.println("\nInput: " + input);

        System.out.println("\nStack Method:");
        System.out.println("Is Palindrome? : " + result1);
        System.out.println("Execution Time: " + time1 + " ns");

        System.out.println("\nDeque Method:");
        System.out.println("Is Palindrome? : " + result2);
        System.out.println("Execution Time: " + time2 + " ns");

        System.out.println("\nReverse Method:");
        System.out.println("Is Palindrome? : " + result3);
        System.out.println("Execution Time: " + time3 + " ns");

        sc.close();
    }
}