package com.codex.dsa.graphs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TarjanGraphAlgorithmsTest {

    @Test
    @DisplayName("Finds single bridge in simple barbell graph")
    public void testFindSingleBridge() {
        // Graph: (0-1), (1-2), (2-0) is a triangle; (2-3) is bridge; (3-4), (4-5), (5-3) is triangle
        int V = 6;
        List<TarjanGraphAlgorithms.Edge> edges = Arrays.asList(
            new TarjanGraphAlgorithms.Edge(0, 1),
            new TarjanGraphAlgorithms.Edge(1, 2),
            new TarjanGraphAlgorithms.Edge(2, 0),
            new TarjanGraphAlgorithms.Edge(2, 3), // bridge
            new TarjanGraphAlgorithms.Edge(3, 4),
            new TarjanGraphAlgorithms.Edge(4, 5),
            new TarjanGraphAlgorithms.Edge(5, 3)
        );

        List<TarjanGraphAlgorithms.Edge> bridges = TarjanGraphAlgorithms.findBridges(V, edges);
        assertEquals(1, bridges.size());
        TarjanGraphAlgorithms.Edge bridge = bridges.get(0);
        assertTrue((bridge.u == 2 && bridge.v == 3) || (bridge.u == 3 && bridge.v == 2));
    }

    @Test
    @DisplayName("Cycle graph contains zero bridges")
    public void testCycleNoBridges() {
        int V = 4;
        List<TarjanGraphAlgorithms.Edge> edges = Arrays.asList(
            new TarjanGraphAlgorithms.Edge(0, 1),
            new TarjanGraphAlgorithms.Edge(1, 2),
            new TarjanGraphAlgorithms.Edge(2, 3),
            new TarjanGraphAlgorithms.Edge(3, 0)
        );

        List<TarjanGraphAlgorithms.Edge> bridges = TarjanGraphAlgorithms.findBridges(V, edges);
        assertTrue(bridges.isEmpty());
    }

    @Test
    @DisplayName("Tarjan SCC identifies strongly connected components in directed graph")
    public void testTarjanSCC() {
        int V = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // Directed edges: 1->0, 0->2, 2->1 (SCC: {0, 1, 2}), 0->3, 3->4
        adj.get(1).add(0);
        adj.get(0).add(2);
        adj.get(2).add(1);
        adj.get(0).add(3);
        adj.get(3).add(4);

        List<List<Integer>> sccs = TarjanGraphAlgorithms.findSCCs(V, adj);
        // Expect 3 SCCs: {4}, {3}, {0, 1, 2}
        assertEquals(3, sccs.size());
    }
}

