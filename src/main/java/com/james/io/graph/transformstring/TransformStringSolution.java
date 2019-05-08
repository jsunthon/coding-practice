package com.james.io.graph.transformstring;

import java.util.*;

public class TransformStringSolution {

    private static final int STARTING_CHAR_OFFSET = 0;
    private static final int LAST_CHAR_OFFSET = 26;

    public int shortestProductionSequence(Set<String> dictionary,
                                          String s,
                                          String t) {
        if (!dictionary.isEmpty()) {
            final Map<String, Integer> wordDistanceMap = new HashMap<>();
            wordDistanceMap.put(s, STARTING_CHAR_OFFSET);

            final Queue<String> wordQueue = new LinkedList<>();
            wordQueue.offer(s);

            String current;
            while ((current = wordQueue.poll()) != null) {
                if (current.equals(t)) {
                    return wordDistanceMap.get(current);
                }
                for (int i = 0; i < current.length(); i++) {
                    String startStr = i == 0 ? "" : current.substring(0, i);
                    String endStr = i < current.length() - 1 ? current.substring(i + 1) : "";
                    for (int j = STARTING_CHAR_OFFSET; j < LAST_CHAR_OFFSET; j++) {
                        String comboStr = startStr + ((char) ('a' + j)) + endStr;
                        if (dictionary.contains(comboStr) && !wordDistanceMap.containsKey(comboStr)) {
                            wordDistanceMap.put(comboStr, wordDistanceMap.get(current) + 1);
                            wordQueue.offer(comboStr);
                        }
                    }
                }
            }
        }

        return -1;
    }
}
