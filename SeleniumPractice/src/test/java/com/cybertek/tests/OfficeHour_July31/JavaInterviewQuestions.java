package com.cybertek.tests.OfficeHour_July31;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class JavaInterviewQuestions {

    public static void sortArrayNoSortMethod(int [] nums){
        int temp;
        for(int i = 0; i< nums.length; i++){

            for (int j=0; j < nums.length-1; j++){
                if(nums[j]< nums[j+1]){
                    temp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = temp;

                }
            }

        }
        System.out.println(Arrays.toString(nums));

    }

    public static void main(String[] args) {
        int [] arr = {9,7,6,5,4,3,6,7,8};
        //System.out.println(JavaInterviewQuestions.sortArrayNoSortMethod(arr);));
        JavaInterviewQuestions.sortArrayNoSortMethod(arr);

        Map<String, Integer> myMap = countLetters("level");
        System.out.println(myMap);
    }

    public static Map<String, Integer> countLetters(String name){
        Map<String, Integer> map = new HashMap<String, Integer>();
        char [] ch = name.toCharArray();
        for (char c : ch){
            String result = c+"";
            if(!map.containsKey(result)){
                map.put(result, 1);
            } else {
                map.put(result, result.length() + 1);
            }
        }
        return map;
    }
}
