import java.io.BufferedReader;
import java.io.FileReader;

public class CountWords {

    public String readFile(String fileName) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String value = reader.readLine();
        reader.close();

        return  value;
    }

//    public List<String> parse(String content) {
//        List<String> tempList = new ArrayList<String>();
//        for(int i = 0; i < content.split("[\\s,]").length; i = i +1){
//
//            if (words[i]!=null||words[i].trim().length()>0){
//                tempList.add(words[i]);
//            }
//
//        }
//        return tempList;
//    }
}
