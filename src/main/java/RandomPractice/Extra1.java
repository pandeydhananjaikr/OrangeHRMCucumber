package RandomPractice;

import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import static Utils.DriverManager.driver;

public class Extra1 {

    public static void main(String[] args) {

//        String str = "I am an automation engineer";
//
//        String [] strArray = str.split(" ");
//
//        String b = "";
//        for ( String a: strArray) {
//            String firstElement = a.substring(0,1).toUpperCase();
//            String restElement = a.substring(1).toLowerCase();
//            String str1 = firstElement+restElement;
//
//            b = b+str1+" ";
//
//        }
//        System.out.println(b);

        List numbers = new ArrayList();
        numbers.add(1);
        numbers.add(2);

// mistakenly
        numbers.add("test");

// read the numbers
        for (int i = 0; i < numbers.size(); i++) {
            try {
                Integer n = (Integer)numbers.get(i);
                // do something with n
            } catch (ClassCastException e) {
                System.out.println("Unexcepted type " + e.getMessage());
            }
        }






















//        int[] num = {1, 2, 3, -4, 0, 3, 7};
//
//        int a = 0;
//        for (int i = 0; i < num.length; i++) {
//            for (int j = i+1; j < num.length; j++) {
//                if (num[i]<=num[j]){
//                    a = num[i];
//                    num[i] = num[j];
//                    num[j]= a;
//                }
//            }
//        }
//
//        for (int i = 0; i < num.length ; i++) {
//            System.out.print(num[i]+" ");
//        }
    }
}
