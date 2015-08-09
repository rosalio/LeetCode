//
//  main.cpp
//  1_Two_Sum
//
//  Created by Xiaochen Dai on 8/8/15.
//  Copyright (c) 2015 Xiaochen Dai. All rights reserved.
//

//Given an array of integers, find two numbers such that they add up to a specific target number.
//
//The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
//
//You may assume that each input would have exactly one solution.
//
//Input: numbers={2, 7, 11, 15}, target=9
//Output: index1=1, index2=2


#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

vector<int> twoSum(vector<int>& nums, int target) {
    vector<int> result(2);
    unordered_map<int, int> table;
    
    for (int i = 0; i < nums.size(); i++) {
        if (table.find(target - nums[i]) == table.end()) {
            table[nums[i]] = i;
        } else {
            result[0] = table[target - nums[i]] + 1;
            result[1] = i + 1;
            break;
        }
    }
    return result;
}

int main(int argc, const char * argv[]) {
    vector<int> input = {2, 7, 11, 15};
    int target = 9;
    
    cout << "Input: number= {";
    for (int i = 0; i < input.size(); i++) {
        cout << input[i];
        if (i < input.size() - 1) {
            cout << ",";
        }
    }
    cout << "}, target=" << target << endl;
    
    vector<int> output = twoSum(input, target);
    
    if (output.size() == 2) {
        cout << "Output: index1=" << output[0] << ", index2=" << output[1] << endl;
    } else {
        cout << "Did not found" << endl;
    }
    
    return 0;
}
