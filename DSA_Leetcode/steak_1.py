from itertools import count
from typing import List
class Solution:

    def majorityElement(self, nums: List[int]) -> int:
        seen={}
        for i in range(len(nums)):
            if nums[i] not in seen:
                seen[nums[i]] = 1
            else:
                seen[nums[i]] += 1
                pass
        high_key=max(seen, key=seen.get)
        return high_key

if __name__ == "__main__":
    sol = Solution()
    nums = [3,2,3]
    result = sol.majorityElement(nums)
    print(result)  # Output: 3