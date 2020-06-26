package com.nikolairudko.task4_1.service;

import com.nikolairudko.task4_1.empty.CustomIntArray;
import com.nikolairudko.task4_1.exception.CustomArrayException;

public class CustomIntSearch {

    public int binarySearch(CustomIntArray array, int elementToSearch) throws CustomArrayException {
        if (array.length() == 0) {
            throw new CustomArrayException("The size of the array is 0.");
        }

        CustomIntSort sort = new CustomIntSort();
        CustomIntArray sortArray = sort.bubbleSortUp(array);

        int firstIndex = 0;
        int lastIndex = array.length() - 1;

        while (firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            if (sortArray.getElement(middleIndex) == elementToSearch) {
                return middleIndex;
            } else if (sortArray.getElement(middleIndex) < elementToSearch)
                firstIndex = middleIndex + 1;
            else if (sortArray.getElement(middleIndex) > elementToSearch)
                lastIndex = middleIndex - 1;
        }
        return -1;
    }

    public int minSearch(CustomIntArray array) throws CustomArrayException {
        if (array.length() == 0) {
            throw new CustomArrayException("The size of the array is 0.");
        }

        int min = array.getElement(0);
        for (int i = 0; i < array.length(); i++) {
            if (array.getElement(i) < min) {
                min = array.getElement(i);
            }
        }

        return min;
    }

    public int maxSearch(CustomIntArray array) throws CustomArrayException {
        if (array.length() == 0) {
            throw new CustomArrayException("The size of the array is 0.");
        }

        int max = array.getElement(0);
        for (int i = 0; i < array.length(); i++) {
            if (array.getElement(i) > max) {
                max = array.getElement(i);
            }
        }

        return max;
    }

    public CustomIntArray primeNumbers(CustomIntArray array) throws CustomArrayException {
        if (array.length() == 0) {
            throw new CustomArrayException("The size of the array is 0.");
        }

        int countPrimeNumber = 0;
        for (int i = 0; i < array.length(); i++) {
            if (isPrime(array.getElement(i))) {
                countPrimeNumber++;
            }
        }

        if (countPrimeNumber == 0) {
            return new CustomIntArray(0);
        }

        CustomIntArray primeArray = new CustomIntArray(countPrimeNumber);

        for (int i = 0; i < array.length(); i++) {
            if (isPrime(array.getElement(i))) {
                primeArray.setElement(array.getElement(i), i);
            }
        }

        return primeArray;
    }

    public CustomIntArray fibonacciNumbers(CustomIntArray array) throws CustomArrayException {
        if (array.length() == 0) {
            throw new CustomArrayException("The size of the array is 0.");
        }

        int countFibonacciNumber = 0;
        for (int i = 0; i < array.length(); i++) {
            if (isFibonacci(array.getElement(i))) {
                countFibonacciNumber++;
            }
        }

        if (countFibonacciNumber == 0) {
            return new CustomIntArray(0);
        }

        CustomIntArray fibonacciArray = new CustomIntArray(countFibonacciNumber);

        for (int i = 0; i < array.length(); i++) {
            if (isFibonacci(array.getElement(i))) {
                fibonacciArray.setElement(array.getElement(i), i);
            }
        }

        return fibonacciArray;
    }

    public CustomIntArray uniqueNumbers(CustomIntArray array) throws CustomArrayException {
        if (array.length() == 0) {
            throw new CustomArrayException("The size of the array is 0.");
        }

        int countUniqueNumber = 0;
        for (int i = 0; i < array.length(); i++) {
            if (isFibonacci(array.getElement(i))) {
                countUniqueNumber++;
            }
        }

        if (countUniqueNumber == 0) {
            return new CustomIntArray(0);
        }

        CustomIntArray uniqueArray = new CustomIntArray(countUniqueNumber);

        for (int i = 0; i < array.length(); i++) {
            if (isUniqueNumber(array.getElement(i))) {
                uniqueArray.setElement(array.getElement(i), i);
            }
        }

        return uniqueArray;
    }

    public boolean isUniqueNumber(int number) {
        number = Math.abs(number);
        if (!(number / 100 > 0 && number / 100 <= 9)) {
            return false;
        }

        int firstDigit = number % 10;
        int secondDigit = number % 100 / 10;

        return firstDigit != secondDigit;
    }

    private boolean isPerfectSquare(int number) {
        int sqr = (int) Math.sqrt(number);
        return (sqr * sqr == number);
    }

    private boolean isFibonacci(int number) {
        return isPerfectSquare(5 * number * number + 4) || isPerfectSquare(5 * number * number - 4);
    }

    private boolean isPrime(int number) {
        if (number == 1) {
            return false;
        }
        for (int d = 2; d * d <= number; d++) {
            if (number % d == 0) {
                return false;
            }
        }
        return true;
    }
}
