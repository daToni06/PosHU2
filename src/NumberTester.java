import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class NumberTester{
    private String fileName;
    private NumberTest oddTester;
    private NumberTest primeTester;
    private NumberTest palindromeTester;
    public NumberTester(String fileName) {
        //TODO
        this.fileName=fileName;
    }
    public void setOddEvenTester(NumberTest oddTester){
        this.oddTester = oddTester;

    }
    public void setPrimeTester(NumberTest primeTester){
        this.primeTester=primeTester;
    }
    public void setPalindromeTester(NumberTest palindromeTester){
        this.palindromeTester=palindromeTester;
    }
    public void testFile(){
        try {
            List<String> fileOutput = Files.readAllLines(Path.of(fileName));
            int n = Integer.parseInt(fileOutput.get(0));
            for (int i = 1; i <= n; i++) {
                String[] currentLine = fileOutput.get(i).split(" ");
                int toTest = Integer.parseInt(currentLine[0]);
                int testNumber = Integer.parseInt(currentLine[1]);
                String result = switch (toTest) {
                    case 1 -> oddTester.testNumber(testNumber) ? "ODD" : "EVEN";
                    case 2 -> primeTester.testNumber(testNumber) ? "DIVIDABLE" : "PRIME";
                    case 3 -> palindromeTester.testNumber(testNumber) ? "NOT PALINDROME" : "PALINDROME";
                    default -> "Oaschloch";
                };
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
