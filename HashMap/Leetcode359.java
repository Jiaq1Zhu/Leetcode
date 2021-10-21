class Leetcode359{
     /*Easy using hashmap  */
     Map<String,Integer> map;
     public Leetcode359(){
        this.map = new HashMap<>();
     }

     public boolean shouldPrint(String message,int timestamp){
         if(!map.containsKey(message)){
             map.put(message,timestamp);
             return true;
         }else{
             if(map.get(message)+ 10 > timestamp){
                 return false;
             }
         }
         map.put(message,timestamp);
         return true;

     }
}