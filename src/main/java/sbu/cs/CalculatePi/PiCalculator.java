package sbu.cs.CalculatePi;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
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

        int N = floatingPoint;
        BigDecimal num1 = BigDecimal.valueOf(1);
        BigDecimal num2 = BigDecimal.valueOf(2);
        BigDecimal num4 = BigDecimal.valueOf(4);
        BigDecimal num5 = BigDecimal.valueOf(5);
        BigDecimal num6 = BigDecimal.valueOf(6);
        BigDecimal num8 = BigDecimal.valueOf(8);
        BigDecimal num16 = BigDecimal.valueOf(16);
        BigDecimal kasr1 ;
        BigDecimal kasr2 ;
        BigDecimal kasr3 ;
        BigDecimal kasr4 ;
        BigDecimal temp ;

        BigDecimal result = BigDecimal.valueOf(0);
        for (int i = 0; i < N; i++) {
            BigDecimal I = BigDecimal.valueOf(i);

            kasr1 = num4 .divide(( (num8 .multiply (I))) .add (num1),floatingPoint, RoundingMode.HALF_UP);
            kasr2 = num2 .divide(( (num8 .multiply (I))) .add (num4),floatingPoint, RoundingMode.HALF_UP);
            kasr3 = num1 .divide(( (num8 .multiply (I))) .add (num5),floatingPoint, RoundingMode.HALF_UP);
            temp = ((num8 .multiply (I))) .add (num6);
            kasr4 = num1 .divide( temp,1000, RoundingMode.HALF_UP);

            BigDecimal sum = (( kasr1 .subtract(kasr2)).subtract(kasr3)).subtract(kasr4);

            for (int j = 0; j < i; j++) {

                sum = sum.divide(num16);
            }
            result = result.add(sum);
        }
        return result.setScale(floatingPoint,RoundingMode.FLOOR);
    }

    public String calculate(int floatingPoint)
    {
        BigDecimal PI = PI_Euler(floatingPoint);
        return PI.toString();
    }

    public static void main(String[] args) {
    }
}
