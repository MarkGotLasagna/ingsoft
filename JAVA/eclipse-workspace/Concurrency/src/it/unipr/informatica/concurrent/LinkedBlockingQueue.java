package it.unipr.informatica.concurrent;

import java.util.LinkedList;

public final class LinkedBlockingQueue<T> 
	implements BlockingQueue<T> {
		
	private LinkedList<T> queue;
	
	private LinkedBlockingQueue() {
		this.queue = new LinkedList<>();
	}
	
	@Override
	public T take() throws InterruptedException {
		synchronized (queue) {
			while (queue.size() == 0)
				queue.wait();
			T object = queue.removeFirst();
			if (queue.size() > 0)
				queue.notify();
			return object;
		}
	}
		
	@Override
	public void put(T object) {
		synchronized (queue) {
			queue.addLast(object);
			
		if (queue.size() == 1)
			queue.notify();
		}
	}
	
	@Override
	public boolean isEmpty() {
		synchronized (queue) {
			return queue.isEmpty();
		}
	}
	
	@Override
	public int remainingCapacity() {
		return Integer.MAX_VALUE;
	}
	
	@Override
	public void clear() {
		synchronized (queue) {
			queue.clear();
		}
	}
	
	
}