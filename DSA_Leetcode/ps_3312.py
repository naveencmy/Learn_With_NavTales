from typing import List
from math import gcd
from bisect import bisect_right
class Solution:
    def gcdValues(self, nums: List[int], queries: List[int]) -> List[int]:
        max_num=max(nums)
        pair=[0]*(max_num+1)
        max_c=[0]*(max_num+1)
        for i in nums:
            max_c[i]+=1
        for i in range(1,max_num+1):
            c=0
            for j in range(i,max_num+1,i):
                    c+=max_c[j]  
            pair[i]=c*(c-1)//2
        for i in range(max_num, 0, -1):
            for j in range(2 * i, max_num + 1, i):
                pair[i] -= pair[j]
        for i in range(1,max_num+1):
             pair[i]+=pair[i-1]
        ans=[]
        for q in queries:
             ans.append(bisect_right(pair,q))
        return ans

if __name__ == "__main__":
    sol = Solution()
    nums = [2,3,4] 
    queries = [0,2,2]
    result = sol.gcdValues(nums,queries)
    print(result)