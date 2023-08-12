package codingPatterns.mergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * We are given a list of Jobs. Each job has a Start time, an End time, and a CPU load when it is running.
 * Our goal is to find the maximum CPU load at any time if all the jobs are running on the same machine.
 * Example 1:
 * Jobs: [[1,4,3], [2,5,4], [7,9,6]]
 * Output: 7
 * Explanation: Since [1,4,3] and [2,5,4] overlap, their maximum CPU load (3+4=7) will be when both the
 * jobs are running at the same time i.e., during the time interval (2,4).
 *
 * Example 2:
 * Jobs: [[1,4,2], [2,4,1], [3,6,5]]
 * Output: 8
 * Explanation: Maximum CPU load will be 8 as all jobs overlap during the time interval [3,4].
 */

public class MaximumCPULoad {
    public static void main(String[] args) {
        List<Job> jobList = new ArrayList<>();
        jobList.add(new Job(1, 4,10));
        jobList.add(new Job(2,4,1));
        jobList.add(new Job(3, 6,15));
        System.out.println(new MaximumCPULoad().maxLoad(jobList));
    }

    private int maxLoad(List<Job> jobList) {
        Collections.sort(jobList, (a,b) -> Integer.compare(a.start, b.start));
        PriorityQueue<Job> jobs = new PriorityQueue<>(jobList.size(), (a, b) -> Integer.compare(a.end, b.end));
        int currLoad = 0, maxLoad = 0;

        for (Job job : jobList) {
            while (!jobs.isEmpty() && job.start > jobs.peek().end) {
                currLoad -= jobs.poll().cpuLoad;
            }
            jobs.add(job);
            currLoad += job.cpuLoad;
            maxLoad = Math.max(currLoad, maxLoad);
        }
        return maxLoad;
    }
}

class Job {
    int start;
    int end;
    int cpuLoad;

    public Job(int start, int end, int cpuLoad) {
        this.start = start;
        this.end = end;
        this.cpuLoad = cpuLoad;
    }

    @Override
    public String toString(){
        return "[" + start + "," + end + "," + cpuLoad + "]";
    }
}
