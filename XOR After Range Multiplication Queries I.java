class Solution {
    int mod=1000000007;
    public int xorAfterQueries(int[] nums, int[][] queries) {
        for(int[] query:queries){
            int l=query[0];
            int r=query[1];
            int k=query[2];
            int v=query[3];

            while(l<=r){
                nums[l]=(int)((long)nums[l]*v%mod);
                l+=k;
            }
        }
        int result=0;
        for(int num:nums){
            result ^=num;
        }
        return result;
    }
}
