class Solution {
    public String simplifyPath(String path) {
        String[] tokens = path.split("/");
        Stack<String> stack = new Stack<>();
        for(String token : tokens) {
            if(token.length() > 0 && !token.equals(".")){
                if(!stack.isEmpty() && token.equals("..")) stack.pop();
                else if(!token.equals("..")) stack.push(token);
            }
        }
        if(stack.isEmpty()) return "/";
        StringBuilder stringBuilder = new StringBuilder();
        for(String dir : stack) stringBuilder.append("/").append(dir);
        return stringBuilder.toString();
    }
}