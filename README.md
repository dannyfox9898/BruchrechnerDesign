# Bruchrechner
Author: <br />Goca Andelkovic<br />
LBS Eibiswald | 2aAPC | Gruppe A |  29.09.2025 - 03.10.2025

___
# BruchrechnerDesign

## 8-Golden-Regeln für Schnittstellen-Design
**Strebe nach Konsistenz** - Alle Schaltflächen sind gleich gestaltet.<br />
<br />**Strebe nach universeller Bedienbarkeit** - Der Rechner kann sowohl mit der Tastatur als auch mit der Maus verwendet werden, indem man die richtigen Tasten auswählt.<br />
<br />**Biete informatives Feedback an** - Die Textfelder werden mit der entsprechenden Zahl ausgefüllt, die eingegeben wird.<br />
<br />**Gestalte Dialoge so, dass sie zu einem Abschluss führen** - Die Schaltfläche „Gleich“ liefert das Endergebnis.<br />
<br />**Verhindere Fehler** - Die Idee ist, dass das Programm eine Funktion hat, die den Benutzer daran hindert, Symbole in Zahlenfelder oder Zahlen in Symbolfelder einzugeben. Die Schaltflächen, die nicht verwendet werden können, sind ausgegraut.<br />
<br />**Erlaube die Umkehrung von Aktionen** - Mit der AC-Taste können Benutzer ihre vorherige Eingabe rückgängig machen.<br />
<br />**Gib dem Nutzer das Gefühl der Kontrolle** - Das Programm tut nichts, es sei denn, der Benutzer gibt direkt etwas ein oder drückt eine Taste.<br />
<br />**Reduziere die Belastung des Kurzzeitgedächtnisses** - Die Felder zeigen, was der Benutzer eingegeben hat, sodass man sich nichts merken muss.<br />

___

## 10 Prinzipien für Interaktions-Design
**Sichtbarkeit des Systemstatus** - Die Felder und Schaltflächen geben dem Benutzer Kontext.<br />
<br />**Übereinstimmung zwischen System und realer Welt** - Die Anzahl und Form des Bruchs entsprechen der Standarddarstellung.<br />
<br />**Kontrolle und Freiheit der Nutzer** - Die AC-Taste ermöglicht dies.<br />
<br />**Konsistenz und Standards** - Das Design ist an das Aussehen eines typischen Taschenrechners angelehnt.<br />
<br />**Fehlerprävention** - Wie bereits erwähnt, verhindert das Programm mit den integrierten Funktionen, dass der Benutzer Zahlen in das Operatorfeld oder Operatoren in Zahlenfelder eingibt.<br />
<br />**Erkennen statt Erinnern** - Alle Zahlen werden auch auf dem Bildschirm angezeigt, sodass der Benutzer die Tastatur nicht verwenden muss.<br />
<br />**Flexibilität und Effizienz** - Das Programm ermöglicht die Eingabe sowohl mit der Tastatur als auch mit der Maus.<br />
<br />**Minimalistisches Design** - Das Design enthält nur wesentliche Elemente.<br />
<br />**Fehler erkennen, verstehen und beheben** - Die Idee ist, dass die fertige Version Popup-Nachrichten enthält, die den Benutzer informieren, wenn etwas schiefgelaufen ist.<br />
<br />**Hilfe und Dokumentation** - In der fertigen Version könnte der Rechner mit einer einfachen Textdatei mitgeliefert werden, die die Funktionsweise des Programms erklärt.<br />
___

# Designumsetzung - Bruchrechner

Hier ist die Implementierung, die ich basierend auf meinem ursprünglichen Entwurf hinzugefügt habe:
- Zuerst habe ich alle Tasten funktionsfähig gemacht, sodass sie ihr entsprechendes Symbol bzw. ihre entsprechende Zahl eingeben.
- Ich habe eine Fehlerbehandlung implementiert, die verhindert, dass Benutzer in die Zähler- und Nennerfelder etwas anderes als Zahlen eingeben (einschließlich des Minuszeichens für negative Zahlen).
- Außerdem habe ich den Code implementiert, der beim Auswählen des Operatorfeldes die Zahlen- und Plus-/Minus-Tasten deaktiviert und ausgraut, sodass der Benutzer keine Nicht-Operatoren in dieses Feld eingeben kann.
- Ich habe auch die Funktionalität der Gleichheitstaste implementiert, damit die Brüche korrekt berechnet werden.
- Schließlich habe ich die Klammern- und Komma-Tasten entfernt, da sie sich als zu kompliziert in der Implementierung erwiesen und unnötig erschienen.
- Ich habe es außerdem so eingerichtet, dass der Benutzer seine Tastatur für den Taschenrechner verwenden kann, und alle unnötigen Tasten wie Buchstaben werden blockiert.
### Verwendung
Technologien im Einsatz:<br />
- **Java**
- **UI Designer (Java Swing)**

___

### Screenshots
![alt text](https://github.com/dannyfox9898/BruchrechnerDesign/blob/main/src/bru1.png)
![alt text](https://github.com/dannyfox9898/BruchrechnerDesign/blob/main/src/bru2.png)