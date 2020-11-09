import java.util.Scanner;
import java.io.File;

public class Main{

    public static void main(String[] args){
        String path;
        if (args.length > 0){
            path = args[0];
        } else {
            System.out.println("Arquivo nao especificado.");
            return;
        }

        try {
                File file = new File(path);
                Scanner input = new Scanner(file);
                while (input.hasNextLine()) {
                    String line = input.nextLine();
                    System.out.println(line);
            }

            input.close();
            
            } catch (Exception e) {
                System.out.println("Nao foi possivel abrir o arquivo " + path);
                e.printStackTrace();
            }

    }


}