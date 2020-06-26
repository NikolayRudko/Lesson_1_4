package com.nikolairudko.task4_1.main;

import com.nikolairudko.task4_1.empty.CustomIntArray;
import com.nikolairudko.task4_1.service.CustomIntSearch;
import org.w3c.dom.ls.LSOutput;

public class Main {
    public static void main(String[] args) {


        CustomIntSearch search = new CustomIntSearch();

        int[] array = new  int []{ 122, -121, 1222, 14, 1, 189, 447  };

        for (int item: array
             ) {
            System.out.printf("%d - %b %n", item, search.isUniqueNumber(item));
        }


    }
}
