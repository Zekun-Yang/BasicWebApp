package com.develogical;

import java.util.Arrays;

public class QueryProcessor {
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    static boolean isPrime(int n)
    {
        // Corner case
        if (n <= 1)
            return false;

        // Check from 2 to n-1
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;

        return true;
    }

    public String process(String query)  {

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

        if (query.toLowerCase().contains("which of the following numbers is the largest:")){
            String[] tmp =  query.toLowerCase().split(" ");
            String[] nums = Arrays.copyOfRange(tmp, 8, tmp.length);
            int largest = Integer.parseInt(nums[0]);
            for (String s : nums){
                int tmp2 = Integer.parseInt(s);
                if (tmp2 > largest){
                    largest = tmp2;
                }
            }

            return String.valueOf(largest);

        }


        if (query.toLowerCase().contains("what is") && query.toLowerCase().contains("plus") && query.toLowerCase().contains("minus")) {
            String[] tmp = query.toLowerCase().split(" ");
            int op = -1;
            for (String s:tmp){
                if (s.equals("plus")){
                    op = 0;
                    break;
                }else if(s.equals("minus")){
                    op = 1;
                    break;
                }
            }

            int result = 0;

            if (op == 0){
                for (String s:tmp){
                    if (isNumeric(s)){
                        result += Integer.parseInt(s);
                    }
                }
                return String.valueOf(result);

            }else{
                for (String s:tmp){
                    if (isNumeric(s)){
                        result = Integer.parseInt(s);
                        break;
                    }
                }
                for (String s:tmp){
                    if (isNumeric(s)){
                        result -= Integer.parseInt(s);
                    }
                }

                return String.valueOf(result);
            }




        }

        return "";
    }
}
