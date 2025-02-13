import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * A tokenizer that converts text input to lowercase and splits it 
 * into a list of tokens, where each token is either a word or a period.
 */
public class LowercaseSentenceTokenizer implements Tokenizer {
  /**
   * Tokenizes the text from the given Scanner. The method should 
   * convert the text to lowercase and split it into words and periods.
   * Words are separated by spaces, and periods are treated as separate tokens.
   * 
   * For example:
   * If the input text is: "Hello world. This is an example."
   * The tokenized output should be: ["hello", "world", ".", "this", "is", "an", "example", "."]
   * 
   * Notice that the text is converted to lowercase, and each period is treated as a separate token.
   * 
   * However, a period should only be considered a separate token if it occurs at the end
   * of a word. For example:
   * 
   * If the input text is: "Hello world. This is Dr.Smith's example."
   * The tokenized output should be: ["hello", "world", ".", "this", "is", "dr.smith's", "example", "."]
   * 
   * The internal period in Dr.Smith's is not treated as its own token because it does not occur at the end of the word.
   * 
   * @param scanner the Scanner to read the input text from
   * @return a list of tokens, where each token is a word or a period
   */
  public List<String> tokenize(Scanner scanner) {
    // TODO: Implement this function to convert the scanner's input to a list of words and periods
    
    String input = scanner.nextLine();

    String Lowered = input.toLowerCase();
    // \\w captures a word string,
    // \\. captures a period,
    // I utilized negative lookbehind and negative lookahead regex expressions, 
    String moveCharacters = Lowered.replaceAll("(?<!\\w)\\.(?!\\w)", " . ") //this replacement checks for a word infront and behind the period if found, and singles out the period
    .replaceAll("(\\w)\\.(\\w)", "$1.$2") //this replacement checks for a period surrounded by words, the \\w checks what is arround and inits its findings to the first and second capturing group
    .replaceAll("\\.(?!\\w)", " . ")//this replacement checks for a period followed by no word string
    .replace(",", " , ")
    .replace("'", "'");

    String[] convertToArray = moveCharacters.split("\\s+"); //Found this for help https://stackoverflow.com/questions/7899525/how-to-split-a-string-by-space \s finds white space tabs, spaces, newlines + finds multiple.
    
    return Arrays.asList(convertToArray);


  }
}

