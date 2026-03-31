class Solution {
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0) return null;
		
		PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
		
		for (ListNode node : lists) {
			if(node != null) {
				minHeap.offer(node);
			}
		}

		ListNode res = new ListNode(0);
		ListNode curr = res;

		while (!minHeap.isEmpty()) {
			ListNode node = minHeap.poll();
			curr.next = node;
			if (node.next != null) {
				minHeap.offer(node.next);
			}
			curr = curr.next;
		}

		return res.next;

	}
}