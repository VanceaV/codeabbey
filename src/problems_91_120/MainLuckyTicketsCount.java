package problems_91_120;

import java.util.*;

public class MainLuckyTicketsCount {
    public static void main(String[] args) {
        int countOfNumbers = 6;
        int halfCountOfNumbers = countOfNumbers / 2;
        int maxsize = (9 * halfCountOfNumbers) + 1;
        int countOfTickets = 0;
        Map<Integer, Integer> hashMap = new HashMap<Integer,Integer>() ;
        int key1;
       for (int i = 0; i < maxsize; i++) {
            hashMap.put(i, 0);
        }
        for (int i = 0; i < Math.pow(10, halfCountOfNumbers); i++) {
            key1 = 0;
            for (int j = 0; j < halfCountOfNumbers; j++) {
                key1 = key1 + i / (int) Math.pow(10, j) % 10;
            }
            hashMap.put(key1, hashMap.get(key1) + 1);
        }
        for (int i = 0; i < maxsize; i++) {
            countOfTickets = countOfTickets + (int) Math.pow(hashMap.get(i), 2);
        }
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet())
            System.out.println(entry.getKey() + " = " + entry.getValue());
        System.out.println("Count Of Lucky Tickets: " + countOfTickets);
    }
}