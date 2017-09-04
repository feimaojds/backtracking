package leecode;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

	
public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backTracking(res, new ArrayList<Integer>(), nums);
        return res;
    }

    public  void backTracking(List<List<Integer>> res,List<Integer> temp,int[] nums){
    	if(temp.size() == nums.length){
    		res.add(new ArrayList<Integer>(temp));
    		return;
    	}
    	for(int i=0;i<nums.length;i++){
    		if(temp.contains(nums[i])) continue;
    		temp.add(nums[i]);
    		backTracking(res,temp,nums);
    		temp.remove(temp.size()-1);
    	}
    }
}
