class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        n = len(intervals)
        if n == 0:
            return []
        def takeFirst(elem):
            return elem[0]
        intervals.sort(key = takeFirst)
        res = []
        left, right = intervals[0][0], intervals[0][1]
        for i in range(1, n):
            if intervals[i][0] <= right:
                right = max(right, intervals[i][1])
            else:
                res.append([left, right])
                left, right = intervals[i][0], intervals[i][1]
        res.append([left, right])
        return res
