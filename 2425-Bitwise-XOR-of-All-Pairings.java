class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        // Because a ^ 0 = a, we can initilize these to 0 without worrying
        int xor1 = 0;
        int xor2 = 0;

        // XOR all elements of nums1
        // Because XOR is Commutative and Associative, we can xor the entire array to use for later based on parity.
        for (int num : nums1) {
            xor1 ^= num;
        }

        // XOR all elements of nums2
        // Because XOR is Commutative and Associative, we can xor the entire array to use for later based on parity.
        for (int num : nums2) {
            xor2 ^= num;
        }

        // Because a ^ 0 = a, we can initilize this to 0 without worrying
        int result = 0;

        // This is where I got confused, the parity rules of XOR. So as an example:
        // nums1 = [2], nums2 = [10,3]
        // This gives us (2x10) and (2x3). We xor everything together for the problem later, so that's equal to:
        // 2x10x2x3
        // Because nums2 is even, we are guaranteed an even number of nums1 elements repeating.
        // And because axa = 0, we get some even number of axa pairs (2x2 above), guaranteeing that all
        // elements of nums1 cancel out.
        // This boils down to:
        // if nums1 is even, nums2 contributes nothing.
        // if nums2 is even, nums1 contributes nothing.

        // If nums2.length is even, nums1 elements do not contribute to the result
        // If nums2.length is odd, nums1 elements contribute to the result
        if (nums2.length % 2 != 0) {
            result ^= xor1;
        }

        // If nums1.length is even, nums2 elements do not contribute to the result
        // If nums1.length is odd, nums2 elements contribute to the result
        if (nums1.length % 2 != 0) {
            result ^= xor2;
        }

        return result;
    }
}