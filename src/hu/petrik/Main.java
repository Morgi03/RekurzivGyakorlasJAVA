package hu.petrik;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println(faktorialis(4));
        System.out.println("--------------");
        System.out.println(hatvanyozas(2, 3));
        System.out.println("--------------");
        int db = 8;
        int max = 10;
        int[] tomb = new int[db];
        lotto(tomb, max, db);
        for (int szam : tomb) {
            System.out.println(szam);
        }
    }

    public static int faktorialis(int n) {
        if (n > 0) {
            return n * (faktorialis(n - 1));
        }
        return 1;
    }

    public static int hatvanyozas(int alap, int kitevo) {
        if (kitevo > 0) {
            return hatvanyozas(alap, kitevo - 1) * alap;
        }
        return 1;
    }

    public static void lotto(int[] szamok, int max, int db) {
        if (db > 0) {
            int proba = (int) (Math.random() * max) + 1;
            boolean lambda = false;
            while (lambda) {
                lambda = Arrays.stream(szamok).anyMatch(szam -> szam == proba);
               proba = (int) (Math.random() * max) + 1;
            }
            szamok[db - 1] = proba;
            lotto(szamok,max,db-1);
        }
    }
}
