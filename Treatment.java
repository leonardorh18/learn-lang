import java.util.*;

public class Treatment{

    public List <DoubleVariable> doubleVariables = new ArrayList<DoubleVariable>();
    public List <StringVariable> stringsVariables = new ArrayList<StringVariable>();
    public DoubleVariable dVariable =  new DoubleVariable();
    public StringVariable sVariable =  new StringVariable();
    public boolean isnotConditional = true;
    

    public List<DoubleVariable> getDoubleVariables() {
        return this.doubleVariables;
    }

    public List<StringVariable> getStringsVariables() {
        return this.stringsVariables;
    }

 
    
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
        if (isnotConditional){
            if (line.contains("=")){

                operationTreatment(line);

            }
            
            if (line.contains(":")){
                String[] splt = line.split(":");
                if (splt[0].equals("mostrar") || splt[0].equals("mostrarln")){
                    OutContent out = new OutContent(stringsVariables, doubleVariables);

                    if (splt[0].equals("mostrarln")){

                        out.out_display(true, splt[1]);

                    } else {

                        out.out_display(false, splt[1]);
                    }
                    

                }

                if (splt[0].equals("se")){

                    Conditional conditional = new Conditional(stringsVariables, doubleVariables);
                    isnotConditional = conditional.verify_conditional(spaceTreatment(splt[1]));                   
                    
                }
            }
        } else {
            if (line.contains("fimse")){
                isnotConditional = !isnotConditional;
            }
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
         DoubleVariable dV =  new DoubleVariable();
        StringVariable sV =  new StringVariable();
       
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

                res = Double.parseDouble(op[0]) / Double.parseDouble(op[1]);

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

            if (sV.existing_variable_string(spaceTreatment(lineSplit[0]), stringsVariables)){
                System.out.println("Nao e possivel atribuir double a uma string");
                System.exit(0);

            } else if (dV.existing_variable_double(spaceTreatment(lineSplit[0]), doubleVariables)){
                //System.out.println("VARIAVEL JA EXISTE");
                dV.setInVar(spaceTreatment(lineSplit[0]),Double.parseDouble(spaceTreatment(lineSplit[1])), doubleVariables );
                return;
            }else {

                dV.setNome(spaceTreatment(lineSplit[0]));
                dV.setValor(Double.parseDouble(lineSplit[1]));
                doubleVariables.add(dV);
                return;
            }
            
          
        } else if (!isNumeric(spaceTreatment(lineSplit[1])) && dV.existing_variable_double(spaceTreatment(lineSplit[1]), doubleVariables) && !dV.existing_variable_double(spaceTreatment(lineSplit[0]), doubleVariables) ) {
            
            dV.setNome(spaceTreatment(lineSplit[0]));
            
            //System.out.println("..." + dV.getValorInList(doubleVariables,  spaceTreatment(lineSplit[1])));
            dV.setValor(dV.getValorInList(doubleVariables,  spaceTreatment(lineSplit[1])));
            doubleVariables.add(dV);
            return;


        }else {
            
            if (treat_existing_variables(spaceTreatment(lineSplit[0]), spaceTreatment(lineSplit[1]))){
                //System.out.println("teste");
                return;
            }else if (sV.existing_variable_string(spaceTreatment(lineSplit[0]), stringsVariables)){
                sV.setInVar(spaceTreatment(lineSplit[0]), lineSplit[1], stringsVariables);

                return;
                
            } else if (!sV.existing_variable_string(spaceTreatment(lineSplit[0]), stringsVariables) && sV.existing_variable_string(spaceTreatment(lineSplit[1]), stringsVariables)){
                sV.setNome(spaceTreatment(lineSplit[0]));
                sV.setValor(sV.getValorInList(stringsVariables, spaceTreatment(lineSplit[1])));
                stringsVariables.add(sV);

                return;

            }else if (dV.existing_variable_double(spaceTreatment(lineSplit[0]), doubleVariables)){
                System.out.println("Nao e possivel atribuir string a uma double");
                System.exit(0);


            } else {
                sV.setNome(spaceTreatment(lineSplit[0]));
                sV.setValor(lineSplit[1]);
                stringsVariables.add(sV);
                return;
            }
            
        }

    if (dV.existing_variable_double(spaceTreatment(lineSplit[0]), doubleVariables)){
        //System.out.println("aq");
        dV.setInVar(spaceTreatment(lineSplit[0]), res, doubleVariables);
        //doubleVariables.add(dV);
        return;
    }else {
        //System.out.println("aq2");
        dV.setNome((spaceTreatment(lineSplit[0])));
        dV.setValor(res);
        doubleVariables.add(dV);
        
        
    }
   
    }
    public boolean treat_existing_variables(String var, String var2){

        if (dVariable.existing_variable_double(var, doubleVariables) && dVariable.existing_variable_double(var2, doubleVariables)){

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
        if (sVariable.existing_variable_string(var, stringsVariables) && sVariable.existing_variable_string(var2, stringsVariables)){

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

 
    
 

    public void showvariables(){
        System.out.println("_____________________________________");
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