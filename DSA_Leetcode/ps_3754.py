from itertools import count
from typing import List
class Solution:
    def sumAndMultiply(self, n: int) -> int:
        total_sum = ""
        product = 0
        for i in str(n):
            if i!="0":
                total_sum+=i
                product+=int(i)
        if total_sum=="":
            return 0
        total=int(total_sum)*product
        return total
    

if __name__ == "__main__":
    sol = Solution()
    n = 0
    result = sol.sumAndMultiply(n)
    print(result)