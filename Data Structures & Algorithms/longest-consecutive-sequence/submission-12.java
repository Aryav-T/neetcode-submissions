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
        ArrayList<Integer> starter = new ArrayList<>();
        ArrayList<Integer> end = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i]-1) == false){
                starter.add(nums[i]);
                int current = nums[i];
                while(map.containsKey(current +1 )){
                        current++;
                }
                end.add(current);
            }
        }
        int difference = 0;
        for(int i = 0; i < starter.size(); i++){
            int diff = end.get(i)- starter.get(i) + 1;
            if(diff > difference){
                difference = diff;
            }
        }
        return difference;
    }
}
