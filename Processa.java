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

        for (char c : line.toCharArray()){

            if (c == '='){
                //System.out.println(c);
                varTreatment(line);
            }

        }

    }

    public void varTreatment(String line){
        String[] lineSplit = line.split("=");
        System.out.println(lineSplit[0]);
    }
}