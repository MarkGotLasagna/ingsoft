$\mathtt{NOTA\ SUL\ CODICE}$
Le lezioni sugli esempi di programmazione in JAVA saranno d'ora in avanti così annotate:
- ciascuna parte di codice di rilevanza, che necessita commenti per l'apprensione, verrà numerata e commentata brevemente sulla sorgente, mentre verrà qui discussa nel dettaglio;
- la discussione sul codice è presa dalle lezioni in presenza/registrazioni, potete verificare così la veridicità;
- il codice finale (nella cartella `JAVA/eclipse-workspace/Example/src`) potrebbe non essere lo stesso codice che riscontrate qui. Tuttavia non vi perdete nulla siccome commenterò anche quello.

---

# Costruzione dei thread

> [!note] Nomenclatura in JAVA
> Seguiamo la denominazione standard:
> - i metodi vengono sempre scritti con l'iniziale <u>m</u>inuscola;
> 	  `run()`
> - le classi vengono sempre scritte con l'iniziale <u>M</u>aiuscola;
> 	  `Notifier`
> - per separare le parole composte NON usiamo '\_' ma mettiamo la <u>M</u>aiuscola ad ogni nuova parola;
> 	  `waitInProgress`

Abbiamo visto la costruzione dei thread in JAVA e abbiamo visto come costruire un progetto in Eclipse. Abbiamo visto come aggiungere una classe in un package, quindi usiamo quello appena imparato per crearne due:
- un thread *Waiter* rimane in attesa aspettando la notifica di un altro;
- un thread *Notifier* dopo un'attesa di tot secondi randomica, notifica con `notifyAll()`.

Usando Eclipse clicchiamo col tasto destro sul nostro file `Example01` e creiamo una nuova classe con `New > Class` chiamandola *Notifier*.

![[Pasted image 20221111070054.png|500]]

## `Notifier`
Al suo interno estendiamo la classe `Thread`, siccome uno dei due modi per creare thread è o questo, o implementare l'interfaccia Runnable. Siccome il metodo `run()` (seppure vuoto) esiste già all'interno di `Thread`, facciamo `@Override` per scriverne un'implementazione.

> [!note] Nota su `@Override`
> Buona norma detta che il nostro metodo debba sempre essere preceduto da `@Override`, perché ci aiuta a non fare errori nell'implementazione: se omettessimo la parola chiave, non verrebbe segnalato nulla, il codice funzionerebbe lo stesso ma la creazione del metodo non sarebbe più una della classe che stiamo estendendo `Thread`

```java
package it.unipr.informatica.example01;

public class Notifier extends Thread {
	@Override
	public void run() {
	}
}
```

### `InterruptedException` vs `Throwable`
Proviamo a mettere all'interno del nostro metodo, un metodo statico di `Thread` per l'attesa di qualche secondo: `sleep(millis)`. Facendo ciò, decidiamo che 2sec possono essere sufficienti. Gestiamo anche l'eccezione che lancerebbe `sleep` con un `try-catch`.
L'eccezione da catturare possiamo deciderla noi:
di base, `sleep` lancia `InterruptedException` (siccome estende `Interrupted`), ma nel caso in cui non ci fidassimo o volessimo verificare la presenza di altre eccezioni, catturiamo `Throwable` per catturarle tutte.

> [!note] Estendiamo di default `InterruptedException`
```java
try {
	Thread.sleep(2000);
} catch(InterruptedException e) {
	//TODO
}
```

> [!note] Catturiamo tutto `Throwable`
```java
try {
	Thread.sleep(2000);
} catch(Throwable throwable) {
	//TODO
}
```

Quindi, per intenderci, dobbiamo catturare l'eccezione perché quando siamo in stato d'attesa qualcuno dall'esterno, può bloccare il Thread che lancerà, per ciascuno, `InterruptedException`. Ogni Thread verrà interrotto.

> [!note] Esempio di classe `Notifier.java` che usa `Throwable`
```java
package it.unipr.informatica.example01;

public class Notifier extends Thread {
	@Override
	public void run() {
		System.out.println("Started");
		
		try {
			// best-effort, almeno 2sec vengono garantiti
			Thread.sleep(2000);
		} catch(Throwable throwable) {
			// blank
		}
		
		System.out.println("Terminated")
	}
}
```

Torniamo ora nella classe con il `main`, dove ragioneremo su come lanciare il thread `Notifier`. Il `main`, essendo metodo `static` non ha accesso agli attributi che non sono uguali di tipo; definiamo la `go()` come tipo `public`.

Per usare la `Notifier`, creiamo un oggetto di tipo `Thread`; prendiamo l'abitudine di creare nuovi oggetti, siccome poi ci potrebbe servire usare i loro stati.
Il nuovo oggetto avrà compito di fare `start()` per avviare l'attesa.

> [!note] Esempio di classe `Example01.java`
```java
public class Example01 {
	public void go() {
		Thread notifier = New Notifier();
		
		notifier.start();
	}
	
	public static void main(String[] args) {
		new Example01().go();
	}
}
```

La compilazione ed esecuzione del programma porterà al seguente risultato aspettato.
![[Pasted image 20221111114538.png]]

