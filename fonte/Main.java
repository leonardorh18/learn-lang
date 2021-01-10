/*
Autor: Leonardo Heidrich Rocha
Estudante de Ciência da Computação na Universidade Federal da Fronteira Sul - Chapecó
Se você quer usar esse código eu deixo ok? fica livre pra fazer o que quiser meu amigo(a)
*/


import java.util.Scanner;
import java.io.File;

public class Main{

    public static void main(String[] args){
            
        
        String path;
        Treatment t = new Treatment();
        if (args.length > 0){

        
            path = args[0];
            
        } else {
            System.out.println("Arquivo nao especificado.");
            return;
        }

        try {
                File file = new File(path+".learn");
                Scanner input = new Scanner(file);
                while (input.hasNextLine()) {
                    String line = input.nextLine();
                   t.lineTreatment(line);
                //t.showvariables();
            }

            input.close();

            } catch (Exception e) {
                System.out.println("Nao foi possivel abrir o arquivo " + path);
                e.printStackTrace();
            }
            //System.out.println("_______________FINAL__________________ ");
            //t.showvariables();

    }


}