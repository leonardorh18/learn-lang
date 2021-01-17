
import java.util.*;

public class DoubleVariable extends Variavel{



    
    private double valor;

    public void setValor(double valor){
        try{

            this.valor = valor;
        } catch (Exception e){

            System.out.println("Atribuição invalida");
        }
    }
    // SET VALOR EM UM DADA VARIAVEL
    public void setInVar(String var, double valor, List<DoubleVariable> doubleVariables ){

        for (DoubleVariable s : doubleVariables){
            if (s.getNome().equals(var)){
                
                s.setValor(valor);
              
            }
    
        }
    }

    public double getValor(){
        return this.valor;
    }


    // RETORNA O VALOR DE UMA VARIAVEL
    public double getValorInList(List<DoubleVariable> doubleVariables, String nome){
        

        for (DoubleVariable s : doubleVariables){
            if (s.getNome().equals(nome)){
                
              return s.getValor();
            }
    
        }
        return this.valor;
    }

    // VERIFICA SE A VARIAVEL EXISTE
    public boolean existing_variable_double(String var, List<DoubleVariable> doubleVariables){

        for (DoubleVariable s : doubleVariables){
            if (s.getNome().equals(var)){
                return true;
            }
        }
        return false;
    }


}