class Solution {
    // void swap(int[] a, , int i, int j){
    //     int temp = a[i];
    //     a[i] = b[j];
    //     b[j] = temp;
    // }

    public void merge(int[] a, int m, int[] b, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while(i >= 0 && j >= 0){
            if(a[i] > b[j]){
                int temp = a[i];
                a[i] = a[k];
                a[k] = temp;
                i--;
                k--;
            } else {
                int temp = b[j];
                b[j] = a[k];
                a[k] = temp;
                j--;
                k--;
            }
        }
        while(i >= 0){
            int temp = a[i];
            a[i] = a[k];
            a[k] = temp;
            i--;
            k--;
        }
        while(j >= 0){
            int temp = b[j];
            b[j] = a[k];
            a[k] = temp;
            j--;
            k--;
        }

    }
}