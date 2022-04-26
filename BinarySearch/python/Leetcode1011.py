class Leetcode1011:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        low, high = max(weights), sum(weights)
        while low <= high:
            capacity = (high - low) // 2 + low
            time = self.daysNeeded(weights, capacity)
            if time > days:
                low = capacity + 1
            else:
                high = capacity - 1
        return low

    def daysNeeded(self, weights: List[int], capacity: int) -> int:
        days = carry = 0
        for weight in weights:
            carry += weight
            if carry > capacity:
                carry = weight
                days += 1
        return days + 1
