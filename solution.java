class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer>st=new Stack<>();
        int i=0;
        int j=0;
        int n=pushed.length;
        while(i<n && j<n){
            st.push(pushed[i]);
            while( !st.isEmpty() && j<n && popped[j]==st.peek()){
                st.pop();
                j++;
            }
            i++;
           

        }
        if(st.isEmpty())
             return true;
        return false;
    }
}