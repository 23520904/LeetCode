class Solution {
    private int digitSum(int n){
        int res = 0;
        while(n>0){
            res+=n%10;
            n/=10;
        }
        return res;
    }
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[] ds = new int[n];
        for(int i = 0; i < n; i++){
            ds[i] = digitSum(nums[i]);
        }
        Integer[] order = new Integer[n];
        for(int i = 0; i < n ; i++) order[i] = i;
        Arrays.sort(order, (a,b) -> {
            if (ds[a] !=ds[b]) return Integer.compare(ds[a],ds[b]);
            return Integer.compare(nums[a],nums[b]);
        });
        boolean[] visited = new boolean[n];
        int cycles = 0;
        for(int i = 0 ; i < n; i++){
            if (!visited[i]){
                cycles++;
                int j = i;
                while(!visited[j]){
                    visited[j] = true;
                    j = order[j];
                }
            }
        }
        return n - cycles;
    }
}