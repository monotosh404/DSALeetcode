class Solution {
    public boolean isPalindrome(int x) {
        int sum=0;
        int y=x;
        if(x<0) return false;
        while(y!=0){
            sum=sum*10+(y%10);
           y/=10;
        }
        if(sum==x) return true;
        else return false;
        
    }
}