/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scn=new Scanner(System.in);
       int t=scn.nextInt();
       for(int test=1;test<=t;test++)
       {
           int n=scn.nextInt();
           int m=scn.nextInt();
           int s=scn.nextInt();

           int arr[]=new int[n];
           PriorityQueue <Integer> pq=new PriorityQueue<>();
           for(int i=0;i<n;i++)
           {
               int x=scn.nextInt();
               pq.add(x);
           }
           for(int i=0;i<m;i++)
           {
               ArrayList<Integer> pos=new ArrayList<>();
               for(int j=0;j<s;j++)
               {
                   int val=pq.poll();
                   val++;
                   pos.add(val);
               }
               for(int val:pos)
               pq.add(val);
           }
           System.out.println(pq.peek());

       }
	}
}
