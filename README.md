# Granstrom_tentamen
Programmerings tentamen

>Uppgiften: att simulera ett Menageri-spel
Menageri är ett spel för 4 eller fler deltagare, med 52 vanliga spelkort. Alla kort utdelas, även om det betyder att vissa spelare får ett kort mer än andra. De utdelade korten läggs med baksidan upp i en hög framför respektive deltagare. Innan själva spelet börjar ska varje spelare välja en djuridentitet åt sig, olika för varje spelare. Spelare till vänster om den som delar ut korten vänder upp sitt översta kort. Sedan gör nästa spelare samma sak, osv. När någon spelare vänder upp ett kort som har samma valör som ett tidigare vänt kort ska man fortast möjligt försöka låta som den spelarens djur. Den som gör detta först får ta samtliga uppvända kort från den spelare som blev härmad, och dessa kort läggs underst i den egna packen. Den som har blivit härmad lägger upp ett nytt kort. Härmar man däremot fel djur så ger man ett kort till den man skulel ha härmat. När en spelares kort är slut vänder spelaren på den hög som ligger uppvänd och börjar om. De spelare som blir av med alla sina kort lämnar spelet. Detta fortsätter tills någon har samtliga kort, och denna spelare vinner spelet.

>Moment 1: 1p. Skapa en klass Djur med två instansvariabler. Denna klass ska ha en metod skrivUt som skriver ut vilken typ av djur och vilket läte på samma rad som djur - läte, t.ex. ko - mu, alltså inte på skilda rader.

>Moment 2: 3p. Skapa en klass DjurList som läser in en fil med följande struktur: på den första raden ett nummer n som visar hur många rader det finns i filen. På de följande n raderna par av formen djur,läte, dvs. två strängar separarade med kommatecken. Klassen ska skapa en lista av Djur-objekt med alla djur och deras läten från filen. Du kan själv välja vilken typ av lista som skapas, och du bör motivera ditt val. Du bör också implementera eventuella andra metoder som du behöver i spelet.

>BONUS 1p. Kontrollera att det inte finns mer än ett djur av samma typ, och eliminera duplikat.

>Moment 3: 1p. Skapa en metod som visar ett grafiskt gränssnitt med dialogrutor som låter en mata in ett nytt par av djur och läte, och lägger till detta till listan som redan skapades i Moment 2. Ifall du inte kunde lösa Moment 2, skapa istället en ny lista.

>Moment 4: 1p. Skapa ett gränssnitt SpelKortGränssnitt med följande attribut: färg (kan vara de följande: hjärta, spader, ruter, klöver) och valör (kan vara de följande: A, 2, 3, 4, 5, 6, 7, 8, 9, 10, J ,Q, K). Du kan själv välja standardvärdet för färg och valör. Ditt interface bör ha följande metoder: getFärg(), getValör() och skrivUt().

>Moment 5: 1p. Skapa en klass SpelKort som implementerar ditt gränssnitt från Moment 4. Du kan lägga till ytterligare fält, beroende på hur du vill hålla reda på vilka kort som har vänts upp eller inte för varje spelare.

>Moment 6: 2p. Skapa en abstrakt klass Person med följande attribut: namn (en sträng), ID (en sträng i följande format: 6 siffror, ett bindestreck, och 4 ytterligare siffror). Klassen ska ha följande metoder: getName() som returnerar namnet, getID() som returnerar ID, och skrivUt() som skriver ut namnet följt av ett mellanslag och därefter ID.

>Moment 7: 7p. Skapa en klass Spelare som utökar (extends) den abstrakta klassen Person och har två ytterligare fält för att representera de kort som var vänts och inte vänts (typ SpelKort, och du väljer själv vilket slags lista du använder), djuret som spelaren representerar, spelarNu (ett booleskt värde som representerar om spelaren fortfarande spelar; ska vara FALSE när spelaren inte har några kort kvar). Implementera metoder för att:

returnera listan med kort som spelaren har spelat och därmed har vänts framför spelaren;
lägga till kort undertill i högen med kort som inte har vänts;
låta som djuret (i praktiken, den ska skriva ut djurets läte);
skriva ut namnet på spelaren, spelarens djurs läte, korten som inte har vänts och korten som har vänts.
BONUS 2p. För varje spelare, håll reda på spelarens tur i spelet. När spelet fortsätter byter det hela tiden vems tur det är att vända ett kort.Detta kommer att vara användbart för att spara spelets uppsättning.

Moment 8: 14p. I main-klassen, gör följande (du får skapa och använda ytterligare klasser!):

4p:

Läs in en fil med par av djur-läte och skapa en DjurList med dem.
Låt användaren mata in, i ett grafiskt gränssnitt, antalet spelare i form av ett nummer mellan 4 och 10. Om numret som matades in inte är mellan 4 och 10, fråga efter ett nytt nummer.
Fråga efter information för så många personer som numret som nyss matades in, och *_skapa ett Spelare-objekt för varje person. Du kan själv välja vilket slags lista du vill använda för att hålla reda på spelarna. Den ording i vilken de matas in kommer att användas som den ordning i vilken de spelar._*
Om antalet spelare är större än antalet unika par av djur-läte som har lästs in från filen, ha användaren att mata in nya par av djur-läte så att det finns minst lika många som antalet spelare. Testa att de nya inmatade paren av djur-läte inte är samma som något tidigare. Tilldela varje spelare slumpvis ett djur-läte-par.
2p:

Skapa en lista av alla kort i en kortlek. Dela ut dem slumpvis åt alla spelare (notera att vissa spelare kan få mer än andra, beroende på antalet spelare).
8p: Börja spela spelet. För varje omgång, gör följande:

Fråga användaren om den vill fortsätta eller spara spelet
Den spelare vars tur det är vänder ett kort. Skriv ut spelarens ID, kortet värde och valör på en ny rad i en loggfil.
Spelare fortsätter att vända kort, och alla turer sparas i loggfilen, tills någon vänder ett kort med samma valör som ett redan vänt kort. Då gör den spelare som vände senaste kortet och den vars kort har samma värde sina respektive läten. Välj slumpmässigt vem av dem som är snabbare. Skriv i loggfilen ID och lätet för de två spelarna, i den ordning de gjorde lätena, på en rad per spelare.
Gör kortutbytet mellan de två spelarna, enligt spelets regler. Obs! Korten byter ordning; det kort som var högst upp i högen av kort som hade vänts blir det kort som är lägst ned i den andra spelarens hög av kort som inte har vänts.
Om användaren väljer att spara spelet, spara den nuvarande speluppsättningen i en ny fil (namn och ID för varje  spelare, vilket djur och läte varje spelare har, och varje spelares kort som har vänts och inte har vänts). Använd inte loggfilen!
BONUS 4p. Gör det möjligt för användaren att ladda in en sparad speluppsättning och fortsätta därifrån. Du kan själv välja hur du sparar filen i Moment 8 så att det blir lätt att ladda ett sparat spel.

Skriv en "Läs mig"-textfil där du inkluderar följande information:

Vilka av momenten du har löst, och vilka delmoment av dessa
Vilka programmeringsval du har gjort (hur du skapade objekten, vilka konstruktorer du skapade, om du har försökt något annat som inte har fungerat)
MÄRK! För att få fulla poäng krävs också felhantering i alla moment. Kom också ihåg att ange hur inputen ska vara så att någon annan kan använda programmet!
