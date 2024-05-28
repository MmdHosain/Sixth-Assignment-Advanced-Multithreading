package sbu.cs.CalculatePi;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

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



        List<BigDecimal> resultList = new ArrayList<>();
        BigDecimal result = BigDecimal.valueOf(0);

        resultList.add(result);
        resultList.add(result);
        resultList.add(result);
        resultList.add(result);

        // threads

        Calculator calculat1 = new Calculator(0,N/2                 ,floatingPoint,resultList,1);
        Calculator calculat2 = new Calculator((N/2),(3*N/4)     ,floatingPoint,resultList,2);
        Calculator calculat3 = new Calculator((3*N/4),(7*N/8)   ,floatingPoint,resultList,3);
        Calculator calculat4 = new Calculator((7*N/8),N+1 ,floatingPoint,resultList,4);

        Thread thread1 = new Thread(calculat1);
        Thread thread2 = new Thread(calculat2);
        Thread thread3 = new Thread(calculat3);
        Thread thread4 = new Thread(calculat4);
        try {
            thread1.start();

            thread2.start();

            thread3.start();

            thread4.start();

            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();

        }
        catch(Exception ignored){
            System.out.println("error in thread running");
        }
        result = result .add(resultList.get(0));
        result = result .add(resultList.get(1));
        result = result .add(resultList.get(2));
        result = result .add(resultList.get(3));

        return result.setScale(floatingPoint,RoundingMode.FLOOR);
    }

    public static class Calculator implements Runnable
    {

        int a;
        int b;
        int n;
        int floatingPoint;

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
        BigDecimal result = BigDecimal.valueOf(0);
        List<BigDecimal> resultList;

        public Calculator(int a,int b,int floatingPoint,List<BigDecimal> resultList,int n) {
            this.a=a;
            this.b=b;
            this.n=n;
            this.floatingPoint = floatingPoint;
            this.resultList =resultList;
        }

        @Override
        public void run() {

            for (int i = a; i < b; i++) {
                BigDecimal I = BigDecimal.valueOf(i);

                kasr1 = num4 .divide(( (num8 .multiply (I))) .add (num1),floatingPoint+10, RoundingMode.HALF_UP);
                kasr2 = num2 .divide(( (num8 .multiply (I))) .add (num4),floatingPoint+10, RoundingMode.HALF_UP);
                kasr3 = num1 .divide(( (num8 .multiply (I))) .add (num5),floatingPoint+10, RoundingMode.HALF_UP);
                kasr4 = num1 .divide( ((num8 .multiply (I))) .add (num6),floatingPoint+10, RoundingMode.HALF_UP);

                BigDecimal sum = (( kasr1 .subtract(kasr2)).subtract(kasr3)).subtract(kasr4);

                for (int j = 0; j < i; j++) {

                    sum = sum.divide(num16);
                }
                result = result.add(sum);
            }
            resultList.set(n-1,result.add(resultList.get(n-1))) ;
        }

    }

    public String calculate(int floatingPoint)
    {
        BigDecimal PI = PI_Euler(floatingPoint);
        return PI.toString();
    }

    public static void main(String[] args) {
    }
}
