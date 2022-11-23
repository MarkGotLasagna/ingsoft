package it.unipr.informatica.examples;

import it.unipr.informatica.concurrent.BlockingQueue;

public class Example02 {
	private void go() {
		BlockingQueue<String> queue = new LinkedBlockingQueue<>();
		// costruisce e attiva i 5 consumer
		for (int i=0; i<5; ++i) {
			Consumer consumer = new Consumer(i, queue);
			new Thread(consumer).start();
		}
		// costruisce e attiva i 5 producer
		for (int i=0; i<5; ++i) {
			Producer producer = new Producer(i, queue);
			new Thread(producer).start();
		}
	}
	
	public static void main(String[] args) {
		new Example02().go();
	}
}