package FoodData;



import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Ashutosh
 */
public class staterData {

    private final StringProperty stateritem;
    private final StringProperty staterprice;

    public staterData(String stateritem, String staterprice) {
        this.stateritem = new SimpleStringProperty(stateritem);
        this.staterprice = new SimpleStringProperty(staterprice);

    }

    public StringProperty getstateritem() {
        return stateritem;
    }

    public StringProperty stateritemProperty() {
        return stateritem;
    }

    public void setstateritem(String stateritem) {
        this.stateritem.set(stateritem);
    }

    public StringProperty getstaterprice() {
        return staterprice;
    }

    public StringProperty staterpriceProperty() {
        return staterprice;
    }

    public void setstaterprice(String staterprice) {
        this.staterprice.set(staterprice);
    }

    public int getPrice() {
        String s = staterprice.getValue();
        return Integer.parseInt(s.split("-")[1]);
    }

}

