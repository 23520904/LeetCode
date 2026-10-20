class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int k = 1; k<= n ;k++){
            if (n % k != 0 ) continue;

            boolean ok = true;
            int prevMax = 0;
            
            for(int start = 0; ok && start < n; start += k){
                int descent = 0;
                int mn = Integer.MAX_VALUE;
                int mx = Integer.MIN_VALUE;
                
                for (int i = 0; i < k; i++){
                    int cur = nums[start + i];
                    int next= nums[start + (i +1)%k];
                    
                    if (cur > next) descent++;
                    mn = Math.min(mn, cur);
                    mx = Math.max(mx, cur);
                }

                if(descent > 1 || mn < prevMax){
                    ok = false;
                }
                else {
                    prevMax = mx;
                }
            }
            if (ok) res+=k;
        }
        return res;
    }
}