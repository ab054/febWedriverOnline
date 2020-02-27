package day1;

import org.testng.annotations.Test;

public class Hello {

    @Test
    public void test00001() {
        System.out.println("Hello, World!");
    }

    @Test
    public void test0002() {
        int myNumber;
        myNumber = 7;

        System.out.println(myNumber);
    }

    @Test
    public void test00031() {
        String s = "I have 5 cookies";

        System.out.println(s);
    }

    @Test
    public void test003() {
        int num = 4;
        String s = "I have " + num + " cookies";

        System.out.println(s);
    }

    @Test
    public void test0004() {
        boolean toBe = false;

        if (toBe && !toBe) {
            System.out.println(toBe);
        } else {
            System.out.println(!toBe);
        }
    }

    @Test
    public void test0005() {
        int[] arr = {1, 2, 3, 4, 5};
        printArray(arr);
    }

    @Test
    public void test0007() {
        int[] arr = {1, 2, 3, 4, 5, 5,6,7,8,9};
        printArray(arr);
    }

    public void printArray(int[] inputArray){
        for(int i=0; i < inputArray.length; i++){
            System.out.print(inputArray[i] + " ");
        }
    }

    @Test
    public void test0008() {
        Point point = new Point(5, 9);
        Point point2 = new Point(6, 0);
        point.printPoint();
    }
}
