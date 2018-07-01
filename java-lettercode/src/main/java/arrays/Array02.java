package arrays;

import sun.security.provider.Sun;

import java.util.*;

public class Array02 {
    /**
     * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
     * 注意：答案中不可以包含重复的三元组。
     *
     * @param args
     */

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        threeSum(nums);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int a = nums[i], j = i + 1, k = nums.length - 1;
            while (j < k) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }

                if (k < nums.length - 1 && nums[k] == nums[k + 1]) {
                    k--;
                    continue;
                }
                int b = nums[j];
                int c = nums[k];
                int sum = a + b + c;
                if (sum == 0) {
                    List<Integer> rt1 = new ArrayList<>();
                    rt1.add(a);
                    rt1.add(b);
                    rt1.add(c);
                    list.add(rt1);
                }

                if (sum <= 0) {
                    while (nums[j] == b && j < k) ++j;
                }
                if (sum >= 0) {
                    while (nums[k] == c && j < k) --k;
                }
            }

        }
        return list;
    }

}
