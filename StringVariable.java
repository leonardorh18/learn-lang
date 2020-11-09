public class StringVariable extends Variavel{

 
    private String valor;

    public void setValor(String valor){
        try{

            this.valor = valor;

        } catch (Exception e){

            System.out.println("Atribuição invalida");
        }
    }

    public String getValor(){
        return this.valor;
    }


}