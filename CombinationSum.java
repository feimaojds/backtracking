package leecode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
	
public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        
        backTracking(res, new ArrayList<Integer>(), candidates, target,0);
        return res;
    }
public void backTracking(List<List<Integer>> res,List<Integer> temp,int[] candidates,int target,int start){
	   if(target == 0){
		   res.add(new ArrayList<Integer>(temp));
	   } else if(target < 0){
		   return;
	   }else{
		   for(int i=start;i<candidates.length;i++){
			   temp.add(candidates[i]);
			   backTracking(res, temp, candidates, target-candidates[i],i);
			   temp.remove(temp.size()-1);
		   }   
	   }
	   
	}


public static void main(String[] args) {
	int[] test = new int[]{1,2};
	new CombinationSum().combinationSum(test,3);
}
}
