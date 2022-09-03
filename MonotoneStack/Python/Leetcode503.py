class Leetcode503:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        res = [-1 for i in range(len(nums))]
        stack = []
        for i in range(2 * len(nums)):
            idx = i % len(nums)
            while stack and nums[stack[-1]] < nums[idx]:
                j = stack.pop()
                res[j] = nums[idx]
            stack.append(idx)
        return res
