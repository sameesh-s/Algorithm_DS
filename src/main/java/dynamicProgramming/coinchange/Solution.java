package dynamicProgramming.coinchange;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.Collections.sort;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    public static long getWays(int n, List<Long> c){
        //sort the array
        HashMap<String, Long> memCache = new HashMap<>();
        Collections.sort(c);
        int i;
        for(int j =0; j< c.size(); j++) {
            i =0;
            //fill the zero'th entry as 1
            memCache.put(Integer.toString(j) + Integer.toString(i), 1L);
            i++;
            Long coin = c.get(j);
            //first coin
            if(j<1){
                for(;i<=n; i++){
                    Long r = i%coin == 0? 1L: 0L;
                    memCache.put(Integer.toString(j)+Integer.toString(i), r);
                }
            }
            else {//rest of the coins
                for (; i <=n; i++) {
                    String key = Integer.toString(j) + Integer.toString(i);
                    if(coin> i){
                        memCache.put(key,
                                memCache.get(Integer.toString(j-1)+Integer.toString(i)));
                    }
                    else{
                        Long remaining = i -coin;
                            Long val = memCache.get(Integer.toString(j-1)+Integer.toString(i))+
                                memCache.get(Integer.toString(j)+Integer.toString(Math.toIntExact(remaining)));

                            memCache.put(key,
                                    val
                                    );

                    }
                }
            }
        }
        return memCache.get(Integer.toString(c.size()-1) + Integer.toString(n));
    }

    /*
     * Complete the 'getWays' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. LONG_INTEGER_ARRAY c
     */
    public static long bruteForceGetWays(int n, List<Long> c) {
        if(n==0) return 1;
        if(n < 0) return 0;
        if(c.isEmpty()) return 0;
        Collections.sort(c);
        List<Long> newCoins = new ArrayList<Long>(c);
        newCoins.remove(0);
        return bruteForceGetWays(n, newCoins) + bruteForceGetWays(Math.toIntExact(n-c.get(0)), c);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Long> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'

        long ways = Result.getWays(n, c);

        bufferedWriter.write(String.valueOf(ways));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
