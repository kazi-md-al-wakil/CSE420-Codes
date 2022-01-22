package cse420.codes;
import java.util.Scanner;
public class Lab2_19301051
{
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner (System.in);
        System.out.println("How many lines: ");
        int val = sc.nextInt();
        int inputNo = 1;
        
        for (int j = 0; j < val; j++)
        {
            System.out.println("Please give input: ");
            String input = sc.next();
            System.out.println(input);
            int cIndex = 0;
            int state = 0;
            boolean m = false; //for email
            boolean n = false; //for web
            boolean o = false;

            while(true)
            {
                switch(state)
                {
                    case 0: //Common state for both mail and website
                        if (cIndex <input.length())
                        {
                            char c=input.charAt(cIndex);
                            cIndex++;
                            if(Character.isLetter(c)==true)
                            {
                                state = 1;
                            }
                            else
                            {
                                state = 6;
                            }
                        }
                        break;
                    case 1: //Common state for both mail and website
                        if (cIndex <input.length())
                        {
                            char c=input.charAt(cIndex);
                            cIndex++;
                            if (c == '@')
                            {
                                state = 2;
                            }
                            else if (c == '.')
                            {
                                state = 7; 
                            }
                            else if (Character.isLetter(c)==true || Character.isDigit(c)==true)
                            {
                                state = 1;
                            }
                        }
                        break;
                    case 2: //from this state email will be found
                        if (cIndex <input.length())
                        {
                            char c=input.charAt(cIndex);
                            cIndex++;
                            if(Character.isLetter(c)==true)
                            {
                                state = 3;
                            }
                            else
                            {
                                state = 6;
                            }
                            
                        }
                        break;   
                    case 3:
                        if (cIndex <input.length())
                        {
                            char c=input.charAt(cIndex);
                            cIndex++;
                            if(c == '.')
                            {
                                state = 4;
                            }
                            else if (Character.isLetter(c)==true)
                            {
                                state = 3;
                            }
                            else
                            {
                                state = 6;
                            }
                        }
                        break;
                    case 4:
                        if (cIndex <input.length())
                        {
                            char c=input.charAt(cIndex);
                            cIndex++;
                            if (Character.isLetter(c)==true)
                            {
                                state = 5;
                            }
                            else
                            {
                                state = 6;
                            }
                        }
                        break;
                    case 5: //final state for email 
                        if (cIndex <input.length())
                        {
                            char c=input.charAt(cIndex);
                            cIndex++;
                            if (Character.isLetter(c)==true && cIndex == input.length())
                            {
                                m = true;
                                state = 5;
                            }
                            else if (Character.isLetter(c)==true)
                            {
                                state = 5;
                            }
                            else
                            {
                                state = 6;
                            }
                        }
                        break;
                    case 6: //trap state
                        if (cIndex <input.length())
                        {
                            char c = input.charAt(cIndex);
                            cIndex++;
                            o = true;
                            state = 6;
                        }
                        else
                        {
                            o = true;
                        }
                        break;
                    case 7: //from this state website url will be found
                        if (cIndex <input.length())
                        {
                            char c = input.charAt(cIndex);
                            cIndex++;
                            if (Character.isLetter(c)==true || Character.isDigit(c)==true)
                            {
                                state = 8; 
                            }
                            else if (c == '@' || c == '.')
                            {
                                state = 6;
                            }
                        }
                        break;
                    case 8:
                        if (cIndex <input.length())
                        {
                            char c = input.charAt(cIndex);
                            cIndex++;
                            if (c == '.')
                            {
                                state = 9; 
                            }
                            else if (Character.isLetter(c)==true || Character.isDigit(c)==true)
                            {
                                state = 8;
                            }
                            else
                            {
                                state = 6;
                            }
                        }
                        break;
                    case 9:
                        if (cIndex <input.length())
                        {
                            char c = input.charAt(cIndex);
                            cIndex++;
                            if (Character.isLetter(c)==true)
                            {
                                state = 10; 
                            }
                            else
                            {
                                state = 6;
                            }
                        }
                        break;
                    case 10:
                        if (cIndex <input.length())
                        {
                            char c = input.charAt(cIndex);
                            cIndex++;
                            if (Character.isLetter(c)==true && cIndex == input.length())
                            {
                                n = true;
                                state = 10; 
                            }
                            else if ( Character.isLetter(c)==true )
                            {
                                state = 10; 
                            }
                            else if (c == '.')
                            {
                                state = 9;
                            }
                            else
                            {
                                state = 6;
                            }
                        }
                        break;
                }
                if (m == true)
                {
                    System.out.println("Email, "+ inputNo);
                    inputNo++;
                    System.out.println("");
                    break;
                }
                else if (n == true)
                {
                    System.out.println("Web, "+ inputNo);
                    inputNo++;
                    System.out.println("");
                    break;
                }
                else if ( o == true)
                {
                    System.out.println("Neither email nor web.");
                    System.out.println("");
                    inputNo++;
                    break;
                }
            }
        }
    }
}
