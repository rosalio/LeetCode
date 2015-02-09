
//  twoSum.cpp
//  Two_Sum
//
//  Created by Xiaochen Dai on 3/31/14.
//  Copyright (c) 2014 Xiaochen Dai. All rights reserved.

/***********************************************************************************************
 
 Given an array of integers, find two numbers such that they add up to a specific target number.
 
 The function twoSum should return indices of the two numbers such that they add up to the target,
 where index1 must be less than index2. Please note that your returned answers
 (both index1 and index2) are not zero-based.
 
 You may assume that each input would have exactly one solution.
 
 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2
 
 ***********************************************************************************************/

#include <iostream>
#include <cstdlib>
#include <unordered_map>
#include <vector>

using namespace std;

/**
 * Solution 1
 * Use a hash table (unordered_map) to store each number and its corresponding index
 * Time: O(n); Space: O(n)
 **/

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


/**
 * Solution 2
 * Use sort and two pointers
 * Time: O(nlogn)
 **/

//vector<int> twoSum(vector<int> &numbers, int target) {
//    vector<int> result(2);
//    vector<int> numbersSorted = numbers;
//    int pHead = 0;
//    int pTail = (int)numbersSorted.size() - 1;
//
//    sort(numbersSorted.begin(), numbersSorted.end());   // copy of numbers to keep indeces
//    while(pHead < pTail) {
//        int sum = numbersSorted[pHead] + numbersSorted[pTail];
//        if(sum == target) {
//            vector<int>::iterator itFirst = find(numbers.begin(), numbers.end(), numbersSorted[pHead]);
//            int first = (int)distance(numbers.begin(), itFirst);
//            vector<int>::iterator itSecond = find(numbers.begin(), numbers.end(), numbersSorted[pTail]);
//            if(itFirst == itSecond)
//                itSecond = find(itFirst + 1, numbers.end(), numbersSorted[pTail]);
//            int second = (int)distance(numbers.begin(), itSecond);
//
//            // swap first and second if necessary
//            if(first > second)
//                swap(first, second);
//            result[0] = first + 1;
//            result[1] = second + 1;
//            break;
//        }
//        else if(sum < target)
//            ++pHead;
//        else
//            --pTail;
//    }
//    return result;
//}


int main(int argc, const char * argv[])
{
    // testing data
    vector<int> input;
    input.push_back(3);
    input.push_back(2);
    input.push_back(4);
    
    int target = 6;
    
    // call function
    vector<int> output = twoSum(input, target);
    
    return 0;
}
