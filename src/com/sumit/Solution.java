package com.sumit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static int[][] insert(int[][] intervals, int[] newInterval) 
    {
        List<int[]> res = new ArrayList<>();
        
        Arrays.sort(intervals, (a1,a2)->Integer.compare(a1[0],a2[0]));
        
        
      /*Algorithm works like this:
       * if current interval is completely left to the newOnterval to be added, then
       * we will add the current interval in list.
       * 
       * if current interval is completely right to the new Interval, then we will add 
       * new interval and update new interval with current interval value.
       * 
       * in other cases we will find min and max bound for new interval 
       * 
       *   
       *   
       */
     for(int i=0;i<intervals.length;i++)
     {
         int [] interval = intervals[i];
         if(interval[1]<newInterval[0])
         {
             res.add(interval);
         } 
         else if(newInterval[1]<interval[0]){
             res.add(newInterval);
             newInterval=interval;
         } else {
             newInterval[0] = Math.min(newInterval[0],interval[0]);
             newInterval[1] = Math.max(newInterval[1], interval[1]);
         }
     }
        
      res.add(newInterval);
      return res.toArray(new int[res.size()][]);
    }
    
    public static void main(String[] args) {
		int [][] arr = {{1,2},{3,5},{6,7},{8,10},{12,16}};
		int []interval = {4,8};
		
		System.out.println(Solution.insert(arr, interval));
	}
}
