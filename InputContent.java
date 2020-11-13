
import java.util.*;

public class InputContent extends Treatment{

    Scanner ler = new Scanner(System.in);

        public InputContent(List <StringVariable> stringsVariables, List <DoubleVariable> doubleVariables){

            this.stringsVariables = stringsVariables;
            this.doubleVariables = doubleVariables;

        }

    public void treat_input(String text){

        if (dVariable.existing_variable_double(spaceTreatment(text), doubleVariables)){

            try {

                dVariable.setInVar(spaceTreatment(text), Double.parseDouble(ler.next()), doubleVariables);

            } catch (Exception e){

                System.out.println("Nao eh possivel atribuir string a um double");
            }
            
            return;

        } else if (sVariable.existing_variable_string(spaceTreatment(text), stringsVariables)){

            try {
                sVariable.setInVar(spaceTreatment(text), ler.nextLine(), stringsVariables);

            } catch (Exception e){

                System.out.println("Nao eh possivel atribuir double a um string");
            }
            
            return;

        }

        String lido = ler.nextLine();

        if (!dVariable.existing_variable_double(spaceTreatment(text), doubleVariables) && isNumeric(spaceTreatment(lido))){

            try {

                dVariable.setValor(Double.parseDouble(spaceTreatment(lido)));
                dVariable.setNome(spaceTreatment(text));
                doubleVariables.add(dVariable);
                return;

            } catch (Exception e){

                System.out.println("Nao eh possivel atribuir string a um double");
            }
            
            return;
        } else if (!sVariable.existing_variable_string(spaceTreatment(text), stringsVariables) && !isNumeric(spaceTreatment(lido))){

            try {

                sVariable.setValor(lido);
                sVariable.setNome(spaceTreatment(text));
                stringsVariables.add(sVariable);
                return;

            } catch (Exception e){

                System.out.println("Erro ao ler");
            }

        }
        
    }
    


}