import java.util.*;

public class StringVariable extends Variavel{

 
    private String valor;

    public void setValor(String valor){
        try{

            this.valor = valor;

        } catch (Exception e){

            System.out.println("Atribuição invalida");
        }
    }

    public void setInVar(String var, String valor, List<StringVariable> stringsVariables ){

        for (StringVariable s : stringsVariables){
            if (s.getNome().equals(var)){
                
                s.setValor(valor);
              
            }
    
        }
    }

    public String getValor(){
        return this.valor;
    }


}