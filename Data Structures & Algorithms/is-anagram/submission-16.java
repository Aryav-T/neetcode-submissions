class Solution {
    public boolean isAnagram(String s, String t) {
      if(s.length() != t.length()){
        return false;
      }
      Map<String, Integer> sMap = new HashMap<>();
      Map<String, Integer> tMap = new HashMap<>();
      for(int i = 0; i < s.length(); i++){
        String temp = s.substring(i, i+1);
        String temp1 = t.substring(i, i+1);
        if(!sMap.containsKey(temp)){
            sMap.put(temp, 1);
        } else {
            sMap.put(temp, sMap.get(temp)+1);
        }    
        if(!tMap.containsKey(temp1)){
            tMap.put(temp1, 1);
        } else {
            tMap.put(temp1, tMap.get(temp1)+1);
        }  
      }
    
    for (String key : sMap.keySet()) {
        if (!sMap.get(key).equals(tMap.get(key))) {
            return false;
        }
    }
    return true;
    }


}
