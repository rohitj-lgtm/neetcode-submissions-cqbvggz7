class Solution {
    boolean compareArray(int[] a, int[] b){
        for(int i = 0; i < a.length; i++) if(a[i] != b[i]) return false;
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for(int i = 0 ; i < 26; i++){
            freq1[i] = 0;
            freq2[i] = 0;
        }

        for(int i = 0; i < s1.length(); i++) freq1[s1.charAt(i) - 'a'] += 1;

        int n = s1.length();
        int m = s2.length();
        int l = 0;
        int r = 0;

        for(r = 0; r < m; r++){
            freq2[s2.charAt(r) - 'a'] += 1;
            if(r - l > n - 1){
                freq2[s2.charAt(l++) - 'a'] -= 1;
            }
            if(compareArray(freq1, freq2)) return true;
        }

        return false;
    }
}
