/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
     
	public static void main(String[] args) throws Exception {
      Scanner scn=new Scanner(System.in);
      int n = scn.nextInt();
      int k=scn.nextInt();
      int d=scn.nextInt();
      int[] arr = new int[n];

      for (int i = 0; i < n; i++) {
         arr[i] = scn.nextInt();
      }
      
       int num=get(arr,k-d==0?k:k-d);
       int num1=get(arr,k+d);
       System.out.println(num);
       System.out.println(num1);
      if(num>num1){
           System.out.println("Wrong "+ Math.abs(num-num1));
      }
      else if(num<num1){
          System.out.println("Right "+ Math.abs(num-num1));
      }
      else{
          System.out.println("Both are Right");
      }
     
      
	}
	public static int get(int[] arr,int k){
	    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
	   for(int i=0;i<arr.length;i++){
              pq.add(arr[i]);
          }
      int size=0;
      if(pq.size()%k==0){
          size=pq.size();
      }
      else{
          size=pq.size() - pq.size()%k;
      }
      int sum=0;
        for(int i=0; i<size; i++){
           
           sum+=pq.remove();
        } 
        return sum;
    }
}
