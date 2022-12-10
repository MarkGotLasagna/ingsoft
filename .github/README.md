# Ingegneria del Software 2022/2023

<div align=center>
	<image src=/PICS/ingsoft_cover.png width=55%></image></br></br>
	<image src=https://shields.io/badge/Eclipse-black?logo=eclipse&style=plastic></image>
	<image src=https://shields.io/badge/arch-black?logo=archlinux&style=plastic></image>
	<image src=https://img.shields.io/github/stars/MarkGotLasagna/ingsoft?style=social></image>
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

Trovate l'insieme degli snippets CSS all'interno della repo [.dots](https://github.com/MarkGotLasagna/.dots).
Lista di plugins utilizzati:
```
/home/maruko/Documents/Obsidian Vault/.obsidian/plugins
├── cm-editor-syntax-highlight-obsidian
├── cmenu-plugin
├── highlightr-plugin
├── obsidian-admonition
├── obsidian-dynamic-toc
├── obsidian-emoji-toolbar
├── obsidian-functionplot
├── obsidian-icon-folder
├── obsidian-icons-plugin
├── obsidian-languagetool-plugin
├── obsidian-pandoc
├── obsidian-tikzjax
└── table-editor-obsidian
```

## Contributing
Chiunque puo' *contribuire* al progetto.
Per farlo chiedo di usare gli stessi strumenti da me utlizzati (in particolare `Obsidian.md`):
- modifiche sintattiche;
- modifiche semantiche;
- modifiche estetiche (quali aggiunta di immagini, formattazione, ecc.).

Se non siete familiari con GitHub, vi consiglio i DOCs ufficiali: [About forks](https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/working-with-forks/about-forks) e [About pull requests](https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/proposing-changes-to-your-work-with-pull-requests/about-pull-requests).

## Similar repos
Repository di persone che stanno/hanno seguito il corso sono esistenti e incoraggio a dare un'occhiata siccome più complete di questa.

- Tommaso Pellegrini
  - https://github.com/netpawn/ISW_Java_Concurrency
  - https://github.com/netpawn/GoF_DPs_Java_Examples

