import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class GoogleSolutions {

    public GoogleSolutions() {}

    // abc -> abc -> abc -> abc
    public static int solution1(String x) {
        int a = 0;
        int increment = 1;
        int b = increment;
        int countMax = 0;
        String subString = "";
        String prevSubString = "";

        while(b <= x.length()) {
            subString = x.substring(a, b);

            if(subString.equals(prevSubString) || a == 0) countMax++;
            else {
                increment++;
                b = increment;
                a = 0;
                countMax = 0;
                continue;
            }

            a = b;
            b += increment;
            prevSubString = subString;
        }

        return countMax;
    }

    public int solution2(String s) {
        int salutes = 0;
        int rightCounts = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '>') rightCounts++;
            else if (c == '<') salutes+=rightCounts;
        }

        return salutes*2;
    }

    public static String solution3(String s, int b) {
        //Set<String> memo = new HashSet<>();
        HashMap<String, Integer> idMemory = new LinkedHashMap<>();
        int k = s.length();

        while(!idMemory.containsKey(s)) {
            idMemory.put(s, idMemory.size());

            char[] idArr = s.toCharArray();
            Arrays.sort(idArr);

            String y = new String(idArr);
            String x = new String(reverseCharArray(idArr));
            s = baseCalculation(x, y, b);

            if(s.length() < k) {
                s += String.join("", Collections.nCopies(k-s.length(), "0"));
            }
        }

        int cycleLength = idMemory.size() - idMemory.get(s);
        return Integer.toString(cycleLength);
    }

    public static char[] reverseCharArray(char[] arr) {
        for(int i = 0; i < arr.length/2; i++) {
            char temp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = temp;
        }
        return arr;
    }

    public static String baseCalculation(String x, String y, int b) {
        x = Integer.toString(Integer.parseInt(x, b), 10);
        y = Integer.toString(Integer.parseInt(y, b), 10);

        return Integer.toString(Integer.parseInt(x, 10) - Integer.parseInt(y, 10), b);
    }
}
