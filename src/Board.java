public class Board {
    Field[] fields;
    String[] fielddata;
    String[] carddata;

    Board(String []fielddata,String[] carddata){
    this.fielddata=fielddata;
    this.carddata=carddata;
    Field[] fields = new Field[4];

    createFields(fielddata);
    }

    void createFields(String[] data){
        for(int i = 0; i< data.length; i++){
            String[] values = data[i].split(",");
            int id =  Integer.parseInt(values[0].trim());
            String FieldType = (values[1].trim());
            String Label = (values[2].trim());
            int Cost = Integer.parseInt(values[3].trim());
            int Income = Integer.parseInt(values[4].trim());
            int SeriesID = Integer.parseInt(values[5].trim());


            fields[i]=new Field(id,Label,Cost,Income);


        }

    }
    public Field getField(int id) {

        return fields[id];
    }



}
