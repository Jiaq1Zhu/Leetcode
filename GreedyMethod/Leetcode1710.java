class Leetcod1710{
    public int maxNum(int[][] boxTypes,int truckSize){
        Arrays.sort(boxTypes,(a,b)->b[1]-a[1]);
        int res = 0;
        for(int i = 0;i < boxTypes.length;i++){
            if(boxTypes[i][0] <= truckSize){
                res += boxTypes[i][0] * boxTypes[i][1];
                truckSize -= boxTypes[i][0];
            }else{
                res += boxTypes[i][1] * truckSize;
                break;
            }
        }
        return res;
    }
}