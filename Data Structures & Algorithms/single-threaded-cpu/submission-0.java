class Task {
    int id;
    int enqueueTime;
    int processingTime;

    Task(int id, int et, int pt) {
        this.id = id;
        this.enqueueTime = et;
        this.processingTime = pt;
    }
}

class Solution {
    public int[] getOrder(int[][] tasks) {
        int[] order = new int[tasks.length];

        Queue<Task> taskQueue = new PriorityQueue<>((a, b) ->{
            if(a.enqueueTime != b.enqueueTime) return a.enqueueTime - b.enqueueTime;
            return a.id - b.id;
        });

        int idx = 0;
        for(int[] task : tasks) { //n
            taskQueue.offer(new Task(idx++, task[0], task[1]));//logn
        } //nlogn

        Queue<Task> priorityQueue = new PriorityQueue<>((a, b) ->{
            if(a.processingTime != b.processingTime) return a.processingTime - b.processingTime;
            return a.id - b.id;
        });

        int time = 0;
        idx = 0;
        while(!taskQueue.isEmpty() || !priorityQueue.isEmpty()) {//n
            while(!taskQueue.isEmpty() && time >= taskQueue.peek().enqueueTime) {
                priorityQueue.offer(taskQueue.poll());
            }

            if(priorityQueue.isEmpty()){
                time = taskQueue.peek().enqueueTime;
                continue;
            }

            Task task = priorityQueue.poll();
            order[idx++] = task.id;
            time += task.processingTime;
        }

        return order;
    }
}
