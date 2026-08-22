class Solution {
    public boolean checkDivisibility(int n) {
        int rem;
        int sum=0;
        int product=1;
        int init=n;
        while(n>0){
            rem=n%10;
            sum+=rem;
            product*=rem;
            n/=10;
        }
        int result=sum+product;
        if (init%result==0) return true;
        else return false;
    }
}