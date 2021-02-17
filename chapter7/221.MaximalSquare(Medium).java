class Solution {
    public int maximalSquare(char[][] matrix) {
        int[][] dp=new int[2][matrix[0].length+1];
        int result=0;
        for(int row=0;row<matrix.length;row++){
            for(int col=0;col<matrix[row].length;col++){
                if(matrix[row][col]=='1'){
                    dp[(row+1)%2][col+1]=Math.min(Math.min(dp[(row)%2][col],dp[(row)%2][col+1]),dp[(row+1)%2][col])+1;
                    result=Math.max(result,dp[(row+1)%2][col+1]);
                }else{
                    dp[(row+1)%2][col+1]=0;
                }
            }
        }
        return result*result;
    }
}
