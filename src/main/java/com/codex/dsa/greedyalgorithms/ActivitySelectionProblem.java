package com.codex.dsa.greedyalgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Concept:
 * The Activity Selection Problem is a classic greedy algorithm problem.
 * Given a set of activities with start and finish times, select the maximum number of mutually
 * compatible activities that can be performed by a single person/resource.
 *
 * Greedy Choice Property:
 * - Always pick the next activity whose finish time is earliest among remaining compatible activities.
 *   This leaves the maximum remaining time available for subsequent activities.
 *
 * Time Complexity:
 * - O(N log N) to sort activities by end time.
 * - O(N) linear scan to greedily pick non-overlapping activities.
 *
 * Space Complexity:
 * - O(1) auxiliary space (excluding result list).
 */
public class ActivitySelectionProblem {

    public static class Activity {
        public final int start;
        public final int finish;

        public Activity(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }

        @Override
        public String toString() {
            return "(" + start + ", " + finish + ")";
        }
    }

    /**
     * Selects maximum subset of mutually compatible activities.
     */
    public static List<Activity> selectMaxActivities(List<Activity> activities) {
        if (activities == null || activities.isEmpty()) {
            return Collections.emptyList();
        }

        List<Activity> sorted = new ArrayList<>(activities);
        // Sort by finish time ascending
        sorted.sort(Comparator.comparingInt(a -> a.finish));

        List<Activity> selected = new ArrayList<>();
        selected.add(sorted.get(0));
        int lastFinish = sorted.get(0).finish;

        for (int i = 1; i < sorted.size(); i++) {
            Activity next = sorted.get(i);
            if (next.start >= lastFinish) {
                selected.add(next);
                lastFinish = next.finish;
            }
        }

        return selected;
    }
}
