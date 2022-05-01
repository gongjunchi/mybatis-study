package org.zuel.common;

public class MergeSortArray {

    public void merge(int[] A, int m, int[] B, int n) {
        int i = m - 1, j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (A[i] >= B[j]) {
                A[k] = A[i];
                k--;
                i--;
            } else {
                A[k] = B[j];
                k--;
                j--;
            }
        }
        while (j >= 0) {
            A[k] = B[j];
            k--;
            j--;
        }
    }

    public static void main(String[] args) {
        MergeSortArray mergeSortArray = new MergeSortArray();
        int[] A = new int[]{1};
        int[] B = new int[]{};
        mergeSortArray.merge(A, 1, B, 0);
        for (int num : A) {
            System.out.print(num);
        }
    }
}
