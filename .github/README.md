# Ingegneria del Software 2022/2023

<div align=center>
	<image src=/.pics/ingsoft_cover.png width=30%></image></br></br>
	<image src=https://shields.io/badge/Eclipse-black?logo=eclipse&style=plastic></image>
	<image src=https://shields.io/badge/arch-black?logo=archlinux&style=plastic></image>
	</br></br>
</div>

del corso di Laurea in Informatica 'Ottobre 2022 - Gennaio 2023'.
Contiene appunti presi durante le lezioni e i programmi JAVA creati e compilati a lezione. Le lezioni sono anche registrate e si trovano sul corso elly2022.

Il corso è unico, tuttavia una sua parte, viene presa in carico dal [Prof. Lars Bendix](https://fileadmin.cs.lth.se/cs/Personal/Lars_Bendix/Teaching/1-ECTS-SCM/Parma-22/) dell'università di Lund, Svezia; periodo in cui viene spiegata la configurazione e management dei software attraverso l'uso di Github.

## Tools

**Text editors**
- `Obsidian.md` per prendere appunti in markdown
- `vim`

**IDE**
- `Eclipse` (strettamente legato al corso)

## Directory structure

```
Documents/Obsidian Vault/UNI/ING. SOFTW.
├── EXERCISES
│   ├── MARKDOWN
│   └── PDF
├── JAVA
│   ├── MARKDOWN
│   └── PDF
└── LESSONS
    ├── MARKDOWN
    └── PDF
```

**Le sottocartelle a nome `PDF` sono quelle contenenti i file esportati**, sono i file che vi interessano:
- **appunti** di teoria li trovate nella cartella `LESSONS`;
- **esercizi** tableau e simili nella cartella `EXERCISES`;
- i **programmi JAVA** sono nella cartella `JAVA`. I commenti sul codice sono numerati, minimali sulla sorgente, dettagliati nella cartella `PDF`. Trovate anche una guida comprensiva su come impostare il workspace su Eclipse.

Per installare soltanto i file PDF:
```
git clone --filter=blob:none --depth 1 --sparse https://github.com/MarkGotLasagna/ingsoft && \
    cd ingsoft && \
    git sparse-checkout init --cone && \
    git sparse-checkout set EXERCISES/PDF JAVA/PDF LESSONS/PDF
```

## Similar repos
Repository di persone che stanno/hanno seguito il corso sono esistenti e incoraggio a dare un'occhiata siccome più complete di questa.

- Tommaso Pellegrini
  - https://github.com/netpawn/ISW_Java_Concurrency
  - https://github.com/netpawn/GoF_DPs_Java_Examples
- Dennis Turco
  - https://github.com/DennisTurco/Ingegneria-del-Software
- Davoleo
  - https://github.com/Davoleo/uni/tree/master/IdS
