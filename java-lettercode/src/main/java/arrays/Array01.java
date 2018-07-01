package arrays;

import java.util.*;

public class Array01 {
    /**
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     */

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        int result = removeDuplicates(nums);

    }

    public static int removeDuplicates(int[] A) {
        if (A == null || A.length == 0)
            return 0;
        int index = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] != A[i - 1]) {
                A[index] = A[i];
                index++;
            }
        }
        return index;

    }
}
