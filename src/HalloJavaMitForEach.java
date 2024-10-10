import java.util.ArrayList;
import java.util.List;

public class HalloJavaMitForEach {

    public static void main(String[] args) {
        List<String> outputForEach = new ArrayList<>();
        for(String s : outputForEach){
            System.out.println(s);
        }
        outputForEach.forEach(s -> System.out.println(s));

    }
}