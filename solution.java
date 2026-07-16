class Solution {
    public int[] nextsmaller(int arr[],int[] nse){
        Stack<Integer>st=new Stack<>();
        int n=arr.length;
        for(int i=n-1;i>=0;i--){
            while(!st.empty() && arr[st.peek()]>=arr[i])
              st.pop();
            nse[i]=st.empty()?n:st.peek();
            st.push(i);

        }
        return nse;}
        public int[] prevsmaller(int arr[],int[] pse){
        Stack<Integer>st=new Stack<>();
        int n=arr.length;
        for(int i=0;i<n;i++){
            while(!st.empty() && arr[st.peek()]>arr[i])
              st.pop();
            pse[i]=st.empty()?-1:st.peek();
            st.push(i);

        }
        return pse;}
      public long sumMins(int[] arr) {
        int n=arr.length;
        long total=0;
     

        int[] nse=new int[n];
        int[] pse=new int[n];
        nextsmaller(arr,nse);
        prevsmaller(arr,pse);
        for(int i=0;i<n;i++){
    int l=i-pse[i];
    int r=nse[i]-i;
    long freq = 1L * l * r;
            total += freq * arr[i];
        }

        return total;
    }
    public int[] nextgreater(int[]arr,int[] nge){
        Stack<Integer>st=new Stack<>();
        int n=arr.length;
        for(int i=n-1;i>=0;i--){
            while(!st.empty() && arr[st.peek()]<=arr[i])
             st.pop();
            nge[i]=st.empty()?n:st.peek();
            st.push(i);
        }
        return nge;}
    public int[] prevgreater(int[] arr,int[] pge){
        Stack<Integer>st=new Stack<>();
        int n=arr.length;
        for(int i=0;i<n;i++){
            while(!st.empty() && arr[st.peek()]<arr[i])
              st.pop();
            pge[i]=st.empty()?-1:st.peek();
            st.push(i);
        }
        return pge;
    }
    
    public long sumMaxs(int[] arr){
        int n=arr.length;
        int[] nge=new int[n];
        int[] pge=new int[n];
        nextgreater(arr,nge);
        prevgreater(arr,pge);
        long total=0;
       
        for(int i=0;i<n;i++){
            int l=i-pge[i];
            int r=nge[i]-i;
            long freq = 1L * l * r;
            total+= freq * arr[i];

        }
        return total;
    }
    
    public long subArrayRanges(int[] arr) {
        return sumMaxs(arr)-sumMins(arr);
        
    }
}