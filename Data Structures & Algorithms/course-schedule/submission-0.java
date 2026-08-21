class Solution {
    public boolean hasCycle(int course, Map<Integer, List<Integer>> adjList, Map<Integer, Integer> vis) {
        if(vis.getOrDefault(course, 0) == 1) return true;
        if(vis.getOrDefault(course, 0) == 2) return false;

        vis.put(course, 1);

        for(int prereq : adjList.getOrDefault(course, new ArrayList<>())) {
            if(hasCycle(prereq, adjList, vis)) return true;
        }

        vis.put(course, 2);
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        Map<Integer, Integer> vis = new HashMap<>();

        for(int[] node : prerequisites) {
            if(adjList.containsKey(node[0])) adjList.get(node[0]).add(node[1]);
            else {
                List<Integer> prereq = new ArrayList<>();
                prereq.add(node[1]);
                adjList.put(node[0], prereq);
            }
        }

        for(int course : adjList.keySet()) {
            if(hasCycle(course, adjList, vis)) return false;
        }

        return true;
    }
}
