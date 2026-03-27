//Approach-1
//T.C : O(mn)
//S.C : O(1)

class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m=mat.length;
        int n=mat[0].length;
        k=k%n;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]!=mat[i][(j+k)%n]){
                    return false;
                }
            }
        }
        return true;
    }
}

