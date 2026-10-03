class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1) {return false;}
        List<List<Integer>> graph = new ArrayList<>();
        for(int i =0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] next : edges){
            graph.get(next[0]).add(next[1]);
            graph.get(next[1]).add(next[0]);
        }
        
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        visited[0] = true;
        queue.offer(0);
        int count = 1;
        while(!queue.isEmpty()){
            int currNode = queue.poll();
            for(int next : graph.get(currNode)){
                if(visited[next] == false){
                    visited[next] = true;
                    queue.offer(next);
                    count++;
                }
            }
        }
        return count == n;
    }
}
