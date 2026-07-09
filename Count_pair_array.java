class Solution {
    public int countKdivPairs(int[] arr, int k) {
        int[] rem = new int[k];
        int res = 0;

        for (int i = 0; i < arr.length; i++) {
            int r = arr[i] % k;
            int sec = (k - r) % k;

            res += rem[sec];
            rem[r]++;
        }

        return res;
    }
}