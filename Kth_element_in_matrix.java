class Solution {
    public int kthSmallest(int[][] mat, int k) {
        // code here
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                pq.add(mat[i][j]);
                if(pq.size()>k){
                    pq.poll();
                }
            }
        }
        return pq.peek();
    }
}