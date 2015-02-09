public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> checkTable = new HashMap<Integer, Integer>();
        int[] result = {-1, -1};
        
        for (int i = 0; i < numbers.length; i++) {
            if (!checkTable.containsKey(new Integer(target - numbers[i]))) {
                checkTable.put(new Integer(numbers[i]), new Integer(i));
            } else {
                result[0] = checkTable.get(target - numbers[i]).intValue() + 1;
                result[1] = i + 1;
            }
        }
        return result;
    }
}