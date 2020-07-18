public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int lengthOfLastWord(final String A) {
        int i = A.length()-1;
        int count = 0;
        boolean flag = false;
        while(i>=0){
            
             while( Character.isLetter( A.charAt(i)) ){
                 i--;
                 count++;
                 if(i < 0)  return count;
                 
                 flag = true;
             }
            
            if( flag) break;
            i--;
            if(i < 0)  return count;
        }
        return count;
    }
}
