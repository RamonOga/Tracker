package ru.job4j.stream.lessons;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CharsMethod {
   public static boolean shit(char[] a, char[] b ) {
       boolean rsl = true;
       for (int i = 0; i < a.length - 1; i++) {
           if (a[i] != b[i]) {
               return false;
           }
       }
       return rsl;
   }
}