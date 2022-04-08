package org.zuel.common;

import java.util.*;

public class HashMapExec {

    public static void main(String[] args) {
        HashMap<String, Double> map = new HashMap<>();
        map.put("January", 1.23);
        map.put("May", 1.232);
        ArrayList<Map.Entry<String, Double>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
            @Override
            public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
                return (int) (o1.getValue() - o2.getValue());
            }
        });
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
            Double res = map.get(key);
            System.out.println(res);
        }
    }
}
