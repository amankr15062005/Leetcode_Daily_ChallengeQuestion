class Solution {
    public int smallestIndex(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            int num=nums[i];
            int digitSum=0;
            while(num!=0){
                digitSum+=num%10;
                num/=10;
            }
            if(digitSum==i){
                return i;
            }
        }
        return -1;
    }
}
