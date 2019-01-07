package tk.seayar.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wupeng
 * Create on 1/3/19.
 * @version 1.0
 */
public class TrappingRainWater {

    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        Queue<Cau> queue = new LinkedList<>();
        queue.offer(createCau(height, 0, height.length));
        int res = 0;
        while (!queue.isEmpty()) {
            Cau cau = queue.poll();
            if (!cau.isSingle()) {
                int rp, lp;
                if (cau.maxIndex > cau.prMaxIndex) {
                    rp = cau.maxIndex;
                    lp = cau.prMaxIndex;
                } else {
                    lp = cau.maxIndex;
                    rp = cau.prMaxIndex;
                }
                int total = cau.array[cau.prMaxIndex] * (rp - lp - 1);
                for (int i = lp + 1; i < rp; i++) {
                    total = total - cau.array[i];
                }
                res += total;
                queue.offer(createCau(cau.array, 0, lp + 1));
                queue.offer(createCau(cau.array, rp, cau.array.length));
            }
        }
        return res;

    }

    Cau createCau(int[] array, int start, int end) {
        int[] copy = new int[end - start];
        int max = -1;
        int maxIndex = -1;
        int k = 0;
        for (int i = start; i < end; i++, k++) {
            copy[k] = array[i];
            if (array[i] >= max) {
                max = array[i];
                maxIndex = k;
            }
        }
        int preMax = -1;
        int preMaxIndex = -1;
        for (int i = 0; i < copy.length; i++) {
            if (copy[i] >= preMax && i != maxIndex) {
                preMax = copy[i];
                preMaxIndex = i;
            }
        }
        return new Cau(maxIndex, preMaxIndex, copy);
    }

    class Cau {
        int maxIndex;
        int prMaxIndex;
        int[] array;

        public Cau(int maxIndex, int prMaxIndex, int[] array) {
            this.maxIndex = maxIndex;
            this.prMaxIndex = prMaxIndex;
            this.array = array;
        }

        public boolean isSingle() {
            return array.length == 1 || array.length == 2;
        }
    }

}
