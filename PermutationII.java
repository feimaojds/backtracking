package leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationII {

	
public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backTracking(res, new ArrayList<Integer>(), nums, new boolean[nums.length]);
        return res;
}

public void backTracking(List<List<Integer>> res,List<Integer> temp,int[] nums,boolean[] used){
	
	if(nums.length == temp.size()){
		res.add(new ArrayList<Integer>(temp));
		return;
	}
	for(int i=0;i<nums.length;i++){
		if(used[i]==true || (nums[i] == nums[i-1] && used[i-1]==false)) continue;
		temp.add(nums[i]);
		used[i] = true;
		backTracking(res, temp, nums, used);
		temp.remove(temp.size()-1);
		used[i] = false;
	}
}

}
