import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(pangrams("We promptly judged antique ivory buckles for the next prize"));
    }

    public static int lonelyinteger(List<Integer> a) {
        // Write your code here
        HashMap<Integer, Integer> numCount = new HashMap<>();
        int res = 0;
        for(int n : a) {
           if(numCount.containsKey(n)) numCount.put(n, numCount.get(n)+1);
           else numCount.put(n, 1);
        }

        for(Map.Entry<Integer, Integer> set : numCount.entrySet()) {
            if(set.getValue() == 1) res = set.getKey();
        }
        return res;
    }

    /*
     * Complete the 'countingSort' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static List<Integer> countingSort(List<Integer> arr) {
        // Write your code here
        List<Integer> result = new ArrayList<>(Collections.nCopies(100,0));
        arr.forEach(num -> {
            result.set(num, result.get(num)+1);
        });
        return result;
    }


    public static int flippingMatrix(List<List<Integer>> matrix) {
        // Write your code here
        int l = matrix.size();
        int s = 0;
        for (int i = 0; i < l/2; i++) {
            for (int j = 0; j < l/2; j++) {
                int m1 = Math.max(matrix.get(i).get(j), matrix.get(i).get(l-j-1));
                int m2 = Math.max(matrix.get(l-i-1).get(j), matrix.get(l-i-1).get(l-j-1));
                s += Math.max(m1, m2);
            }
        }
        return s;
    }

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        int pos = 0;
        int neg = 0;
        int zero = 0;
        int l = arr.size();
        for (int num : arr) {
            if (num == 0) zero += 1;
            if (num > 0) pos += 1;
            if (num < 0) neg += 1;
        }

        System.out.printf("%.6f\n", (float) pos/l);
        System.out.printf("%.6f\n", (float) neg/l);
        System.out.printf("%.6f\n", (float) zero/l);
    }

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        Collections.sort(arr);
        long minSum = arr.subList(0, 4).stream().mapToLong(Integer::longValue).sum();
        long maxSum = arr.subList(1,  arr.size()).stream().mapToLong(Integer::longValue).sum();
        System.out.println(minSum + " " + maxSum);
    }

    public static String timeConversion(String s) throws ParseException {
        // Write your code here
        SimpleDateFormat twelveHour = new SimpleDateFormat("hh:mm:ssa");
        SimpleDateFormat twentyHour = new SimpleDateFormat("HH:mm:ss");

        return twentyHour.format(twelveHour.parse(s));
    }

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        // Write your code here
        HashMap<String, Integer> queryCount = new HashMap<>();
        for(String str : strings){
            if(queryCount.containsKey(str)) queryCount.put(str, queryCount.get(str)+1);
            else queryCount.put(str, 1);
        }

        List<Integer> res = new ArrayList<>();
        for(String str : queries) {
            res.add(queryCount.getOrDefault(str, 0));
        }

        return res;
    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int sum1 = 0;
        int sum2 = 0;
        int i = 0;
        int j = arr.size()-1;
        while(i < arr.size()){
            sum1 += arr.get(i).get(i);
            sum2 += arr.get(i).get(j);
            i += 1;
            j -= 1;
        }
        return Math.abs(sum1 - sum2);
    }

    public static String pangrams(String s) {
        // Write your code here
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        s = s.toLowerCase();
        for(char c : alphabet) {
            if(!(s.contains(Character.toString(c)))) return "not pangram";
        }
        return "pangram";
    }

    public static String twoArrays(int k, List<Integer> A, List<Integer> B) {
        // Write your code here
        Collections.sort(A);
        Collections.sort(B);
        Collections.reverse(B);
        for(int i = 0; i < A.size(); i++) {
            if((A.get(i) + B.get(i)) < k) return "NO";
        }
        return "YES";
    }
}