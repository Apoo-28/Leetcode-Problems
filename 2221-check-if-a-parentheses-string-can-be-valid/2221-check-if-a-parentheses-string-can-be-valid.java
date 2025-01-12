class Solution {

    // Method to determine if a string can be made valid by swapping parentheses
    public boolean canBeValid(String s, String locked) {
        int n = s.length();

        // If the length of the string is odd, it can't be a valid string of parentheses
        if (n % 2 == 1) {
            return false;
        }

        // Initialize the balance counter for left-to-right scan
        int balance = 0;

        // Left-to-right scan to ensure all ')' can be matched
        for (int i = 0; i < n; ++i) {
            // If we have an unlocked character or a '(', we can potentially match a ')'
            if (s.charAt(i) == '(' || locked.charAt(i) == '0') {
                ++balance;
            } else if (balance > 0) {
                // We have a locked ')' and we have an earlier '(', so pair them
                --balance;
            } else {
                // Mismatched ')' which cannot be matched
                return false;
            }
        }

        // Reset the balance counter for right-to-left scan
        balance = 0;

        // Right-to-left scan to ensure all '(' can be matched
        for (int i = n - 1; i >= 0; --i) {
            // If we have an unlocked character or a ')', we can potentially match a '('
            if (s.charAt(i) == ')' || locked.charAt(i) == '0') {
                ++balance;
            } else if (balance > 0) {
                // We have a locked '(' and we have an earlier ')', so pair them
                --balance;
            } else {
                // Mismatched '(' which cannot be matched
                return false;
            }
        }

        // If all the checks pass, the string can be made valid
        return true;
    }
}