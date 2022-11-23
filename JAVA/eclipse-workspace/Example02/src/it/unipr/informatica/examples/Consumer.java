package it.unipr.informatica.examples;

import it.unipr.informatica.concurrent.BlockingQueue;

public class Consumer implements Runnable {
	// id >= 0
	private int id;
	// in ingresso
	private BlockingQueue<String> queue;
	public Consumer(int id, BlockingQueue<String> queue) {
		if (id < 0)
			throw new IllegalArgumentException("id < 0");
		if (queue == null)
			throw new IllegalArgumentException("queue == null");
		this.id = id;
		this.queue = queue;
	}
	
	@Override
	public void run() {
		try {
			for (int i = 0; i<5; ++i) {
				String message = queue.take();
				System.out.println("C" + id + 
					" received " + message);
				Thread.sleep(100 + (int) (50 * Math.random()));
			}
		} catch (InterruptedException interrupted) {
			System.err.println("Consumer " + id + " terminated");
		}
	}
}