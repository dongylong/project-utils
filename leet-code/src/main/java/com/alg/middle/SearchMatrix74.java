package com.alg.middle;

public class SearchMatrix74 {
    public boolean searchMatrixTwice(int[][] matrix, int target) {
        int rowIndex = binarySearchFirstColumn(matrix,target);
        if(rowIndex<0){
            return false;
        }
        return binarySearchRow(matrix[rowIndex],target);
    }

    private boolean binarySearchRow(int[] row, int target) {
        int low = 0;
        int high = row.length-1;
        while (low<=high){
            int mid = (high-low)/2 +low;
            if(row[mid] == target){
                return true;
            }else if (row[mid]>target){
                high = mid -1;
            }else{
                low = mid +1;
            }
        }
        return false;
    }

    private int binarySearchFirstColumn(int[][] matrix, int target) {
        int low = -1;
        int high = matrix.length-1;
        while (low<high){
            int mid = (high-low +1)/2 +low;
            if(matrix[mid][0] <= target){
                low= mid;
            }else{
                high = mid -1;
            }
        }
        return low;
    }

    public boolean searchMatrixOnce(int[][] matrix, int target) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int low = 0;
        int high = rowLen * colLen - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int x = matrix[mid / colLen][mid % colLen];
            if (x < target) {
                low = mid + 1;
            } else if (x > target) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

}
