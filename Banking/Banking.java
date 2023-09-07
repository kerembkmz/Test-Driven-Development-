package Banking;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Banking {
    Map<Long, List<Integer>> dateAndAmountMap;
    private int lastBalance = 0;
    public Banking(){
        dateAndAmountMap = new TreeMap<>();
        dateAndAmountMap.put(System.currentTimeMillis(), List.of(0, 0));
        System.out.println("TIME        |AMOUNT | BALANCE \n");
    }


    public void deposit(int amount){
        int newBalance = lastBalance + amount;
        lastBalance = newBalance;
        dateAndAmountMap.put(System.currentTimeMillis(), List.of(amount, newBalance));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void withdraw(int amount){
        int newBalance = lastBalance - amount;
        lastBalance = newBalance;
        dateAndAmountMap.put(System.currentTimeMillis(), List.of(amount * -1, newBalance));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void printStatement(){


        for (long key : dateAndAmountMap.keySet()){
            long keyInSeconds = key/1000;
            LocalDateTime dateTime = LocalDateTime.ofInstant(
                    Instant.ofEpochSecond(keyInSeconds),
                    ZoneId.systemDefault()
            );
            System.out.println(dateTime.getHour()+":" + dateTime.getMinute()+":" +dateTime.getSecond() + "    |" + dateAndAmountMap.get(key).get(0) + "    |" + dateAndAmountMap.get(key).get(1) + "\n");
        }
    }
}
