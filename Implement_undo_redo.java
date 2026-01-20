class Solution 
{
    StringBuilder sb=new StringBuilder();
    Stack<Character> stack=new Stack<>();
    
    public void append(char x) {
        sb.append(x);
    }

    public void undo() {
        int len=sb.length();
        stack.push(sb.charAt(len-1));
        sb.deleteCharAt(len-1);
    }

    public void redo() {
        sb.append(stack.pop());
    }

    public String read() {
        return sb.toString();
    }
}