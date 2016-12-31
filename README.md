Menageri

Granstrom_tentamen; Ken Granström

Jag har (eller bättre sagt: försökt lösa...) löst alla moment + delmoment förrutom den sista; möjligheten att ladda ett sparat spel.
Jag har suttit många dagar och försökt hitta små fel som ibland gör att spelet inte fungerar helt korrekt.
Ibland händer det att en och samma spelare jämför valörer med sig själva och ibland händer det att
en spelare jämför mera än en gång med samma spelare per omgång. Om man bortser från de här felena så rättar sig spelet sig själv
efter några omgångar. Tiden har tagit slut så jag måste lämna dessa fel i spelet :( bortsett från det här så fungerar alla andra 
delmoment som de skall.

Jag har användt mig av arraylistor var det företer sig något slag av listor. Dessa är i klassen DjurList som läser in djur-ljud från
en fil samt input (om det behövs) från spelaren. I main filen har jag en huvud arraylist som är viktig för hela spelet. Den innehåller
alla kort som kan spelas. Spelade kort skickas till SpelKort klassen som innehåller två arraylistor; en för spelade kort och en för 
kort vunna. När en spelare vinner en omgång så skrivs alla kort av både vinnaren och förloraren till listan med vunna kort, dock med 
vinnarens namn + id (även djur-läte och tur).

I sin helhet har jag försökt sköta felmeddelanden smart och se att de finns var de är viktiga. Jag har bl.a utnyttjat IndexOutOfBoundsException
i listorna med att catch detta och istället för att visa felmeddelanden, dela ut nya kort. Som ett exempel.

Som sista ord kan jag tillägga att jag är lite missnöjd med resultatet. Det var en ytterst intressant uppgift som jag antagligen kommer att 
göra färdig på egen hand oberoende. Jag inser att jag borde användt mera tid för den här uppgiften.
Main filen är lite tung på funktioner och de kunde säkert optimeras mera och bättre, om inte göras om helt. 

Men det här är vad jag åstadkom i alla fall :)




