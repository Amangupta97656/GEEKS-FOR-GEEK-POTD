class Solution {

    public ArrayList<Integer> commonElements(int[] a, int[] b, int[] c) {

        int m=a.length,n=b.length,p=c.length;

        int i=0,j=0,k=0;

        ArrayList<Integer>ans=new ArrayList<>();

        while(i<m&&j<n&&k<p){

         if(a[i]==b[j]&&b[j]==c[k]){

             ans.add(a[i]);

             int cur=a[i];

             i++;j++;k++;

             while(i<m&&a[i]==cur)

             i++;

             while(j<n&&b[j]==cur)

             j++;

             while(k<p&&c[k]==cur)

             k++;

         }else{

        int min=Math.min(a[i],Math.min(b[j],c[k]));

         if(a[i]==min)

         i++;

         if(b[j]==min)

         j++;

         if(c[k]==min)

         k++;

             

         }

        }

       return ans;

    }

}