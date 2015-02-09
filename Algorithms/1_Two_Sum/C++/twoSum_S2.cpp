vector<int> twoSum(vector<int> &numbers, int target) {
    vector<int> result(2);
    vector<int> numbersSorted = numbers;
    int pHead = 0;
    int pTail = (int)numbersSorted.size() - 1;

    sort(numbersSorted.begin(), numbersSorted.end());   // copy of numbers to keep indeces
    while(pHead < pTail) {
        int sum = numbersSorted[pHead] + numbersSorted[pTail];
        if(sum == target) {
            vector<int>::iterator itFirst = find(numbers.begin(), numbers.end(), numbersSorted[pHead]);
            int first = (int)distance(numbers.begin(), itFirst);
            vector<int>::iterator itSecond = find(numbers.begin(), numbers.end(), numbersSorted[pTail]);
            if(itFirst == itSecond)
                itSecond = find(itFirst + 1, numbers.end(), numbersSorted[pTail]);
            int second = (int)distance(numbers.begin(), itSecond);

            // swap first and second if necessary
            if(first > second)
                swap(first, second);
            result[0] = first + 1;
            result[1] = second + 1;
            break;
        }
        else if(sum < target)
            ++pHead;
        else
            --pTail;
    }
    return result;
}
