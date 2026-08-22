class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> order = new ArrayList<>();
        List<List<Integer>> adjList = new ArrayList<>();
        List<Integer> vis = new ArrayList<>();
        int[] result = new int[numCourses];

        for(int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
            vis.add(0);
        }

        for(int[] p : prerequisites) {
            adjList.get(p[0]).add(p[1]);
        }

        for(int i = 0; i < numCourses; i++) {
            if(hasCycle(i, adjList, vis, order)) return new int[0];
        }

        for(int i = 0; i < numCourses; i++) result[i] = order.get(i);
        return result;
    }

    private boolean hasCycle(int i, List<List<Integer>> adjList, List<Integer> vis, List<Integer> order) {
        if(vis.get(i) == 1) return true;
        if(vis.get(i) == 2) return false;

        vis.set(i, 1);

        for(int prereq : adjList.get(i)) {
            if(hasCycle(prereq, adjList, vis, order)) return true;
        }

        vis.set(i, 2);
        order.add(i);

        return false;

    }
}
