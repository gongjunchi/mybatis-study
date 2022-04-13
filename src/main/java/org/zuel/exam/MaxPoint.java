package org.zuel.exam;

public class MaxPoint {

    public int maxPointsNum (Point[] points) {
        // write code here
        int len = points.length;
        if (len <= 2) {
            return len;
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            Point a = points[i];
            for (int j = i + 1; j < len; j++) {
                Point b = points[j];
                int count = 2;
                for (int k = j + 1; k < len; k++) {
                    Point c = points[k];
                    int left = (a.y - b.y) * (c.x - a.x);
                    int right = (a.x - b.x) * (c.y - a.y);
                    if (left == right) {
                        count++;
                    }
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }
}
