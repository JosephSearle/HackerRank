import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<>();
        List<Integer> n = new ArrayList<>();
        n.add(1);
        n.add(2);
        n.add(3);
        List<Integer> m = new ArrayList<>();
        m.add(4);
        m.add(5);
        m.add(6);
        List<Integer> p = new ArrayList<>();
        p.add(9);
        p.add(8);
        p.add(9);
        nums.add(n);
        nums.add(m);
        nums.add(p);

        System.out.println(diagonalDifference(nums));
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
}