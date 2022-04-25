class Leetcode704:
    def search(self, nums: List[int], target: int) -> int:
        if len(nums) == 0:
            return -1
        l, r = 0, len(nums) - 1
        while l <= r:
            mid = (r - l) // 2 + l
            if nums[mid] == target:
                return mid
            elif nums[mid] < target:
                l = mid + 1
            else: r = mid - 1
        return -1
