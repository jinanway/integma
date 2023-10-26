import java.util.Scanner;
import java.util.*;
import java.lang.*;
import java.text.DecimalFormat;
public class Encode {
    
    private String phrase;
    private int count1;
    private int count2;
    private int count3;
    private double integral1;
    private double integral2;
    private double integral3;
    private ArrayList<Character> charArray = new ArrayList<Character>();
    ArrayList<Character> alph1 = new ArrayList<Character>();
    ArrayList<Character> alph2 = new ArrayList<Character>();
    ArrayList<Character> alph3 = new ArrayList<Character>();
    ArrayList<Integer> capitalLetters = new ArrayList<Integer>();
    
    public Encode(){
        phrase = "";
        count1 = 1;
        count2 = 1;
        count3 = 1;
    }
    
    public Encode(String word, int counter1, int counter2, int counter3){
        phrase = word;
        count1 = counter1 % 26;
        count2 = counter2 % 26;
        count3 = counter3 % 26;
        integral1 = counter1;
        integral2 = counter2;
        integral3 = counter3;

        alph1 = new ArrayList<Character>(Arrays.asList('a', 'b', 'c', 'd','e', 'f','g', 'h','i', 'j','k', 'l','m', 'n','o', 'p','q', 'r','s', 't','u', 'v','w', 'x','y','z'));
        alph2 = new ArrayList<Character>(Arrays.asList('a', 'b', 'c', 'd','e', 'f','g', 'h','i', 'j','k', 'l','m', 'n','o', 'p','q', 'r','s', 't','u', 'v','w', 'x','y','z'));
        alph3 = new ArrayList<Character>(Arrays.asList('a', 'b', 'c', 'd','e', 'f','g', 'h','i', 'j','k', 'l','m', 'n','o', 'p','q', 'r','s', 't','u', 'v','w', 'x','y','z'));

        for(int i = 0; i < phrase.length(); i++){
            if(Character.isUpperCase(phrase.charAt(i))){
                capitalLetters.add(i);
            }
            charArray.add(Character.toLowerCase(phrase.charAt(i)));
        }
        
        for(int i = 0; i < count1; i++){
            alph1.add(0, alph1.get(alph1.size()-1));
            alph1.remove(alph1.size()-1);
        }
        
        for(int i = 0; i < count2; i++){
            alph2.add(0, alph2.get(alph2.size()-1));
            alph2.remove(alph2.size()-1);
        }
        
        for(int i = 0; i < count3; i++){
            alph3.add(0, alph3.get(alph3.size() - 1));
            alph3.remove(alph3.size() - 1);
        }
    }

    public String Encodalizer(){
        String frase = "";
        int tempNum;
        char temp;
        int j = 0;
        int k = 0;
        int l = 0;
        for(int i = 0; i < charArray.size(); i++){
            if(alph1.indexOf(charArray.get(i)) == -1){
                frase = frase + charArray.get(i);
            } else {
                if(j + count1 > 26){
                    alph2.add(0, alph2.get(alph2.size()-1));
                    alph2.remove(alph2.size()-1);
                    k++;
                    count1 = 0;
                    j = 0;
                    if(k + count2 > 26){
                        alph3.add(0, alph3.get(alph3.size() - 1));
                        alph3.remove(alph3.size() - 1);
                        l++; 
                        k = 0;
                        count2 = 0;
                        if(l + count3 > 26){
                            l = 0;
                            count3 = 0;
                        }
                    }
                }
                tempNum = (alph1.indexOf(charArray.get(i))) % 25;
                tempNum = alph2.indexOf(alph2.get(tempNum % 25));
                tempNum = alph3.indexOf(alph3.get(tempNum % 25));
                temp = alph3.get(tempNum % 25);
                frase = frase + temp;
                temp = ' ';
                alph1.add(0, alph1.get(alph1.size()-1));
                alph1.remove(alph1.size()-1);
                j++;
            }
        }
        char tempChar;
        for(int i = 0; i < capitalLetters.size(); i++){
            tempChar = frase.charAt(capitalLetters.get(i));
            tempChar = Character.toUpperCase(tempChar);
            frase = frase.substring(0, capitalLetters.get(i)) + tempChar + frase.substring(capitalLetters.get(i) + 1);
        }
        return frase;
    }

    public String Decodalizer(){
        String frase = "";
        int tempNum;
        char temp;
        int j = 0;
        int k = 0;
        int l = 0;
        int first = 0;
        int second = 0;
        int third = 0;
        int rotation = 0;
        for(int i = 0; i < charArray.size(); i++){
            if(alph1.indexOf(charArray.get(i)) == -1){
            } else {
                if(j + count1 > 26){
                    alph2.add(0, alph2.get(alph2.size()-1));
                    alph2.remove(alph2.size()-1);
                    k++;
                    j = 0;
                    count1 = 0;
                    first++;
                    if(k + count2 > 26){
                        alph3.add(0, alph3.get(alph3.size() - 1));
                        alph3.remove(alph3.size() - 1);
                        l++;
                        k = 0;
                        count2 = 0;
                        second++;
                        if(l + count3 > 26){
                            l = 0;
                            count3 = 0;
                            third++;
                        }
                    }
                }
                alph1.add(0, alph1.get(alph1.size()-1));
                alph1.remove(alph1.size()-1);
                j++;
            }
        }
        char letter1 = alph1.get(0);
        char letter2 = alph2.get(0);
        char letter3 = alph3.get(0);
        for(int i = charArray.size() - 1; i >= 0; i--){
            if(alph1.indexOf(charArray.get(i)) == -1){
                frase = charArray.get(i) + frase;
            } else {
                if(first > 0){
                    if(second > 0){
                        alph3.add(alph3.get(0));
                        alph3.remove(0);
                        second--;
                        if(third > 0){
                        third--;
                        }
                    }
                    alph2.add(alph2.get(0));
                    alph2.remove(0);
                    first--;
                }
                alph1.add(alph1.get(0));
                alph1.remove(0);
                tempNum = (alph3.indexOf(charArray.get(i))) % 25;
                tempNum = alph2.indexOf(alph2.get(tempNum));
                tempNum = alph1.indexOf(alph1.get(tempNum));
                temp = alph1.get((tempNum));
                frase = temp + frase;
                temp = ' ';
                rotation--;
            }
        }
        char tempChar;
        for(int i = 0; i < capitalLetters.size(); i++){
            tempChar = frase.charAt(capitalLetters.get(i));
            tempChar = Character.toUpperCase(tempChar);
            frase = frase.substring(0, capitalLetters.get(i)) + tempChar + frase.substring(capitalLetters.get(i) + 1);
        }
        return frase;
    }

    public void Integral(){
        DecimalFormat df = new DecimalFormat("#.###");
        int start1 = (int)(Math.random() * 5) + 1;
        double final1 = Math.log(integral1 + Math.exp(start1));
        int start2 = (int)(Math.random() * 5) + 1;
        double final2 = Math.cbrt((integral2 + (Math.pow(start2, 3)/3))*3);
        int start3 = (int)(Math.random() * 5) + 1;
        double final3 = Math.exp(integral3 + Math.log(start3));

        System.out.println("The integral for your first rotor is ∫eˣdx from " + start1 + " to " + df.format(final1) + ",");
        System.out.println("The integral for your second rotor is ∫x²dx from " + start2 + " to " + df.format(final2) + ",");
        System.out.println("and The integral for your third rotor is ∫(1/x)dx from " + start3 + " to " + df.format(final3));
    }

}