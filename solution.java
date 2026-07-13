class Solution {
    public boolean helper(int[]state,   ArrayList<Integer>[]adj,int i,ArrayList<Integer>list){
        if(state[i]==1)
         return false;
        if(state[i]==2){
           
         return true;}
        state[i]=1;
        for(int n:adj[i]){
            if(!helper(state,adj,n,list))
             return false;
        }
        state[i]=2;
         list.add(i);
        return true;
     }
    public int[] findOrder(int n, int[][] pre) {
      ArrayList<Integer>[]adj=new ArrayList[n];
       
        for(int i=0;i<n;i++)
            adj[i]=new ArrayList<>();
        for(int[] ds:pre){
            int u=ds[0];
            int v=ds[1];
            adj[v].add(u);
        }
      
       ArrayList<Integer>list=new ArrayList<>();
       int[] state=new int[n];
       int[] ans=new int[n];
        for(int i=0;i<n;i++){
           
           if(  helper(state,adj,i,list)==false)
            return new int[0];
      
        

        }
        Collections.reverse(list);

        for (int i = 0; i < list.size(); i++) {
    ans[i] = list.get(i);
}
return ans;

        
    }
}