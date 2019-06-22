public class LCS {
    public static int recursiveCount = 0;
    public static int L[][];

    public static void main(String[] args) {

        recursiveCount = 0;
        System.out.println("Brute Force of LCS (Longest Common Subsequence)");
        System.out.println("LCS output : " + forenceLCS("GAATTCAGTTA", "GGATCGA", 11, 7));
        System.out.println("Number Recurrsive Count : " + recursiveCount);

        System.out.println("\n");
        recursiveCount = 0;
        System.out.println("Memorize of LCS");
        System.out.println("LCS output : " + memorizeLCS("GAATTCAGTTA", "GGATCGA", 11, 7));
        System.out.println("Number Recurrsive Count : " + recursiveCount);

    }

    public static int forenceLCS(String s1, String s2, int i, int j) {
        recursiveCount++;
        if (i == 0 || j == 0)
            return 0;
        else if (s1.charAt(i - 1) == s2.charAt(j - 1))
            return forenceLCS(s1, s2, i - 1, j - 1) + 1;
        else
            return Math.max(forenceLCS(s1, s2, i - 1, j), forenceLCS(s1, s2, i, j - 1));
    }

    public static int memorizeLCS(String s1, String s2, int i, int j) {
        // return memorizeLCSHelper(s1, s2, s1.length(), s2.length());
        L = new int[i + 1][j + 1];
        for (int a = 0; a <= i; a++)
            for (int b = 0; b <= j; b++)
                L[a][b] = -1;
        return memorizeLCSHelper(s1, s2, i, j);
    }

    public static int memorizeLCSHelper(String s1, String s2, int i, int j) {
        if (L[i][j] < 0) {
            recursiveCount++;
            if (i == 0 || j == 0)
                L[i][j] = 0;
            else if (s1.charAt(i - 1) == s2.charAt(j - 1))
                L[i][j] = memorizeLCSHelper(s1, s2, i - 1, j - 1) + 1;
            else
                L[i][j] = Math.max(memorizeLCSHelper(s1, s2, i - 1, j), memorizeLCSHelper(s1, s2, i, j - 1));
        }
        return L[i][j];
    }

}