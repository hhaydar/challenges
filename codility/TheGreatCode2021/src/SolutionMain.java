public class SolutionMain {

    public static void main(String[] args) {
        int N=5; int K=3;
        int[] A = {1, 1, 4, 1, 4};
        int[] B = {5, 2, 5, 5, 4};
        int[] C = {1, 2, 2, 3, 3};
        System.out.println(new SolutionUsingTreeGoldenAward().solution(N,K,A,B,C));
    }
}
