import java.util.*;

public class Processa{

    List <DoubleVariable> doubleVariables = new ArrayList<DoubleVariable>();
    List <StringVariable> stringsVariables = new ArrayList<StringVariable>();

    public String spaceTreatment(String line){

        String newLine = new String();

        for (char c : line.toCharArray()){

            if (!(c == ' ')){
               
                newLine = newLine + c;
            }
        }

        return newLine;
 

}

    public void lineTreatment(String line){

            if (line.contains("=")){

                operationTreatment(line);

            }

      
    }

    public double doOperation (double v1, double v2, char op){

        if (op == '+'){
            return v1+v2;
        } else if (op == '-'){
            return v1 - v2;
        } else if(op == '*'){
            return v1 * v2;

        } else if(op == '/'){
            return v1/v2;
        } else if (op == 'm'){
            return v1%v2;
        }
        return 0;

    }


    public double verifyVariables(String op0, String op1, char op){
        double res = 0;
        double aux1 = 0, aux2 = 0;
        boolean found = false;

        if ( isNumeric(op0) && !isNumeric(op1)){

                for (DoubleVariable d: doubleVariables){

                    if(d.getNome().equals(op1)){
                        found = !found;

                        res =  doOperation(Double.parseDouble(op0), d.getValor(), op);

                    }
                }
                
        } else if ( !isNumeric(op0) && isNumeric(op1)){

            for (DoubleVariable d: doubleVariables){

                if(d.getNome().equals(op0)){
                    found = !found;

                    res =  doOperation(d.getValor() , Double.parseDouble(op1), op);

                }
            }


        } else if ( !isNumeric(op0) && !isNumeric(op1)){
            boolean found_aux =  false;
            for (DoubleVariable d: doubleVariables){

                if(d.getNome().equals(op0)){
                    found = !found;

                    aux1 =  d.getValor();

                }
                if(d.getNome().equals(op1)){
                    found_aux = !found_aux;
                    aux2 =  d.getValor();

                }
            }
            res = doOperation(aux1 , aux2, op);
        }

        return res;
    }

    public void operationTreatment(String line){

        double res = 0 ;
        String[] lineSplit = line.split("=");
        lineSplit[0] = spaceTreatment(lineSplit[0]);

        //System.out.println("-- "+lineSplit[1]);
        
        if (lineSplit[1].contains("+")){

            String[] op = lineSplit[1].split("\\+");
            op[0] = spaceTreatment(op[0]);
            op[1] = spaceTreatment(op[1]);

            if (isNumeric(op[0]) && isNumeric(op[1])){

                res = Double.parseDouble(op[0]) + Double.parseDouble(op[1]);

            } else {
                res = verifyVariables(op[0], op[1], '+');
            }

        } else if (lineSplit[1].contains("-")){

             String[] op = lineSplit[1].split("-");
            op[0] = spaceTreatment(op[0]);
            op[1] = spaceTreatment(op[1]);

            if (isNumeric(op[0]) && isNumeric(op[1])){

                res = Double.parseDouble(op[0]) + Double.parseDouble(op[1]);

            } else {
                res = verifyVariables(op[0], op[1], '-');
            }

        } else if (lineSplit[1].contains("*")){

            String[] op = lineSplit[1].split("\\*");
            op[0] = spaceTreatment(op[0]);
            op[1] = spaceTreatment(op[1]);

            if (isNumeric(op[0]) && isNumeric(op[1])){

                res = Double.parseDouble(op[0]) + Double.parseDouble(op[1]);

            } else {
                res = verifyVariables(op[0], op[1], '*');
            }

        } else if (lineSplit[1].contains("/")){

            String[] op = lineSplit[1].split("/");
            op[0] = spaceTreatment(op[0]);
            op[1] = spaceTreatment(op[1]);

            if (isNumeric(op[0]) && isNumeric(op[1])){

                res = Double.parseDouble(op[0]) + Double.parseDouble(op[1]);

            } else {
                res = verifyVariables(op[0], op[1], '/');
            }

        } else if (lineSplit[1].contains("%")) {

            String[] op = lineSplit[1].split("%");
            op[0] = spaceTreatment(op[0]);
            op[1] = spaceTreatment(op[1]);

            if (isNumeric(op[0]) && isNumeric(op[1])){

                res = Double.parseDouble(op[0]) % Double.parseDouble(op[1]);

            } else {
                System.out.println("mod");
                verifyVariables(op[0], op[1], 'm');
            }

        } else if (isNumeric(spaceTreatment(lineSplit[1]))){

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

      

    }
    // só rap debugar cê ta certihno
    public void showvariables(){
        for (StringVariable s : stringsVariables){

            System.out.println(s.getNome() + " String "+ s.getValor());
        }
        for (DoubleVariable s : doubleVariables){
            System.out.println(s.getNome() + " Double " + s.getValor());
        }
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