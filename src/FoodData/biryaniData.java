package FoodData;



import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Ashutosh
 */
public class biryaniData {

    private final StringProperty biryaniitem;
    private final StringProperty biryaniprice;

   /* public int getPrice() {
        String s = biryaniprice.getValue();
        return Integer.parseInt(s.split("-")[1]);
    }*/

    public biryaniData(String biryaniitem, String biryaniprice) {
        this.biryaniitem = new SimpleStringProperty(biryaniitem);
        this.biryaniprice = new SimpleStringProperty(biryaniprice);
    }

    public StringProperty getBiryaniitem() {
        return biryaniitem;
    }

    public StringProperty biryaniitemProperty() {
        return biryaniitem;
    }

    public void setbiryaniitem(String biryaniitem) {
        this.biryaniitem.set(biryaniitem);
    }

    public StringProperty getBiryaniprice() {
        return biryaniprice;
    }

    public StringProperty biryanipriceProperty() {
        return biryaniprice;

    }

    public void setbiryaniprice(String biryaniprice) {
        this.biryaniprice.set(biryaniprice);
    }

}
