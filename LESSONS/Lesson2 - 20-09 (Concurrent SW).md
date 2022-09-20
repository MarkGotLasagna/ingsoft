==**Sistemi concorrenti**==
Lo studio dei sistemi concorrenti dal punto di vista matematico facilita lo studio dello stesso. Errori possono essere evitati, race condition, dead lock, ecc. Bisogna capire durante la computazione, usando la *logica*.

$$(p \vee q) \wedge (\neg p \vee \neg q)$$

Un **linguaggio formale** è formato da:
- sintassi, set di formule ben definite
- semantica, interpretazione della sintassi

Un **linguaggio logico** è un linguaggio formale formato:
- assiomi, deduzioni logiche, ovvero verità presunte
- regole d'inferenza, per ottenere nuove verità dagli assiomi

Applicare un algoritmo/teorema lo si fa partendo da assiomi e regole. Purtroppo il linguaggio minimo per descrivere la matematica fa sì che per come è fatto (aritmetica dei numeri interi), non ci sono sempre dimostrazioni per il teorema.

---
## Logica proposizionale
La **logica proposizionale** è formata da simboli: questi simboli sono *atomi* e sono detti come se fossero affermazioni *TRUE* o *FALSE*.

 $q$ = Alice hates Bob...

Usiamo *connettivi* per costruire formule.
Questi hanno precedenza diversa:

$\neg, \wedge, \vee, \to, \equiv$

L'insieme dei simboli prop. è chiamato $P$.
$\top, \bot$ non sono appartenenti a $P$, hanno valori costanti e sono rispettivamente *TRUE* e *FALSE* (potremmo anche ometterli).
Le parentesi tonde più esterne possiamo ometterle o meno, possiamo usare quadre e graffe ma non sono necessarie.

$$((p \wedge q)\wedge r) \to p \wedge q \wedge r$$

Se qualcuno fornisce un insieme non vuoto, riusciamo a creare formule ben formate. Abbiamo così la sintassi, ci serve ora la semantica. La logica delle prop. serve ad attribuire un *significato* che è un *valore di verità*. 
Una interpretazione è una funzione che assegna un valore di verità a ciascun ed ogni simbolo di $P$.

|     | p   | q   | r   |
| --- | --- | --- | --- |
| I1  | F   | F   | F   |
| I2  | F   | F   | T   |
| I3  | F   | T   | F   |
| I4  | T   | F   | F   |
| ... |     |     |     |
*Cosa succede se $P$ è infinito? Ovvero insieme discreto?*
Il numero d'interpretazioni possibili $2^\infty$

Data un'***interpretazione*** $I$ su $P$, che chiamiamo $G_I$, ha le stesse proprietà di $P$, la funzione porta agli stessi risultati.

$$G_I(A) = I(A) \to P(A) = I(A)$$Una interpretazione $I$ è un ***modello*** per la proposizione $A$ se e soltanto se$$I \models A$$
es.
$$A = (p \to q)\wedge q$$<center> con $I$ tale che $I(p)=F$ e $I(q)=T$, allora $I$ è un modello per $A$.

Per verificare quello che abbiamo detto fino adesso (*model checking algorithm*):

$$I\models p$$ <center>se e soltanto se $I(p)=T$ e $p\in P$

Se un'interpretazione è sempre vera allora questa si chiama **tautologia**, con valore semantico sempre vero. Ci serve per fare ragionamenti.

$p \to q (p \vee q)$ sarà sempre vera per esempio

| $A \to A$              | sempre vera |
| ---------------------- | ----------- |
| $\neg A \to (A \to B)$ | sempre vera |
| ...                    |             |


