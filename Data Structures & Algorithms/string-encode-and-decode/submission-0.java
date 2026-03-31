class Solution {

    public String encode(List<String> strs) {
        if(strs.isEmpty()) return "";
        StringBuilder result = new StringBuilder();
        List<Integer> sizes = new ArrayList<>();

        for(String str : strs){
            sizes.add(str.length());
        }

        for(int size : sizes){
            result.append(size).append(",");
        }

        result.append("#");

        for(String str : strs){
            result.append(str);
        }

        return result.toString();
    }

    public List<String> decode(String str) {
        if(str.length() == 0) return new ArrayList<>();
        String len = "";
        List<String> result = new ArrayList<>();
        List<Integer> sizes = new ArrayList<>();
        int i = 0;
        for(char c : str.toCharArray()){
            i++;
            if(c == '#') break;
            if(c == ',') {
                sizes.add(Integer.parseInt(len));
                len = "";
            } else len += c;
        }
        for(int size : sizes){
            result.add(str.substring(i, i+size));
            i += size;
        }
        return result;
    }
}
