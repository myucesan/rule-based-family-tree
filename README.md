# Expert System Practicum

500769574 | Mustafa Yücesan | [mustafa.yucesan@hva.nl](mailto:mustafa.yucesan@hva.nl)

# Introductie

Voor het implementeren van het expert systeem ben ik gebonden aan de mogelijkheden van deze java shell. In deze shell kan ik meerdere antecendenten (condities) toevoegen en als er 5 antecedenten zijn praten we over 5 AND condities. Deze shell doet niet aan OR. Veel mensen gebruiken PROLOG voor het expert systeem waarbij ik voor de verandering voor een java expert systeem wilde kiezen. Ik zal kijken in hoeverre het mogelijk is om een familieboom in deze shell te maken.

Deze shell biedt zowel forward chaining als backward chaining. Forward chaining houdt in dat het langzamerhand van A naar B gaat maar bij backward chaining is het juist andersom waarbij het B als doel stelt en langzaam terugwerkt van B naar A. Dit blijkt in de praktijk iets efficiënter te werken.

Voor dit practicum zijn een aantal vragen gesteld. Deze vragen lijken gebaseerd te zijn op het gebruik van PROLOG maar ik zal ze zo goed mogelijk proberen te beantwoorden met behulp van deze expert shell.

## Vraag - en antwoord

---

Maak een voorbeeld systeem met je eigen "familieboom" als data en regels over vader, moeder, oom, neef/nicht (cousin en nephew)
en laat het systeem vragen beantwoorden als "wie zijn (klein-)zonenbeschrijf/test hoe het werkt. Let op dat je geen feiten toevoegd die het systeem zelf af kan leiden dus hou de initiële kennisbank zo klein mogelijk.

Er is een methode dat gebruik maakt van de RuleInferenceEngine klasse dat wordt gebruikt om regels aan feiten te koppelen. In deze methode worden er regels aan de database toegevoegd. Daarna wordt er een andere functie aangemaakt die gebruik maakt van de inference engine, 
daar wordt een variabele met de inference engine als datatype. De returnwaarde van de RuleInferenceEngine methode (de returnwaarde is de engine met database) wordt gegeven aan dit variabelen. In de tweede methode met de variabele worden 'facts' toegevoegd. Het vreemde van deze expert shell is dat het maar tot 1 resultaat kan komen. Oftewel, op het moment dat een rule matcht aan de beschikbare feiten dan krijg je direct resultaat. Dat is ook wel logisch maar
in het geval van een familieboom zou je wel verder moeten kijken. Het is niet direct een IF THEN gebaseerd systeem wat het een beetje vaag maakt en lastig om een familieboom expert systeem van te maken. Ik zal relatie namen gebruiken voor de familieboom in plaats van namen in verband met privacygevoel.