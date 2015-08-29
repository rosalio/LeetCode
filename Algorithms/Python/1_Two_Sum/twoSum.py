class Solution:
    # @return a tuple, (index1, index2)
    def twoSum(self, num, target):
        checkTable = {}
        for i in xrange(0, len(num)):
            if checkTable.has_key(target - num[i]):
                return (checkTable.get(target - num[i]) + 1, i + 1)
            else:
                checkTable[num[i]] = i