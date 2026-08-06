class Solution {
    public int smallestNumber(int n, int t) {
        int product = 1;
        int temp = n;

        while(n != 0){
            int digit = n%10;
            product *= digit;
            n/=10;
        }
        if(product % t == 0){
            return temp;
        }
        
        return smallestNumber(temp+1,t);
    }
}