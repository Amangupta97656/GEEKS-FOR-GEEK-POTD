class Solution {
    public int minimumCost(int[] cost, int w) {
        int n = cost.length;
        
        int[][] memo = new int[n][w +1];
        for (int[] mem: memo) {
            Arrays.fill(mem, -1);
        }
        
        int val = recur(n -1, w, cost, memo);
        return val >= (int)1e9 ? -1: val;
    }
    
    private int recur(int i, int w, int[] cost, int[][] memo) {
        if (w == 0) return 0;
        if (i == 0) {
            if (cost[i] >= 0 && w % (i +1) == 0) 
                return (w / (i +1)) * cost[i];
            return (int)1e9;
        }
        if (memo[i][w] != -1) return memo[i][w];
        
        int skip = recur(i -1, w, cost, memo);
        int pick = (int)1e9;
        if (w >= (i +1) && cost[i] >= 0) {
            pick = cost[i] + recur(i, w - (i +1), cost, memo);
        }
        return memo[i][w] = Math.min(pick, skip);
    }
}