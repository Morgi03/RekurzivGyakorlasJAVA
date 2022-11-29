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
        System.out.println("--------------");
        int meret = 50;
        int[] rendezettTomb = new int[meret];
        for (int i = 0; i < meret; i++) {
            rendezettTomb[i] =  (int)(Math.random()*98)+1;
        }
        rendezettTomb = Arrays.stream(rendezettTomb).sorted().toArray();
        for (int i = 0; i < meret; i++) {
            System.out.print(rendezettTomb[i]+",  ");
        }
        System.out.println("\n--------------\n");
        System.out.println(LKR(rendezettTomb, 1, 97, 12));

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
            boolean lambda = Arrays.stream(szamok).anyMatch(szam -> szam == proba);
            if (lambda) {
                lotto(szamok, max, db - 1);
            } else {
                szamok[db - 1] = proba;
                lotto(szamok, max, db - 1);
            }
        }
    }

    public static int LKR(int[] x, int bal, int jobb, int ertek) {
        if (bal > jobb) {
            return 0;
        } else {
            int center = (bal + jobb) / 2;
            if (x[center] == ertek) {
                return center;
            } else {
                if (x[center] > ertek) {
                    LKR(x, bal, center - 1, ertek);
                } else {
                    return LKR(x, center + 1, jobb, ertek);
                }
            }
        }
        return 0;
    }
}
