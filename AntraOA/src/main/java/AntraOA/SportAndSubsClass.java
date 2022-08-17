package AntraOA;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SportAndSubsClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cricket c = new Cricket();
        Football f = new Football();
        int[] age1 = new int[11];
        int[] age2 = new int[11];
        for (int i = 0; i < 2; i++) {
            String[] age = sc.nextLine().split(" ");
            if (i == 0) {
                int j = 0;
                for (String s : age)
                    age1[j++] = Integer.parseInt(s);
            } else {
                int j = 0;
            }
        }
    }
}

interface Sport {
    void calculateAvgAge(int[] age);

    void retirePlayer(int id);
}

class Cricket implements Sport {
    public int[] pIDs = new int[11];
    Map<Integer, String> pStatus = new HashMap<>();

    public Cricket() {
        System.out.println("A new cricket team has been formed");
    }

    public void calculateAvgAge(int[] age) {
        BigDecimal total = new BigDecimal(0);
        for (int i = 0; i < age.length; i++) {
            pIDs[i] = age[i];
            total = total.add(new BigDecimal(age[i]));
            pStatus.put(i, "NR");
        }
        BigDecimal avg = total.divide(new BigDecimal(age.length), 2,
                RoundingMode.HALF_UP);
        System.out.println("The average age of the team is " +
                avg.toString());
    }

    public void retirePlayer(int x) {
        String status = pStatus.get(x);
        if (status != null && "R".equalsIgnoreCase(status)) {
            System.out.println("Player has already retired");
        } else {
            pStatus.put(x, "R");
            System.out.println("Player with id: " + x + " has retired");
        }
    }
}

class Football implements Sport {
    public int[] pIDs = new int[11];
    Map<Integer, String> pStatus = new HashMap<>();

    public Football() {
        System.out.println("A new football team has been formed");
    }

    public void calculateAvgAge(int[] age) {
        BigDecimal total = new BigDecimal(0);
        for (int i = 0; i < age.length; i++) {
            pIDs[i] = age[i];
            total = total.add(new BigDecimal(age[i]));
            pStatus.put(i, "NR");
        }
        BigDecimal avg = total.divide(new BigDecimal(age.length), 2,
                RoundingMode.HALF_UP);
        System.out.println("The average age of the team is " +
                avg.toString());
    }

    public void retirePlayer(int x) {
        String status = pStatus.get(x);
        if (status != null && "R".equalsIgnoreCase(status)) {
            System.out.println("Player has already retired");
        } else {
            pStatus.put(x, "R");
            System.out.println("Player with id: " + x + " has retired");
        }
    }

    public void playerTransfer(int s, int x) {
        String status = pStatus.get(x);
        if (status != null && "R".equalsIgnoreCase(status)) {
            System.out.println("Player has already retired");
        } else {
            System.out.println("Player with id: " + x + " has been transferred with a fee of " + s);
        }
    }
}