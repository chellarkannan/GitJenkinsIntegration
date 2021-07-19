package com.codility.coding;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution1 {
	
	static int getLargestNum(Set<Integer>setInt) {
		int largeNum =0;
		
		for(int num:setInt) {
			largeNum=num;
		}
		return largeNum;
	}
	
	static int returnMissingNum(int A[]) {
		int nextInt=0; boolean containsNegNum=false; boolean containsPosAndNeg=false;
		Set<Integer> setInt = new HashSet<Integer>();
		for(int i=0;i< A.length;i++) {
			setInt.add(A[i]);
		}		
		int largeNum = getLargestNum(setInt);
		if(largeNum<0)
			return 1;
		for(int a:setInt) {
			nextInt= a+1;
			if(a<0)
				containsNegNum=true;
			if(containsNegNum && a >0) 
				containsPosAndNeg=true;
			if(nextInt<largeNum && nextInt>0) {
				if(!setInt.contains(nextInt))
					break;
			}
		}
		return nextInt;
	}

	public static void main(String args[]) {
		
		int [] A = new int [] {3,2};
		System.out.println(returnMissingNum(A));
	}
}
