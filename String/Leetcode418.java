public class Leetcode418 {
    public int wordTyping(String[] sentence, int rows, int cols){
        StringBuilder sb = new StringBuilder();
        for(String s: sentence){
            sb.append(s);
            sb.append(" ");
        }
        String all = sb.toString();
        int start = 0, len = all.length();
        for(int i = 0;i < rows; i++){
            start += cols;
            if(all.charAt(start%len) ==' '){
                start++;
            }else{
                while(start > 0 && all.charAt((start-1)%len) != ' ')start--;
            }
        }
        return start/len;
    }
}
