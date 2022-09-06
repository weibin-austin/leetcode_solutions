package LeetcodeSolutions.twoPointer.twopointers;

public class ContainerWithMostWater11 {
    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
/*
    面试话术：We can just provide all the combination  of the left and right pointer, and calculate all the possible results, and find out the biggest one. O(n^2)
            But we can do better, we can resolve this issue with the time complexity of O(n) by using two pointers
            left  = 0, right = length - 1 -> width
            water = max{water, width * min[h(left), h(right)]}
            only move the shorter height index has the possibility to get the larger area of water, because the width will shorter , we need to find the possible higher height to get more area

            Even height[left] == height[right], we can move either side, and the water size of next scenario must smaller than the current one.
            Because if height_new > height_old , we use the height_old to calculate area, the result is area_new = height_old * (width - 1) < area_old
                    if height_new <= height_old, area_new = height_new * (width - 1) < area_old
                                         |                                                                             |
                 |----------------|      |-----------|                            |----------------|       |-----------|
                 |                |      |           |                            |                |       |           |
                 |                |      |           |                            |                |       |           |
                 |________________|      |___________|                            |________________|       |___________|
                left            right   left        right

                 |                                                                               |
                 |-----------|                                                       |-----------|
                 |           |                                                       |           |
                 |___________|                                                       |___________|
                left       right


 */
    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1, res = 0;
        while(left < right) {
            if(height[left] < height[right]) {
                res = Math.max(res, (right - left) * height[left]);
                left++;
            } else {
                res = Math.max(res, (right - left) * height[right]);
                right--;
            }
        }
        return res;
    }
}
