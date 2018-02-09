package FoodData;



import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Ashutosh
 */
public class seaFoodData {

    private final StringProperty seafooditem;
    private final StringProperty seafoodprice;

  /*  public int getPrice() {
        String s = seafoodprice.getValue();
        return Integer.parseInt(s.split("-")[1]);
    }*/

    public seaFoodData(String seafooditem, String seafoodprice) {
        this.seafooditem = new SimpleStringProperty(seafooditem);
        this.seafoodprice = new SimpleStringProperty(seafoodprice);
    }

    public StringProperty getseafooditem() {
        return seafooditem;
    }

    public StringProperty seafooditemProperty() {
        return seafooditem;
    }

    public void setseafooditem(String seafooditem) {
        this.seafooditem.set(seafooditem);
    }

    public StringProperty getseafoodprice() {
        return seafoodprice;
    }

    public StringProperty seafoodpriceProperty() {
        return seafoodprice;

    }

    public void setseafoodprice(String seafoodprice) {
        this.seafoodprice.set(seafoodprice);
    }

}
