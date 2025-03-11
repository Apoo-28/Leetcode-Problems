class Solution {
    public int numberOfSubstrings(String s) {
          int len = s.length();
          char[] arr = s.toCharArray();
          int[] t = new int[3];
          int res = 0;
          int count = 0;
          int l = 0;
          for (int i = 0; i < len; i++) {
              t[arr[i] - 'a']++;
              while(t[0] > 0 && t[1] > 0 && t[2] > 0) {
                  count++;
                  t[arr[l] - 'a']--;
                  l++;
              }
              res += count;
          }
          return res;
      }
}