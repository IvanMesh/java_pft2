package ru.stqa.pft.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {

  public static void main(String[] args) {
    String[] langs = {"Java", "C#", "Python", "PHP"};
    langs[0] = "Java";
    langs[1] = "C#";
    langs[2] = "Python";
    langs[3] = "PHP";
    for (int i = 0; i < langs.length; i++) {
      System.out.println("Я хочу выучить " + langs[i]);
    }
    for (String l : langs) {
      System.out.println("Я хочу выучить " + l);
    }

    List<String> languages = new ArrayList<String>();
    languages.add("Java");
    languages.add("C#");
    languages.add("Python");
    languages.add("PHP");
    for (String l : languages) {
      System.out.println("Я не хочу выучить " + l);
    }

    List<String> languages1 = Arrays.asList("Java", "C#", "Python", "PHP");

    for (int i = 0; i < languages1.size(); i++) {
      System.out.println("ой хочу выучить " + languages1.get(i));
    }

    List languages2 = Arrays.asList("Java", "C#", "Python", "PHP");

    for (Object l : languages2) {
      System.out.println("ой2 хочу выучить " + l);
    }
  }
}
