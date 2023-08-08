//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] numerator = IntArray.input(br, n);
            
            
            int[] denominator = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.countFractions(n, numerator, denominator);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



// Aman Jha code


class Solution {
    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public static int countFractions(int n, int[] numerator, int[] denominator) {
        HashMap<String, Integer> fractions = new HashMap<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            int num = numerator[i];
            int denom = denominator[i];
            int gcd = gcd(num, denom);

            num /= gcd;
            denom /= gcd;

            String fraction = num + "/" + denom;
            String comp = (denom - num) + "/" + denom;

            if (fractions.containsKey(comp)) {
                count += fractions.get(comp);
            }

            fractions.put(fraction, fractions.getOrDefault(fraction, 0) + 1);
        }

        return count;
    }
}
