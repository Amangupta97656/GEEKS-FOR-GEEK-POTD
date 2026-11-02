class Solution {
    public int largestSumCycle(int[] edge) {
        // code here
        int V = edge.length;

                ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

                for (int i = 0; i < V; i++) {
                    adj.add(new ArrayList<>());
                }

                for (int i = 0; i < V; i++) {
                    if (edge[i] != -1) {
                        adj.get(i).add(edge[i]);
                    }
                }

                int[] vis1 = new int[V];
                int[] vis2 = new int[V];

                long[] maxSum = {-1};

                for (int i = 0; i < V; i++) {

                    if (vis1[i] == 0) {
                        dfs(i, vis1, vis2, adj, maxSum);
                    }
                }

                return (int)maxSum[0];
            }

           
           private static void dfs(int node, int[] vis1, int[] vis2,
                                   ArrayList<ArrayList<Integer>> adj,
                                   long[] maxSum) {

               vis1[node] = 1;
               vis2[node] = 1;

               for (int num : adj.get(node)) {

                   if (vis1[num] == 0) {

                       dfs(num, vis1, vis2, adj, maxSum);

                   } else if (vis2[num] == 1) {

                       long sum = 0;
                       int curr = num;

                       do {
                           sum += curr;
                           curr = adj.get(curr).get(0);
                       } while (curr != num);

                       maxSum[0] = Math.max(maxSum[0], sum);
                   }
               }

               vis2[node] = 0;
           }

}