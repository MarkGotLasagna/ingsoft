package it.unipr.informatica.concurrent;

// politica FIFO
public interface BlockingQueue<T> {
	// aggiunta sulla coda
	public void put(T e)
		throws InterruptedException;
	
	// rimozione sulla coda
	public T take()
		throws InterruptedException;
	
	// spazio rimasto (per coda limitata superiormente)
	public int remainingCapacity();
	
	// controllo sincrono se coda vuota o meno
	public boolean isEmpty();
	
	// libero reference dell'oggetto
	public void clear();
}
