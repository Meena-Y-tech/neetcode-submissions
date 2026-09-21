class Solution {
    public int jump(int[] nums) {
        int jump = 0;
        int end = 0;
        int reach = 0;
        int n = nums.length;

        for(int i = 0; i < n - 1; i++) {

            reach = Math.max(reach, i + nums[i]);

            if(i == end) {
                jump++;
                end = reach;
            }
        }

        return jump;
    }
}
