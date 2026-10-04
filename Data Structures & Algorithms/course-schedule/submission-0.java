class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList());
        }
        for(int[] prereq : prerequisites){
            inDegree[prereq[0]]++;
            graph.get(prereq[1]).add(prereq[0]);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }
        int count = 0;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            count++;
            for(int i : graph.get(curr)){
                inDegree[i]--;
                if(inDegree[i]==0){
                    queue.offer(i);
                }
            }
        }
        return count == numCourses;


    }
}
