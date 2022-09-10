package com.cakmak.findPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CalculatePaths {
    public String findShortestPath(int start, Integer[][] arr){
        HashMap<Character, List<Integer>> provincesAndDistancesOfProvincesToOtherCities = new HashMap<>();
        for (int i = 0,j=65; i < arr.length; i++,j++) {
            provincesAndDistancesOfProvincesToOtherCities.put((char) j, Arrays.stream(arr[i]).toList());
        }

        List<String> hashMapKey = new ArrayList<>();
        for (Character key : provincesAndDistancesOfProvincesToOtherCities.keySet()) {
            hashMapKey.add(String.valueOf(key));
        }

        Permutations<String> permutations = new Permutations<>(hashMapKey);
        ArrayList possibilities=new ArrayList();
        for (List<String> permutation : permutations) {
            possibilities.add(permutation);
        }

        HashMap<Integer,Character> index=new HashMap<>();
        HashMap<Integer,String> probabilityAndDistance=new HashMap<>();
        ArrayList<Integer> distances=new ArrayList();
        String result="";
        for (int i = 0; i <hashMapKey.size(); i++) {
            if (start==i){
                String onePossibility="";
                for (int j = 0; j < possibilities.size()/hashMapKey.size(); j++) {
                    onePossibility = String.valueOf(possibilities.get(j + possibilities.size()/hashMapKey.size()*i));

                    for (int k = 1,a=0; k < onePossibility.length(); k=k+3,a++) {
                        index.put(Integer.valueOf(a),Character.valueOf(onePossibility.charAt(k)));
                    }


                    Integer totalDistance=0;
                    boolean isThereNoWay = false;
                    for (int k = 0; k < index.size()-1; k++) {
                        if (isThereNoWay){
                            break;
                        }
                        List<Integer> distanceToOtherCities=provincesAndDistancesOfProvincesToOtherCities.get(index.get(k));
                        Character nextCity = null;
                        if ((k+1) < index.size()){
                            nextCity=index.get(k+1);
                        }

                        int l=65;
                        while (true){
                            if (Integer.valueOf(nextCity)==l){
                                Integer distance=distanceToOtherCities.get(l-65);
                                if (distance == -1){
                                    totalDistance=-1;
                                    isThereNoWay = true;
                                }else {
                                    totalDistance=totalDistance+distance;
                                }
                                break;
                            }
                            l++;
                        }


                    }
                    if (totalDistance!=-1) {
                        probabilityAndDistance.put(totalDistance, onePossibility);
                    }
                    distances.add(totalDistance);
                    index.clear();
                }

                int smallestDistance = FindSmallestNumber.smallestDistance(distances);

                result = probabilityAndDistance.get(smallestDistance)+" = "+smallestDistance;
            }
        }

        return result;
    }
}
