class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int s = 0;
        int e = people.length - 1;
        int count = 0;
        while(s <= e){
            int sum = people[s] + people[e];
            if(s == e) sum = people[s];
            if(sum <= limit){
                s++;
                e--;
            }
            else e--;
            count++;
        }
        return count;
    }
}