import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> a = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            List<Integer> n = new ArrayList<>();
            for(int j = 0; j < 5; j++){
                n.add(j);
            }
            a.add(n);
        }

        System.out.println(flippingMatrix(a));
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

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int i = 0;
        int j = 0;
        int k = 0;
        int h = arr.get(0).size()-1;
        int sum1 = 0;
        int sum2 = 0;

        while(i < arr.size()) {
            sum1 += arr.get(i).get(j);
            sum2 += arr.get(k).get(h);
            i += 1;
            j += 1;
            k += 1;
            h -= 1;
        }

        return Math.abs(sum1 - sum2);
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

//        for(int i = 0; i < res.length; i++) {
//            if(res[i] == 0) continue;
//            while(res[i] > 0) {
//                result.add(i);
//                res[i] -= 1;
//            }
//        }
//
//        return result;
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
}