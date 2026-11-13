class Solution {
    // Function to find the nodes that are common in both BST.
    public static ArrayList<Integer> inOrder(Node root){
        ArrayList<Integer> result=new ArrayList<>();
        inOrderHelper(root,result);
        return result;
    }
    public static void inOrderHelper(Node root, ArrayList<Integer> result){
        if(root==null) return;
        inOrderHelper(root.left,result);
        result.add(root.data);
        inOrderHelper(root.right,result);
    }
    public static ArrayList<Integer> findCommon(Node r1, Node r2) {
        // code here
        ArrayList<Integer> a1=inOrder(r1);
        ArrayList<Integer> a2=inOrder(r2);
        ArrayList<Integer> res=new ArrayList<>();
        Set<Integer> s=new HashSet<>();
        for(int i=0;i<a2.size();i++){
            s.add(a2.get(i));
        }
        for(int i=0;i<a1.size();i++){
            if(s.contains(a1.get(i))){
                res.add(a1.get(i));
            }
        }
        return res;
    }
}

