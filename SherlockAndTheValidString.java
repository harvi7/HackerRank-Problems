import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        
        Map<Character, Integer> frequencies = new HashMap<>();
        
        for(char letter : s.toCharArray())
        {
            if(frequencies.containsKey(letter))
                frequencies.put(letter, frequencies.get(letter) + 1);
            else
                frequencies.put(letter, 1);
        }
           
        Set<Integer> freqSet = new HashSet<>();
        for(int freq : frequencies.values())
        {
            freqSet.add(freq);
        }
        
        if(freqSet.size() > 2)//More than 2 frequencies
            System.out.println("NO");
        else if(freqSet.size() == 1)
            System.out.println("YES");
        else//2 different frequencies
        {
            List<Integer> setList = new ArrayList<Integer>(freqSet);
            int f1 = setList.get(0);
            int f2 = setList.get(1);
            int f1Count = 0;
            int f2Count = 0;
            
            for(int freq : frequencies.values())
            {
                if(freq == f1) f1Count++;
                if(freq == f2) f2Count++;
            }      
            
            if((f1 == 1 && f1Count == 1 ) || (f2 == 1 && f2Count == 1 ))
                System.out.println("YES");
            else if ((Math.abs(f1 - f2)  == 1) && (f1Count == 1 || f2Count == 1))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}