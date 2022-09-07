public class Leetcode1864 {
    public int minSwaps(String s) {
        // get the number of one and zero
        int cntOne = 0, cntZero = 0;
        for(char c: s.toCharArray()){
            if(c == '1')cntOne++;
            else cntZero++;
        }
        // if the absolute diff is greater than 1, no way we can get a valid result
        if(Math.abs(cntZero-cntOne)> 1)return -1;
        if(cntZero > cntOne){
            // if num of zero is more than num of one
            // zero will have to start first
            return countSwap(s,'0');
        }else if(cntZero < cntOne){
            // one will have to start first
            return countSwap(s,'1');
        }
        // if we have same number of one and zeros, return the min swap.
        return Math.min(countSwap(s,'0'),countSwap(s,'1'));
    }
    
    int countSwap(String s, char start){
        int count = 0;
        for(char c: s.toCharArray()){
            // check how many character is in the wrong place.
            if(c != start)count++;
            start = (char)('1'-start+'0');
        }
        // swap number is half of the character in the wrong place
        return count/2;
    }
}
