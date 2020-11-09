public class DoubleVariable extends Variavel{

    private double valor;

    public void setValor(double valor){
        try{

            this.valor = valor;
        } catch (Exception e){

            System.out.println("Atribuição invalida");
        }
    }

    public double getValor(){
        return this.valor;
    }


}