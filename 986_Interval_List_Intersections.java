class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> intersections = new ArrayList<>();
        int lenA = A.length;
        int lenB = B.length;
        
        int idxA = 0;
        int idxB = 0;
        while (idxA < lenA && idxB < lenB) {
            int low = Math.max(A[idxA][0], B[idxB][0]);
            int high = Math.min(A[idxA][1], B[idxB][1]);
            
            if (low <= high) {
                intersections.add(new int[]{low, high});
            }
            
            if (A[idxA][1] < B[idxB][1]) {
                idxA++;
            } else {
                idxB++;
            }
        }

        return intersections.toArray(new int[intersections.size()][]);
    }
}