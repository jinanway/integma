import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the ENIGMA");
        directions();
    }
    public static void directions(){
        Scanner sc = new Scanner(System.in);
        System.out.println("If you want to encode a message type Encode, if you want to decode a message type Decode");
        String choice = sc.nextLine();
        if (choice.equals("Encode")){
            System.out.println("What is the phrase you want to encode?"); 
            String phrase = sc.nextLine();
            System.out.println("What is your first rotor?");
            int num1 = sc.nextInt();
            System.out.println("What is your second rotor?");
            int num2 = sc.nextInt();
            System.out.println("What is your third rotor?");
            int num3 = sc.nextInt();
            Encode thing = new Encode(phrase, num1, num2, num3); 
            System.out.println("Your encoded phrase is " + thing.Encodalizer());
            thing.Integral();
        } else if(choice.equals("Decode")){
            System.out.println("What is the phrase you want to decode?");
            String dePhrase = sc.nextLine();
            System.out.println("What is the first rotor of the encryption?");
            int deNum1 = sc.nextInt();
            System.out.println("What is the second rotor of the encryption?");
            int deNum2 = sc.nextInt();
            System.out.println("What is the third rotor of the encryption?");
            int deNum3 = sc.nextInt();
            Encode deThing = new Encode(dePhrase, deNum1, deNum2, deNum3);
            System.out.println("Your decoded phrase is " + deThing.Decodalizer());
        } else {
            System.out.println("Please type either Encode or Decode, is case sensitive");
            directions();
        }
    }
}
