class Solution {
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        int[][] vis=new int[m][n];
        Queue<int[]>q=new LinkedList<>();
      for(int j = 0; j < n; j++){
    if(board[0][j] == 'O'){
        q.add(new int[]{0, j});
        vis[0][j] = 1;
    }
}
for(int j = 0; j < n; j++){
    if(board[m-1][j] == 'O'){
        q.add(new int[]{m-1, j});
        vis[m-1][j] = 1;
    }
}
for(int i = 0; i < m; i++){
    if(board[i][0] == 'O'){
        q.add(new int[]{i, 0});
        vis[i][0] = 1;
    }
}
for(int i = 0; i < m; i++){
    if(board[i][n-1] == 'O'){
        q.add(new int[]{i, n-1});
        vis[i][n-1] = 1;
    }
}
        int[][] dis={{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int r=curr[0];
            int c=curr[1];
            for(int[] d:dis){
                int row=r+d[0];
                int col=c+d[1];
                if(row>=0 && col>=0 && row<m && col<n && vis[row][col]==0 && board[row][col]=='O'){
                    vis[row][col]=1;
                    q.add(new int[]{row,col});
                }
            }
        }
        for(int i=0;i<m;i++)
         for(int j=0;j<n;j++)
          if(board[i][j]=='O' && vis[i][j]==0)
           board[i][j]='X';
        
    }
}