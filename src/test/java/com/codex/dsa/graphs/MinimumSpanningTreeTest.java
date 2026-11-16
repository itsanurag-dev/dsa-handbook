package com.codex.dsa.graphs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MinimumSpanningTreeTest {

    @Test
    @DisplayName("Kruskal and Prim produce identical optimal MST weight on standard graph")
    public void testStandardGraphMST() {
        int V = 5;
        List<MinimumSpanningTree.Edge> edges = new ArrayList<>();
        edges.add(new MinimumSpanningTree.Edge(0, 1, 1));
        edges.add(new MinimumSpanningTree.Edge(1, 2, 2));
        edges.add(new MinimumSpanningTree.Edge(2, 3, 3));
        edges.add(new MinimumSpanningTree.Edge(3, 4, 4));
        edges.add(new MinimumSpanningTree.Edge(0, 4, 10));
        edges.add(new MinimumSpanningTree.Edge(1, 3, 5));

        MinimumSpanningTree.MSTResult kruskalResult = MinimumSpanningTree.kruskalMST(V, edges);
        MinimumSpanningTree.MSTResult primResult = MinimumSpanningTree.primMST(V, edges);

        assertNotNull(kruskalResult);
        assertNotNull(primResult);

        // Optimal MST: (0-1:1), (1-2:2), (2-3:3), (3-4:4) -> Weight = 10
        assertEquals(10, kruskalResult.totalWeight);
        assertEquals(10, primResult.totalWeight);
        assertEquals(4, kruskalResult.edges.size());
        assertEquals(4, primResult.edges.size());
    }

    @Test
    @DisplayName("Disconnected graph returns null (no spanning tree covers all vertices)")
    public void testDisconnectedGraph() {
        int V = 4;
        List<MinimumSpanningTree.Edge> edges = new ArrayList<>();
        edges.add(new MinimumSpanningTree.Edge(0, 1, 2));
        // Vertices 2 and 3 are in disconnected component with edge between them
        edges.add(new MinimumSpanningTree.Edge(2, 3, 5));

        assertNull(MinimumSpanningTree.kruskalMST(V, edges));
        assertNull(MinimumSpanningTree.primMST(V, edges));
    }

    @Test
    @DisplayName("Single vertex graph edge case")
    public void testSingleVertex() {
        MinimumSpanningTree.MSTResult kruskalResult = MinimumSpanningTree.kruskalMST(1, new ArrayList<>());
        MinimumSpanningTree.MSTResult primResult = MinimumSpanningTree.primMST(1, new ArrayList<>());

        assertNotNull(kruskalResult);
        assertNotNull(primResult);
        assertEquals(0, kruskalResult.totalWeight);
        assertEquals(0, primResult.totalWeight);
        assertEquals(0, kruskalResult.edges.size());
    }
}

