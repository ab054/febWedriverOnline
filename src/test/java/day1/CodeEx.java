package day1;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class CodeEx {

    @Test
    public void testPrintEvenNumbers() {
        for (int i = 1; i <= 10; i++) {
            if (i%2==0) System.out.println(i);
        }
    }

    @Test
    public void printHelloAtEvenNumbers() {
        for (int i = 1; i <= 10; i++) {
            if (i%2==0) System.out.println("hello world");
        }
    }

    @Test
    public void swapTwoNumbersInArray() {
        int[] inputArray = {1,2,3,4};
        swap(inputArray, 1, 2);
        System.out.println(Arrays.toString(inputArray));
    }

    @Test
    public void swapTest_OfBoundsException() {
        int[] inputArray = {1,2,3,4};
        int inputParamL = 6;
        int inputParamR = 2;

        swap(inputArray, inputParamL, inputParamR);
        System.out.println(Arrays.toString(inputArray));
    }


    private void swap(int[] inputArray, int leftIndex, int rightIndex) {
        int temp = inputArray[leftIndex];
        inputArray[leftIndex] = inputArray[rightIndex];
        inputArray[rightIndex] = temp;
    }

    @Test
    public void testCountLetters() {
        String input = "hello world";
        char inputParamLetter = 'l';
        int amountOfLetters = howManyLetters(input, inputParamLetter);
        outResults(input, inputParamLetter, amountOfLetters);
    }

    @Test
    public void testCountLetters2() {
        String input = "hello world";
        char inputParamLetter = 'f';
        int amountOfLetters = howManyLetters(input, inputParamLetter);
        outResults(input, inputParamLetter, amountOfLetters);
    }

    @Test
    public void testCountLetters4() {
        String input = "hello21312%%5 world";
        char inputParamLetter = '%';
        int amountOfLetters = howManyLetters(input, inputParamLetter);
        outResults(input, inputParamLetter, amountOfLetters);
    }

    @Test
    public void testCountLetters5() {
        String input = "hello21312%%5 world";
        char inputParamLetter = '%';

        int result = howManyLetters(input, inputParamLetter);
        outResults(input, inputParamLetter, result);

    }

    private int howManyLetters(String input, char inputParamLetter) {
        int result = 0;
        for(char eachChar : input.toCharArray()){
            if(eachChar==inputParamLetter) result++;
        }
        return result;
    }

    private void outResults(String input, char inputParamLetter, int amountOfLetters) {
        System.out.println("Amount of letters "
                + inputParamLetter + " in string="
                + input + " equals to " + amountOfLetters);
    }

    @Test
    public void testConstructor() {
        Actor actor1 = new Actor("Name1", "LastName1");
        Actor actor2 = new Actor("Name2", "LastName2", true);
    }

    @Test
    public void testWhile() {
        int i = 0;
        while (i < 5) {
            System.out.println("While loop: i = " + i++);
        }
    }

    @Test
    public void testDoWhile() {
        int i = 0;
        do {
            System.out.println("Do-While loop: i = " + i++);
        } while (i < 5);
    }

    @Test
    public void test006() {
        int[] array = {1,2,3,4,5,6,7};
        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        ArrayList<Actor> arrayList2 = new ArrayList<Actor>();

        Actor[] actors = {new Actor("name", "lastname"), new Actor("name2", "lastname2")};

        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        int oneElement = arrayList.get(3);

    }
}
