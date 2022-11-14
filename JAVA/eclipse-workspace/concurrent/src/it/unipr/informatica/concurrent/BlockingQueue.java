package it.unipr.informatica.concurrent;

public interface BlockingQueue<T> {
	// aggiungo
	public void put(T e) throws InterruptedException;
	
	// rimuovo
	public T take() throws InterruptedException;
	
	// elementi disponibili di coda limitata superiormente
	public int remainingCapacity();
	
	// verifichaimo la coda vuota o meno
	public boolean isEmpty();
	
	// eliminiamo reference alla coda
	public void clear();
}
