package db.domain;

import domain.WoordenLijst;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WoordenLezer {
    private String bestandsnaam;

    public WoordenLezer(String bestandsNaam){
        this.bestandsnaam=bestandsNaam;
    }

    public WoordenLijst lees() throws DbException, FileNotFoundException{
        WoordenLijst woordenLijst = new WoordenLijst();
        File file = new File(bestandsnaam);
        Scanner scanner = new Scanner(file);
        String woord = "";
        while (scanner.hasNextLine()){
            woord = scanner.nextLine();
            woordenLijst.voegToe(woord);
        }
        scanner.close();
        return woordenLijst;
    }
    /*public static ArrayList<String> leesIn(String file)
        throws FileNotFoundException {
        Scanner s = new Scanner(new File(file));
        ArrayList<String> list = new ArrayList<String>();
        while (s.hasNext()) {
            list.add(s.next());
        }
        s.close();
        return list;
    }*/
}
