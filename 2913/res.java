class Solution {
    public int sumCounts(List<Integer> nums) {
        int res = 0;
        int n = nums.size();//3
        // k =0
        for(int i = 0;i < n; i++){
            int distinct = 0;
            for(int j = i; j < n; j++){
                boolean isNew = true;
                for (int k = i ; k < j; k++){
                    if(nums.get(k) == nums.get(j)){
                        isNew = false;
                        break;
                    }
                } // scan from i to j - 1
                if(isNew){
                    distinct++;
                }
                res += distinct*distinct;
            }
        }
        return res;
    }
}