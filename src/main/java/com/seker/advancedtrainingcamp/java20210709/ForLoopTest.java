package com.seker.advancedtrainingcamp.java20210709;

import com.seker.advancedtrainingcamp.java20210708.MovingAverage;

public class ForLoopTest {

    private static int[] numbers = {1, 6 , 8};

    public static void main(String[] args) {
        MovingAverage ma = new MovingAverage();
        for (int number : numbers) {
            ma.submit(number);
        }
        double avg = ma.getAvg();
    }

}
