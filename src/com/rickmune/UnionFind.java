package com.rickmune;

import java.util.HashSet;
import java.util.Set;

public class UnionFind {

    public int countComponents(int n, int[][] edges) {
        int[] ids = new int[n];
        for (int i = 0; i < ids.length; i++) ids[i] = i;
        for (int[] edge : edges)union(edge[0], edge[1], ids);
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < ids.length; i++) set.add(find(i, ids));
        return set.size();
    }

    private void union(int edge1, int edge2, int[] ids) {
        int parent1 = find(edge1, ids);
        int parent2 = find(edge2, ids);
        ids[parent1] = parent2;
    }

    private int find(int edge, int[] ids) {
        if (ids[edge] != edge) ids[edge] = find(edge, ids);
        return ids[edge];
    }
}
