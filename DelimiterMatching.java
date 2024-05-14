package delimitermatching;

import java.util.Scanner;
import java.util.Stack;

public class DelimiterMatching {
    
    public static boolean doesMatch(String testString) {
        Stack<Character> delimiterStack = new Stack<>(); //Create a stack called "delimiterStack" to hold the symbols
        
        for (int i = 0; i < testString.length(); i++) { //Construct a for loop to itterate through the length of the input string
            char current = testString.charAt(i); //Create a variable 'c' that hold the character at the "ith"/ current position 
            
            if (current == '(' || current == '[' || current == '{') { //If the value at that index is an open symbol listed
                delimiterStack.push(current); // If so, we are going to push it into the stack we created
            } 
            
            else {
                if (delimiterStack.isEmpty()) //Put the isEmpty condition right after the push if statement to avoid a stack underflow
                    return false; //There is no match, stack is empty
                    char top = delimiterStack.pop(); // Pops the top symbol from the stack"
                if ((current == ')' && top != '(') || (current == ']' && top != '[') || (current == '}' && top != '{')) { //If the current symbol is a closing one AND does not match with the top of the stack...
                    return false; 
                }
            }
        }

        return delimiterStack.isEmpty(); //Return true if its empty (YAY WE HAVE A MATCH!), if not, return false (BOOOO NO MATCH!)
    }

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in); //Create the scanner object called scanner to allow for the users input
        System.out.println("Enter a string to test if your string is matching (keep in mind, only the characters (){}[] are acceptable: ");
        String testString = scanner.nextLine();// Accept the users input as a string
        
        
        //We want to make sure only the 6 symbols are being used in the input string
        if (!testString.matches("[(){}\\[\\]]*")){
        System.out.println("Unacceptable input! Please only use the characters listed above");
        scanner.close();
        return; //If the string contains anything other than the symbols mentioned, terminate the program      
        }
        
        //Check to see if the users string is matching by calling the doesMatch method and printing the results
        boolean result = doesMatch(testString);
        if (result){
            System.out.println("Delimiter DOES match");
        } else {
            System.out.println("Delimiter DOES NOT match");
        }
        
        scanner.close(); //Close the scanner, we dont need it anymore           
        }
        
    }

