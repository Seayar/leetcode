package tk.seayar.leetcode;

public class Main {

    public static void main(String[] args) {
        // write your code here
        TrappingRainWater ways = new TrappingRainWater();
//        int[] a = new int[]{2,2,4,3,6,7,3,4,5,7};
//        int[] a = new int[]{1,2,3,2,1};
        int[] a = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1, 3, 5, 6, 7, 3, 4, 6, 8, 6, 99, 6, 4, 57, 56, 34, 43, 52, 2, 2, 4, 6};
        System.out.println(ways.trap(a));

    }
}
