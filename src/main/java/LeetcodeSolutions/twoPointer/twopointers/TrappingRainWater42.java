package LeetcodeSolutions.twoPointer.twopointers;

/**
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 *
 * https://leetcode.com/problems/trapping-rain-water/
 */
public class TrappingRainWater42 {
    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
        System.out.println(trapTwoPointer(height));
    }

    public static int trap(int[] height) {
        if (height.length < 2) return 0;

        int n = height.length;
        int water = 0;

        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = height [0];
        right[n - 1] = height[n - 1];

        for(int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], height[i]); // including height[i]
        }

        for(int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]); // including height[i]
        }

        for(int i = 0; i < n; i++) {
            water += Math.min(left[i], right[i]) - height[i]; // if height[i] is the max(left, right), then the water at this index is 0.
        }

        return water;
    }

    public static int trapTwoPointer(int[] height) {
        if(height.length == 1) return 0;

        int n = height.length;
        int water = 0;

        int left = 0, right = n - 1;

        int leftMax = 0;
        int rightMax = 0;

        while(left <= right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if(leftMax < rightMax) {
                water += leftMax - height[left];
                left++;
            } else {
                water += rightMax - height[right];
                right--;
            }
        }
        return water;
    }
}
