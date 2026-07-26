class Solution {

      public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length() + "!" + s);
        }
        return sb.toString();
    }

    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int index = 0;
        while (index < s.length()) {
            String num = "";
            while (index < s.length() && s.charAt(index) != '!') {
                num += s.charAt(index);
                index++;
            }
            index++;
            int length = Integer.valueOf(num);
            res.add(s.substring(index, index + length));
            index+=length;
        }
        return res;
    }
}
