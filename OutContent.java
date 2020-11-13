public class OutContent extends Processa{

    StringVariable s = new StringVariable();
    DoubleVariable d = new DoubleVariable();

    public void out_display(boolean ln, String text) {
        System.out.println("eu odeio java");
  
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
       
        if (s.existing_variable_string(spaceTreatment(text), stringsVariables)){
            System.out.print("existe string"+spaceTreatment(text));
            return true;
           
        }

        if (d.existing_variable_double(spaceTreatment(text), doubleVariables)){
            System.out.print("existe double"+spaceTreatment(text));
            return true;
        }

        return false;

    }

    public void out_variable(String text, boolean ln){

        if (d.existing_variable_double(spaceTreatment(text), doubleVariables)){

            if (ln) {
                System.out.println(d.getValorInList(doubleVariables, spaceTreatment(text)));
            }  else {

                System.out.print(d.getValorInList(doubleVariables, spaceTreatment(text)));
            }

        } else {

            if (ln) {
                System.out.println(s.getValorInList(stringsVariables, spaceTreatment(text)));
            }  else {

                System.out.print(s.getValorInList(stringsVariables, spaceTreatment(text)));
            }

            
        }

        return;

    }


    



}