public class PalindromeCheckerApp {
    public static void main(String[] args){
        //UC4
        // Declare and initialize hte input string
        String input = "radar";

        // Convert the string into a character array
        char[] chars = input.toCharArray();

        // Initialize pointer at the beginning
        int start = 0;

        // initialize pointer at the end
        int end = chars.length - 1;

        // Assume palindrome initially
        boolean isPalindrome = true;

        // Continue comparison until pointers cross.
        while (start < end){

            if (chars[start] != chars[end]){
                isPalindrome = false;
                break;

            }

            start++; //move forward
            end--; //move backward

        }

        System.out.println("Is it a Palindrome? : " + isPalindrome);

    }
}
