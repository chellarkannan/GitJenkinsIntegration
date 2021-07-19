package com.codility.coding;

import java.util.*;
import java.util.Map.Entry;

public class Solution2 {

	static boolean iterateMap(Map<String, Integer> map, int rep){
		boolean exists = false;
		for(Entry<String, Integer> a:map.entrySet()) {
			if(a.getValue()==rep)
				exists=true;
		}
		return exists;
	}
	
	static int addFinalMap(Map<String, Integer> map){
		int tobeRemoved=0;		
		Set<Integer> uniqueRep= new HashSet<Integer>();
		for(Entry<String, Integer> a:map.entrySet()) {
			int toAdd=a.getValue();
			while(toAdd>0) {
				if(!uniqueRep.add(toAdd)) {
					tobeRemoved++;
					toAdd--;
					continue;
				}
				else
					break;
			}
		}
		return tobeRemoved;
	}
	static int solution(String s) {
		int tobeRemoved = 0;
		Map<String,Integer> map = new HashMap<String,Integer>();
		for(int i=0;i<s.length();i++) {
			String currentChar = ""+s.charAt(i);
			if(map.containsKey(currentChar))
				map.put(currentChar, map.get(currentChar)+1);
			else
				map.put(currentChar, 1);
		}
		
		return addFinalMap(map);
		
	}
		
	public static void main(String args[]) {
		
		String a = "ccaaffddecee";
		System.out.println(solution(a));	
		
	}
}
