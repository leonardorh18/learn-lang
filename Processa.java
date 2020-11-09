public class Processa{

    public void lineSpaceTreatment(String line){
            String newLine = new String();
            for (char c : line.toCharArray()){

                if (!(c == ' ')){
                   
                    newLine = newLine + c;
                }
            }

           
            operationTreatment(newLine);

    }

    public void operationTreatment(String line){

        if (line.contains("=")){
            varTreatment(line);
        }

    }

    public void varTreatment(String line){
        String[] lineSplit = line.split("=");
        
        double res = 0 ;
        
        if (lineSplit[1].contains("+")){

            String[] op = lineSplit[1].split("+");
        }


 
    }
}