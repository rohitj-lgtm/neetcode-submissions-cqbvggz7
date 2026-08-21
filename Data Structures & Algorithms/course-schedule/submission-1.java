class Solution {
    public boolean hasCycle(int course, List<List<Integer>> adjList, List<Integer> vis) {
        if(vis.get(course) == 1) return true;
        if(vis.get(course) == 2) return false;

        vis.set(course, 1);

        for(int prereq : adjList.get(course)) {
            if(hasCycle(prereq, adjList, vis)) return true;
        }

        vis.set(course, 2);
        return false;
    }


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        List<Integer> vis = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
            vis.add(0);
        }
        for(int[] p : prerequisites) adjList.get(p[0]).add(p[1]);

        for(int course = 0; course < numCourses; course++) {
            if(hasCycle(course, adjList, vis)) return false;
        }

        return true;
    }
}
