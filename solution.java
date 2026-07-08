import java.util.*;
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int[][] ans=new int[m][n];
        int[][] vis=new int[m][n];
        Queue<int[]>q=new LinkedList<>();
        for(int i=0;i<m;i++)
         for(int j=0;j<n;j++){
            if(mat[i][j]==0){
                vis[i][j]=1;
                q.add(new int[]{i,j,0});
            }
            else
             vis[i][j]=0;
             
         }
         int[][] dis={{0,1},{0,-1},{1,0},{-1,0}};
         while(!q.isEmpty()){
            int[] curr=q.poll();
            int r=curr[0];
            int c=curr[1];
            int steps=curr[2];
            ans[r][c]=steps;
            for(int d[]:dis){
                int row=r+d[0];
                int col=c+d[1];
                if(row>=0 && row<m && col>=0 && col<n && vis[row][col]==0){
                    vis[row][col]=1;
                    q.add(new int[]{row,col,steps+1});

                } 
            }
         }
         return ans;
        
        
    }
}