
import java.util.*;
public class Conditional extends Treatment {

   

    private boolean begin = false;


    public boolean isBegin() {
        return this.begin;
    }

    public boolean getBegin() {
        return this.begin;
    }

    public void setBegin(boolean begin) {
        this.begin = begin;
    }

    public Conditional(List <StringVariable> stringsVariables, List <DoubleVariable> doubleVariables){

        this.stringsVariables = stringsVariables;
        this.doubleVariables = doubleVariables;


    }

    public boolean compare(double v1, double v2, char op){

        if (op == '>'){
            return v1 > v2;
        }

        if (op == '<'){

            return v1 < v2;
        }

        if (op == '='){

            return v1 == v2;
        }

        if (op == 'm'){

            return v1 >= v2;
        }

        if (op == 'n'){

            return v1 <= v2;
        }

        return false;
    }

    public String remove_equal(String text){

        String newtext = new String();

        for ( char c: text.toCharArray()){

            if (!(c == '=')){

                newtext = newtext + c;
            }
          

        }

        return newtext;
    }

    public boolean verify_conditional(String text){
        if (text.contains(">=") ){
           
            String[] splt = text.split("\\>");
            splt[1] = remove_equal(splt[1]);

            //System.out.println(splt[1]);
            char c = 'm';

            if (dVariable.existing_variable_double(spaceTreatment(splt[0]), doubleVariables) && dVariable.existing_variable_double(spaceTreatment(splt[1]), doubleVariables) ){

                return compare(dVariable.getValorInList(doubleVariables, spaceTreatment(splt[0])), dVariable.getValorInList(doubleVariables, spaceTreatment(splt[1])), c);

            } else if (!dVariable.existing_variable_double(spaceTreatment(splt[0]), doubleVariables) && dVariable.existing_variable_double(spaceTreatment(splt[1]), doubleVariables)){

                return compare(Double.parseDouble(splt[0]), dVariable.getValorInList(doubleVariables, spaceTreatment(splt[1])), c);

            } else if (dVariable.existing_variable_double(spaceTreatment(splt[0]), doubleVariables) && !dVariable.existing_variable_double(spaceTreatment(splt[1]), doubleVariables)){

                return compare(dVariable.getValorInList(doubleVariables, spaceTreatment(splt[0])), Double.parseDouble(splt[1]), c);

            } else if (!dVariable.existing_variable_double(spaceTreatment(splt[0]), doubleVariables) && !dVariable.existing_variable_double(spaceTreatment(splt[1]), doubleVariables)){

                return compare(Double.parseDouble(splt[0]), Double.parseDouble(splt[1]), c);

            }
            
            
        }


        if (text.contains("<=")){
        //System.out.println("aquii");

            String[] splt = text.split("\\<");

           splt[1] = remove_equal(splt[1]);

            char c = 'n';

            if (dVariable.existing_variable_double(spaceTreatment(splt[0]), doubleVariables) && dVariable.existing_variable_double(spaceTreatment(splt[1]), doubleVariables) ){

                return compare(dVariable.getValorInList(doubleVariables, spaceTreatment(splt[0])), dVariable.getValorInList(doubleVariables, spaceTreatment(splt[1])), c);

            } else if (!dVariable.existing_variable_double(spaceTreatment(splt[0]), doubleVariables) && dVariable.existing_variable_double(spaceTreatment(splt[1]), doubleVariables)){

                return compare(Double.parseDouble(splt[0]), dVariable.getValorInList(doubleVariables, spaceTreatment(splt[1])), c);

            } else if (dVariable.existing_variable_double(spaceTreatment(splt[0]), doubleVariables) && !dVariable.existing_variable_double(spaceTreatment(splt[1]), doubleVariables)){

                return compare(dVariable.getValorInList(doubleVariables, spaceTreatment(splt[0])), Double.parseDouble(splt[1]), c);

            } else if (!dVariable.existing_variable_double(spaceTreatment(splt[0]), doubleVariables) && !dVariable.existing_variable_double(spaceTreatment(splt[1]), doubleVariables)){

                return compare(Double.parseDouble(splt[0]), Double.parseDouble(splt[1]), c);

            }
            
            
        }

    
        if (text.contains(">")){
            
            String[] splt = text.split("\\>");
            char c = '>';

            if (dVariable.existing_variable_double(spaceTreatment(splt[0]), doubleVariables) && dVariable.existing_variable_double(spaceTreatment(splt[1]), doubleVariables) ){

                return compare(dVariable.getValorInList(doubleVariables, spaceTreatment(splt[0])), dVariable.getValorInList(doubleVariables, spaceTreatment(splt[1])), c);

            } else if (!dVariable.existing_variable_double(spaceTreatment(splt[0]), doubleVariables) && dVariable.existing_variable_double(spaceTreatment(splt[1]), doubleVariables)){

                return compare(Double.parseDouble(splt[0]), dVariable.getValorInList(doubleVariables, spaceTreatment(splt[1])), c);

            } else if (dVariable.existing_variable_double(spaceTreatment(splt[0]), doubleVariables) && !dVariable.existing_variable_double(spaceTreatment(splt[1]), doubleVariables)){

                return compare(dVariable.getValorInList(doubleVariables, spaceTreatment(splt[0])), Double.parseDouble(splt[1]), c);

            } else if (!dVariable.existing_variable_double(spaceTreatment(splt[0]), doubleVariables) && !dVariable.existing_variable_double(spaceTreatment(splt[1]), doubleVariables)){

                return compare(Double.parseDouble(splt[0]), Double.parseDouble(splt[1]), c);

            }
           
                
        }
            

        if (text.contains("<")){
            String[] splt = text.split("\\<");
            char c = '<';

            if (dVariable.existing_variable_double(spaceTreatment(splt[0]), doubleVariables) && dVariable.existing_variable_double(spaceTreatment(splt[1]), doubleVariables) ){

                return compare(dVariable.getValorInList(doubleVariables, spaceTreatment(splt[0])), dVariable.getValorInList(doubleVariables, spaceTreatment(splt[1])), c);

            } else if (!dVariable.existing_variable_double(spaceTreatment(splt[0]), doubleVariables) && dVariable.existing_variable_double(spaceTreatment(splt[1]), doubleVariables)){

                return compare(Double.parseDouble(splt[0]), dVariable.getValorInList(doubleVariables, spaceTreatment(splt[1])), c);

            } else if (dVariable.existing_variable_double(spaceTreatment(splt[0]), doubleVariables) && !dVariable.existing_variable_double(spaceTreatment(splt[1]), doubleVariables)){

                return compare(dVariable.getValorInList(doubleVariables, spaceTreatment(splt[0])), Double.parseDouble(splt[1]), c);

            } else if (!dVariable.existing_variable_double(spaceTreatment(splt[0]), doubleVariables) && !dVariable.existing_variable_double(spaceTreatment(splt[1]), doubleVariables)){

                return compare(Double.parseDouble(splt[0]), Double.parseDouble(splt[1]), c);

            }
            
            
        }

        if (text.contains("==")){
            
            String[] splt = text.split("\\==");
            char c = '=';

            if (dVariable.existing_variable_double(spaceTreatment(splt[0]), doubleVariables) && dVariable.existing_variable_double(spaceTreatment(splt[1]), doubleVariables) ){

                return compare(dVariable.getValorInList(doubleVariables, spaceTreatment(splt[0])), dVariable.getValorInList(doubleVariables, spaceTreatment(splt[1])), c);

            } else if (!dVariable.existing_variable_double(spaceTreatment(splt[0]), doubleVariables) && dVariable.existing_variable_double(spaceTreatment(splt[1]), doubleVariables)){

                return compare(Double.parseDouble(splt[0]), dVariable.getValorInList(doubleVariables, spaceTreatment(splt[1])), c);

            } else if (dVariable.existing_variable_double(spaceTreatment(splt[0]), doubleVariables) && !dVariable.existing_variable_double(spaceTreatment(splt[1]), doubleVariables)){

                return compare(dVariable.getValorInList(doubleVariables, spaceTreatment(splt[0])), Double.parseDouble(splt[1]), c);

            } else if (!dVariable.existing_variable_double(spaceTreatment(splt[0]), doubleVariables) && !dVariable.existing_variable_double(spaceTreatment(splt[1]), doubleVariables)){

                return compare(Double.parseDouble(splt[0]), Double.parseDouble(splt[1]), c);

            }
          
            
        }

        
       

        return false;

    }


}