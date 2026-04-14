import util.TextUI;

public class Board {

    private Field[] fields;
    TextUI ui = new TextUI();

    public Board(String[] fielddata, String[] carddata){
        fields = new Field[fielddata.length];
        createFields(fielddata);
//        Chance.cardDeck = new CardDeck(carddata);
    }

    private void createFields(String[] data){
        //Header - Id, FieldType, Label, Cost, Income, Series ID

        for(String s:data){
           String [] splitData = s.split(",");
           int ID = Integer.parseInt(splitData[0].trim());
            String fieldType = splitData[1].trim().toLowerCase();
           String label = splitData[2].trim();
           int cost = Integer.parseInt(splitData[3].trim());
           int income = Integer.parseInt(splitData[4].trim());
           int seriesID = Integer.parseInt(splitData[5].trim());

           Field f = null;

           switch (fieldType){
               case "startfield":
                   f = new Start(ID, label, income);
                   break;
               case "plot":
                   f = new Plot(ID, label,cost, income, seriesID);
                   break;
               case "chance":
                   f=new Chance(ID, label);
                   break;
               case "tax":
                   f=new Tax(ID, label, cost);
                   break;
               case "shippingline":
                   f=new ShippingLine(ID, label, cost, income, seriesID);
                   break;
               case "visit":
                   f= new Visit(ID, label);
                   break;
               case "brewery":
                   f=new Brewery(ID, label, cost, income, seriesID);
                   break;
               case "parking":
                   f=new Parking(ID, label);
                   break;
               case "prison":
                   f=new Prison(ID, label);
                   break;
               default: ui.displayMsg("Fieldtype ugyldig for ID: "+ID);

           }
           fields[ID-1] = f;
            System.out.println(fieldType);

        }

    }

    public Field getField(int id){

        return fields[id-1];
    }
}
