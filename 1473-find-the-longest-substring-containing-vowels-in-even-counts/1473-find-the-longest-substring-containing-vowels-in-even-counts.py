class Solution(object):
    def findTheLongestSubstring(self, s):
        # Map each vowel to a bit position
        vowel_to_bit = {'a': 0, 'e': 1, 'i': 2, 'o': 3, 'u': 4}
        
        # Dictionary to store the first occurrence of each bitmask
        first_occurrence = {0: -1}  # Starting with bitmask 0 at index -1
        
        # Initialize the bitmask to represent no vowels encountered
        bitmask = 0
        max_len = 0  # Variable to track the longest valid substring
        
        # Iterate over the string, character by character
        for i, char in enumerate(s):
            if char in vowel_to_bit:
                # Toggle the corresponding bit for this vowel
                bitmask ^= (1 << vowel_to_bit[char])
            
            # Check if we have seen this bitmask before
            if bitmask in first_occurrence:
                # Calculate the length of the substring if the bitmask is found
                max_len = max(max_len, i - first_occurrence[bitmask])
            else:
                # Record the first occurrence of the bitmask
                first_occurrence[bitmask] = i
        
        return max_len