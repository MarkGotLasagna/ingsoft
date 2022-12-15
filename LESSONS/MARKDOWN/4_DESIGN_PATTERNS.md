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
## Abstract factory
Un modo per costruire oggetti, che venga reso reale tramite *interfaccia*, lo chiamiamo **Abstract Factory**. Una volta realizzate le parti astratte, realizziamo le parti *concrete* con **Concrete Factory**. La parte concreta, implementazione della parte astratta, *produrrà* prodotti con nome **Concrete Product**.


