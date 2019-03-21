import java.io.*;
//import java.math.*;
//import java.security.*;
//import java.text.*;
import java.util.*;
//import java.util.concurrent.*;
//import java.util.regex.*;

public class ArrayManipulation {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
//    	long max = 0;
//    	long[] myArray = new long[n];
//    	
//    	for(int row = 0; row < queries.length; row++)
//    	{
//    		for(int arrayIterator = queries[row][0]; arrayIterator <= queries[row][1]; arrayIterator++)
//    		{
//    			myArray[arrayIterator - 1] += queries[row][2];
//    		}
//    	}
//    	
//    	for(int arrayIterator = 0; arrayIterator < myArray.length; arrayIterator++)
//    	{
//    		if(myArray[arrayIterator] > max)
//    		{
//    			max = myArray[arrayIterator];
//    		}
//    	}
//    	
//    	return max;
// Above is my own independent attempt at this problem. It works fine, but a better solution with less time complexity exists, below.
    	
    	long max = 0;
    	long[] myArray = new long[n];
    	
    	for(int row = 0; row < queries.length; row++)
    	{
    		int lower = queries[row][0];
    		int upper = queries[row][1];
    		int sum = queries[row][2];
    		
    		myArray[lower-1] += sum;
    		if(upper < n)
    		{
        		myArray[upper] -= sum;
    		}

    		
    	}
    	
    	long temp = 0;
    	
    	for(int arrayIterator = 0; arrayIterator < n; arrayIterator++)
    	{
    		temp += myArray[arrayIterator];
    		if(temp > max)
    		{
    			max = temp;
    		}
    	}
    	
    	return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
