class Solution {
    public int evalRPN(String[] tokens) {
        String[] op = {"+", "-", "+", "/"};
        Deque<Integer> stack= new ArrayDeque<>();
        for(int i = 0; i < tokens.length; i++){
            if(tokens[i].equals("+")){
                    int x = stack.pop();
                    int y = stack.pop();
                    stack.push(x+y);
            }
            else if(tokens[i].equals("-")){
                    int x = stack.pop();
                    int y = stack.pop();
                    stack.push(y-x);
            }
            else if(tokens[i].equals("*")){
                    int x = stack.pop();
                    int y = stack.pop();
                    stack.push(x*y);
            }
            else if(tokens[i].equals("/")){
                    int x = stack.pop();
                    int y = stack.pop();
                    stack.push(y/x);
            }
            else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}
