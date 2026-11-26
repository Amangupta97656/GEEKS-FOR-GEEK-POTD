class Solution {
    public ArrayList<Integer> countVowels(String s, int[][] queries) {
        // code here
        int n = s.length();
        int[] arr = new int[n+1];
        // concept(prefix arr used.)
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='a'||s.charAt(i)=='e'||s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='u'){
              arr[i+1] = arr[i] +1;
            }
            else{
                arr[i+1] = arr[i];
            }
        }
        
        int size = queries.length;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<size;i++){
            int start = queries[i][0];
            int end = queries[i][1];
            int temp = arr[end+1] - arr[start];
            ans.add(temp);
        }
        return ans;
    }
}