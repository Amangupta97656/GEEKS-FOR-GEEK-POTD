class Solution {
    public int maxSubarrayXOR(int[] arr, int k) {
        // code here
        int maxi=0,xor=0;
        for(int i=0;i<arr.length;i++){
            xor=xor^arr[i];
            if(i>=k-1){
                maxi=Math.max(maxi,xor);
                xor=xor^arr[i-k+1];
            }
        }
        return maxi;
    }
}