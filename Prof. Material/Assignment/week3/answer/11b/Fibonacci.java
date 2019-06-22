public class Fibonacci {

    static int recursiveCount = 0;
    static int[] F;

    public static void main(String[] args) {
        recursiveCount = 0;
        System.out.println("Brute Force Recursive Version");
        System.out.println("Output Fibonacci :-> " + bruteForceFibo(30));
        System.out.println("Number of Recurrsive Call Count: " + recursiveCount);

        System.out.println("\n");
        recursiveCount = 0;
        System.out.println("Memoized Version");
        System.out.println("Output Fibonacci :-> " + memoizedFibo(30));
        System.out.println("Number of Recurrsive Call Count: " + recursiveCount);

    }

    public static int bruteForceFibo(int n) {
        recursiveCount++;
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return bruteForceFibo(n - 2) + bruteForceFibo(n - 1);
    }

    public static int memoizedFibo(int n) {
        F = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            F[i] = -1;
        }
        return fibonacci(n);
    }

    public static int fibonacci(int n) {
        recursiveCount++;
        if (F[n] < 0) {
            if (n == 0)
                F[n] = 0;
            else if (n == 1)
                F[n] = 1;
            else
                F[n] = fibonacci(n - 2) + fibonacci(n - 1);
        }
        return F[n];
    }

}