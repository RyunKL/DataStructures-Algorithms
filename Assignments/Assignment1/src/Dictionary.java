import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
public class Dictionary {
    public int currentWordCount;
    public int maxDictionarySize;
    WordInfo[] DictionaryList;
    public Dictionary(int maxSize){
        this.currentWordCount = 0;
        maxDictionarySize = maxSize;
        DictionaryList = new WordInfo[maxSize];
    }
    public void selectionSort(){
        if(currentWordCount == 0) return;
        for(int i = 0; i < currentWordCount - 1; i++){
            int min = i;
            for(int j = i + 1; j < currentWordCount; j++){
                if(DictionaryList[min].getWord().compareTo(DictionaryList[j].getWord()) < 0){
                    min = j;
                }
            }WordInfo temp = DictionaryList[min];
            DictionaryList[min] = DictionaryList[i];
            DictionaryList[i] = temp;
        }
    }
    public int binarySearch(String keyword){
        int hi = currentWordCount - 1;
        int lo = 0;
        while (hi >= lo){
            int mid = (hi + lo)/2;
            if (DictionaryList[mid].getWord().compareTo(keyword) == 0) return mid;
            if (DictionaryList[mid].getWord().compareTo(keyword) > 0) hi = mid - 1;
            if (DictionaryList[mid].getWord().compareTo(keyword) < 0) lo = mid + 1;
        }return -1;
    }

    public boolean add(String word, String meaning){
        if(currentWordCount >= maxDictionarySize) return false;
        if(binarySearch(word) > 0){
            System.out.println("Error, the word: " + word + " you're trying to add already exists " +
                    "in the Dictionary");
        }
        DictionaryList[currentWordCount] = new WordInfo(word, meaning);
        currentWordCount++;
        selectionSort();
        return true;
    }

    public boolean delete(String keyword){
        int index = binarySearch(keyword);
        if (index == -1){
            System.out.println("Error, the word: " + keyword + " could not be found");
            return false;
        }

        currentWordCount -= 1;
        DictionaryList[index] = DictionaryList[currentWordCount];
        selectionSort();
        return true;
    }

    public String returnMeaning(String keyword){
        int location = binarySearch(keyword);
        if (location == -1){
            String out = "Error, the word: " + keyword + " could not be found";
            return out;
        }
        String out = DictionaryList[location].getMeaning();
        return out;
    }
    public void spellCheck(String fileName){
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while((line = br.readLine()) !=null){
                String [] words = line.split(",|\\.|\\s");
                for(String word: words){
                    if(binarySearch(word) > 0){
                        System.out.println(word);
                    }
                }
            }
            br.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    @Override
    public String toString(){
        selectionSort();
        String out ="----Dictionary----";
        for(int index = 0; index < currentWordCount; index++){
            out += "\n" + DictionaryList[index];
        }
        return out;
    }

}
