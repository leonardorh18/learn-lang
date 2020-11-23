
import java.util.*;

public class Looping extends Treatment {
    
    public Looping(List<String> comands, List<StringVariable> stringsVariables, List <DoubleVariable> doubleVariables){
        this.doubleVariables = doubleVariables;
        this.stringsVariables = stringsVariables;
        this.comands = comands;

    }

    
    
    private String atribuicao = new String();
    private String condicao = new String();
    private String doit = new String();


  

    public boolean loop_isvalid(String text){
        Conditional cond = new Conditional(stringsVariables, doubleVariables);
        String[] splt = text.split(";");

       operationTreatment(splt[0]);
       //System.out.println("é valido");
       if (cond.verify_conditional(splt[1])){
        //System.out.println("é valido");
        atribuicao = splt[0];
        condicao = splt[1];
        doit = splt[2];

        //System.out.println("doit "+ doit);
        //System.out.println("atrib "+ atribuicao);
        //System.out.println("condicao "+ condicao);

       }

        return cond.verify_conditional(splt[1]);

    }

  

    public void do_para(){
    Conditional cond = new Conditional(stringsVariables, doubleVariables);

    
    
    while (cond.verify_conditional(condicao)){
       
        
        for (String s: comands){

            //System.out.println("linha - "+ s);
            super.lineTreatment(s);

        }

        lineTreatment(doit);

       
        

    }
        
        
      
    }


}