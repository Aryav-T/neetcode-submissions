class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][];
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> dist(b) - dist(a));
        for(int[] next : points){
            maxHeap.offer(next);
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        for(int i = 0; i < k; i++){
            result[i] = maxHeap.poll();
        }
        return result;
    }

    private int dist(int[] point ){
        int x = point[0]*point[0];
        int y = point[1]*point[1];
        return x + y;
    }
}
