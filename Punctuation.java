//Richard Li
//12-11-2024
//Punctuation.java
//This program outputs the words that contain punctuation given a string
/* 
 * Pseudocode: 
 * in main, call searchIt(), pass in text variable as parameter.
 * D&I start/end variable, iterate through each character until you find a space using getPunctuationWords().
 * if a space is found, then the word will be a substring from start to end.
 * check if the substring(word) has punctuation using the method checkForPunctuation() by 
 * going through all punctuation marks and seeing if they a match a letter from the word.
 * if the word has punctuation, add it to result.
 * set start to end.
 * at the end, print Punctuationwords(result) using the printWords() method by passing it in as a parameter.
*/

public class Punctuation 
{

    // Main method - entry point of the program
    public static void main(String[] args) 
    {
        //create instance of Punctuation called p
        Punctuation p = new Punctuation();
        // Sample text input
        String text = "Blood, Sweat, and Tears by Winston Churchill " +
"May 13, 1940" +
"Mr. Speaker:" +
"On Friday evening last I received His Majesty’s commission to form a new " +
"Administration. It was the evident wish and will of Parliament and the nation that this should be conceived on the broadest possible basis and that it should " +
"include all parties, both those who supported the late Government and also the parties of the Opposition." +
"I have completed the most important part of this task. A War Cabinet has been formed of five Members, representing, with the Liberal Opposition, the unity of the nation." +
"The three party Leaders have agreed to serve, either in the War Cabinet or in high executive office. The three Fighting Services have been filled. It was necessary " +
"that this should be done in one single day, on account of the extreme urgency and rigour of events. A number of other key positions were filled yesterday, and I am "
+ "spite of all terror, victory, however long and hard the road may be; for without victory, for all that the British Empire has stood for, no survival for the urge and impulse of the"
+ "ages, that mankind will move forward towards its goal. " +
"But I take up my task with buoyancy and hope. I feel sure that our cause will not be suffered to fail among men. At this time I feel entitled to claim the aid of all, " +
"and I say, \"Come then, let us go forward together with our united strength.\"";
        
        // Calling the method searchIt to process the text
        p.searchIt(text);
    }

    // Method to search for punctuation-containing words and print them
    public void searchIt(String text) 
    {
        System.out.print("\n\n\n");
        // Get words with punctuation
        String punctuationWords = getPunctuationWords(text);
        
        // Print the words that have punctuation
        printWords(punctuationWords);
        System.out.println("\n\n\n");
    }

    // Method to get words that contain punctuation
    public String getPunctuationWords(String text) 
    {
        String result = "";
        
        int start = 0;
        for (int i = 0; i < text.length(); i++) 
        {
            if (text.charAt(i) == ' ' || i == text.length() - 1) 
            {
                
                // Use if-else statement to determine the end of the word
                int endIndex;
                if (i == text.length() - 1) 
                {
                    endIndex = i + 1;  // Include the last character
                } 
                else 
                {
                    endIndex = i;  // Regular case: don't have the space
                }

                // Extract the word and check for punctuation
                String word = text.substring(start, endIndex);
                
                // Check if the word has punctuation
                if (checkForPunctuation(word)) 
                {
                    // If punctuation is found, add the word to the result
                    if(start == 0)
                      result += word;
                    else
                      result += (" " + word);
                }
                // Set the start index
                start = i + 1;
            }
        }
        
        // Return the string containing words with punctuation
        return result;
    }

    // Method that checks if a word contains punctuation using .equals() and charAt()
    public boolean checkForPunctuation(String word) 
    {
        String punctuationMarks = ",.!?;:";

        // go through each character
        for (int i = 0; i < word.length(); i++) 
        {
            // Get the current character
            char currentChar = word.charAt(i);
            
            // Iterate through each character in the punctuationMarks string
            for (int j = 0; j < punctuationMarks.length(); j++) 
            {
                // Compare the character with punctuation
                if (currentChar == punctuationMarks.charAt(j)) 
                {
                    return true; // Return true if punctuation is there
                }
            }
        }
        return false; // Return false if there isn't punctuation
    }

    // Method to print each word that contains punctuation
    public void printWords(String words) 
    {
        // print the word
        System.out.print(words);
    }
}
