# Ingegneria del Software 2022/2023

<div align=center>
	<image src=https://shields.io/badge/Eclipse-black?logo=eclipse&style=plastic></image>
	<image src=https://shields.io/badge/arch-black?logo=archlinux&style=plastic></image>
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
│   ├── eclipse-workspace
│   ├── MARKDOWN
│   └── PDF
└── LESSONS
    ├── MARKDOWN
    └── PDF
```

**Le sottocartelle a nome `PDF` sono quelle contenenti i file esportati**, sono i file che vi interessano:
- **appunti** di teoria li trovate nella cartella `LESSONS`;
- **esercizi** tableau e simili nella cartella `EXERCISES`;
- i **programmi JAVA** sono nella cartella `JAVA`, al suo interno trovate l'intero workspace Eclipse che se volete potete semplicemente scaricare e usare come vostro. I commenti sul codice sono numerati, minimali sulla sorgente, dettagliati nella cartella `PDF`. Trovate anche una guida comprensiva su come impostare il workspace su Eclipse.

Per installare soltanto i file PDF:
```
git clone --filter=blob:none --depth 1 --sparse https://github.com/MarkGotLasagna/ingsoft && \
    cd ingsoft && \
    git sparse-checkout init --cone && \
    git sparse-checkout set EXERCISES/PDF JAVA/PDF LESSONS/PDF
```

<p align="center">
  <img src="/PICS/graph_view.png" width="50%" alt="Graph view">
</p>

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

## Similar repos
Repository di persone che stanno/hanno seguito il corso sono esistenti e incoraggio a dare un'occhiata siccome più complete di questa.

- Tommaso Pellegrini
  - https://github.com/netpawn/ISW_Java_Concurrency
  - https://github.com/netpawn/GoF_DPs_Java_Examples

## Funding

<p align="center" style="border-radius:25px;">
  <img src="/PICS/tip-jar-paypal.jpg" width="25%" alt="PayPal QR"></br>
  <img src="/PICS/tip-ko_fi.png" width="25%" alt="Ko-fi pic">
</p>

Donazioni vanno ai link [PayPal.me](https://paypal.me/MarcoRondelli?country.x=IT&locale.x=it_IT) oppure [Ko-fi](https://ko-fi.com/markgotlasagna). </br>Potete in alternativa cliccare i link a destra della dashboard, oppure in alto, all'icona a forma di cuore.

Gli appunti rimarranno sempre e comunque *gratuiti*.
