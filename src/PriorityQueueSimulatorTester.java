import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Random;

public class PriorityQueueSimulatorTester {
    public static int currentTimeCycles = 0; //track current time in CPU cycles
    public static int totalAverageTime = 0;

    public static void findFirstStarvedProcess() {
        //
    }

    public static void initializeJobsArray(Job[] jobsArray) {
        Random randomLength = new Random();
        Random randomPriority = new Random();

        for (int i = 0; i < jobsArray.length; i++) { //O(1) as length is constant
            jobsArray[i] = new Job("JOB_" + (i + 1), randomLength.nextInt(70) + 1, randomPriority.nextInt(40) + 1);
        }
    }

    public static void populatePriorityQueue(Job[] jobsArray, MinPriorityQueue<Job> pq) {
        for (int i = 0; i < jobsArray.length; i++) {
            jobsArray[i].setEntryTime(i + 1);
            pq.insert(jobsArray[i]);
            currentTimeCycles++;
        }
    }

    public static void executeJob(Job currentJob, MinPriorityQueue<Job> pq, int currentJobPriority) {
        currentJob.setCurrentJobLength(currentJob.getCurrentJobLength() - 1);
        currentJob.setFinalPriority(currentJobPriority);

//        System.out.println("Now executing " + currentJob.getJobName() + ". Job length: " + currentJob.getJobLength() +
//                "; Current remaining length: " + currentJob.getCurrentJobLength() + "; Initial priority: " + currentJob.getJobPriority() +
//                "; Current priority: " + currentJob.getFinalPriority());

        if (currentJob.getCurrentJobLength() != 0) {
            pq.insert(currentJob);
        } else {
            currentJob.setEndTime(currentTimeCycles);
            currentJob.setWaitTime(currentTimeCycles - currentJob.getEntryTime() - currentJob.getJobLength());
            totalAverageTime += currentJob.getWaitTime();
        }
        currentTimeCycles++;
    }

    public static void runProcessor(Job[] jobsArray, MinPriorityQueue<Job> pq, String executionType) {
        int cycleCount = 0; //reset to 0 when 30 is reached
        int numPriorityChanges = 0;

        long startTime = System.nanoTime();

        initializeJobsArray(jobsArray);
        populatePriorityQueue(jobsArray, pq);

        while (!pq.isEmpty()) {
            cycleCount++;
            if (cycleCount == 30) {
                if (pq.maximum().isExecuted()) {
                    executeJob(pq.extractMax(), pq, 1);
                }
                cycleCount = 0; // reinitialize count
                numPriorityChanges++;
            }

            Job currentJob = pq.extractMin();
            executeJob(currentJob, pq, currentJob.getJobPriority());
        }

        long endTime = System.nanoTime();

        System.out.println("\n***" + executionType + "***" +
                "\nCurrent system time (cycles): " + currentTimeCycles
                + "\nTotal number of jobs executed: " + jobsArray.length + " jobs"
                + "\nAverage process waiting time: "  + Math.abs(totalAverageTime)/jobsArray.length + " cycles"
                + "\nTotal number of priority changes: " + numPriorityChanges
                + "\nActual system time needed to execute all jobs: " + (endTime - startTime) * Math.pow(1, 6) + " ms");
    }

    public static void main(String[] args) {
        // Set number of jobs
        Random generator = new Random();
        int[] maxNumberOfJobs = {100, 1000, 10000}; //, 100000, 1000000
        int randomIndex = generator.nextInt(maxNumberOfJobs.length);
        Job[] jobsInputArray = new Job[maxNumberOfJobs[randomIndex]]; //maxNumberOfJobs[randomIndex]

        MinPriorityQueue<Job> sortedListPQ = new SortedListPQ<Job>();
        MinPriorityQueue<Job> arrayListHeapPQ = new ArrayListHeapPQ<Job>();

        // SORTED LIST PRIORITY QUEUE
        runProcessor(jobsInputArray, sortedListPQ, "SORTED LIST PRIORITY QUEUE");

        // ARRAY LIST HEAP PRIORITY QUEUE
        runProcessor(jobsInputArray, arrayListHeapPQ, "ARRAY LIST HEAP PRIORITY QUEUE");
    }
}
