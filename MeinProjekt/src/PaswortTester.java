import java.util.ArrayList;

public class PaswortTester {
    private int mindestZeichen = 6; private int mindestGrossbuchstaben = 1; private int mindestZahlen = 1;
    private int mindestSonderzeichen = 1; private char[] erlaubteSonderzeichen ={'!','+','-','.'};
    boolean Ergebnis = true;

    public boolean testePasswort(String passwort) {
        StringBuilder result = new StringBuilder();
        // Zähler Variablen für anzahlGrossbuchstaben, anzahlZahlen, anzahlSonderzeichen
        int anzahlGrossbuchstaben = 0;
        int anzahlZahlen = 0;
        int anzahlSonderzeichen = 0;

        //for(int i = 0; i <= passwort.length() -1; i++) {
        for(int i = 0; i < passwort.length(); i++) {
            char aktuellesZeichen = passwort.charAt(i);
            if(istZahl(aktuellesZeichen)) {
                anzahlZahlen ++;

            }
            if(istGrossbuchstabe(aktuellesZeichen)) {
                anzahlGrossbuchstaben ++;
            }
            if(istSonderzeichen(aktuellesZeichen)) {
                if(istSonderzeichenErlaubt(aktuellesZeichen)) {
                    anzahlSonderzeichen++;
                } else {
                    // System.out.println("Sonderzeichen " + aktuellesZeichen + " ist nicht erlaubt.");
                    result.append("Sonderzeichen " + aktuellesZeichen + " ist nicht erlaubt. Erlaubt sind: " + new String(erlaubteSonderzeichen));
                    result.append(System.lineSeparator());
                }

            }
        }


        if(Ergebnis == true){

            if(anzahlZahlen < mindestZahlen) {
                result.append("Zu wenig Zahlen. Es fehlen: " + (mindestZahlen - anzahlZahlen));
                result.append(System.lineSeparator());
                Ergebnis = false;
                return Ergebnis;
            }
            if(anzahlGrossbuchstaben < mindestGrossbuchstaben) {
                result.append("Zu wenig Großbuchstaben. Es fehlen: " + (mindestGrossbuchstaben - anzahlGrossbuchstaben));
                result.append(System.lineSeparator());
                Ergebnis = false;
                return Ergebnis;
            }
            if(anzahlSonderzeichen < mindestSonderzeichen) {
                result.append("Zu wenig Sonderzeichen. Es fehlen: " + (mindestSonderzeichen - anzahlSonderzeichen));
                result.append(System.lineSeparator());
                Ergebnis = false;
                return Ergebnis;
            }
            if(passwort.length() < mindestZeichen) {
                result.append("Zu wenig Zeichen. Es fehlen: " + (mindestZeichen - passwort.length()));
                result.append(System.lineSeparator());
                Ergebnis = false;
                return Ergebnis;
            }

            // Schleife
            //    von 0 bis passwort.length - 1
            //    für jeden einzelnen char in passwort (an der Stelle i)
            //          https://docs.oracle.com/javase/8/docs/api/java/lang/Character.html -> Testmethoden für jeden Character Typ
            //          Oder:
            //          Vergleich von chars:
            //          'a' < 'z'
            //          char zeichen;
            //          'A' <= zeichen
            //          zeichen <= 'Z'
            //      Prüfe ist der character ein Großbuchstabe, Zahl oder kleinbuchstabe, wenn nicht -> sonderzeichen
            //      Wenn der Character ein Sonderzeichen ist, dann prüfe ob es erlaubt ist
            //      Wenn es eine Zahl/Großbuchstabe oder Sonderzeichen ist, erhöhe die entsprechenden Zähler

            // Nach der Schleife:
            // Prüfe:
            //      stimmt die Anzahl der Großbuchstaben/Zahlen/Sonderzeichen mit den mindest-Zahlen überen?
            //      stimmt die Länge des Strings mit der mindestLaenge überen?
            //      Je nach Ergebnis der Prüfungen, dann entsprechende Ausgabe
        }
        // result.toString()

        return Ergebnis;
    }

    private boolean istZahl(char c) {
        //return c >= '0' && c <= '9';
        return Character.isDigit(c);
    }

    private boolean istGrossbuchstabe(char c) {
        // return c >= 'A' && c <= 'Z';
        return Character.toLowerCase(c) != c;
        //return Character.isUpperCase(c);
    }

    private boolean istSonderzeichen(char c) {
        return !istGrossbuchstabe(c) && !istZahl(c) && !(c >= 'a' && c <= 'z');
        // return !Character.isLetterOrDigit(c);
    }

    private boolean istSonderzeichenErlaubt(char c) {
        boolean erlaubt = false;

        // for(int i = 0; i < erlaubteSonderzeiche.length; i++) {
        // char erlaubtesSonderzeichen = erlaubteSonderzeichen[i];

        for(char erlaubtesSonderzeichen : erlaubteSonderzeichen) {
            if(c == erlaubtesSonderzeichen) {
                erlaubt = true;
            }
        }
        return erlaubt;
    }

    private boolean istSonderzeichenErlaubt2(char c) {
        String erlaubteZeichen = new String(erlaubteSonderzeichen);

        return erlaubteZeichen.indexOf(c) >= 0;
    }
}