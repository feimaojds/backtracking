package leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backTracking(res, new ArrayList<Integer>(), candidates, target, 0,new boolean[candidates.length]);
        return res;
    }

    public void backTracking(List<List<Integer>> res,List<Integer> temp,int[] candidates,int target,int start,boolean[] used){
    	if(target == 0) {
    		res.add(new ArrayList<Integer>(temp));
    	}else if(target<0){
    		return;
    	}
    	for(int i=start;i<candidates.length;i++){
    		if(i>0&&candidates[i]==candidates[i-1]&&used[i-1]==false) continue;
    		temp.add(candidates[i]);
    		used[i] = true;
    		backTracking(res, temp, candidates, target-candidates[i],i+1,used);
    		used[i] = false;
    		temp.remove(temp.size()-1);
    	}
    }
}
