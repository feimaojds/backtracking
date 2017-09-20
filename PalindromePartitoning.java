package leecode;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitoning {

	
	 public List<List<String>> partition(String s) {
	        List<List<String>> res = new ArrayList<>();
	        List<String> temp = new ArrayList<String>();
	        if(s==null || s.length() ==0) return res;
	        backTracking(res, temp, s, 0);
	        return res;
	    }
	 
	 public void backTracking(List<List<String>> res,List<String> temp,String s,int a){
		 if(a==s.length()) res.add(new ArrayList<String>(temp));
		 
		 for(int i=a;i<s.length();i++){
			 if(isPalindrome(s, a, i)){
				 temp.add(s.substring(a, i+1));
				 backTracking(res, temp, s, i+1);
				 temp.remove(temp.size()-1);
			 }
		 }
	 }
	 
	 public static boolean isPalindrome(String s,int a,int b){
		 if(a>b) return false;
		 if(a==b) return true;
		 while(a<b){
			 if(s.charAt(a)!=s.charAt(b)) return false;
			 a++;
			 b--;
		 }
		 return true;
	 }
	 
}
