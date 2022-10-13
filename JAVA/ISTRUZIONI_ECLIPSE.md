Passo a passo le istruzioni da seguire per programmare in JAVA, utlizzando l'IDE Eclipse 2022-09

1) dopo l'instalazzione avviare Eclipse, presenterà il launcher per la scelta del workspace se già esistente, creandolo altrimenti
   
   ![[Pasted image 20221013132535.png|]]
2) all'avvio di Eclipse, ci sarà una pagina di presentazione che possiamo chiudere siccome non ci interessa
3) sulla sinistra clicchiamo `Create a project...` per creare un nuovo progetto `Java`, navigare quindi tra i menu aperti (nella finestra `Select a wizard` e selezionare:
   `Java > Java Project > 'Next>'`
   
   ![[Pasted image 20221013132920.png]]

4) nella nuova finestra, scrivere nel campo `Project name` il nome del progetto in `JAVA` che tipicamente assumerà nomenclatura numerata a seconda dell'esercitazione in corso. Deselezionare il campo `Module` in fondo alla finestra e cliccare `Next>` o `Finish`.

	![[Pasted image 20221013133242.png]]

5) nella finestra a lato sinistro a nome `Package Explorer`, cliccare sul progetto appena creato e selezionare col tasto destro la cartella dei file sorgente `src > New > Package`
6) nella finestra che comparirà, compilare il campo `Name` con il nome che assumerà l'insieme della nostra esercitazione (struttura a cipolla): `it.unipr.informatica.example01`. Cliccare su `Finish`.

![[Pasted image 20221013133859.png]]

7) sempre nella stessa finistra di sinistra, cliccare col destro il package appena creato `src > New > Class` per creare una nuova classe, la quale useremo per il `main`.

   ![[Pasted image 20221013134246.png]]
8) il file `main` è pronto, possiamo scrivere un esempio se vogliamo e avviare la compilazione. Per farlo, l'icona in alto a sinistra ci permette di compilare. Per sicurezza, siccome il nostro è un progetto e vogliamo che funzioni per l'insieme, compiliamo per intero `Run > Run as > Java application`.
   
   ```java
   package it.unipr.informatica.example01;

	public class Example01 {
		public static void main(String[] args) {
			System.out.println("Started");
		}
	}
	```

![[Pasted image 20221013134844.png]]   
   
   ![[Pasted image 20221013134553.png]]