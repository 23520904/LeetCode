class Solution {
    public int powExplore(long n, int x, int i){
        if(n < x) return i;
        long k = n/x;
        return powExplore(k,x,++i);
    }
    public long countCommas(long n) {
        //Base explore 
        int expo = powExplore(n,1000,0);
        long base = Math.round(Math.pow(1000, expo));
        // Cal num of commas below base
        //Base duoi tru base duoi tiep
        long numComma = 0;
        for(int i = expo; i>= 2; i--){
            numComma+=Math.round(Math.pow(1000,i) - Math.pow(1000, i-1))*(i-1);
        }
        numComma+=(n - base + 1) * expo;
        return   numComma;

    }
}