from typing import List


class Solution:
    def removeCoveredIntervals(self, intervals: List[List[int]]) -> int:
        intervals.sort(key=lambda x: (x[0], -x[1]))
        vaild=0
        max=-1
        for interval in intervals:
            if interval[1] > max:
                vaild += 1
                max = interval[1]
            
        return vaild

if __name__ == "__main__":
    sol = Solution()
    intervals = [[1,4],[2,3]]
    result = sol.removeCoveredIntervals(intervals)
    print(result)  # Output: 2
