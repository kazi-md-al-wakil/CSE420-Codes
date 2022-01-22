package cse420.codes;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Lab3_19301051
{
    public static void main(String[] args)
    {
        String [] arrP1 = new String [100];
        String [] arrS2 = new String [100];
        
        Scanner sc = new Scanner (System.in);
        
        System.out.println("How many patterns: ");
        int num1 = sc.nextInt();
        
        System.out.println("Your patterns: ");
        
        for (int i = 1; i < num1+1; i++)
        {
            String s = sc.next();
            arrP1[i] = s;
            
        }
        System.out.println("How many inputs: ");
        int num2 = sc.nextInt();
        
        System.out.println("Your inputs: ");
        
        for (int i = 0; i < num2; i++)
        {
            String s = sc.next();
            arrS2[i] = s;
        }
        System.out.println("Outputs: ");
        for (int i = 0; i < num2; i++)
        {
            int gob = 0;
            for (int j = 1; j < num1+1; j++)
            {
                Pattern r = Pattern.compile(arrP1[j]);
                Matcher m = r.matcher(arrS2[i]);
                if (m.find())
                {
                    System.out.println("Yes, " + j);
                }
                else
                {
                    gob++;
                }
            }
            if(gob == num1)
            {
                System.out.println("No, "+ 0);
            }
        }
        
    }
}
