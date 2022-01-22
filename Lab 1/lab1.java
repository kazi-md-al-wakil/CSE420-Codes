package javaapplication1;
import java.util.regex.*;
import java.io.*;
import java.util.Arrays;
import java.util.List;
public class lab1
{
    public static void main(String[] args) throws FileNotFoundException, IOException 
    {
        String [] keywords = { "int","abstract", "assert", "boolean",
                "break", "byte", "case", "catch", "char", "class", "const",
                "continue", "default", "do", "double", "else", "extends", "false",
                "final", "finally", "float", "for", "goto", "if", "implements",
                "import", "instanceof", "interface", "long", "native",
                "new", "null", "package", "private", "protected", "public",
                "return", "short", "static", "strictfp", "super", "switch",
                "synchronized", "this", "throw", "throws", "transient", "true",
                "try", "void", "volatile", "while"};
        String [] operators = {"+", "-", "*", "/", "%", "="};
        String [] logicalOperators = {"==", "!=", ">", "<", ">=", "<="};
        
        String [] others= {",", ";", "(",")", "{","}"};

        File file = new File("F:\\BRAC\\Semester 8-Fall'21\\CSE420\\Lab\\Lab 1\\lab01.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        
        String st;
        String [] keywords1 = new String [8]; 
        String [] iden1 = new String [5]; 
        String [] operators1 = new String [3]; 
        String [] logicalOperators1 = new String [1]; 
        String [] values1 = new String [4]; 
        String [] others1 = new String [6]; 

        
        int k =0;
        int op =0;
        int l =0;
        int o =0;
        int v =0;
        int iden=0;

      while ((st = br.readLine())!= null)
      { 

          String [] a = st.split(" ");
          
          //keywords
          for(String string: a)
          {
              for(int j = 0; j<keywords.length; j++)
              {
                    if(string.equals(keywords[j]))
                    {
                        List<String> wordList = Arrays.asList(keywords1);
                        boolean result = wordList.contains(string);
                        if(result == true)
                        {
                        }
                        else
                        {
                            keywords1[k]=string;
                            k++; 
                        }
                    }
              }
          }
          
          //others
          for(String string: a)
          {
              for(int j = 0; j<others.length; j++)
              {
                    if(string.equals(others[j]))
                    {
                        List<String> wordList = Arrays.asList(others1);
                        boolean result = wordList.contains(string);
                        if(result == true)
                        {
                        }
                        else
                        {
                            others1[o]=string;
                            o++; 
                        }
                    }
              }
          }
          //Logical Operators
          for(String string: a)
          {
              for(int j = 0; j<logicalOperators.length; j++)
              {
                    if(string.equals(logicalOperators[j]))
                    {
                        List<String> wordList = Arrays.asList(logicalOperators1);
                        boolean result = wordList.contains(string);
                        if(result == true)
                        {
                        }
                        else
                        {
                            logicalOperators1[l]=string;
                            l++; 
                        }
                    }
              }
          }
          //Math Operators
          for(String string: a)
          {
              for(int j = 0; j<operators.length; j++)
              {
                    if(string.equals(operators[j]))
                    {
                        List<String> wordList = Arrays.asList(operators1);
                        boolean result = wordList.contains(string);
                        if(result == true)
                        {
                        }
                        else
                        {
                            operators1[op]=string;
                            op++; 
                        }
                    }
              }
          }
          //Numerical Values
          for(String string: a)
          {
              Pattern p = Pattern.compile("((0|1|2|3|4|5|6|7|8|9)+)((.(0|1|2|3|4|5|6|7|8|9)+)?)");
              Matcher m = p.matcher(string);  
              boolean b = m.matches();  
              if (b==true)
              {
                  List<String> wordList = Arrays.asList(values1);
                  boolean result = wordList.contains(string);
                  if(result == true)
                  {
                  }
                  else
                  {
                      values1[v]=string;
                      v++;
                  }
              }
          }
          //identifiers
          for(String string: a)
          {
              Pattern p = Pattern.compile("^([a-zA-Z_$][a-zA-Z\\\\d_$]*)$");
              Matcher m = p.matcher(string);  
              boolean b = m.matches();  
              if (b==true)
              {
                  List<String> wordList1 = Arrays.asList(keywords1);
                  boolean result1 = wordList1.contains(string);
                  
                  List<String> wordList = Arrays.asList(iden1);
                  boolean result2 = wordList.contains(string);
                  
                  if(result1 == false)
                  {
                      if (result2 == true)
                      {
                      }
                      else
                      {
                          iden1[iden]=string;
                          iden++;
                      }   
                  }
              }
          }
      }

      System.out.print("Keywords: ");
      int b1 = 0;
      while(keywords1[b1]!= null)
      {
          System.out.print(keywords1[b1]+">>>");
          b1++;
      }
      for(String string: keywords1)
      {
          System.out.print(string+",");
      }
      System.out.println("");
      //-------

      System.out.print("Identifiers: ");
      for(String string: iden1)
      {
          System.out.print(string+",");
      }
      System.out.println("");
      
      //-------
      
      System.out.print("Math Operators: ");
      for(String string: operators1)
      {
          System.out.print(string+",");
      }
      System.out.println("");
      //-------
      
      System.out.print("Logical Operators: ");
      for(String string: logicalOperators1)
      {
          System.out.print(string+" ");
      }
      System.out.println(" ");
      //-------
      System.out.print("Values: ");
      for(String string: values1)
      {
          System.out.print(string+",");
      }
      System.out.println("");
      //-------
      System.out.print("Others: ");
      for(String string: others1)
      {
          System.out.print(string+" ");
      }
      System.out.println("");
    }
}
