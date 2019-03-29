package com.james.io.graph.transformstring;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomTransformStringSolution {

    private int res = -1;

    int getProductionSequence(Set<String> dict,
                                     String s,
                                     String t) {
        Map<String, Set<String>> graph = getGraph(dict);
        dfs(graph, Stream.of(s).collect(Collectors.toCollection(LinkedHashSet::new)), s, t);
        return res;
    }

    private void dfs(Map<String, Set<String>> graph,
                     Set<String> seen,
                     String s,
                     String t) {
        if (s.equals(t)) {
            res = res == -1 ? seen.size() - 1 : Math.min(seen.size() - 1, res);
            return;
        }
        if (graph.containsKey(s)) {
            for (String neigh : graph.get(s)) {
                if (!seen.contains(neigh)) {
                    seen.add(neigh);
                    dfs(graph, seen, neigh, t);
                    seen.remove(neigh);
                }
            }
        }
    }

    private Map<String, Set<String>> getGraph(Set<String> dict) {
        Map<String, Set<String>> graph = new HashMap<>();
        Set<String> edges;
        for (String s : dict) {
            edges = graph.computeIfAbsent(s, k -> new HashSet<>());
            for (String t : dict) {
                if (!s.equals(t) && isValid(s, t)) {
                    edges.add(t);
                }
            }
        }
        return graph;
    }

    private boolean isValid(String s, String t) {
        if (s.length() == t.length()) {
            int charsDiff = 0;
            for (int k = 0; k < s.length(); k++) {
                if (s.charAt(k) != t.charAt(k)) {
                    charsDiff++;
                }
            }
            return charsDiff == 1;
        }
        return false;
    }
}
