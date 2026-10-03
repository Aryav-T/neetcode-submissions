class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        } 
        for(int[] next : times){
            int from = next[0];
            int to = next[1];
            int cost = next[2];
            graph.get(from).add(new int[]{to, cost});
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b)->Integer.compare(a[0], b[0]));
        heap.offer(new int[]{0,k});
        while(!heap.isEmpty()){
            int[] top = heap.poll();
            int cost = top[0];
            int node = top[1];
            if(cost > dist[node]){
                continue;
            }
            for(int[] edge : graph.get(node)){
                int neighbor = edge[0];
                int neighborCost = edge[1];
                int newCost = neighborCost + cost;
                if(newCost < dist[neighbor]){
                    dist[neighbor] = newCost;
                    heap.offer(new int[]{newCost, neighbor});
                }
            }
        }
    
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, dist[i]);
        }
        return max;
    }
}
