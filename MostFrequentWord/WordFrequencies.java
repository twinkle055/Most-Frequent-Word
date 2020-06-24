
/**
 * Write a description of WordFrequencies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*; 

public class WordFrequencies {
    
    private ArrayList<String> myWords; 
    private ArrayList<Integer> myFreqs; 
    
    public WordFrequencies(){
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    
    public void findUnique(){
        myWords.clear();
        myFreqs.clear();
        FileResource fr = new FileResource();
        for(String s : fr.words())
        {
            s = s.toLowerCase();
            int index = myWords.indexOf(s);
            if(index == -1)
            {
                myWords.add(s);
                myFreqs.add(1);
            }
            else
            {
                int value = myFreqs.get(index);
                myFreqs.set(index, value+1);
            }
        }
    }
    
    public void tester(){
        findUnique();
        for(int i=0; i<myFreqs.size(); i++)
        {
            System.out.println(myFreqs.get(i) +"\t" + myWords.get(i));
        }
        int index = findIndexOfMax();
        System.out.println("Number of unique words = " + myFreqs.size());
        System.out.println("The word that occurs maximum times is \"" + myWords.get(index) + "\" and it occurs " + myFreqs.get(index) + " times.");
    }
    
    public int findIndexOfMax(){
        int index = -1;
        int max = 0;
        for(int i=0; i<myFreqs.size(); i++)
        {
            if(myFreqs.get(i) > max)
            {
                max = myFreqs.get(i);
                index = i;
            }
        }
        return index;
    }
}
