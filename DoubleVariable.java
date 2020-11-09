public class DoubleVariable extends Variavel{



    
    private double valor;

    public void setValor(double valor){
        try{

            this.valor = valor;
        } catch (Exception e){

            System.out.println("Atribuição invalida");
        }
    }

    public setInVar(String var, double valor, List<DoubleVariable> doubleVariables ){

        for (DoubleVariable s : doubleVariables){
            if (s.getNome().equals(var)){
                
                s.setValor(valor);
              
            }
    
        }
    }

    public double getValor(){
        return this.valor;
    }


}