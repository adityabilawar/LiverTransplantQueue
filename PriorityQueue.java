public interface PriorityQueue
{
	boolean isEmpty();
	void add(Object x);
	Object poll();
	//Retrieves and removes the head of this queue, or null if this queue is empty.
	Object peek();
	//Retrieves, but does not remove, the head of this queue, returning null if this queue is empty.
	int size();
}