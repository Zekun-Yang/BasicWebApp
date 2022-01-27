package com.develogical;

import java.util.Arrays;

public class QueryProcessor {

    public String process(String query) {
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }

        if (query.toLowerCase().contains("imperial")) {
            return "Imperial College is a university in London";
        }

        if (query.toLowerCase().contains("zekun")) {
            return "Hi! Zekun Yang";
        }

        if(query.toLowerCase().contains(("name"))) {
            return "Alpha";
        }

        if (query.toLowerCase().contains("largest:")){
            String[] tmp =  query.toLowerCase().split(" ");
            String[] nums = Arrays.copyOfRange(tmp, 1, tmp.length);
            int largest = Integer.parseInt( nums[0]);
            for (String s : nums){
                int tmp2 = Integer.parseInt(s);
                if (tmp2 > largest){
                    largest = tmp2;
                }
            }

            return String.valueOf(largest);

        }
        return "";
    }
}
