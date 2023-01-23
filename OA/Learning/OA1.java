class OA1{
    public static void getDistribution(int[] cardTypes,int packetNum){
        int res = 0;
        for(int i = 0;i < cardTypes.length;i++){
            res += cardTypes[i]%packetNum+1;
        }
        return res;
    }
}

int addCardSum = 0;
for(int i = 0; i < cardTypes.size(); i++){
if(cardTypes[i]%2!=0)
addCardSum++;
}

if(addCardSum<2 || addCardSum==3)
addCardSum=0;

return addCardSum; 