package apa;

import java.util.ArrayList;
import java.util.Arrays;

public class NutsAndBolts {
public static void findPair(ArrayList<Integer> b, ArrayList<Integer> g) {
int bolt = b.get(0);
int size = b.size();
ArrayList<Integer> gLess = new ArrayList<>();
ArrayList<Integer> gBigger = new ArrayList<>();
ArrayList<Integer> bLess = new ArrayList<>();
ArrayList<Integer> bBigger = new ArrayList<>();
int gaika = 0;
for (int i = 0; i < size; i++) {
if (g.get(i) > bolt) gBigger.add(g.get(i));
else if (g.get(i) < bolt) gLess.add(g.get(i));
else gaika = g.get(i);
}
for (int i = 0; i < size; i++) {
if (b.get(i) > gaika) bBigger.add(b.get(i));
else if (b.get(i) < gaika) bLess.add(b.get(i));
}
System.out.print("\nbolts: ");
for (Integer i : b) System.out.print("" + i + " ");
System.out.print("\ngaiks: ");
for (Integer i : g) System.out.print("" + i + " ");
System.out.print("\nG=" + gaika + " B=" + bolt);
if (bLess.size() > 0) findPair(bLess, gLess);
if (bBigger.size() > 0) findPair(bBigger, gBigger);
}

public static void main(String args[]) {
ArrayList<Integer> g = new ArrayList<>(Arrays.asList(1, 3, 8, 6, 5, 7, 2, 9, 4)); //гайки
ArrayList<Integer> b = new ArrayList<>(Arrays.asList(3, 5, 6, 8, 2, 9, 7, 4, 1)); //болты
findPair(b, g);
}
}