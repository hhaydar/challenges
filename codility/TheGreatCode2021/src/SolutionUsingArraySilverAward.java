public class SolutionUsingArraySilverAward {
    public static int solution (int N, int K, int[] A, int[] B, int[] C) {
        /* cakes[n][0] number of flavors/layers, cakes[n][1] last lavor/layer */
        int[][] cakes = new int[N][2];
        for (int e=0; e<A.length; e++) {
            for (int c = A[e] - 1; c < B[e]; c++) {
                cakes[c][1] = cakes[c][1] < C[e] ? C[e] : Integer.MAX_VALUE;
                cakes[c][0]++;
            }
        }
        int nCakes=0;
        for (int k=0; k<N; k++) {
            if ((cakes[k][0] == K) && (cakes[k][1] == K)) nCakes++;
        }
        return  nCakes;
    }
}
