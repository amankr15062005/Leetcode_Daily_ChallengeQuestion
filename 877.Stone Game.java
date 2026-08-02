class Solution {
    int[][] dp;
    public int solve(int[] arr,int i,int j){
        if(i==j){
            return arr[i];
        }
        if(i>j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int take_i=arr[i]+Math.min(solve(arr,i+2,j),solve(arr,i+1,j-1));
        int take_j=arr[j]+Math.min(solve(arr,i+1,j-1),solve(arr,i,j-2));
        return dp[i][j]=Math.max(take_i,take_j);
    }
    public boolean stoneGame(int[] piles) {
        int n=piles.length;
        dp=new int[n][n];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        int total_score=Arrays.stream(piles).sum();
        int alice_score=solve(piles,0,n-1);
        int bob_score=total_score-alice_score;
        return alice_score>bob_score;
    }
}
