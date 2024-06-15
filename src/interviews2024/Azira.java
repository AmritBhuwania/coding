package interviews2024;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 3 different nodes, round robin manner
 *
 * 3 nodes
 *
 * A(0), B(1), C(2)
 *
 * R1 -> 1 % 3
 * R2 -> 2 % 3
 * R3 -> 3 % 3
 *
 * Rn -> n % 3
 */
public class Azira {

    volatile int counter = 0;

    private Object obj = new Object();

    public static void main(String[] args) {

        List<TimeSlot> timeList = new ArrayList<>(Arrays.asList(new TimeSlot(700, 1100),
                new TimeSlot(1000, 1200), new TimeSlot(1400, 1600), new TimeSlot(1900, 2100)));

        List<TimeSlot> timeListAns = new ArrayList<>();

        // filter api for given employee

        timeList.sort((a, b) -> a.getStart() - b.getStart());

        int start = timeList.get(0).start;
        int end = Integer.MAX_VALUE;

        for (int i = 1; i < timeList.size(); ++i) {

            if (timeList.get(i).start <= timeList.get(i-1).end) {
                end = Math.max(timeList.get(i-1).end, timeList.get(i).end);
            }

            else if (timeList.get(i).start > timeList.get(i-1).end) {

                timeListAns.add(new TimeSlot(start, end));
                start = timeList.get(i).start;
                end = timeList.get(i).end;
            }

        }

        timeListAns.add(new TimeSlot(start, end));
        System.out.println(timeListAns);


    }


}

class TimeSlot {
    int start;
    int end;

    public TimeSlot(int a, int b) {
        this.start = a;
        this.end = b;
    }

    public int getStart() {
        return start;
    }

    @Override
    public String toString() {
        return "TimeSlot{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }

    public int getEnd() {
        return end;
    }
}

//0 prints 0
//1 prints 1
//2 prints 2
//0 prints 3
//1 prints 4
//2 prints 5




//        Azira azira = new Azira();
//        Thread t1 = new Thread(azira.new Printer(0));
//        Thread t2 = new Thread(azira.new Printer(1));
//        Thread t3 = new Thread(azira.new Printer(2));
//        Thread t4 = new Thread(azira.new Printer(0));
//        Thread t5 = new Thread(azira.new Printer(1));
//        Thread t6 = new Thread(azira.new Printer(2));

//        t1.start();
//        t2.start();
//        t3.start();

//        List<Integer> serverIds = List.of(1,2,3,4,5,6);
//
//        for (int i = 0; i < 60; ++i) {
//            int serverId = getServerId(i, serverIds);
//            System.out.println("ServerId " + serverId + " will process request: " + i);
//        }
//    }
//
//    public static Integer getServerId(int requestId, List<Integer> serverIds) {
//
//        if (requestId < 20) {
//            serverIds = serverIds.subList(0, 3);
//        } else if (requestId < 50) {
//            serverIds = serverIds.subList(0, 5);
//        } else if (requestId < 60) {
//            serverIds = serverIds.subList(0, 6);
//        }
//
//        return requestId % serverIds.size();
//
//    }
//
//
//
//    class  Printer implements Runnable {
//
//        int threadNum;
//
//        public Printer(int threadNum) {
//            this.threadNum = threadNum;
//        }
//
//        @Override
//        public void run() {
//            while (counter < 20) {
//                synchronized (obj) {
//                    if (threadNum % 3 == counter % 3) {
//                        System.out.println(threadNum + " prints " + counter);
//                        ++counter;
//                        notifyAll();
//                    } else {
//                        try {
//                            wait();
//                        } catch (InterruptedException e) {
//                            throw new RuntimeException(e);
//                        }
//                    }
//                }
//            }
//        }
//    }
