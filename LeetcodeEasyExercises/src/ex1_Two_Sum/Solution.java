package ex1_Two_Sum;
import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
    	
        HashMap<Integer,Integer> indexMap = new HashMap<>();
        
        for(int i = 0; i < numbers.length; i++){
            Integer neededNumber = target - numbers[i];
            
            if(indexMap.containsKey(neededNumber)){
                return new int[]{indexMap.get(neededNumber), i};
            }

            indexMap.put(numbers[i], i);
        }
        return null;
    }
}