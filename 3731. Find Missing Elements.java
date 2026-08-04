       Approach-1
class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer>result=new ArrayList<>();
        int n=nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n-1;i++){
            for(int j=nums[i]+1;j<nums[i+1];j++){
                result.add(j);
            }
        }
        return result;
    }
}

      Approach-2

class Solution{
    public List<Integer> findMissingElements(int[] nums){
        Set<Integer>set=new HashSet<>();
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int x:nums){
            set.add(x);
            min=Math.min(min,x);
            max=Math.max(max,x);
        }
        List<Integer>result=new ArrayList<>();
        for(int i=min+1;i<max;i++){
            if(!set.contains(i)){
                result.add(i);
            }
        }
        return result;
    }
}
