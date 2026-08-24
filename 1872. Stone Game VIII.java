Approach-1 - Recursion + Memo (79/80 Test Case Pases. 1 case TLE)
  
class Solution {
    int n;
    int[] t;
    int solve(int i,int[] prefSum){
        if(i==n-1){
            return prefSum[n-1];
        }
        if(t[i]!=-1){
            return t[i];
        }
        int take=prefSum[i]-solve(i+1,prefSum);
        int skip=solve(i+1,prefSum);
        return t[i]=Math.max(take,skip);
    }
    public int stoneGameVIII(int[] stones) {
        n=stones.length;
        int[] prefSum=new int[n];
        prefSum[0]=stones[0];
        for(int i=1;i<n;i++){
            prefSum[i]=prefSum[i-1]+stones[i];
        }
        t=new int[n];
        Arrays.fill(t,-1);
        return solve(1,prefSum);
    }
}


Approach-2 - Bottom Up

class Solution {

    public int stoneGameVIII(int[] stones) {

        int n = stones.length;

        int[] prefixSum = new int[n];

        prefixSum[0] = stones[0];

        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + stones[i];
        }

        int[] t = new int[n];

        t[n - 1] = prefixSum[n - 1];

        for (int i = n - 2; i >= 1; i--) {

            int take = prefixSum[i] - t[i + 1];

            int skip = t[i + 1];

            t[i] = Math.max(take, skip);
        }

        return t[1];
    }
}
