vector<int> twoSum(vector<int> &numbers, int target) {
    vector<int> result(2);
    unordered_map<int, int> checkTable;
    
    for(int i = 0; i < numbers.size(); i++) {
        if(checkTable.find(target - numbers[i]) == checkTable.end()) {
            checkTable[numbers[i]] = i;
        } else {
            result[0] = checkTable[target - numbers[i]] + 1;
            result[1] = i + 1;
        }
    }
    return result;
}
