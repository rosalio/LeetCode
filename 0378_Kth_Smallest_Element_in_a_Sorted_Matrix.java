class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Point> minHeap = new PriorityQueue<Point>(k);
        
        minHeap.add(new Point(0, 0, matrix[0][0]));
        visited[0][0] = true;
        
        for (int i = 0; i < k - 1; ++i) {
            Point p = minHeap.poll();
            
            if (p.x + 1 < m && !visited[p.x + 1][p.y]) {
                Point right = new Point(p.x + 1, p.y, matrix[p.x + 1][p.y]);
                minHeap.add(right);
                visited[p.x + 1][p.y] = true;
            }
            
            if (p.y + 1 < n && !visited[p.x][p.y + 1]) {
                Point down = new Point(p.x, p.y + 1, matrix[p.x][p.y + 1]);
                minHeap.add(down);
                visited[p.x][p.y + 1] = true;
            }
        }
        return minHeap.poll().val;
    }
    
    class Point implements Comparable<Point> {
        public int x;
        public int y;
        public int val;
        
        public Point(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
        
        public int compareTo(Point other) {
            return this.val - other.val;
        }
    }
}