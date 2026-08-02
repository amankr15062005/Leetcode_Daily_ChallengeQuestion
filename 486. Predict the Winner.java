class Solution {
    int[][] dp;
    public int solve(int[] arr,int i, int j){
        if(i==j){
            return arr[i];
        }
        if(i>j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int take_i=arr[i]+Math.min(solve(arr,i+2,j), solve(arr,i+1,j-1));
        int take_j=arr[j]+Math.min(solve(arr,i,j-2), solve(arr,i+1,j-1));

        return dp[i][j]=Math.max(take_i,take_j);
    }
    public boolean predictTheWinner(int[] nums) {
        int n=nums.length;
        dp=new int[n][n];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        int total_score=Arrays.stream(nums).sum();
        int p1_score=solve(nums,0,n-1);
        int p2_score=total_score-p1_score;

        return p1_score>=p2_score;
    }
}
