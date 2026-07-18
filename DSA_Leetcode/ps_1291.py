from typing import List
class Solution:
    def sequentialDigits(self, low: int, high: int) -> List[int]:
        window=[]
        min_len=int(len(str(low)))
        max_len=int(len(str(high)))
        master_s='123456789'
        for i in range(min_len,max_len+1):
            for j in range(10-i):
                subwind=master_s[j:j+i]
                num=int(subwind)
                if low<=num<=high:
                    window.append(num)
                else:
                    pass
        return window
if __name__ == "__main__":
    sol = Solution()
    result = sol.sequentialDigits(low=100,high=300)
    print(result)
            