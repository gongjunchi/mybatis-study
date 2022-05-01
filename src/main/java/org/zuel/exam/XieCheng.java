package org.zuel.exam;

import java.util.*;

public class XieCheng {

    /**
     * 考试时自己实现的方法，会超时
     */
    public void question2() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.nextLine();
        char[] color = sc.nextLine().toCharArray();
        int[][] matrix = new int[n][2];
        for (int i = 0; i < n; i++) {
            matrix[i][0] = nums[i];
            matrix[i][1] = color[i] == 'R' ? 1 : 0;
        }
        int res = 0;
        Arrays.sort(matrix, (o1, o2) -> o1[0] - o2[0]);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (matrix[i][0] != matrix[j][0]) {
                    break;
                }
                if (matrix[i][1] != matrix[j][1]) {
                    res++;
                }
            }
        }
        System.out.println(res);
    }

    public void question2_() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.nextLine();
        char[] color = sc.nextLine().toCharArray();
        HashMap<Integer, Integer> mapR = new HashMap<>();
        HashMap<Integer, Integer> mapB = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (color[i] == 'R') {
                mapR.put(nums[i], mapR.getOrDefault(nums[i], 0) + 1);
            } else {
                mapB.put(nums[i], mapB.getOrDefault(nums[i], 0) + 1);
            }
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : mapR.entrySet()) {
            if (mapB.containsKey(entry.getKey())) {
                res += entry.getValue() * mapB.get(entry.getKey());
            }
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        XieCheng xieCheng = new XieCheng();
        xieCheng.question2_();
    }
}
