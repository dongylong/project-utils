package demo.didi;

/**
 * 0   1   2   3
 * 0    1   2   3   4
 * 1    5   6   7   8
 * 2    9  10  11  12
 * 3    13 14  15  16
 */

/**
 * 1   2   3   4
 * 5   6   7   8
 * 9  10  11  12
 * 13 14  15  16
 **/
public class demo {
    public static void main(String[] args) {
        int[][] arr = new int[4][4];
//        int length = arr.length;
        int length = 4;
        for (int i = 1; i <= length; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(i+ j*(length-1)+" ");
            }
            System.out.println();
        }    }

    private static void printArr(int[][] arr) {
        //00
        //10 01
        //20 11 02
        //30 21 12 03
        //31 22 13
        //32 12
        //33
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                System.out.println(i+ j*(length-1)+" ");
            }
            System.out.println();
        }
    }
}
