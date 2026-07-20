class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> seen = new HashMap<>();
        for(int i = 0; i< strs.length; i++){
            char[] s = strs[i].toCharArray();
            Arrays.sort(s);
            String temp = new String(s);
            List<String> store = seen.getOrDefault(temp, new ArrayList<>());
            store.add(strs[i]);
            seen.put(temp, store);
        }
        for(String key: seen.keySet()){
            result.add(seen.get(key));
        }
        return result;
    }
}
