package multithreading.basics;
/*
By default java executes code sequentially that is it will execute code line by line.
Consider the example given below

First runner1 is executed followed by runner 2
 */

class Runner1 {
    public void execute() {
        for (int i = 0; i < 10; i++) {
            System.out.println("RUNNER 1 " + i);
        }
    }
}

class Runner2 {
    public void execute() {
        for (int i = 0; i < 10; i++) {
            System.out.println("RUNNER 2 " + i);
        }
    }
}
public class SequntialProcessing {
    public static void main(String[] args) {
        Runner1 r1 = new Runner1();
        Runner2 r2 = new Runner2();
        r1.execute();
        r2.execute();
    }
}
