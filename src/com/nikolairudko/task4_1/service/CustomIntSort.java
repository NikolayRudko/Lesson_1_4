package com.nikolairudko.task4_1.service;

import com.nikolairudko.task4_1.empty.CustomIntArray;
import com.nikolairudko.task4_1.exception.CustomArrayException;

public class CustomIntSort {

    public CustomIntArray bubbleSortUp(CustomIntArray array) throws CustomArrayException {

        CustomIntArray sortArray = new CustomIntArray(array);

        boolean isSorted = false;
        int temp;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < sortArray.length() - 1; i++) {
                if (sortArray.getElement(i) > sortArray.getElement(i + 1)) {
                    temp = sortArray.getElement(i);
                    sortArray.setElement(sortArray.getElement(i + 1), i);
                    sortArray.setElement(temp, i + 1);
                    isSorted = false;
                }
            }
        }

        return sortArray;
    }

    public CustomIntArray bubbleSortDown(CustomIntArray array) throws CustomArrayException {
        return reverse(bubbleSortUp(array));
    }

    public CustomIntArray insertionSortUp(CustomIntArray array) throws CustomArrayException {

        CustomIntArray sortArray = new CustomIntArray(array);

        for (int i = 1; i < sortArray.length(); i++) {
            int current = sortArray.getElement(i);
            int j = i - 1;
            while (j >= 0 && current < sortArray.getElement(i)) {
                sortArray.setElement(sortArray.getElement(j), j + 1);
                j--;
            }
            sortArray.setElement(current, j + 1);
        }

        return sortArray;
    }

    public CustomIntArray insertionSortDown(CustomIntArray array) throws CustomArrayException {
        return reverse(insertionSortUp(array));
    }

    public CustomIntArray selectionSortUp(CustomIntArray array) throws CustomArrayException {

        CustomIntArray sortArray = new CustomIntArray(array);

        for (int i = 0; i < sortArray.length(); i++) {
            int min = sortArray.getElement(i);
            int minId = i;
            for (int j = i + 1; j < sortArray.length(); j++) {
                if (sortArray.getElement(j) < min) {
                    min = sortArray.getElement(j);
                    minId = j;
                }
            }
            int temp = sortArray.getElement(i);
            sortArray.setElement(min, i);
            sortArray.setElement(temp, minId);
        }

        return sortArray;
    }

    public CustomIntArray selectionSortDown(CustomIntArray array) throws CustomArrayException {
        return reverse(selectionSortUp(array));
    }

    private CustomIntArray reverse(CustomIntArray array) throws CustomArrayException {

        CustomIntArray reverseArray = new CustomIntArray(array.length());

        for (int i = 0; i < reverseArray.length(); i++) {
            reverseArray.setElement(array.getElement(reverseArray.length() - 1 - i), i);
        }
        return reverseArray;
    }
}
