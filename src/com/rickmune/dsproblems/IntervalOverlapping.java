package com.rickmune.dsproblems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class IntervalOverlapping {

    public static void main(String[] args) {
        mergerOverlappingIntervals(new int[][]{{4, 6}, {1, 2}, {7, 14}, {8, 10}, {9, 18}});
        System.out.println();
        mergeIntervalsUsingStack(new int[][]{{4, 6}, {1, 2}, {7, 14}, {8, 10}, {9, 18}});
    }

    private static void mergerOverlappingIntervals(int[][] p) {

        if (p == null || p.length <= 1) return;

        int index = 0;
        Arrays.sort(p, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        for (int i = 0; i < p.length; i++) {

            if (index > 0 && p[index - 1][1] >= p[i][0]) {

                while (index > 0 && p[index - 1][1] >= p[i][0]) {

                    p[index - 1][1] = Math.max(p[index - 1][1], p[i][1]);
                    index--;

                }
            } else
                p[index] = p[i];
            index++;
        }

        for (int i = 0; i < index; i++)
            System.out.print(Arrays.toString(p[i]) + " ");
    }

    static class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private static void mergeIntervalsUsingStack(int[][] p) {

        if (p == null || p.length <= 1) return;

        Arrays.sort(p, (o1, o2) -> o1[0] - o2[0]);

        int n = p.length;

        Interval[] intervals = new Interval[n];

        for (int i = 0; i < n; i++) {
            intervals[i] = new Interval(p[i][0], p[i][1]);
        }

        Stack<Interval> intervalStack = new Stack<>();
        intervalStack.push(intervals[0]);
        for (int i = 1; i < n; i++) {
            Interval peek = intervalStack.peek();

            if (intervals[i].start < peek.end) {
                Interval merge = intervalStack.pop();
                merge.end = Math.max(intervals[i].end, merge.end);

                intervalStack.push(merge);
            } else {
                intervalStack.push(intervals[i]);
            }
        }

        p = new int[intervalStack.size()][2];
        int i = 0;
        for (Interval x : intervalStack) {
            p[i] = new int[]{x.start, x.end};
            i++;
        }
        for (i = 0; i < p.length; i++)
            System.out.print(Arrays.toString(p[i]) + " ");
        return;
    }
}
