import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int subarraySum(int[] nums, int k) {

        // 1. 创建哈希表：key = 前缀和，value = 这个和出现了几次
        Map<Integer, Integer> map = new HashMap<>();

        // 2. 初始化：前缀和为 0 出现 1 次（必须初始化）
        map.put(0, 1);

        int count = 0;    // 记录答案
        int preSum = 0;   // 记录当前的前缀和

        // 3. 遍历数组
        for (int num : nums) {
            preSum += num;  // 累加，计算当前前缀和

            // 4. 重点：找 preSum - k 出现过几次 → 就是有多少个子数组满足
            if (map.containsKey(preSum - k)) {
                count += map.get(preSum - k);
            }

            // 5. 把当前前缀和放进 map，次数+1
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }

        return count;
    }
}

/*  求和为 k 的连续子数组个数

    核心思路：前缀和 + HashMap
    前缀和
    从数组开头一路加到当前位置的总和，记为 preSum。

    关键公式
    preSum - 之前的前缀和 = k
    → 说明中间这一段子数组和 = k
    公式变形：preSum-k=之前的前缀和

    简化成一句话
    每次算完当前前缀和，去查 preSum - k 出现过几次
    出现几次，就有几个符合条件的子数组。

    HashMap 作用
    存：前缀和 = 出现次数
    用来快速查询，不用重复遍历。        */