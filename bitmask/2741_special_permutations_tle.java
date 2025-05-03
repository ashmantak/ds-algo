//https://leetcode.com/problems/special-permutations/

class Solution {
    int modulo = 1000000007; 
    
    public int specialPerm(int[] nums) {
        int n = nums.length;
        return permutate(nums, 0, new boolean[n], -1);
    }
    public int permutate(int[] nums, int curr, boolean[] used, int prev){
        
        if (curr == nums.length) {
            //System.out.println(prev); 
            return 1;
        }
        int ans = 0 ; 
        for(int k=0; k<nums.length; k++){
            if(used[k]) continue;
            if (curr==0){
                used[k]=true;
                //el[curr]=nums[k];
                ans += permutate(nums, curr + 1 , used, nums[k])%modulo; 
                used[k] = false;
            }else if (prev % nums[k] == 0 || nums[k] % prev == 0 ){
                used[k] = true;
                ans += permutate(nums, curr+1, used, nums[k]) % modulo;
                used[k] = false; 
            }
        }

        return ans;

    }
}
