class Solution {
    public int reverseDegree(String s) {
        int sum=0;
        for(int i=0;i<s.length();i++){
            int ascii=(int) s.charAt(i);
            int diff=ascii-97;
            int new1=26-diff;
            sum+=(new1*(i+1));
        }
        return sum;
    }
}