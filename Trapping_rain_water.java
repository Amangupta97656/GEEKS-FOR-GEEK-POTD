class Solution {
    public int maxWater(int arr[]) {
        
        int n = arr.length;
        int lh = arr[0], rh = arr[n-1];
        int l=0, r = n-1;
        
        int res = 0;
        while(l < r) {
            if(lh < rh) {
                if(lh < arr[l]) {
                    lh = arr[l];
                    continue;
                }
                res += (lh - arr[l]);
                l++;
            }
            else {
                if(rh < arr[r]) {
                    rh = arr[r];
                    continue;
                }
                res += (rh - arr[r]);
                r--;
            }
        }
        return res;
    }
}