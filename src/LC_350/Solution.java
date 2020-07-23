package LC_350;

import java.util.*;

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int value : nums1) {
            map1.put(value, map1.getOrDefault(value, 0) + 1);
        }
        for (int value : nums2) {
            map2.put(value, map2.getOrDefault(value, 0) + 1);
        }
        int[] ret = new int[Math.min(nums1.length, nums2.length)];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            int key = entry.getKey();
            if (map2.containsKey(key)) {
                int cnt = Math.min(entry.getValue(), map2.get(key));
                for (int i = 0; i < cnt; i++) {
                    ret[index++] = key;
                }
            }
        }
        return Arrays.copyOf(ret, index);
    }

    //  方法2
    public int[] intersect_1(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length)
            return intersect_1(nums2, nums1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int value : nums1) {
            map.put(value, map.getOrDefault(value, 0) + 1);
        }
        int[] ret = new int[nums1.length];
        int index = 0;
        for (int value : nums2) {
            int count = map.getOrDefault(value, 0);
            if (count > 0) {
                ret[index++] = value;
                --count;
            }
            if (count > 0) {
                map.put(value, count);
            } else {
                map.remove(value);
            }
        }
        return Arrays.copyOf(ret, index);
    }

    //  法3
    public int[] intersect_2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] ret = new int[Math.min(nums1.length, nums2.length)];
        int p1 = 0, p2 = 0, index = 0;
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] < nums2[p2]) {
                p1++;
            } else if (nums1[p1] > nums2[p2]) {
                p2++;
            } else {
                ret[index++] = nums1[p1];
                p1++;
                p2++;
            }

        }
        return Arrays.copyOf(ret, index);
    }
}
