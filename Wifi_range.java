class Solution {
    boolean wifiRange(String s, int x) {
        int n = s.length();
        boolean[] covered = new boolean[n];

        // Mark all covered rooms
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {

                int left = Math.max(0, i - x);
                int right = Math.min(n - 1, i + x);

                for (int j = left; j <= right; j++) {
                    covered[j] = true;
                }
            }
        }

        // Check if every room is covered
        for (int i = 0; i < n; i++) {
            if (!covered[i]) {
                return false;
            }
        }

        return true;
    }
}

