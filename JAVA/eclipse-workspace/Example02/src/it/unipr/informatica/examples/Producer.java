package it.unipr.informatica.examples;

import it.unipr.informatica.concurrent.BlockingQueue;

public class Producer implements Runnable {
	// id >= 0
	private int id;
	// in ingresso
	private BlockingQueue<String> queue;
	public Producer(int id, BlockingQueue<String> queue) {
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
				String message = id + "/" + 1;
				System.out.println("P" + id + " sending" + message);
				queue.put(message);
				System.out.println("P" + id + " sent" + message);
				// attesa tra 100ms a 150ms
				Thread.sleep(100 + (int) (50 * Math.random()));
			}
		} catch (InterruptedException interrupted) {
			System.err.println("Producer " + id + " interrupted");
		}
	}
}