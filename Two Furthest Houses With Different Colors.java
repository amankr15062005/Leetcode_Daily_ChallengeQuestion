class Solution {
    public int maxDistance(int[] colors) {
       int n=colors.length;
       int result=0;
    //    for(int i=0;i<n-1;i++){
    //     for(int j=i+1;j<n;j++){
    //         if(colors[i]!=colors[j]){
    //             result=Math.max(result,(j-i));
    //         }
    //     }
    //    } 
    //    return result;

    for(int i=0;i<n;i++){
        if(colors[i]!=colors[0]){
            result=Math.max(result,i);
        }
        if(colors[i]!=colors[n-1]){
            result=Math.max(result,(n-1-i));
        }
    }
    return result;
    }
}
