package string_array_matrix.Array;

public class TrappingRainWater {

    /**
     * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
      For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
      The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
     In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
     *
     * The key logic hers is that
     * 1.) for any ith element if water is to be trapped then there should be a taller element on the left and a taller element on the right.
     * 2.) For both the left and right side we need to find the tallest element (for both the left and right side we can iterate till numbers are in increasing order)
     * and then the water trapped at ith element will be min(leftMax, rightMax) - height[i]
     */
    public int trap(int[] height) {

    }
}
