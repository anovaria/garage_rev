package com.mycompany.garage;

import java.util.Scanner;
import org.apache.commons.lang.ArrayUtils;

/**
 *
 * @author alex
 */
public class Garage {

    final static int MAX = 4;
    Veicolo elencoVeicoli[] = new Veicolo[MAX];
    Scanner sc = new Scanner(System.in);

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Garage G = new Garage();
    }

    public Garage() {
        int i, j = 0;
        char ch, scelta;
        do {
            Inserisci();
            System.out.print("continui?(s/n):");
            scelta = sc.next().charAt(0);
            j++;
        } while (scelta != 'n' && j < MAX);//fine do-while
    }

    private void Inserisci() {
        //inserisco veicoli 
        //throw new IllegalArgumentException("errore");
        Scanner sc = new Scanner(System.in);
        System.out.println("dimmi alimentazione?(b,d)");
        Auto.Alimentazione alimentazione = null;
        char ch;
        boolean invalid;
        do {
            invalid = false;
            try {
                //alimentazione = Auto.Alimentazione.valueOf(sc.nextLine().toUpperCase());

                ch = Character.toUpperCase(sc.next().charAt(0));
                //alimentazione = Auto.Alimentazione.valueOf(Character.toString(ch));
                //System.out.println(ch);
                switch (Character.toString(ch)) {
                    case "B":
                        alimentazione = Auto.Alimentazione.Benzina;
                        break;
                    case "D":
                        alimentazione = Auto.Alimentazione.Diesel;
                        break;
                    default:
                        throw new IllegalArgumentException("Errore!!");
                }
                Auto A = new Auto(0, 4, alimentazione, "fiat", 2000, 1200);
                elencoVeicoli[A.posto] = A;
                System.out.println("Inserito " + A.toString());
                stampaSituazione();
                //rimuovi(A.posto);

            } catch (IllegalArgumentException ex) {
                System.out.println(ex);
                System.out.println("Alim non valida riprova");
                invalid = true;
            }

        } while (invalid);

        Moto M = new Moto(1, 4, "aprilia", 2000, 600);
        elencoVeicoli[M.posto] = M;
        System.out.println("Inserito " + M.toString());
        stampaSituazione();
        Furgone F = new Furgone(2, 300, "Ducato", 1995, 2500);
        elencoVeicoli[F.posto] = F;
        System.out.println("Inserito " + F.toString());
        stampaSituazione();
        //rimuovi(F.posto);
        //rimuovi(M.posto);

    }

    private void rimuovi(int posto) {
        String rimosso = elencoVeicoli[posto].toString();
        elencoVeicoli = (Veicolo[]) ArrayUtils.remove(elencoVeicoli, posto);
        System.out.println("Rimosso: " + rimosso);
        stampaSituazione();
    }

    private void stampaSituazione() {
        String res = "Situazione Auto in garage:";
        for (int i = 0; i < elencoVeicoli.length; i++) {
            res += "\n" + elencoVeicoli[i];
        }

        System.out.println(res);
    }

}

class Veicolo {

    protected int posto;
    protected String marca;
    protected int anno;
    protected int cilindrata;

    public Veicolo(int posto, String marca, int anno, int cilindrata) {
        this.posto = posto;
        this.marca = marca;
        this.anno = anno;
        this.cilindrata = cilindrata;
    }

    @Override
    public String toString() {
        return String.format(" posto) %s, marca %s, anno %s, cil. %s ", posto, marca, anno, cilindrata);
    }

}

class Auto extends Veicolo {

    protected static enum Alimentazione {
        Benzina, Diesel
    }
    protected int porte;
    //public String alim;
    Alimentazione alim;

    public Auto(int posto, int porte, Alimentazione alim, String marca, int anno, int cilindrata) {
        super(posto, marca, anno, cilindrata);
        this.porte = porte;
        this.alim = alim;
    }

    @Override
    public String toString() {
        //return "posto: " + posto + ") Auto: " + marca + ", porte=" + porte + ", alim=" + alim + ", anno=" + anno + ", "
        //      + "cil.=" + cilindrata;
        return super.toString() + String.format(" porte %s, alim. %s ", porte, alim);
    }

}

/**
 *
 * @author alex
 */
class Moto extends Veicolo {

    protected int tempi;

    public Moto(int posto, int tempi, String marca, int anno, int cilindrata) {
        super(posto, marca, anno, cilindrata);
        this.tempi = tempi;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" tempi %s ", tempi);
        //return "posto: " + posto + ") Moto " + marca + " cil.=" + cilindrata + " anno=" + anno + " tempi=" + tempi + '}';
    }

}

class Furgone extends Veicolo {

    protected int capacita;

    public Furgone(int posto, int cpacita, String marca, int anno, int cilindrata) {
        super(posto, marca, anno, cilindrata);
        this.capacita = cpacita;
    }

    @Override
    public String toString() {

        return super.toString() + String.format(" capacità %s ", capacita);
    }

}
