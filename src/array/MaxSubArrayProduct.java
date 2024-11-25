package array;

public class MaxSubArrayProduct {
    static int maxProduct(int[] arr) {
        // code here
        //1 2 3 4 -> all positives
        //1 -2 1 -4 -> even negatives
        //1 -1 2 3 -3 -1 -> odd negatives -> not considering either negatives at the end, can be done by calculating
        //                                   product of elements before the negatives anf after them using 2 pointers
        //1 -1 0 2 3 0 -3 4 -> contains zeroes -> if there are zeroes, change variable used to get product to 1
        //                                        as it can impact the result if not changed
        int n = arr.length;
        int prod = 1,max = Integer.MIN_VALUE;
        int pre = 1;
        int suf = 1;
        for(int i=0;i<n;i++){
            if(arr[i]==0 || pre==0){
                pre = 1;
            }
            if(arr[n-i-1]==0 || suf==0){
                suf = 1;
            }
            pre = pre*arr[i];
            suf = suf*arr[n-i-1];
            max = Math.max(max,pre);
            max = Math.max(max,suf);
        }
        return max;
    }

    public static void main(String[] args) {
        int arr[] = {-1,0,-3};
        System.out.println(maxProduct(arr));
    }
}
