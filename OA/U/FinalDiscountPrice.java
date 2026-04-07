public class FinalDiscountPrice {
    public static void finalPrice(int[] prices) {
        int n = prices.length;
        long totalCost = 0;
        int[] finalCost = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int idx = stack.pop();
                finalCost[idx] = prices[idx] - prices[i];
            }
            stack.push(i);
        }
        for (int cost : finalCost) {
            totalCost += cost;
        }
        for (int i = 0; i < stack.size(); i++) {
            int idx = stack.pop();
            totalCost += prices[idx];
        }
        System.out.println(totalCost);
    }
}
