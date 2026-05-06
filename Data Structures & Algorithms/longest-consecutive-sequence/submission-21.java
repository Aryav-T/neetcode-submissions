class Solution {
    public int longestConsecutive(int[] nums) {
        int length = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i],nums[i]);
            if(map.containsKey(i) == false){
                length++;
            }

        }
        int difference = 0;
        for(int i = 0; i < nums.length; i++){
            int count = 1;
            if(map.containsKey(nums[i]-1) == false){
                int current = nums[i];
                while(map.containsKey(current +1 )){
                        current++;
                        count++;
                }
                if(count > difference){
                    difference = count;
                }
            }
        }
        return difference;
    }
}
