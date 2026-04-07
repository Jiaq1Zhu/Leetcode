public class FindMaxItem {
    public static List<Integer> findMaxItem(List<Integer> prices, List<Integer> pos, List<Long> amount) {
        long[] prefixSum = new long[prices.size() + 1];
        prefixSum[0] = 0;
        for (int i = 0; i < prices.size(); i++) {
            prefixSum[i + 1] = prefixSum[i] + prices.get(i);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < pos.size(); i++) {
            int p = pos.get(i);
            long budget = amount.get(i);
            if (p > n) {
                res.add(0);
                continue;
            }
            int startIndex = p - 1;
            long currentPrefix = prefixSum[startIndex];
            long maxAffordableSum = currentPrefix + budget;
            int left = startIndex, right = prices.size();
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (prefixSum[mid] <= maxAffordableSum) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            res.add(right - startIndex);
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> prices = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            prices.add(Integer.parseInt(bufferedReader.readLine().trim()));
        }

        int posCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> pos = new ArrayList<>();
        for (int i = 0; i < posCount; i++) {
            pos.add(Integer.parseInt(bufferedReader.readLine().trim()));
        }

        int amountCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Long> amount = new ArrayList<>();
        for (int i = 0; i < amountCount; i++) {
            amount.add(Long.parseLong(bufferedReader.readLine().trim()));
        }

        List<Integer> result = Result.findMaximumValue(prices, pos, amount);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));
            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
