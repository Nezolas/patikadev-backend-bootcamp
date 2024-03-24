import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class Repetitive {
    public static void main(String[] args) {
        String mostRepetitive = "";
        int maxCount = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Tekrar eden kelimeyi bulmak istediğiniz metni aşağıya giriniz: ");
        String text = input.nextLine();

        // There is an explanation for the split method in the fallowing website:  https://stackoverflow.com/questions/225337/how-to-split-a-string-with-any-whitespace-chars-as-delimiters
        String[] words = text.split("\\s+");

        HashMap<String, Integer> wordCounter = new HashMap<>();

        for(int i = 0; i < words.length; i++) {
            String wordLowForm = words[i].toLowerCase();
            if (wordCounter.containsKey(wordLowForm)) {
                int counter = wordCounter.get(wordLowForm);
                wordCounter.put(wordLowForm, counter + 1);
            } else {
                wordCounter.put(wordLowForm, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : wordCounter.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostRepetitive = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        System.out.println("**************************************************************");
        System.out.println("Metinde en çok tekrar eden kelime: " + "\"" + mostRepetitive + "\" " +"\n" + "Tekrar Sayısı: " + maxCount  );
        System.out.println("***************************************************************");

    }
}