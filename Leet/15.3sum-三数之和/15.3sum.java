class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return Collections.emptyList();
        }

        Set<List<Integer>> result = new LinkedHashSet<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int head = i + 1;
            int tail = nums.length - 1;
            while (head < tail) {
                int sum = -(nums[head] + nums[tail]);
                if (sum == nums[i]) {
                    List<Integer> v = Arrays.asList(nums[i], nums[head], nums[tail]);
                    result.add(v);
                }
                if (sum < nums[i]) {
                    tail--;
                } else {
                    head++;
                }
            }
        }

        return new ArrayList<>(result);
    }
}

// 自己去重
class Solution {
    private List<List<Integer>> squeezeFastSolution(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new LinkedList<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            // 加速1：c为非负数，就不能满足a+b+c=0了
            if (nums[i] > 0) {
                return result;
            }
            // 加速2：跳过计算过的数据，同时防止结果重复
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int head = i + 1;
            int tail = nums.length - 1;
            while (head < tail) {
                int sum = -(nums[head] + nums[tail]);
                if (sum == nums[i]) {
                    result.add(Arrays.asList(nums[i], nums[head], nums[tail]));
                    // 加速3：跳过计算过的数据，同时防止结果重复
                    while (head < tail && nums[head] == nums[head + 1]) {
                        head++;
                    }
                    while (head < tail && nums[tail] == nums[tail - 1]) {
                        tail--;
                    }
                }
                if (sum <= nums[i]) {
                    tail--;
                } else {
                    head++;
                }
            }
        }

        return result;
    }
}