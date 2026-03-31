class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for(int i = 0 ; i < s1.length(); i++){
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }
        int matches = 0;
        for(int i = 0; i < 26; i++){
            if(freq1[i] == freq2[i]){
                matches++;
            }
        }

        int l = 0;
        for(int r = s1.length(); r < s2.length(); r++){
            if(matches == 26){
                return true;
            }

            freq2[s2.charAt(r) - 'a']++;
            if(freq2[s2.charAt(r) - 'a'] == freq1[s2.charAt(r) - 'a']) matches++;
            else if(freq2[s2.charAt(r) - 'a'] == freq1[s2.charAt(r) - 'a'] + 1) matches--;

            freq2[s2.charAt(l) - 'a']--;
            if(freq2[s2.charAt(l) - 'a'] == freq1[s2.charAt(l) - 'a']) matches++;
            else if(freq2[s2.charAt(l) - 'a'] == freq1[s2.charAt(l) - 'a'] - 1) matches--;

            l++;
        }

        return matches == 26;
    }
}
