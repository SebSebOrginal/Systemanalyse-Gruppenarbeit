import java.util.ArrayList;
import java.util.Scanner;
import java.sql.*;
//Klasse soll Methoden zur Erstellung & Löschung erstellen

public class AccountVerwalten {
        PaswortTester paswortTester = new PaswortTester();
        UserListen userListen = new UserListen();
        Scanner sc = new Scanner(System.in);
private ArrayList<String> username = new ArrayList<>();
private ArrayList<String> passwort = new ArrayList<>();

//Methode zum erstellen eines Accounts

public boolean accountErstellen() {
        String a; String b;
        System.out.println("Gib deinen Username ein");
        a = sc.next();
        //for schleife um zu überprufen, dass username nur 1x ist
        username.add(a);
        System.out.println("Gib deinen Passwort ein");
        b = sc.next();
        if(paswortTester.testePasswort(b)==true) {

        passwort.add(b);
        System.out.println(username.toString() + passwort.toString());
        }
        else{
        System.out.println("Passwort Entspricht nicht den vorgaben");
        }

        return true;
        }

public boolean accountLöschen() {
        String a; // Nutzvariable
        boolean erfolgreich = false;
        System.out.println("Gib deinen Username ein");
        a = sc.next();
        for (int i = 0; i< username.size(); i++){
        String ueberpruefen = username.get(i);
        if( ueberpruefen == a){
        username.remove(i);
        passwort.remove(i);
        System.out.println("Account" + a + "gelöscht");
        erfolgreich = true;
        }
        }
        return erfolgreich;
        }
public boolean login(){
        String a; String b; int x; boolean erfolgreich = false;
        System.out.println("Gib deinen Username ein");
        a = sc.next();
        // Index von username bekommen System.out.println(username.indexOf(a));

        x = username.indexOf(a);
        //bei username nicht in ArrayList Wert ist -1
        System.out.println(x);
        System.out.println("Gib dein Passwort ein");
        b = sc.next();
        //wenn wert -1 ist, OutOfBounce, da keine Stelle -1 da ist
        try{
        if (b.equals(passwort.get(x))){
        erfolgreich = true;
        }

        } catch (IndexOutOfBoundsException outOfBoundsException){
        System.out.println("Username falsch/existiert nicht");
        }

        if(erfolgreich == true){
        System.out.println("Login Erfolgreich");
        }
        else{
        System.out.println("Login nicht Erfolgreich");
        }
        return erfolgreich;
        }

}