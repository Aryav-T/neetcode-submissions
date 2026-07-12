class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] sum = new int[2];
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length; j++){
                if( i != j && nums[i]+nums[j] == target){
                    sum[0] = i;
                    sum[1] = j;
                    return sum;
                }
            }
        }
        return sum;
    }
}
 