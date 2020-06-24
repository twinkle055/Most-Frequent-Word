
/**
 * Write a description of CharactersInPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;

public class CharactersInPlay {
    
    private ArrayList<String> names;
    private ArrayList<Integer> count;
    
    public CharactersInPlay(){
        names = new ArrayList<String>();
        count = new ArrayList<Integer>();
    }
    
    public void update(String person){
        int index = names.indexOf(person);
        if(index == -1)
        {
            names.add(person);
            count.add(1);
        }
        else
        {
            int value = count.get(index);
            count.set(index, value+1);
        }
    }
    
    public void findAllCharacters(){
        FileResource fr = new FileResource();
        for(String line : fr.lines())
        {
            int index = line.indexOf(".");
            if(index != -1)
            {
                String n = line.substring(0, index);
                update(n);
            }
        }
    }
       
    public void tester(int avg){
        names.clear();
        count.clear();
        findAllCharacters();
        for(int i=0; i<count.size(); i++)
        {
            if(count.get(i) > avg)
            {
                System.out.println(names.get(i) + "\t" + count.get(i));
            }
        }
    }
    
    public void charactersWithNumParts(int num1, int num2){
        for(int i=0; i<count.size(); i++)
        {
            if(count.get(i) >= num1 && count.get(i) <= num2)
            {
                System.out.println(names.get(i) + "\t" + count.get(i));
            }
        }
    }
}
