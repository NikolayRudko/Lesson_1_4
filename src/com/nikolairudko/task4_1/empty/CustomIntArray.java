package com.nikolairudko.task4_1.empty;

public class CustomIntArray {
    private int[] numberArray;

    public CustomIntArray() {
        this.numberArray = new int[10];
    }

    public CustomIntArray(int[] numberArray) {
        this.numberArray = numberArray;
    }

    public void setNumberArray(int[] numberArray) {
        this.numberArray = numberArray;
    }


    public void setElement(int element, int index) {
        if (isCorrectIndex(index)) {
            this.numberArray[index] = index;
        }
    }

    private boolean isCorrectIndex(int index) {
        return index >= 0 && index < numberArray.length;
    }


    //todo
    public int length() {
        return numberArray.length;
    }



    //TODO
    //equals()

    //hasCode()

    //toString()
}

