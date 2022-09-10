package com.cakmak.findPath;

import java.util.ArrayList;

public class FindSmallestNumber {
    public static int smallestDistance(ArrayList<Integer> arrayList){
        int smallest=0;
        for(int n = 0; n < arrayList.size(); n++) {
            if(n == 0)
                smallest = arrayList.get(n);

            if(arrayList.get(n) < smallest && arrayList.get(n) !=-1)
                smallest = arrayList.get(n);
        }
        return smallest;
    }
}
