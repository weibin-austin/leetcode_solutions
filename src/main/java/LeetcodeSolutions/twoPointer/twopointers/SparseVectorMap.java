package LeetcodeSolutions.twoPointer.twopointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SparseVectorMap {
     Map<Integer, Integer> map;

    SparseVectorMap(int[] nums) {
        map = new HashMap<>();
         for (int i = 0; i < nums.length; i++) {
             if(nums[i] != 0) {
                 map.put(i, nums[i]);
             }
         }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVectorMap vec) {
        if(vec.map.size() < this.map.size()) return vec.dotProduct(this);
        Map<Integer, Integer> map1 = this.map; // 如果数据太大的话 会产生hash collision， hash本身的时间复杂度就比较高，空间时间都不友好
        Map<Integer, Integer> map2 = vec.map;
        int ans = 0;
        for(int key: map1.keySet()) {
            if(map2.containsKey(key)) {
                ans += map1.get(key) * map2.get(key);
            }
        }
        return ans;
    }
}

class SparseVectorList {

    List<int[]> list;

    SparseVectorList(int[] nums) {
        list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            list.add(new int[]{i, nums[i]});
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVectorList vec) {
        if(vec.list.size() > this.list.size()) return vec.dotProduct(this);

        int res = 0;

        for(int i = 0; i < vec.list.size(); i++) {
            int index = vec.list.get(i)[0];
            int value = vec.list.get(i)[1];

            res += value * binarySearch(index, 0, list.size() - 1);
        }

        return res;
    }

    private int binarySearch(int index, int left, int right) {
        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(list.get(mid)[0] == index) return list.get(mid)[1];

            if(list.get(mid)[0] < index) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);