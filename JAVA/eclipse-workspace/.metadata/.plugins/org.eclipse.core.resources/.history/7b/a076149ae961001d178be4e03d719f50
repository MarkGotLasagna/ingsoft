package it.unipr.informatica.example01;

public class Example01 {
	private Object mutex = new Object();
	
	private boolean waitInProgess = false;
	
	// scegliamo se metterlo privato o pubblico
	// di solito degli attributi mettiamo private, hanno senso public se hanno scopo identificato
	// es.: qualcuno da fuori vuole chiamare go()
	public void go() {
		waitInProgess = false;
		
		// creiamo un nuovo thread, il corpo del thread è doNotify
		Thread notifier = new Thread(this::doNotify);
		
		Thread waiter = new Thread(this::doWait);
		
		notifier.start();
		
		waiter.start();
	}
	
	//NOTA SULLA NOMENCLATURA
	//tenere a mente che le classi avranno sempre nome con la Maiuscola
	//i metodi sono sempre in minuscolo
	
	// static non ha accesso agli attributi diversi da static
	public static void main(String[] args) {
		// definito nell'altro file possiamo creare un Notifier
		new Example01().go();
	}
	
	private void doWait() {
			System.out.println("Waiter started");
			
			synchronized (mutex) {
				waitInProgess = true;
				
				mutex.notifyAll();
				
				try {
					mutex.wait();
				} catch (Throwable e) {
					// TODO: handle exception
				}
			}
			
			System.out.println("Waiter terminated");
	}
	
	//lo stato di Esempio01 è condiviso per la Notifier 
	//private class Notifier extends Thread {
		// è buona norma scrivere @Override perché esiste già un metodo col nome run()
		// a noi serve ridefinirlo e quindi lo scriviamo
	private void doNotify() {
		System.out.println("Notifier started");
		
		synchronized (mutex) {
			try {
				while (!waitInProgess)
					mutex.wait();
				
				Thread.sleep(5000);
				
				mutex.notifyAll();
			} catch (Throwable throwable){
				// NULL
			}
		}
		
		System.out.println("Notifier terminated");
	}
	

}
