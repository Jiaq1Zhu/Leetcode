class Leetcode34:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if len(nums) == 0:
            return [-1, -1]
        l = self.findBoundary(nums, target, True)
        r = self.findBoundary(nums, target, False)
        if l < len(nums) and r < len(nums):
            return [l, r]
        else: return [-1, -1]
    
    def findBoundary(self, nums: List[int], target: int, left: bool) -> int:
        l, r, res = 0, len(nums) - 1, len(nums)
        while l <= r:
            mid = (r - l) // 2 + l
            if nums[mid] == target:
                res = mid
                if left: r = mid - 1
                else: l = mid + 1
            elif nums[mid] < target:
                l = mid + 1
            else: r = mid - 1
        return res
