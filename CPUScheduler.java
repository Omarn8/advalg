package coarsework;
import java.util.ArrayList;

public class CPUScheduler {

    public static void main(String[] args) {
        ArrayList<Job> jobs = new ArrayList<Job>();
        jobs.add(new Job(1, 0, 10));
        jobs.add(new Job(2, 0, 5));
        
        int currentTime = 0;
        while (!jobs.isEmpty()) {
            Job currentJob = null;
            int currentJobIndex = -1;
            int currentPolicy = 0; 
            for (int i = 0; i < jobs.size(); i++) {
                Job job = jobs.get(i);
                if (currentJob == null || currentPolicy == 0) {
                    currentJob = job;
                    currentJobIndex = i;
                    currentPolicy = 0;
                } else if (currentPolicy == 1 && job.priority > currentJob.priority) {
                    currentJob = job;
                    currentJobIndex = i;
                } else if (currentPolicy == 2 && job.duration < currentJob.duration) {
                    currentJob = job;
                    currentJobIndex = i;
                }
            }
            
            jobs.remove(currentJobIndex);
            System.out.println("System time [" + currentTime + "] - job " + currentJob.jobNumber + " is running.");
            currentJob.duration--;
            if (currentJob.duration > 0) {
                jobs.add(currentJob);
            }
            
            currentTime++;
        }
    }
    
    static class Job {
        int jobNumber;
        int priority;
        int duration;
        
        public Job(int jobNumber, int priority, int duration) {
            this.jobNumber = jobNumber;
            this.priority = priority;
            this.duration = duration;
        }
    }

}
