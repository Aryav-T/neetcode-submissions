class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] sum = new int[2];
        Map<Integer, Integer> seen = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int diff = target - nums[i];
            if(!seen.containsKey(diff)){
                seen.put(nums[i], i);
            }else{
                sum[0] = seen.get(diff);
                sum[1] = i;
            }
        }
        return sum;
    }
}
 