public class Leetcode1177 {
    /**
     * In this problem, we want to know if a range given by query can construct a palindrome if we replace k characters.
     * The key of this problem is that the character within range can be sort in different ways.
     * This this means that if the number of a character is even, it can always be part of a palindrome.
     * Then we can find how many character has odd occurance. We sum it up, we can change half of them to existed other half to form a palindrome.
     * So, it this number does not exceed k. It can be a palindrome.
     * @param s
     * @param queries
     * @return
     */
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        // Create a prefix sum array to record the occurence of each letter at different position of the string.
        int[][] cnt = new int[s.length()+1][26];
        List<Boolean> res  = new ArrayList<>();
        for(int i = 0;i < s.length();i++){
            cnt[i + 1] = Arrays.copyOf(cnt[i],26);
            ++cnt[i + 1][s.charAt(i) - 'a'];
        }
        for(int[] query:queries){
            int sum = 0;
            // for each query, we iterate through the array and sum up the character with odd number of occurancy.
            for(int i = 0;i < 26;i++){
                // both side inclusive
                sum += (cnt[query[1] + 1][i] - cnt[query[0]][i]) % 2;
            }
            // check if the number of characters we need to replace is within range.
            res.add(sum/2 <= query[2]);
        }
        return res;
    }
}
