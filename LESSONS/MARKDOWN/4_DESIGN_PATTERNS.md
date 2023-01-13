# Unified Modeling Language (UML)

![[UML_logo.svg|200]]

Notazione grafica introdotta da Object Management Group (OMG) 
poco prima degli anni 2000. Sarebbe la notazione standard per la definizione delle architetture dei sistemi software, progettati con approccio orientato agli oggetti.
La visione e' astratta, nessun linguaggio e' preso come esempio.

## Class diagram
Diagramma delle classi.
E' un rettangolo scritto su foglio di carta in cui abbiamo elementi grafici rappresentanti l'architettura statica del nostro sistema software. Convenzioni sono presenti.

![[Pasted image 20221220093032.png|500]]

- Una **classe** e' sempre descritta da un *rettangolo* diviso tipicamente in almeno 3 parti, con obbiettivo la massima comprensione di chi sta leggendo. Se una delle parti non e' usata, possiamo lasciare bianco il campo.
  
  ![[Pasted image 20221220095301.png|250]]
  
	- Nome della classe;
	- Elenco attributi
	   Sempre identificati da un simbolo che ci dice la *visibilta'*, pubblica se c'e' un *+*, privata se *-* e protetta se c'e' un *#*.  Il tipo segue dopo il nome dell'attributo, dopo i due punti.
	- Operazioni
	   Sempre descritte dal nome e almeno il tipo degli argomenti, per distinguere operazioni con stesso nome.
	- Contratti
	   Non hanno una notazione effettiva, sono state proposte idee per formalizzare ma nessuno la utilizza. Come fosse un commento, descrizione breve.
- Una **classe astratta** la riconosciamo per il nome scritto in *italics*, corsivo.
  
  ![[Pasted image 20221220095332.png|250]]
  
	- Nome della classe;
	- Elenco attributi;
	- Operazioni;
- Una **interfaccia** viene indicata con un *pallino*.
  
  ![[Pasted image 20221220095402.png]]
  
- Anche la **classe** ha forma rettangolare.
   A seconda del legame presente tra piu' classi, si utilizza uno strandard diverso per specificare le relazioni tra di esse:
	- Il caso della specializzazione `Frame` -> `Window` vuole dire che la classe `Frame` e' una classe base di `Window` 
	  
	  ![[Pasted image 20221220094906.png]]
	  
	- Nella dipendenza usiamo la freccia tratteggiata piena. 
	  
	  ![[Pasted image 20221220095918.png|250]]
	  
	- Parliamo di composizione se all'interno della classe ci sono oggetti di un'altra classe
	   Il contenitore cr4ea e distrugge il contenuto (`EventQMgr` crea e distrugge i suoi eventi e contiene in qualche modo una collezione di eventi e li gestisce)
	   
	   ![[Pasted image 20221220100235.png|350]]
	   
	- Nell'aggregazione diciamo che `MenuBar` contiene lista di `MenuItem`, ma quest'ultime non sono create da `MenuBar`, non gestisce la loro vita. Con \* indichiamo la cardinalita', in questo caso infinita. La convenzione indica di scrivere $x..y$ per la cardinalita' degli oggetti (e.g. $1..\#$ indica almeno uno; $0..\mathtt{max}$ per dire che c'e' un massimo).
	  
	  ![[Pasted image 20221220100511.png|250]]
	  
	- Un'associazione 
	  
	  ![[Pasted image 20221220100602.png]]
	  
- I **commenti** sono legati con linea tratteggiata
  
  ![[Pasted image 20221220095440.png]]

## Sequence diagram
![[Pasted image 20221220105637.png|400]]
Descrizione dello scambio di messaggi tra oggetti che vivono nel sistema software. E' una notazione abbastanza ridondante, richiede tanto spazio ma è anche molto chiara.
Linee tratteggiate servono a descrivere il *tempo* dall'alto verso il basso.
Ogni classe ha un diagramma di flusso di questo tipo: ogni metodo ha un tempo di esecuzione e quindi ogni oggetto.

## Activity diagram
![[Pasted image 20221220183923.png|350]]

Notazione più compatta, rispetto ai sequence diagram fanno qualcosina di più: permettono di avere condizioni di scelta, branch sullo stile dei diagrammi di flusso e condizioni di sincronizzazione.

Le frecce dall'alto al basso servono a collegare delle attività, ognuno dei box prende il nome di *attività* e se volessimo raggruppare queste, le metteremmo in una *swimlane*.
Lo stato iniziale/finale viene rappresentato da pallino nero, con le linee orizzontali chiamate *fork*, separiamo i flussi concorrenti e con il rombo vuoto specifichiamo lo stato uscende della fork, attività rientranti chiamate *join*.

## State diagram
I [[#Sequence diagram]] e [[#Activity diagram]] descrivono l'andamento dinamico del nostro sistema, facendolo dal punto di vista della documentazione: chiarire le possibili soluzioni temporali, catturando qualche informazione ma non tutte.
Gli state diagram descrivono automi a stati finiti, in modo compatto; ogni stato può essere aperto e descritto in questo modo.

![[Pasted image 20221220190345.png|350]]

- L'evento **on** ci fa entrare nello stato di partenza, **off/reset** ci porta nello stato finale.
- Dentro a `Time keeping` possono succedere 2 cose:
	- L'evento **mode**, attivato dalla transizione interna `check()`, ci fa entrare in un *macro stato* chiamato `Time editing`
	- `check()` controlla il tempo e se non necessita alcuna modifica dell'orario, entra in **final state**.

# Design patterns
La costruzione di soluzioni partendo da schemi preesistenti, ci mette in una situazione garantita: i **design patterns** sono soluzioni riutilizzabili a problemi comuni ricorrenti dato un contesto nel *design del software*. 

Piuttosto che copia e incolla, le soluzioni dei nostri problemi sono delle rivisitazioni: avere un design pattern vuole dire avere un problema e soluzioni proposte al problema, soluzioni abbastanza generali che vanno poi messe all'interno del nostro progetto.
Per come sono fatti, hanno a che fare con la *programmazione orientata agli oggetti*.

I design pattern NON sono codice, ci viene detto con precisione le cose da fare, ma non c'è alcun codice da cui copiare. Le soluzioni proposte dai pattern sono incentrate piuttosto che alle prestazioni, alla *riusabilità*, siccome prioritaria.

- *creational patterns*
  intesi per la creazione di oggetti classe, piuttosto che istanziare direttamente;
- *structural patterns*
  usare ereditarietà per comporre interfacce e definire oggetti per nuove funzionalità;
- *behavioral patterns*
  protocolli per la comunicazione tra gli oggetti.

## Creational patterns
- *abstarct factory* raggruppa object factories che hanno un tema comune;
- *builder* costruisce oggetti complessi separando costruzione e rappresentazione;
- *factory method* crea oggetti senza specificare la classe esatta da costruire;
- *prototype* crea oggetti clonando un oggetto preesistente;
- *singleton* restringe la creazione degli oggetti per una classe, a una sola istanza.
### Abstract factory

![[Pasted image 20221220195151.png|400]]

Un modo per costruire oggetti, che venga reso reale tramite *interfaccia*,
lo chiamiamo **Abstract Factory**. 
Una volta realizzate le parti astratte, 
realizziamo le parti *concrete* con **Concrete Factory**. 
La parte concreta, implementazione della parte astratta,
*produrrà* oggetti con nome **Concrete Product**.

### Builder
![[Pasted image 20221221092059.png|400]]
Per la costruzione delle parti, usiamo il **Builder**.

![[Pasted image 20221221092525.png]]
Abbiamo un'interfaccia `Builder` e la sua parte concreta `ConcreteBuilder`.
Su interfaccia `Builder` andiamo a chiamare `buildPart()` per ogni parte dell'oggetto composto e una volta che abbiamo il numero sufficiente eseguiamo `getResult()`, per ritornare il prodotto.

### Factory method
![[Pasted image 20221221103541.png|400]]
Molto legato all'abstract factory, e' il **factory method**.
Permettiamo alle sottoclassi d'intervenire nella costruzione delle parti di un oggetto: spostiamo la `new` con il nome della classe, in un metodo protetto che ha come unico scopo quello di fare `return new(nomeClasse)`.

### Prototype
Per costruire un oggetto facciamo `new` di una classe.
Nei linguaggi orientati agli oggetti basati su classi, come appunto JAVA`fas:Java`, per costruire un oggetto facciamo `new` di classe concreta; le abstract factory, concrete factory e builder ci possono complicare la vita ma quello che ci serve sara' sempre e comunque la `new`.

![[Pasted image 20221221105918.png|400]]

Nei linguaggi orientati agli oggetti *basati su prototipi*, quello che succede e' che si costruisce un oggetto andando a replicarne un altro. Per costruire un nuovo oggetto, non chiediamo alla classe di crearlo (siccome questa non esiste), ma duplichiamo un oggetto che gia' abbiamo e lo modifichiamo a piacimento.
Tutto avviene a tempo d'esecuzione ma ci sono 2 grandi svantaggi:
1) non abbiamo tipi di dato a livello statico
    non riusciamo ad associare a tempo di compilazione un tipo a un oggetto, perche' questo poterebbe avere messaggi diversi in base alla strada presa e il compilatore non puo' immaginarseli
2) eliminiamo lo scopo del compilatore
    che non e' tanto generare codice, ma piuttosto segnalare errori e aiutare nella creazione

### Singleton
Altro esempio particolare di creazione di oggetti e' quello in cui di oggetti istanziabili per una classe, ce ne' sempre e comunque uno soltanto.

![[Pasted image 20221223193216.png|300]]
Un caso ci possa servire, per esempio, e' quando vogliamo creare classe solo per input/output a cui non interessa parlare con il sistema operativo. Viene costruito l'unico oggetto unica istanza *lazy* (potenzialmente mai) della classe: la prima volta che tocchiamo l'oggetto che necessita di essere visualizzato, come per esempio una UI, allora costruiremo.

## Structural patterns
- *adapter* permette a classi con interfacce incompatibili di lavorare insieme racchiudendo la stessa interfaccia in una gia' esistente;
- *bridge* dissocia un'astrazione da una implementazione per lavorare indipendentemente;
- *composite* costruisce zero-or-more oggetti simili cosicche' possano essere manipolati come un tutt'uno;
- *decorator* aggiunge/sovrasscrive comportamenti in un metodo di un oggetto;
- *proxy* provvede spazio per un altro oggetto per il controllo dell'accesso e riduzione complessita';
### Adapter
- Object adapter
Una *target* interface e' una interfaccia che ci piacerebbe usare, ma la nostra classe non implementa questa e quindi non ci e' possibile usarla. Per risolvere, modifichiamo il sorgente aggiungendo la parola chiave `implements`, aggiungiamo le funzioni mancanti e chiamiamo, a modifiche apportate, il metodo modificato a noi interessato.
- Class adapter
  tende a essere piu' utilizzato: anziche' usare la delega esplicita per andare a girare la chiamata, uso l'ereditarieta', anche se non in tutti i casi posso farlo.