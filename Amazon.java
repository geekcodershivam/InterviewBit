// criticalConnections 

class Solution
{    
    List<PairInt> list;
    Map<Integer, Boolean> visited;
    List<PairInt> criticalConnections(int numOfServers, int numOfConnections,List<PairInt> connections)
    {
        Map<Integer, HashSet<Integer>> adj = new HashMap<>();
        for(PairInt connection : connections){
            int u = connection.first;
            int v = connection.second;
            if(adj.get(u) == null){
                adj.put(u,new HashSet<Integer>());
            }
            adj.get(u).add(v);
            if(adj.get(v) == null){
                adj.put(v,new HashSet<Integer>());
            }
            adj.get(v).add(u);
        }
       
        list = new ArrayList<>();
        for(int i =0;i<numOfConnections;i++){
            visited = new HashMap<>();
            PairInt p = connections.get(i);
            int x = p.first;
            int y = p.second;
            adj.get(x).remove(y);
            adj.get(y).remove(x);
            DFS(adj,1);
            if(visited.size()!=numOfServers){
                    if(p.first > p.second)
                        list.add(new PairInt(p.second,p.first));
                    else
                        list.add(p);
            }
            adj.get(x).add(y);
            adj.get(y).add(x);
        }
        return list;
    }
   
    public void DFS(Map<Integer, HashSet<Integer>> adj, int u){
        visited.put(u, true);
        if(adj.get(u).size()!=0){
            for(int v : adj.get(u)){
                if(visited.getOrDefault(v, false)== false){
                    DFS(adj,v);
                }
            }
        }
    }
}

// PositionofTargetValue
public int PositionofTargetValue(ArrayList<ArrayList<Integer>> a, int b) {
    if(a.size() < 1) return 0;
    int yLength = a.get(0).size();
    int max = (a.size() * yLength) - 1;
    int min = 0;
    int mid;
    int x;
    int y;
    while(min <= max){
        mid = min + ((max - min)/2);
        x = mid / yLength;
        y = mid % yLength;
        if(a.get(x).get(y) == b){
           // System.out.println(x+" "+y);
            return 1;
        }else if (a.get(x).get(y) > b){
            max = mid - 1;
        }else{
            min = mid + 1;
        }
    }
    return 0;
}

// arbitrary points
public Node copyRandomList(Node head) {
    if (head == null) return null;
    Node dummy = new Node(0);
    Node  n1 = head, n2 = dummy;
    while (n1 != null) {
        Node tmp = n1.next;
        n2.next = n1;
        n2.next.next = new Node(n1.val);
        n1 = tmp;
        n2 = n2.next.next;
    }
    n1 = head;
    n2 = n1.next;
    while (n1 != null) {
        n2.random = n1.random == null ? null : n1.random.next;
        n2 = n2.next == null ? dummy : n2.next.next;
        n1 = n1.next.next;
    }
    n1 = head;
    while (n2.next != null) {
        n2.next = n2.next.next;
        n2 = n2.next;
        n1.next = n2.next;
        n1 = n1.next;
    }
    return dummy.next;
}

// pair sum 
private static int[] Find2Sum(int[] nums, int target) {
	Map<Integer, Integer> map = new HashMap<>();
	int max = Integer.MIN_VALUE;
	int[] res = new int[] {-1, -1};
	for(int i=0;i<nums.length;i++) {
		if(map.containsKey(nums[i])) {
			if(nums[i] > max || nums[map.get(nums[i])] > max) {
				res[0] = map.get(nums[i]);
				res[1] = i;
				max = Math.max(nums[i], nums[map.get(nums[i])]);
			}
		}
		map.put(target - nums[i], i);
	}
	return res;
}

// Subtree of Another Tree
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(t == null || s == null) return false;
        return compare(s, t) ? true : isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    boolean compare(TreeNode s, TreeNode t){
        if(t == null && s == null) return true;
        if(t == null || s == null) return false;
        if(s.val == t.val) return compare(s.left, t.left) && compare(s.right, t.right);
        return false;
    }
}
 
// mergeTwoLists
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null || l2==null) return l1==null ? l2:l1;
        ListNode dm=new ListNode(-1);
        ListNode prev= dm;
        ListNode curr=l1;
        ListNode curr1=l2;
        while(curr!=null && curr1!=null){
            if(curr.val<=curr1.val){
                prev.next=curr;
                prev=curr;
                curr=curr.next;
            }
            else{
                prev.next=curr1;
                prev=curr1;
                curr1=curr1.next;
            }
        }
        if(curr!=null){
            prev.next=curr;
        }
        if(curr1!=null){
            prev.next=curr1;
        }
        return dm.next;
    }
    
}

// numsGenres FavoriteVideogenre
public Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
    Map<String, List<String>> res = new HashMap<>();
    Map<String, String> songstogenre = new HashMap<>();
    
    for(String genre : genreMap.keySet()) {
        List<String> songs = genreMap.get(genre);
        for(String song : songs) {
            songstogenre.put(song, genre);
        }
    }
    
    Map<String, Map<String, Integer>> usergenrecount = new HashMap<>();
    for(String user : userMap.keySet()) {
        if(!usergenrecount.containsKey(user))
            usergenrecount.put(user, new HashMap<>());
        List<String> songs = userMap.get(user);
        for(String song : songs) {
            String genre = songstogenre.get(song);
            int count = usergenrecount.get(user).getOrDefault(genre, 0) + 1;
            usergenrecount.get(user).put(genre, count);
        }
    }
    
    for(String user : usergenrecount.keySet()) {
        if(!res.containsKey(user))
            res.put(user, new ArrayList<>());
        Map<String, Integer> pair = usergenrecount.get(user);
        int max = 0;
        List<String> favgenre = new ArrayList<>();
        for(String genre : pair.keySet()) {
            if(favgenre.size() == 0) {
                favgenre.add(genre);
                max = pair.get(genre);
            } else if(pair.get(genre) > max) {
                favgenre.clear();
                favgenre.add(genre);
                max = pair.get(genre);
            } else if(pair.get(genre) == max)
                favgenre.add(genre);
        }
        res.put(user, favgenre);
    }
    return res;
}

//SumPairs
/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int[] arr={8,7,6,5,4,3,2,1};
		System.out.println(SumPairs(arr,6));
	}
	public static int SumPairs(int[] input, int k){
    Map<Integer, Integer> frequencies = new HashMap<>();
    int pairsCount = 0;      

    for(int i=0; i<input.length; i++){
        int value = input[i];
        int complement = k - input[i];

        if(frequencies.containsKey(complement)){                
            int freq = frequencies.get(complement) - 1;
            pairsCount++;
            System.out.println(value + ", " + complement);    
            if(freq == 0){
                frequencies.remove(complement);
            }else{
                frequencies.put(complement, freq);
            }
        }else{
            if(frequencies.containsKey(value)){         
                frequencies.put(value, frequencies.get(value) + 1);             
            }else{
                frequencies.put(value, 1);
            }
        }
    }
    return pairsCount;
}
}
// searchMatrix 
public class Solution {
    public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
        if(a.size() < 1) return 0;
        int yLength = a.get(0).size();
        int max = (a.size() * yLength) - 1;
        int min = 0;
        int mid;
        int x;
        int y;
        while(min <= max){
            mid = min + ((max - min)/2);
            x = mid / yLength;
            y = mid % yLength;
            if(a.get(x).get(y) == b){
               // System.out.println(x+" "+y);
                return 1;
            }else if (a.get(x).get(y) > b){
                max = mid - 1;
            }else{
                min = mid + 1;
            }
        }
        return 0;
    }
}





// https://leetcode.com/discuss/interview-question/356960
// https://leetcode.com/discuss/interview-question/372581
// https://leetcode.com/discuss/interview-question/373006
// https://leetcode.com/discuss/interview-question/344650/Amazon-Online-Assessment-Questions/
// https://docs.google.com/forms/d/e/1FAIpQLScKoVbnlIQqRJeQRLKvvSVrGL9J30CmIng6UvaRQF6YUWTLBA/formResponse
// https://events.withgoogle.com/30daysofgooglecloud/enrol-in-the-program/