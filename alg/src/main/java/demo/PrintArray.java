package demo;

public class PrintArray {
    public static void main(String[] args) {
        /*// row != col:
        int[][] arr = new int[][] {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                //{ 13, 14, 15, 16 },
        };
        */
        int[][] arr = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
        };

        slash(arr);
        System.out.println("======");
        backslash(arr);


    }

    public static void slash(int[][] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("arr cannot be null");
        }
        int col = arr[0].length;
        int row = arr.length;
        for (int k = 0; k < col * 2 - 1; k++) {     //k代表有多少行输出，由col决定
            int sum = k;                              //同一行的元素，行下标和列下标的和相等
            for (int j = 0; j < col; j++) {
                int i = sum - j;
                if (isValidIndex(i, row) && isValidIndex(j, col)) {
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void backslash(int[][] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("arr cannot be null");
        }
        int row = arr.length;
        int col = arr[0].length;
        for (int k = 0; k < col * 2 - 1; k++) {     //k代表有多少行输出，由col决定
            int diff = col - k - 1;                 //同一行的元素，行下标和列下标的差相等
            for (int j = 0; j < col; j++) {
                int i = j - diff;
                if (isValidIndex(i, row) && isValidIndex(j, col)) {
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    private static boolean isValidIndex(int i, int n) {
        return i >= 0 && i < n;
    }

}
