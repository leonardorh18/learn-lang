import java.util.*;

public class Processa{

    List <DoubleVariable> doubleVariables = new ArrayList<DoubleVariable>();
    List <StringVariable> stringsVariables = new ArrayList<StringVariable>();

    public void lineSpaceTreatment(String line){
            String newLine = new String();
            for (char c : line.toCharArray()){

                if (!(c == ' ')){
                   
                    newLine = newLine + c;
                }
            }

           if (newLine.contains("=")){

            operationTreatment(newLine);

           }
           

    }

    public void operationTreatment(String line){

        double res = 0 ;
        String[] lineSplit = line.split("=");
        //System.out.println("-- "+lineSplit[1]);
        
        if (lineSplit[1].contains("+")){

            String[] op = lineSplit[1].split("\\+");
            res = Double.parseDouble(op[0]) + Double.parseDouble(op[1]);

        }else if (lineSplit[1].contains("-")){

            String[] op = lineSplit[1].split("-");
            res = Double.parseDouble(op[0]) - Double.parseDouble(op[1]);

        } else if (lineSplit[1].contains("*")){

            String[] op = lineSplit[1].split("\\*");
            res = Double.parseDouble(op[0]) * Double.parseDouble(op[1]);

        } else if (lineSplit[1].contains("/")){

            String[] op = lineSplit[1].split("/");
            res = Double.parseDouble(op[0]) / Double.parseDouble(op[1]);

        } else if (lineSplit[1].contains("%")) {

            String[] op = lineSplit[1].split("%");
            res = Double.parseDouble(op[0]) % Double.parseDouble(op[1]);

        } else if (isNumeric(lineSplit[1])){

            DoubleVariable dVariable =  new DoubleVariable();
            dVariable.setNome(lineSplit[0]);
            dVariable.setValor(Double.parseDouble(lineSplit[1]));
            doubleVariables.add(dVariable);
            return;



        } else {

            StringVariable sVariable =  new StringVariable();
            sVariable.setNome(lineSplit[0]);
            sVariable.setValor(lineSplit[1]);

            stringsVariables.add(sVariable);
            return;
        }

    DoubleVariable dVariable =  new DoubleVariable();
    dVariable.setNome(lineSplit[0]);
    dVariable.setValor(res);
    doubleVariables.add(dVariable);

            // debug de pobre
            for (StringVariable s : stringsVariables){
                System.out.println(s.getNome() + ' ' + s.getValor());
            }
            for (DoubleVariable s : doubleVariables){
                System.out.println(s.getNome() +' '+ s.getValor());
            }

    }

    public void varTreatment(String line){
        
        
        
 
    }

    public static boolean isNumeric(String str) { 
        try {  
          Double.parseDouble(str);  
          return true;
        } catch(NumberFormatException e){  
          return false;  
        }  
      }
}