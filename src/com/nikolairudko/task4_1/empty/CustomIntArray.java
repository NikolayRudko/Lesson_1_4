package com.nikolairudko.task4_1.empty;

import com.nikolairudko.task4_1.exception.CustomArrayException;

public class CustomIntArray {
    private int[] numberArray;

    public CustomIntArray() {
        this.numberArray = new int[10];
    }

    public CustomIntArray(int size) {
        if (size < 0) {
            throw new ClassCastException("A null object was passed on.");
        }
        this.numberArray = new int[size];
    }

    public CustomIntArray(int[] numberArray) throws CustomArrayException {
        if (numberArray == null) {
            throw new ClassCastException("A null object was passed on.");
        }
        this.numberArray = numberArray;
    }

    public  CustomIntArray(CustomIntArray numberArray) throws CustomArrayException{
        if (numberArray == null) {
            throw new ClassCastException("A null object was passed on.");
        }
        this.numberArray = numberArray.getNumberArray();
    }

    public void setNumberArray(int[] numberArray) {
        if (numberArray == null) {
            throw new ClassCastException("A null object was passed on.");
        }
        this.numberArray = numberArray;
    }

    public int[] getNumberArray() {
        int[] cloneArray = new int[numberArray.length];
        for (int i = 0; i < cloneArray.length; i++) {
            cloneArray[i] = numberArray[i];
        }
        return cloneArray;
    }

    public void setElement(int element, int index) throws CustomArrayException {
        if (isCorrectIndex(index)) {
            this.numberArray[index] = element;
        } else {
            throw new ClassCastException(String.format("Array overrun, array size 10, passed index 2.",
                    numberArray.length, index));
        }
    }

    public int getElement(int index) throws CustomArrayException {
        if (isCorrectIndex(index)) {
            return this.numberArray[index];
        } else {
            throw new ClassCastException(String.format("Array overrun, array size 10, passed index 2.",
                    numberArray.length, index));
        }
    }

    private boolean isCorrectIndex(int index) {
        return index >= 0 && index < numberArray.length;
    }

    public int length() {
        return numberArray.length;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        CustomIntArray array = (CustomIntArray) obj;

        if (numberArray.length != array.length()) {
            return false;
        }
        for (int i = 0; i < array.length(); i++) {
            try {
                if (numberArray[i] != array.getElement(i)) {
                    return false;
                }
            } catch (CustomArrayException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    private String customArrayInfo() {
        StringBuilder info = new StringBuilder();
        for (int element : numberArray) {
            info.append(element).append(" ");
        }
        return info.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        for (int element : numberArray) {
            result = result + element * 31;
        }
        return result;
    }

    public String toString() {
        return String.format("Arrays size - %d,%nElements: %n[ %s]",
                numberArray.length, customArrayInfo());
    }
}