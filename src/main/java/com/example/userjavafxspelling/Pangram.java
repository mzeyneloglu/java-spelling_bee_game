package com.example.userjavafxspelling;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Pangram {

    // Method
    public HashSet<String> getPangramList(HashSet<String> wordList) throws IOException {

        // Random Char Generator
        RandomCharGenerator charGenerator = new RandomCharGenerator();

        // Pangram Word List
        HashSet<String> pangramWords = new HashSet<>();

        // Read the Word List
        String alphaPath = "src/main/resources/com/example/userjavafxspelling/alphabet.txt";
        Iterator<String> itr = wordList.iterator();

        // Iteration Word List
        String data;
        while(itr.hasNext()){
            // Counter of matches characters
            int counter = 0;
            data = itr.next();

            char [] charCharacters = data.toCharArray();
            ArrayList<Character> charWordList = new ArrayList<>();

            for(Character ch : charCharacters)
                charWordList.add(ch);

            // Alphabets Text File Reader
            WordListReader reader = new WordListReader(alphaPath);
            HashSet<String> arrayList = reader.wordReader();
            Iterator<String> stringIterator = arrayList.iterator();

            // Iteration Alphabet List
            while(stringIterator.hasNext()){
                String alphabet = stringIterator.next();
                if(charWordList.contains(alphabet.charAt(0)) )
                    counter++;
            }
            // Find 7 different characters word
            if (counter == 7)
                pangramWords.add(data);

            // Clear charWordList
            charWordList.clear();

        }
        return pangramWords;
    }
    public void truePangrams(){
        String midString;
        Scanner wrongpangramScanner=null,alphabetScanner=null,dictionaryScanner=null;

        File wrongpangramFile=new File("src/main/resources/com/example/userjavafxspelling/eskipangrams.txt");
        File readalphabetFile=new File("src/main/resources/com/example/userjavafxspelling/alphabet.txt");
        File readworddictionaryFile=new File("src/main/resources/com/example/userjavafxspelling/sozluk.txt");
        File truepangramFile=new File("src/main/resources/com/example/userjavafxspelling/pangrams.txt");//

        // Array List
        ArrayList<Character> wrongletterArrayList=new ArrayList<Character>();
        ArrayList<Character> trueletterArrayList=new ArrayList<Character>();
        ArrayList<String> temptrueArrayList=new ArrayList<String>();
        ArrayList<String> truepangramArrayList=new ArrayList<String>();

        try
        {
            wrongpangramScanner= new Scanner(wrongpangramFile);
            while (wrongpangramScanner.hasNext())
            {
                String tempwrongpangramString=wrongpangramScanner.next();
                alphabetScanner =new Scanner(readalphabetFile);
                try
                {
                    while (alphabetScanner.hasNext())
                    {
                        String letterString= alphabetScanner.next();
                        if(tempwrongpangramString.contains(letterString))
                            trueletterArrayList.add(letterString.charAt(0));

                        else
                            wrongletterArrayList.add(letterString.charAt(0));
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                System.out.println(" "+ wrongletterArrayList+" " );
                System.out.println(" "+ trueletterArrayList+" " );

                for(int index=0;index<trueletterArrayList.size();index++)
                {
                    midString=trueletterArrayList.get(index).toString();
                    System.out.println(" "+ midString+" " );
                    try
                    {
                        dictionaryScanner = new Scanner(readworddictionaryFile,"UTF-8");
                        while (dictionaryScanner.hasNextLine())
                        {
                            boolean checkBit=true;
                            String dictionarywordString=dictionaryScanner.next();
                            if(dictionarywordString.length()>3)
                            {
                                for(int i=0;i<wrongletterArrayList.size();i++)
                                {
                                    if(dictionarywordString.contains(wrongletterArrayList.get(i).toString()))
                                    {
                                        checkBit=false;
                                        System.out.println(" "+tempwrongpangramString+" "+dictionarywordString+" "+ wrongletterArrayList.get(i)+" "+checkBit );
                                        break;
                                    }
                                }
                                if(checkBit)
                                {
                                    int counter = 0;
                                    for(int j=0;j<trueletterArrayList.size();j++)
                                    {
                                        if(dictionarywordString.contains(trueletterArrayList.get(j).toString()))
                                        {
                                            counter++;
                                            System.out.println("sy "+counter+" "+trueletterArrayList.get(j) +" sy");
                                        }
                                    }
                                    if(counter > 3)
                                    {
                                        temptrueArrayList.add(dictionarywordString);
                                        System.out.println("---"+dictionarywordString+"---");
                                    }
                                }
                            }
                        }
                        if(temptrueArrayList.size()>20  )
                        {
                            if(temptrueArrayList.size()<80)
                            {
                                if(!truepangramArrayList.contains(tempwrongpangramString))
                                {
                                    truepangramArrayList.add(tempwrongpangramString);
                                    System.out.println("*"+tempwrongpangramString+"*");
                                }
                            }
                        }
                        temptrueArrayList.clear();
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
                wrongletterArrayList.clear();
                trueletterArrayList.clear();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        try
        {
            FileWriter trueFileWriter=new FileWriter(truepangramFile,false);
            BufferedWriter trueBufferedWriter= new BufferedWriter(trueFileWriter);
            for(int i=0;i<truepangramArrayList.size();i++)
            {
                System.out.print("--"+i+"  "+truepangramArrayList.get(i)+ "--" );
                trueBufferedWriter.write(truepangramArrayList.get(i).toUpperCase());
                trueBufferedWriter.write(System.getProperty("line.separator"));
            }
            trueBufferedWriter.close();
            trueFileWriter.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
