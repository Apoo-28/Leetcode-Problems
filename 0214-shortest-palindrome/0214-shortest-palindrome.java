class Solution {
    public String shortestPalindrome(String s) {
        if(s == null || s.length() == 0) return s;
        String ss = s + "#" + new StringBuilder(s).reverse().toString();
        int[] next = new int[ss.length()];
        next[0] = -1;
        for(int i = 1, j = -1; i < ss.length(); i++){
            while(j > -1 && ss.charAt(i) != ss.charAt(j + 1))
                j = next[j];
            if(ss.charAt(i) == ss.charAt(j + 1)) j++;
            next[i] = j;
        }
        return new StringBuilder(s.substring(next[ss.length() - 1] + 1, s.length())).reverse().toString() + s;
    }
}