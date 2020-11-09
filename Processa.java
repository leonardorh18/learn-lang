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

        } else if (isNumeric(lineSplit[1])){

            Variavel variavel =  new Variavel();
            variavel.



        }

        System.out.println(res);

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