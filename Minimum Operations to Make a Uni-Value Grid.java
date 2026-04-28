class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer>list=new ArrayList<>();
        for(int row=0;row<grid.length;row++){
            for(int col=0;col<grid[0].length;col++){
                list.add(grid[row][col]);
            }
        }

        int result=0;
        Collections.sort(list);
        int length=list.size();
        int median=list.get(length/2);

        for(int num: list ){
            if(num%x != median%x){
                return -1;
            }
            result += Math.abs(median-num)/x;
        }
        return result;
    }
}
