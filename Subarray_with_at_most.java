class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    void add(int x) {
        map.put(x, map.getOrDefault(x, 0) + 1);
    }
    void remove(int x) {
        map.put(x, map.getOrDefault(x, 0) - 1);
        if(map.get(x) == 0) {
            map.remove(x);
        }
    }
    public int countAtMostK(int arr[], int k) {
        // code here
        
        int ans = 0, left = 0, right = 0;
        
        while(right < arr.length) {
            add(arr[right]);
            
            while(map.size() > k && left <= right) {
                remove(arr[left++]);
            }
            ans += (right - left + 1);
            right++;
        }
        return ans;
    }
}
 