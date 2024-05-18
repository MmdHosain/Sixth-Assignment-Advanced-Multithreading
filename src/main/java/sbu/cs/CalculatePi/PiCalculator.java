package sbu.cs.CalculatePi;

import java.math.BigDecimal;
import java.util.Random;
import java.util.random.RandomGenerator;

public class PiCalculator {

    /**
     * Calculate pi and represent it as a BigDecimal object with the given floating point number (digits after . )
     * There are several algorithms designed for calculating pi, it's up to you to decide which one to implement.
     Experiment with different algorithms to find accurate results.

     * You must design a multithreaded program to calculate pi. Creating a thread pool is recommended.
     * Create as many classes and threads as you need.
     * Your code must pass all of the test cases provided in the test folder.

     * @param floatingPoint the exact number of digits after the floating point
     * @return pi in string format (the string representation of the BigDecimal object)
     */

    // Euler
    public BigDecimal PI_Euler(int floatingPoint){

        return null;
    }

    public String calculate(int floatingPoint)
    {
        BigDecimal PI = PI_Euler(floatingPoint);
        return PI.toString();
    }

    public static void main(String[] args) {
//        int[] arr = new int[10];
//        for (int i = 0; i < 10; i++) {
//            arr[i] = 0 ;
//        }
        Double a = (double) 0;
        Double b = (double) 0;
        for (int j = 0; j < 100; j++)
        {
            for (int i = 0; i < 10000; i++) {
                Random rand = new Random();
                int x= rand.nextInt(-1000,1000);
                x = x*x;
                int y= rand.nextInt(-1000,1000);
                y = y*y;

                if (x + y < 1000*1000){
                    a++;
                }
                else b++;

            }
            System.out.println(j);
        }
//        for (int i = 0; i < 10; i++) {
            System.out.println(a/b);
//        }
    }
}
