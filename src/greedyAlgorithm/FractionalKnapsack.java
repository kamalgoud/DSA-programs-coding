package greedyAlgorithm;

import java.util.Arrays;
import java.util.List;

public class FractionalKnapsack {
//    Given two arrays, val[] and wt[], representing the values and weights of items, and an integer capacity
//    representing the maximum weight a knapsack can hold,
//    determine the maximum total value that can be achieved by putting items in the knapsack.
//    You are allowed to break items into fractions if necessary.
//    Return the maximum value as a double, rounded to 6 decimal places.
double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
    // code here
    int n = wt.size();
    int[][] collection = new int[n][2];
    for(int i=0;i<n;i++){
        collection[i][0] = val.get(i);
        collection[i][1] = wt.get(i);
    }
    Arrays.sort(collection,(a, b)->{
        return b[0]*a[1] - a[0]*b[1];
    });
    double res = 0;
    for(int i=0;i<n;i++){
        // System.out.println(collection[i][0]+" "+collection[i][1]);
        if(capacity>=collection[i][1]){
            capacity -= collection[i][1];
            res += collection[i][0];
        }
        else if(capacity>0 && capacity<collection[i][1]){
            double x = capacity*(double)collection[i][0]/(double)collection[i][1];
            capacity = 0;
            res += x;
            break;
        }
    }
    return res;
}
}
