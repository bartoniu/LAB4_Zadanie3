import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Zadanie3 {
    public static void main(String[] args)
    {
        int n = 10;
        int k = 3;
        int p = 2;
        Random random = new Random();
        List<String> allWords = null;

        try {
            allWords = wordReader();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> newWords = new LinkedList<>();
        List<String> oldWords = new LinkedList<>();
        List<String> forgottenWords = new LinkedList<>();

        for(int i = 0; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                newWords.add(allWords.remove(random.nextInt(allWords.size())));
            }

            if (i > k) {
                for (int j = 0; j < 2; j++) {
                    oldWords.add(newWords.remove(0));
                }
            }

            if (oldWords.size() > 0) {
                int counter = 0;
                for (int j = 0; j < 2 && oldWords.size() > 0; j++) {
                    counter = random.nextInt(oldWords.size());

                    if (random.nextInt(p) == 0) {
                        forgottenWords.add(oldWords.remove(counter));
                    }
                }
            }

            System.out.println("Day " + i);
            System.out.println("New words: " + newWords.get(newWords.size() - 2) + " " + newWords.get(newWords.size() - 1));
            System.out.println("Forgotten words: " + forgottenWords.toString());
            System.out.println(newWords.toString() + oldWords.toString());

            for(int g = 0; g < forgottenWords.size(); g++)
            {
                allWords.add(forgottenWords.remove(0));
            }
        }
    }

    public static List<String> wordReader() throws IOException {
        File file = new File("1500.txt");

        if (file.createNewFile())
        {
            System.out.println("File .bin is created!");
        } else {
            System.out.println("File .bin already exists.");
        }

        BufferedReader data = new BufferedReader(new FileReader(file));

        String variable = "";

        List<String> list = new LinkedList<>();

        while((variable = data.readLine()) != null)
        {
            list.add(variable);
        }

        data.close();

        return list;
    }
}
