package FoodData;




import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Ashutosh
 */
public class oderData {
    private final StringProperty item;
    //  private final int pri;
    private final StringProperty price ;

    public oderData(String item,String price){
        this.item=new SimpleStringProperty(item);
        this.price=new SimpleStringProperty(price);
    }

    public StringProperty getitem() {
        return item;
    }
    public StringProperty itemProperty(){
        return item;
    }
    public void setitem(String item){
        this.item.set(item);
    }

    public StringProperty getPrice() {
        return price;
    }
    public StringProperty priceProperty(){
        return price;
    }
    public void setprice(String price){
        this.price.set(price);
    }








}

