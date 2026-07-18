from typing import List
from math import gcd
class Solution:
    def gcdSum(self, nums: list[int]) -> int:
        prefix_arr=[]
        curr_max=0
        for num in nums:
            curr_max=max(curr_max,num)
            calculated_gcd=gcd(num,curr_max)
            prefix_arr.append(calculated_gcd)
        prefix_arr.sort()
        total_sum=0
        l=0
        r=len(prefix_arr)-1
        while(l<r):
            total_sum+=gcd(prefix_arr[l],prefix_arr[r])
            l+=1
            r-=1

        return total_sum

if __name__ == "__main__":
    sol = Solution()
    nums = [3,6,2,8]
    result = sol.gcdSum(nums)
    print(result)