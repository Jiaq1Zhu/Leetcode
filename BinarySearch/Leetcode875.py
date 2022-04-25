class Leetcode875:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        l, r = 0, max(piles)
        while l <= r:
            k = int((r - l) // 2 + l)
            if k == 0:
                return 1
            time = self.hoursNeeded(piles, k)
            if time <= h:
                r = k - 1
            else:
                l = k + 1
        return l


    def hoursNeeded(self, piles: List[int], k: int) -> int:
        h = 0
        for pile in piles:
            if pile % k == 0:
                h += pile // k
            else: h += pile // k + 1
        return h
