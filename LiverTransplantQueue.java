import java.util.Queue;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LiverTransplantQueue implements PriorityQueue{
	private ArrayList<Patient> pQueue;
	public LiverTransplantQueue() {
		pQueue = new ArrayList<Patient>();
	}
	public boolean isEmpty() {
		return pQueue.isEmpty();
	}

	@Override
	public void add(Object x) {
		if(x instanceof Patient)
			pQueue.add((Patient)x);
		else 
			System.err.println("Object not of Patient type");
	}

	@Override
	public Object poll() {
		if(pQueue.isEmpty()) {
			System.err.println("No Patients Are In Queue");
		}
		else if(pQueue.size() == 1) {
			return pQueue.remove(0);
		}
		else {
		Patient minHeap = pQueue.get(pQueue.size()-1);
		int index = 0;
		for(int i = pQueue.size() - 2; i >= 0; i--) {
			if(pQueue.get(i).compareTo(minHeap) < 0) {
				minHeap = pQueue.get(i);
				index = i;
			} else if(pQueue.get(i).equals(minHeap)) {
				minHeap = pQueue.get(i);
				index = i;
			}
		}
		pQueue.remove(index);
		return minHeap;
		}
		return null;
	}

	@Override
	public Object peek() {
		if(this.isEmpty())
			throw new NoSuchElementException();
		else {
		Patient minHeap = pQueue.get(0);
		int index = 0;
		for(int i = pQueue.size() - 1; i > 0; i--) {
			if(pQueue.get(i).compareTo(minHeap) < 0) {
				minHeap = pQueue.get(i);
				index = i;
			}
			else if(pQueue.get(i).equals(minHeap)) {
				minHeap = pQueue.get(i);
				index = i;
			}
		}
		return minHeap;
		}
	
	}

	@Override
	public int size() {
		return pQueue.size();
	}
	public String getNaturalOrder() {
		String output = "";
		ArrayList<Patient> temp = new ArrayList<Patient>();
		while(!pQueue.isEmpty()) {
			temp.add(pQueue.get(0));
			output+=pQueue.remove(0) + " ";
		}
		while(!temp.isEmpty()) {
			pQueue.add(temp.remove(0));
		}
			
		return output;
	}
	public String toString() {
		//doesnt Matter
		return pQueue.toString();
	}
	public static void main(String[] args)
	{
    		LiverTransplantQueue pq= new LiverTransplantQueue();
    		pq.add(new Patient("Smith",3));
    		pq.add(new Patient("Chen",2));
    		pq.add(new Patient("Jones",3));
    		pq.add(new Patient("Wong",3));
    		pq.add(new Patient("Gupta",2));
    		pq.add(new Patient("Garcia",1));
    		pq.add(new Patient("Brown",3));
    		System.out.println("The list is");
    		System.out.println(pq); 
    		while(pq.size()>0)
    		{
           			 System.out.println("The next patient for the liver transplant is");
           			 System.out.println(pq.poll());
   	            }
              }

}