import java.util.*;

// Strategy Interface
interface PalindromeStrategy {
    boolean check(String input);
}

// Stack Strategy
class StackStrategy implements PalindromeStrategy {

    public boolean check(String input) {

        Stack<Character> stack = new Stack<>();

        // Push characters
        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        // Compare characters
        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

// Deque Strategy
class DequeStrategy implements PalindromeStrategy {

    public boolean check(String input) {

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
}

// Main Class
public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter input: ");
        String input = sc.nextLine();

        System.out.println("Choose Strategy:");
        System.out.println("1. Stack Strategy");
        System.out.println("2. Deque Strategy");

        int choice = sc.nextInt();

        PalindromeStrategy strategy;

        if (choice == 1) {
            strategy = new StackStrategy();
        } else {
            strategy = new DequeStrategy();
        }

        boolean result = strategy.check(input);

        System.out.println("Input: " + input);
        System.out.println("Is Palindrome? : " + result);

        sc.close();
    }
}