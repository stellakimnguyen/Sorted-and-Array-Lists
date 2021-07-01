public class Job implements Comparable<Job>{
    private String jobName; //job process
    private int jobLength; //needed CPU cycles
    private int currentJobLength; //remaining CPU cycles
    private int jobPriority; //initial priority at start time
    private int finalPriority; //final priority at end time
    private long entryTime; //time entering the PQ
    private long endTime; //time leaving PQ (terminated)
    private long waitTime; //total wait time (entered PQ to termination)
    private boolean isExecuted; //to avoid low-priority starvation

    //CONSTRUCTORS
    public Job() {
        jobName = "JOB_1";
        jobLength = 35;
        currentJobLength = 35;
        jobPriority = 1;
        finalPriority = 1;
        entryTime = 0;
        endTime = 0;
        waitTime = 0;
        isExecuted = false;
    }

    public Job(String name, int length, int priority) {
        jobName = name;
        jobLength = length;
        currentJobLength = length;
        jobPriority = priority;
        finalPriority = priority;
        entryTime = 0;
        endTime = 0;
        waitTime = 0;
        isExecuted = false;
    }

    //GETTERS & SETTERS
    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public int getJobLength() {
        return jobLength;
    }

    public void setJobLength(int jobLength) {
        this.jobLength = jobLength;
    }

    public int getCurrentJobLength() {
        return currentJobLength;
    }

    public void setCurrentJobLength(int currentJobLength) {
        this.currentJobLength = currentJobLength;
    }

    public int getJobPriority() {
        return jobPriority;
    }

    public void setJobPriority(int jobPriority) {
        this.jobPriority = jobPriority;
    }

    public int getFinalPriority() {
        return finalPriority;
    }

    public void setFinalPriority(int finalPriority) {
        this.finalPriority = finalPriority;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(long entryTime) {
        this.entryTime = entryTime;
    }
e
    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public long getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(long waitTime) {
        this.waitTime = waitTime;
    }

    public boolean isExecuted() {
        return isExecuted;
    }

    public void setExecuted(boolean executed) {
        isExecuted = executed;
    }

    //METHODS
    public String toString() {
        return ("Name: " + this.jobName + " \tJob Length: " + this.jobLength + " \tCurrent Length: " + this.currentJobLength + " \tJob Priority: " + this.jobPriority
            + " \tFinal Priority: " + this.finalPriority + " \tEntry Time: " + this.entryTime + " \tEnd Time: " + this.endTime + " \tWait Time: " + this.waitTime);
    }

    @Override
    public int compareTo(Job other) {
        if (finalPriority - other.getFinalPriority() == 0) {
            return -1;
        }
       return finalPriority - other.getFinalPriority() ; //jobPriority.compareTo(other.getJobPriority())
    }
}
