import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class FileRead implements Runnable{
    private static synchronized void calculateWordFrequency(File file) throws IOException {
        Thread th = Thread.currentThread();
       // AtomicInteger freqCount = new AtomicInteger();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        //We can use ConcurrentHashMap instead. Benefits explained in readme.
        HashMap<String, Integer> frequency = new HashMap<>();
        // We can put below code in synchronized block where the compound operation is performed
        while(line != null){
            if(!line.trim().equals("")){
                String[] words = line.split(" ");

                for(String word : words){
                    String wordWithoutSpecial = word.replaceAll("[^\\w\\s]","");
                    if(wordWithoutSpecial == null || wordWithoutSpecial.trim().equals("")){
                        continue;
                    }
                    String lowerCaseWord =  wordWithoutSpecial.toLowerCase();

                    if(frequency.containsKey(lowerCaseWord)){
                        frequency.put(lowerCaseWord, frequency.get(lowerCaseWord)+1);
                    }else{
                        frequency.put(lowerCaseWord, 1);
                    }
                }
            }
            line = reader.readLine();
           // System.out.println(th.getName()+" "+line);  // we can observe both the thread accessing the same code asynchronously
        }
        System.out.println(th+ " "+ frequency);
    }

    @Override
    public void run() {
        Path path = Paths.get(System.getProperty("user.dir")).resolve("gpl-3.0.txt");
        try {
            calculateWordFrequency(path.toFile());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
