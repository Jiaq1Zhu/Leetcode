class Leetcode937{
    public String[] reorder(String[] logs){
        //Create a new Compartor
        Comparator<String> myComp = new Comparator<String>(){
            public int compare(String log1,String log2){
                //Split log int identifer:content;
                String[] parts1 = log1.split(" ",2);
                String[] parts2 = log2.split(" ",2);
                // check if log is digit or letter
                boolean isDigit1 = Character.isDigit(parts1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(parts2[1].charAt(0));
                
                // case 1 both not digit
                if(!isDigit1 && !isDigit2){
                    int cmp = parts1[1].compareTo(parts2[1]);
                    if(cmp != 0)return cmp;
                    return parts1[0].compareTo(parts2[0]);
                }// case 2 log1 is letter, log2 is digit
                else if(!isDigit1 && isDigit2)return -1;
                // case 3 log1 is digit, log2 is letter
                else if(isDigti1 && !isDigit2)return 1;
                return 0;
            }
        };
        Arrays.sort(logs,myComp);
        return logs;
    }
}