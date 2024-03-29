import java.io.IOException;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(4);
        arr.add(5);
        arr.add(3);
        arr.add(2);
        whatFlavors(arr, 4);
    }


    public static int longestSubarray(List<Integer> arr) {
        // Write your code here
        int largestSubArray = 0;

        for (int i = 0; i < arr.size(); i++) {
            List<Integer> subArr = new ArrayList<>();
            for (int j = i; j < arr.size(); j++) {
                int val = arr.get(j);
                if (subArr.size() == 0) {
                    subArr.add(val);
                    continue;
                }

                if ((val+=1) == subArr.get(subArr.size()-1) || (val-=1) == subArr.get(subArr.size()-1)) {
                    subArr.add(val);
                } else {
                    break;
                }
            }
            if(subArr.size() > largestSubArray) largestSubArray = subArr.size();
        }
        return largestSubArray;
    }

    public static String gridChallenge(List<String> grid) {
        // Write your code here
        for(String row : grid) {
            char[] sorted = row.toCharArray();
            Arrays.sort(sorted);
        }

        for (int i = 0; i < grid.get(0).length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < grid.size(); j++) {
                sb.append(grid.get(j).charAt(i));
            }
            String sorted = sb.toString();
            char[] sort = sorted.toCharArray();
            Arrays.sort(sort);
            if(!Arrays.equals(sb.toString().toCharArray(), sort)) return "NO";
        }

        return "YES";
    }

    public static String caesarCipher(String s, int k) {
        // Write your code here
        //char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder cipher = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            boolean isUpper = false;
            if(Character.isUpperCase(c)) {
                c = Character.toLowerCase(c);
                isUpper = true;
            }
            int pos = alphabet.indexOf(c);
            int newPos = (pos + k) % alphabet.length();
            char cipherChar = alphabet.charAt(newPos);
            if(isUpper) cipherChar = Character.toUpperCase(cipherChar);
            cipher.append(cipherChar);
        }

        return cipher.toString();
    }

    public static void findZigZagSequence(int [] a, int n){
        Arrays.sort(a);
        int mid = n/2;
        int temp = a[mid];
        a[mid] = a[n - 1];
        a[n - 1] = temp;

        int st = mid + 1;
        int ed = n - 2;
        while(st <= ed){
            temp = a[st];
            a[st] = a[ed];
            a[ed] = temp;
            st = st + 1;
            ed = ed - 1;
        }
        for(int i = 0; i < n; i++){
            if(i > 0) System.out.print(" ");
            System.out.print(a[i]);
        }
        System.out.println();
    }

    public int lonelyinteger(List<Integer> a) {
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

    public static int birthday(List<Integer> s, int d, int m) {
        // Write your code here
        int count = 0;
        for(int i = 0; i < s.size()-m+1; i++) {
            int num = s.subList(i, i+m).stream().mapToInt(Integer::intValue).sum();
            if(num == d) count += 1;
        }
        return count;
    }

    public static String hackerrankInString(String s) {
        List<Character> lc = new ArrayList<Character>();
        String h = "hackerrank";

        for(int i=0; i<h.length(); i++)
            lc.add(h.charAt(i));

        for(int i=0; i<s.length(); i++){
            if(lc.get(0) == s.charAt(i))
                lc.remove(0);

            if(lc.isEmpty())
                return "YES";

        }

        return "NO";
    }

    public static List<String> weightedUniformStrings(String s, List<Integer> queries) {
        List<String> results = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int count = 0;
        char prev = s.charAt(0);
        for(char c : s.toCharArray()) {
            int val = alphabet.indexOf(c)+1;
            if (c == prev) {
                count += val;
            }
            else count = val;
            prev = c;
            counts.add(count);
        }

        for(int q : queries) {
            if(counts.contains(q)) results.add("Yes");
            else results.add("No");
        }

        return results;
    }

    /**
     * Calculate the minimum amount of bribes needed to be taken to reach the state of the array being passed in
     * A person cannot jump more than 2 spaces in the queue.
     *
     * [2,1,5,3,4]    [5,2,1,3,4]       [1 2 3 4 5 6 7 8]
     *                                  [1 2 5 3 4 6 7 8]
     *                                  [1 2 5 3 7 4 6 8]
     *                                  [1 2 5 3 7 8 4 6]
     *                                  [1 2 5 3 7 8 6 4]
     * count = 3      Too Chaotic       count = 7
     *
     * @param q
     */
    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        int count = 0;
        for(int i = q.size()-1; i > 0; i--) {
            int jumps = q.get(i) - (i+1);
            if(jumps > 2){
                System.out.println("Too chaotic");
                return;
            }
            for(int j = Math.max(0, q.get(i)-2); j <= i; j++) {
                if (q.get(j) > q.get(i)) count += 1;
            }
        }
        System.out.println(count);
    }

    public static int minimumAbsoluteDifference(List<Integer> arr) {
        // Write your code here
        int min = Integer.MAX_VALUE;
        int l = arr.size();
        arr.sort(null);
        for(int i = 1; i < l; i++) {
            int prev = arr.get(i-1);
            int curr = arr.get(i);
            int diff = Math.abs(prev - curr);

            if(diff < min) min = diff;
        }
        return min;
    }

    public static int luckBalance(int k, List<List<Integer>> contests) {
        // Write your code here
        List<Integer> importantScores = new ArrayList<>();
        int balance = 0;
        int luckLost = 0;
        for(List<Integer> contest : contests) {
            if(contest.get(1) == 1) importantScores.add(contest.get(0));
            else balance += contest.get(0);
        }
        importantScores.sort(null);
        for(int i = importantScores.size()-1; i >= 0; i--) {
            if(k > 0){
                balance += importantScores.get(i);
                k--;
            }
            else luckLost += importantScores.get(i);
        }
        return balance - luckLost;
    }

    public static int maxMin(int k, List<Integer> arr) {
        // Write your code here
        int minFairness = Integer.MAX_VALUE;
        int arrSize = arr.size();
        arr.sort(null);

        for(int i = 0; i <= arrSize - k; ++i) {
            List<Integer> nums = arr.subList(i, i + k);
            int value = nums.get(k - 1) - nums.get(0);
            if (value < minFairness) {
                minFairness = value;
            }
        }

        return minFairness;
    }

    public static List<Integer> jimOrders(List<List<Integer>> orders) {
        // Write your code here
        HashMap<Integer, Integer> orderPos = new HashMap<>();

        for(int i = 0; i < orders.size(); i++) {
            int order = orders.get(i).get(0);
            int time = orders.get(i).get(1);
            int value = order+ time;
            orderPos.put(value, orders.get(0).indexOf(order)+1);
        }

        List<Integer> result = new ArrayList<>(orderPos.keySet());
        Collections.sort(result);

        for(int i = 0; i < result.size(); i++) result.set(i, orderPos.get(result.get(i)));
        return result;
    }

    public static int sherlockAndAnagrams(String s) {
        // Write your code here
        List<String> subStrings = new ArrayList<>();
        int res = 0;

        // Find all the substrings in the list.
        for(int i = 0; i < s.length(); i++) {
            for(int j = i+1; j < s.length()+1; j++) {
                String subString = s.substring(i, j);
                char[] sort = subString.toCharArray();
                Arrays.sort(sort);
                String sortedSubString = new String(sort);
                subStrings.add(sortedSubString);
            }
        }

        for(int i = 0; i < subStrings.size(); i++) {
            for(int j = i+1; j < subStrings.size(); j++) {
                if(subStrings.get(i).equals(subStrings.get(j))) res++;
            }
        }

        return res;
    }

    // return the number of triplet that are in geometric progression with the same ratio.
    // Complete the countTriplets function below.
    // [1,2,2,4] r=2
    public static long countTriplets(List<Long> arr, long r) {
        // order the list.
        // iterate through the list and add elements to the HashMap with <position, number>.
        // check if the hashmap has number/r and number*r.
        int count = 0;
        HashMap<Long, Integer> ratioMap = new HashMap<>();

        for(int i = 0; i < arr.size(); i++) {
            long val = arr.get(i);
            if(ratioMap.containsKey(val)) ratioMap.put(val, ratioMap.get(val)+1);
            else ratioMap.put(val, 1);
        }

        if(ratioMap.size() == 1)

        for(Map.Entry<Long, Integer> set : ratioMap.entrySet()) {
            long curr = set.getKey();
            long prev = curr/r;
            long next = curr*r;
            if(ratioMap.containsKey(curr/r) && ratioMap.containsKey(curr*r)) {
                int increment = set.getValue() * ratioMap.get(prev) * ratioMap.get(next);
                count += increment;
            }
        }
        return count;
    }

    /*
     * Complete the 'arrayManipulation' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        // Write your code here
        List<Long> arr = new ArrayList<>(Collections.nCopies(n, (long) 0));

        for(List<Integer> query : queries) {
            int from = query.get(0)-1;
            int to = query.get(1)-1;
            long value = query.get(2);
            for(int i = from; i <= to; i++) arr.set(i, arr.get(i)+value);
        }

        return Collections.max(arr);
    }

    public static int fib(int n) {
        return fib(n, new HashMap<>());
    }
    public static int fib(int n, HashMap<Integer, Integer> memo) {
        if (n == 0 || n == 1) return n;

        if (memo.containsKey(n)) return memo.get(n);

        int result = fib(n-1, memo) + fib(n-2, memo);
        memo.put(n, result);
        return result;
    }

    public static int trib(int n) {
        return trib(n, new HashMap<>());
    }

    public static int trib(int n, HashMap<Integer, Integer> memo) {
        if(n == 0 || n == 1) return 0;
        if(n == 2) return 1;

        if(memo.containsKey(n)) return memo.get(n);

        int result = trib(n-1, memo) + trib(n-2, memo) + trib(n-3, memo);
        memo.put(n, result);
        return result;
    }

    public static boolean sumPossible(int amount, List<Integer> numbers) {
        return sumPossible(amount, numbers, new HashMap<>());
    }

    public static boolean sumPossible(int amount, List<Integer> numbers, HashMap<Integer, Boolean> memo) {
        if (amount == 0) return true;
        if (amount < 0) return false;
        if(memo.containsKey(amount)) return memo.get(amount);
        for (int num : numbers) {
            int subAmount = amount - num;
            if(sumPossible(subAmount, numbers, memo)) {
                memo.put(subAmount, true);
                return true;
            }
        }
        memo.put(amount, false);
        return false;
    }

    public static int minChange(int amount, List<Integer> coins) {
        return minChange(amount, coins, new HashMap<>());
    }

    public static int minChange(int amount, List<Integer> coins, HashMap<Integer, Integer> memo) {
        if(amount == 0) return 0;

        if (amount < 0) return -1;

        if (memo.containsKey(amount)) return memo.get(amount);

        int minCoins = -1;
        for(int num : coins) {
            int subAmount = amount - num;
            int subCoins = minChange(subAmount, coins);
            if (subCoins != -1) {
                int numCoins = subCoins + 1;
                if (numCoins < minCoins || minCoins == -1) minCoins = numCoins;
            }
        }

        memo.put(amount, minCoins);
        return minCoins;
    }

    static int maxSubsetSum(int[] arr) {
        int a=arr[0];
        int b=0;
        for(int i=1;i<arr.length;i++)
        {
            int temp=a;
            a=b+arr[i];
            b=(int)Math.max(temp,b);
        }

        return (int)Math.max(a,b);
    }

    static int minCostPath(List<List<Integer>> graph) {
        return minCostPath(0,0,graph);
    }

    static int minCostPath(int x, int y, List<List<Integer>> graph) {
        int graphLen = graph.size();
        int rowLen = graph.get(0).size();
        if (x == graphLen-1 && y == rowLen-1) return graph.get(x).get(y);
        else if (x == graphLen-1) return graph.get(x).get(y) + minCostPath(x, y+1, graph);
        else if (y == rowLen-1) return graph.get(x).get(y) + minCostPath(x+1, y, graph);
        else return graph.get(x).get(y) + Math.min(minCostPath(x+1, y, graph), minCostPath(x, y+1, graph));
    }

    // 6 = 27
    public static int fibonacciModified(int t1, int t2, int n) {
        // Write your code here
        int[] fibArr = new int[n+1];
        fibArr[1] = t1;
        fibArr[2] = t2;
        for(int i = 3; i < fibArr.length; i++) {
            fibArr[i] = fibArr[i-2] + (int)Math.pow(fibArr[i-1], 2);
        }
        return fibArr[fibArr.length-1];
    }

    public static String xor(String s, String t) {
        StringBuilder res = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if(sChar == tChar) res.append('0');
            else res.append('1');
        }

        return res.toString();
    }

    // {[]}
    public static String isBalanced(String s) {
        // Write your code here
        HashMap<Character, Character> brackets = new HashMap<>();
        brackets.put(']', '[');
        brackets.put('}', '{');
        brackets.put(')', '(');
        Stack<Character> bracketQueue = new Stack<>();

        for (char c : s.toCharArray()) {
            if (brackets.containsKey(c)) {
                if(bracketQueue.isEmpty()) return "NO";
                char openBracket = bracketQueue.pop();
                if (openBracket != brackets.get(c)) return "NO";
            }
            else bracketQueue.push(c);
        }
        if(!bracketQueue.isEmpty()) return "NO";
        return "YES";
    }

    // [10, 20, 30, 40, 50]
    // d = 3
    public static int activityNotifications(List<Integer> expenditure, int d) {
        // Write your code here
        int count = 0;
        for (int i = d; i < expenditure.size(); i++) {
            int currentDay = expenditure.get(i);
            List<Integer> trail = expenditure.subList(i-d, i);
            Collections.sort(trail);
            float median;
            int mid = trail.size()/2;
            if(trail.size() % 2 == 0) median = ((float)trail.get(mid) + (float)trail.get(mid-1)) / 2;
            else median = trail.get(mid);
            if(currentDay >= median*2) count+=1;
        }
        return count;
    }

    /**
     * money = 4
     * cost = [1, 4, 5, 3, 2]
     */
    public static void whatFlavors(List<Integer> cost, int money) {
        // Write your code here
        HashMap<Integer, Integer> costMap = new HashMap<>();
        for (int i = 0; i < cost.size(); i++) {
            int price = cost.get(i);
            if (price < money) {
                int remainder = money - price;
                if (costMap.containsKey(remainder)) {
                    System.out.println(costMap.get(remainder) + " " + i + 1);
                    break;
                } else costMap.put(price, i + 1);
            }
        }
    }
}