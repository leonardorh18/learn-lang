import java.util.*;

public class Processa{

    List <DoubleVariable> doubleVariables = new ArrayList<DoubleVariable>();
    List <StringVariable> stringsVariables = new ArrayList<StringVariable>();
     // retira os espaços
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
    
    // vê qual operacao fazer
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

    // verifica o tipo das variaveis pra mandar pra doOperation
    public double verifyVariables(String op0, String op1, char op){
        double res = 10;
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

    //etapa inicial do tratamento das operacoes
    public void operationTreatment(String line){
        DoubleVariable dVariable =  new DoubleVariable();
        StringVariable sVariable =  new StringVariable();
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
                
                res = verifyVariables(op[0], op[1], 'm');
            }

        } else if (isNumeric(spaceTreatment(lineSplit[1]))){

            if (existing_variable_string(spaceTreatment(lineSplit[0]))){
                System.out.println("Nao e possivel atribuir double a uma string");
                System.exit(0);

            } else if (existing_variable_double(spaceTreatment(lineSplit[0]))){

                dVariable.setInVar(spaceTreatment(lineSplit[0]),Double.parseDouble(spaceTreatment(lineSplit[1])), doubleVariables );
                return;
            }else {

                dVariable.setNome(lineSplit[0]);
                dVariable.setValor(Double.parseDouble(lineSplit[1]));
                doubleVariables.add(dVariable);
                return;
            }
            
          
        } else if (!isNumeric(spaceTreatment(lineSplit[1])) && existing_variable_double(spaceTreatment(lineSplit[1])) && !existing_variable_double(spaceTreatment(lineSplit[0])) ) {

            dVariable.setNome(lineSplit[0]);
            //System.out.println("..." + dVariable.getValorInList(doubleVariables,  spaceTreatment(lineSplit[1])));
            dVariable.setValor(dVariable.getValorInList(doubleVariables,  spaceTreatment(lineSplit[1])));
            doubleVariables.add(dVariable);
            return;


        }else {
            
            if (treat_existing_variables(spaceTreatment(lineSplit[0]), spaceTreatment(lineSplit[1]))){
                //System.out.println("teste");
                return;
            }else if (existing_variable_string(spaceTreatment(lineSplit[0]))){
                sVariable.setInVar(spaceTreatment(lineSplit[0]), lineSplit[1], stringsVariables);

                return;
                
            } else {
                sVariable.setNome(lineSplit[0]);
                sVariable.setValor(lineSplit[1]);
                stringsVariables.add(sVariable);
                return;
            }
            
        }

    dVariable.setNome(lineSplit[0]);
    dVariable.setValor(res);
    doubleVariables.add(dVariable);
    
    }
    public boolean treat_existing_variables(String var, String var2){

        if (existing_variable_double(var) && existing_variable_double(var2)){

            for (DoubleVariable s : doubleVariables){
                if (s.getNome().equals(var)){
                    
                    for(DoubleVariable c: doubleVariables){

                        if (c.getNome().equals(var2)){

                            s.setValor(c.getValor());
                        }
                    }
                }
            }
            return true; //feito
        }
        if (existing_variable_string(var) && existing_variable_string(var2)){

            for (StringVariable s : stringsVariables){

                if (s.getNome().equals(var)){
                    
                    for(StringVariable c: stringsVariables){

                        if (c.getNome().equals(var2)){

                            s.setValor(c.getValor());
                        }
                    }
                }
            }
            return true; //feito
        }
        return false; 
    }   

    public boolean existing_variable_string(String var){
        for (StringVariable s: stringsVariables){
            if (s.getNome().equals(var)){
                return true;
            }
        }

        return false;
    }
    
    public boolean existing_variable_double(String var){

        for (DoubleVariable s : doubleVariables){
            if (s.getNome().equals(var)){
                return true;
            }
        }
        return false;
    }

    public void showvariables(){
        for (StringVariable s : stringsVariables){

            System.out.println(s.getNome() + "-String-"+ s.getValor());
        }
        for (DoubleVariable s : doubleVariables){
            System.out.println(s.getNome() + "-Double-" + s.getValor());
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