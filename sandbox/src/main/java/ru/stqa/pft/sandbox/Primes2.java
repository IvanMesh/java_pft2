package ru.stqa.pft.sandbox;

public class Primes2 {

  public static void main(String[] args) {
    int n = 100;
    int c = 4;
      for (int i = 2; c < n; c++) {
        if (c % i == 0) {
          System.out.println(c);
        }
      }
  }
}
