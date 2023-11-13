import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(5);
        miniMaxSum(nums);
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
}