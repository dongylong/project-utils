package com.study.demo;

public class PrintRotateArr {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
//                {13, 14, 15, 16},
        };
        printRotateArr(arr);
    }

    private static void printRotateArr(int[][] arr) {
        //row
        int rowLen = arr.length;
        //col
        int colLen = arr[0].length;
        int beginX = 0;
        int beginY = 0;
        int endX = colLen - 1;
        int endY = rowLen - 1;
        while (true) {
            //左上到右上
            for (int i = beginX; i <= endX; i++) {
                System.out.print(arr[beginY][i]);
            }
            beginY++;
            System.out.println();
            if(beginY>endY){
                break;
            }
            //打印最右侧一行
            for (int i = beginY; i <= endY; i++) {
                System.out.print(arr[i][endX]);
            }
            endX--;
            if(endX<beginX){
                break;
            }
            System.out.println();
            for (int i = endX; i >= beginX; i--) {
                System.out.print(arr[endY][i]);
            }
            endY--;
            if(endY<beginY){
                break;
            }
            System.out.println();
            for (int i = endY; i >= beginY; i--) {
                System.out.print(arr[i][beginX]);
            }
            beginX++;
            if(beginX>endX){
                break;
            }
            System.out.println();
        }
    }
}
