 class Solution {

    public boolean isBinaryPalindrome(int n) {

       String s = Integer.toBinaryString(n);

       String rev = new StringBuilder(s).reverse().toString();

       return s.equals(rev);

}

}.