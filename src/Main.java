import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String result = "";

    public static void main(String[] args) throws IOException {
        System.out.println("Enter string to reverse: ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String string = bufferedReader.readLine();

        stringBufferReverse(string);
        iterationReverse(string);
        recursionReverse(string, string.length() - 1);
    }

    static void stringBufferReverse(String string){
        StringBuffer stringBuffer = new StringBuffer();

        /*Get through all string chars, starting from the last. The append function adds the first char on index 0,
        and every char after that is put on index + 1, so we get the reversed string*/
        for(int i = string.length() - 1; i >= 0; i--){
            stringBuffer.append(string.charAt(i));
        }

        System.out.println("Reversed string using StringBuffer: " + stringBuffer.toString());
    }

    static void iterationReverse(String string){
        int halfLength = string.length()/2;
        int tempIndex = string.length() - 1;

        //Separate the string into chars array
        char[] stringChars = string.toCharArray();

        for(int i = 0; i < halfLength; i++){
            //Get the last char
            char tempChar = stringChars[tempIndex];
            /*Replace the char at tempIndex with the char at i index. The tempIndex starts from the last char and
            in every iteration decreases by 1, the i index increases by 1, so we replace every char with the opposite one */
            stringChars[tempIndex] = stringChars[i];
            stringChars[i] = tempChar;
            tempIndex--;
        }
        string = String.valueOf(stringChars);

        System.out.println("Reversed string using iteration: " + string);
    }

    /*The index is the string length - 1. The method calls itself until the index is 0. On every call the index
    is decreased by 1 and the char at this index is added to the result string.*/
    static void recursionReverse(String string, int index){
        char[] stringChars = string.toCharArray();

        if(index == 0){
            result += stringChars[index];
            System.out.print("Reversed string using recursion: " + result);
        }
        else {
            result += stringChars[index];
            recursionReverse(string, index - 1);
        }
    }
}
