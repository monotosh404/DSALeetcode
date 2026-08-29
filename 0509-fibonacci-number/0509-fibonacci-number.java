class Solution {
    public int fib(int n) {
        int f0=0;
        int f1=1;
        int f=0;
        if(n==0) return 0;
        if(n==1) return 1;
        while(n-1>0){
            f=f1+f0;
            f0=f1;
            f1=f;
            
            n--;
        }
        return f;
    }
}