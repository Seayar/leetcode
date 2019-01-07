package tk.seayar.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wupeng
 * Create on 1/3/19.
 * @version 1.0
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(0xFFFF);
        Integer index;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            index = map.get(target - nums[i]);
            if (index != null && index != i) {
                return new int[]{i, index};
            }
        }
        return null;
    }

}
