class Solution {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        Map<Integer, Integer> sums = new HashMap ();
        sums.put(0, 1);
        int sum = 0;
        for (int n : nums) {
            sum += n;
            if (sums.containsKey(sum - k)) {
                result += sums.get(sum - k);
            }
            if (sums.containsKey(sum)) {
                sums.replace(sum, sums.get(sum) + 1);
            } else {
                sums.put(sum, 1);
            }
            // System.out.println(sums);
        }
        return result;
    }
}
