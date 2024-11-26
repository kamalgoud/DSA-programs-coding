package recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
//    Given an array of distinct integers candidates and a target integer target,
//    return a list of all unique combinations of candidates where the chosen numbers sum to target.
//    You may return the combinations in any order.
//    The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
//     frequency of at least one of the chosen numbers is different.

    List<List<Integer>> al = new ArrayList<>();
    List<Integer> l = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        fun(n-1,candidates,target);
        return al;
    }
    public void fun(int x,int candidates[],int target){
        if(target==0){
            al.add(new ArrayList<>(l));
            return;
        }
        if(x<0 || target<0){
            return;
        }
        l.add(candidates[x]);
        fun(x,candidates,target-candidates[x]);
        l.remove(l.size()-1);
        fun(x-1,candidates,target);
    }
}
