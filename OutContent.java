import java.util.*;
public class OutContent extends Processa{

    public OutContent(List <StringVariable> stringsVariables, List <DoubleVariable> doubleVariables){

        this.stringsVariables = stringsVariables;
        this.doubleVariables = doubleVariables;

    }
    
    public void out_display(boolean ln, String text) {
    
        if (ln){

            if (output_is_variable(text)){
              
                out_variable(text, ln);
                return;
            }

            System.out.println(text);
            
        } else {
            
            if (output_is_variable(text)){
               
                out_variable(text, ln);
                return;
            }

            System.out.print(text);
        }

    }

    public boolean output_is_variable(String text){
 
        if (sVariable.existing_variable_string(spaceTreatment(text), stringsVariables)){
     
            return true;
           
        }

        if (dVariable.existing_variable_double(spaceTreatment(text), doubleVariables)){
            
            return true;
        }

        return false;

    }

    public void out_variable(String text, boolean ln){

        if (dVariable.existing_variable_double(spaceTreatment(text), doubleVariables)){

            if (ln) {
                System.out.println(dVariable.getValorInList(doubleVariables, spaceTreatment(text)));
            }  else {

                System.out.print(dVariable.getValorInList(doubleVariables, spaceTreatment(text)));
            }

        } else {

            if (ln) {
                System.out.println(sVariable.getValorInList(stringsVariables, spaceTreatment(text)));
            }  else {

                System.out.print(sVariable.getValorInList(stringsVariables, spaceTreatment(text)));
            }

            
        }

        return;

    }


    



}