package com.mycompany.app;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;


/*
    1) We convert each integer in firstArray and secondArray to its corresponding
    ASCII character using a cast to (char).
    2) We then concatenate these ASCII characters into concatenatedString.
    3) Then it repeats concatenatedString multiplier times and appends lastChar which is letter to the end.
    4) Finally, it returns the resulting string.

*/
public class App 
{
    public static String stringManipulation(ArrayList<Integer> firstArray, ArrayList<Integer> secondArray, int multiplier, char lastChar) {

        StringBuilder concatenatedString = new StringBuilder();

        // check if the arrays are empty
        if (firstArray.isEmpty() || secondArray.isEmpty()) {
            return null;
        }

        // check if the multiplier is non-negative
        if (multiplier < 0) {
            return null;
        }

        // check if the lastChar is proper character
        if (!Character.isLetter(lastChar)) {
            return null;
        }

        // Convert firstArray to string and append to concatenatedString
        for (int num : firstArray) {
            concatenatedString.append((char) num);
        }

        // Convert secondArray to string and append to concatenatedString
        for (int num : secondArray) {
            concatenatedString.append((char) num);
        }

        // Create the final string by repeating concatenatedString 'multiplier' times
        StringBuilder finalString = new StringBuilder();
        for (int i = 0; i < multiplier; i++) {
            finalString.append(concatenatedString);
        }

        // Append the lastChar to the final string
        finalString.append(lastChar);

        return finalString.toString();
    }

    public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {
            //System.out.println(req.queryParams("input1"));
            //System.out.println(req.queryParams("input2"));

            String input1 = req.queryParams("input1");
            java.util.Scanner sc1 = new java.util.Scanner(input1);
            sc1.useDelimiter("[;\r\n]+");
            java.util.ArrayList<Integer> inputList1 = new java.util.ArrayList<>();
            while (sc1.hasNext())
            {
                int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
                inputList1.add(value);
            }
            System.out.println(inputList1);

            String input2 = req.queryParams("input2");
            java.util.Scanner sc2 = new java.util.Scanner(input2);
            sc2.useDelimiter("[;\r\n]+");
            java.util.ArrayList<Integer> inputList2 = new java.util.ArrayList<>();
            while (sc2.hasNext())
            {
                int value = Integer.parseInt(sc2.next().replaceAll("\\s",""));
                inputList2.add(value);
            }
            System.out.println(inputList2);


            String input3 = req.queryParams("input3").replaceAll("\\s","");
            int input3AsInt = Integer.parseInt(input3);

            String input4 = req.queryParams("input4").replaceAll("\\s","");
            char input4AsInt = input4.charAt(0);

            String result = App.stringManipulation(inputList1, inputList2, input3AsInt, input4AsInt);

            Map map = new HashMap();
            map.put("result", result);
            return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
                (rq, rs) -> {
                    Map map = new HashMap();
                    map.put("result", "not computed yet!");
                    return new ModelAndView(map, "compute.mustache");
                },
                new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

}
