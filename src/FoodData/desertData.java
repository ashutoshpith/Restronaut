package FoodData;



import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Ashutosh
 */
public class desertData {

    private final StringProperty desertitem;
    private final StringProperty desertprice;

  /*  public int getPrice() {
        String s = desertprice.getValue();
        return Integer.parseInt(s.split("-")[1]);
    }*/

    public desertData(String desertitem, String desertprice) {
        this.desertitem = new SimpleStringProperty(desertitem);
        this.desertprice = new SimpleStringProperty(desertprice);
    }

    public StringProperty getdesertitem() {
        return desertitem;
    }

    public StringProperty desertitemProperty() {
        return desertitem;
    }

    public void setdesertitem(String desertitem) {
        this.desertitem.set(desertitem);
    }

    public StringProperty getdesertprice() {
        return desertprice;
    }

    public StringProperty desertpriceProperty() {
        return desertprice;
    }

    public void setdesertprice(String desertprice) {
        this.desertprice.set(desertprice);
    }

}

