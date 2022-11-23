# Pool of resources
Se abbiamo per esempio 10 risorse e 20 flussi di esecuzione, fintanto che i flussi di esecuzione richiedenti la risorsa non superano il numero di risorse disponibili, allora non ci saranno problemi.

Un gruppo di risorse e' chiamato *pool of resources*:
- alla creazione/eliminazione, il pool viene acquisito/rilasciato;
- le risorse sono assegnate alla richiesta;
- il controllo dell'accesso e' garantito dal pool.

## Thread pools
Sono oggetti usati dal flusso di esecuzione nel momento del bisogno: nel momento in cui ci serve un thread per computare, uno qualsiasi va bene.
Nelle configurazioni vengono sempre specificati 1024 thread per ogni processo, quindi nella JVM. Sono risorse da usare con parsimonia ma tipicamente non ce ne accorgiamo, tuttavia noi discutiamo il numero giusto per le nostre operazioni.

### Executors
Per eseguire in concorrenza dei *task*:
- associato ad un thread pool;
- mette in coda i task che non possono essere eseguiti subito;
- provvede modo di restituire il risultato di un task;
- provvede modo per ritornare eccezioni che hanno causato la terminazione;
- permette d'interrompere task e thread associati.

#### `Executor.java`
```java
package it.unipr.informatica.concurrent;

public interface Executor {
	public void 
}
```

#### `RejectedExecutionException.java`
```java
package it.unipr.informatica.concurrent;

public class RejectedExecutionException extends RuntimeException {
	private static final long serialversionUID = 
		-6748556787095111509L;
		
	public RejectedExecutionException(String message) {
		super(message);
	}
}
```

#### `ExecutorService.java`
```java

```

#### `Executors.java`
```java
package it.unipr.informatica.concurrent;

public class Executors {
	public static ExecutorService newFixedThreadPool(int count) {
		return new SimpleThreadPoolExecutorService(count);
	}
	
	private Executors() {
		// blank
	}
}
```

#### `SimpleThreadPoolExecutorService.java`
```java
package it.unipr.informatica.concurrent;

class SimpleThreadPoolExecutorService implements ExecutorService {
	private Worker[] workers;
	private BlockingQueue<Runnable> tasks;
	private boolean shutdown;
	
	SimpleThreadPoolExecutorService(int count) {
		if(count<1)
			throw new IllegalArgumentException("count < 1");
		this.shutdown = false;
		this.tasks = new LinkedBlockingQueue<>();
		this.workers = new Worker[count];
		for(int i=0; i<count; ++i) {
			Worker worker = new Worker();
			workers[i] = worker;
			worker.start();
		}
	}
	
	@Override
	public void execute(Runnable command) {
		if(command == null)
			throw new NullPointerException("command == null");
		synhronized(tasks) {
			if(shutdown)
				throw new 
					RejectedExecutionException("shutdown == true");
			try {
				tasks.put(command);
			} catch(InterruptedException interruptedException) {
				// blank
			}
		}
	}
	
	@Override
	public void shutdown() {
		synchronized(tasks) {
			shutdown = true;
			int length = workers.length;
			for(int i=0;i<length;++i)
				workers[i].shutdown();
		}
	}
	
	private class Worker implements Runnable {
		private boolean shutdown;
		private Thread thread;
		private Worker() {
			this.shutdown = false;
			this.thread = new Thread(this);
		}
		
		@Override
		public void run() {
			for(;;) {
				synchronized(thread) {
					if(shutdown)
						return;
				}
				try {
					Runnable runnable = tasks.take();
					runnable.run();
				} catch(InterruptedException interruptedException) {
					return;
				} catch(Throwable throwable) {
					throwable.printStackTrace();
				}
			}
		}
		
		private void start() {
			thread.start();
		}
		
		private void shutdown() {
			synchronized(thread) {
				shutdown = true;
				thread.interrupt();
			}
		}
	}
}
```

## `DownloadManager.java`
```java
package it.unipr.informatica.examples;
import java.io.BufferInputStream;

public final class DownloadManager {
	private static final int BUFFER_SIZE = 1024;
	private ExecutorService executorService;
	
	public DownloadManager(int connections) {
		if(connections < 1)
			throw IllegalArgumentException("connections < 1");
		this.executorService = 
			Executors.newFixedThreadPool(connections);
	}
	
	public void shutdown() {
		esecutorService.shutdown();
	}
	
	public void download(String url) {
		if(url==null)
			throw new IllegalArgumentException("url==null");
		executorService.execute(() -> downloadAndPrint(url));
	}
	
	private void downloadAndPrint(String url) {
		try (InputStream inputStream = new URL(url).openStream();
			BufferedInputStream bufferedInputStream = 
				new BufferedInputStream(inputStream);
			ByteArrayOutputStream outputStream =
				new ByteArrayOutputStream()
				// ...
	}
}
```

## `Example05.java`
```java

```