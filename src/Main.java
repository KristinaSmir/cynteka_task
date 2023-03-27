import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        String separator = File.separator;
        String path = separator + "Users" + separator + "krist" + separator + "Desktop" + separator + "Project" + separator + "untitled_cynteka_task" + separator + "src" + separator + "notes.input";
        String path1 = separator + "Users" + separator + "krist" + separator + "Desktop" + separator + "Project" + separator + "untitled_cynteka_task" + separator + "src" + separator + "notes.output";
        File input = new File(path);
        File output = new File(path1);

        try (BufferedReader reader = new BufferedReader(new FileReader(input));
             BufferedWriter writer = new BufferedWriter(new FileWriter(output))){
            // считавание данных
            List<String> stringsN = getList (reader);
            List<String> stringsM = getList (reader);

            //получение строк (результата)
            List<String> result = Sequences.sequence(stringsN,stringsM);

            //запись
            for (int i = 0; i < result.size(); i++){
                writer.write(result.get(i) + "\n");
            }

        }catch (Exception exception){
            exception.printStackTrace();
        }

    }
    public static List<String> getList(BufferedReader reader) throws IOException{
        //считывание числа
        int n = 0;
        String str =reader.readLine();
        if (str != null){
            n = Integer.parseInt(str);
        }

        //считывание строки
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < n; i++){
            if (reader.ready())
                strings.add(reader.readLine());
            else throw new IOException("Wrong number of lines");
        }
        return strings;
    }
}

