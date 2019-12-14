import net.datastructures.HeapPriorityQueue;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ProcessScheduling {

    protected static class Process {
        private int id; // process id
        private int pr; // priority
        private int arrivalTime; // arrival time
        private int duration; // duration

        public Process() {
            id = 0;
            pr = 0;
            arrivalTime = 0;
            duration = 0;
        }
        public Process(int id, int pr, int arrivalTime, int duration) {
            this.id = id;
            this.pr = pr;
            this.arrivalTime = arrivalTime;
            this.duration = duration;
        }

        public int getId() {return id;}
        public int getPr() {return pr;}
        public int getArrivalTime() {return arrivalTime;}
        public int getDuration() {return duration;}

        public void setId(int id) {this.id = id;}
        public void setPr(int pr) {this.pr = pr;}
        public void setArrivalTime(int arrivalTime) {this.arrivalTime = arrivalTime;}
        public void setDuration(int duration) {this.duration = duration;}

        public String toString() {
            String s = new String();
            s += "Id = " + id + ", ";
            s += "priority = " + pr + ", ";
            s += "duration = " + duration + ", ";
            s += "arrival time = " + arrivalTime;
            return s;
        }


    }

    /**
     * Static method to get process with earliest arrival time in D.
     * @param arr array list D
     * @return index of the process with earliest arrival time.
     */
    protected static int getEarliest(ArrayList<Process> arr) {
        int min = 99999;
        int index = 0;
        for (Process p : arr) {
            int arrivalTime = p.getArrivalTime();
            if (arrivalTime < min) {
                min = arrivalTime;
                index = arr.indexOf(p);
            }
        }
        return index;
    }


    public static void main(String[] args) throws Exception {

        HeapPriorityQueue<Integer, Process> pq = new HeapPriorityQueue<>(); // Create empty priority queue Q
        ArrayList<Process> processList = new ArrayList<>(); // new ArrayList D

        /**
         * Read all process from input file
         * Store them in a new ArrayList D
         */
        String Path = "./process_scheduling_in.txt";
        FileInputStream fin = new FileInputStream(Path);
        InputStreamReader reader = new InputStreamReader(fin);
        BufferedReader buff = new BufferedReader(reader);
        String strTmp = "";
        while ((strTmp = buff.readLine()) != null) {
            String arr[] = strTmp.split("\\s+");
            int id = Integer.parseInt(arr[0]);
            int pr = Integer.parseInt(arr[1]);
            int duration = Integer.parseInt(arr[2]);
            int arrivalTime = Integer.parseInt(arr[3]);
            Process p = new Process(id, pr, arrivalTime, duration);
            processList.add(p);
            System.out.println(p.toString());
        }
        System.out.println();

        // now process list D is full
        // priority queue Q is empty

        // simulation
        int currentTime = 0;
        boolean running = false;
        int n = processList.size(); // number of processes


        int totalWT = 0; // total weight time
        int finishTime = 0;

        /**
         * According to pseudocode given in hw pdf, while ends when D is empty.
         * That's wrong cuz when D is empty, there might be processes still waiting in Q, so the whole process is not
         * done.
         * Process should end when both D and Q is empty!
         */
        while (!processList.isEmpty() || !pq.isEmpty()) {

            if (!processList.isEmpty()) {
                int index = getEarliest(processList);
                Process eP = processList.get(index);
                int aT = eP.getArrivalTime();

                if (aT <= currentTime) {
                    processList.remove(eP);
                    pq.insert(eP.getPr(), eP);
                }
            }

            if (!pq.isEmpty() && !running) {
                Process rP = pq.removeMin().getValue();
                running = true;
                int waitTime = currentTime - rP.getArrivalTime();
                totalWT += waitTime;
                System.out.println("Process removed from queue is: id = " + rP.getId() + ", at time " + currentTime +
                        ", wait time = " + waitTime + " Total wait time = " + (double) totalWT);
                System.out.println("Process id = " + rP.getId());
                System.out.println("       Priority = " + rP.getPr());
                System.out.println("       Arrival = " + rP.getArrivalTime());
                System.out.println("       Duration = " + rP.getDuration());
                finishTime = currentTime + rP.getDuration();
                System.out.println("Process " + rP.getId() + " finished at time " + finishTime);
                System.out.println();
            }

            currentTime += 1;
            if (finishTime == currentTime) {
                running = false;
            }
        }

        System.out.println("Total wait time = " + (double) totalWT);
        System.out.println("Average wait time = " + String.format("%.1f", (double) totalWT / n));

    }
}
