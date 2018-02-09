package Admin;

import java.sql.Connection;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Ashutosh
 */
public class adminInfo {

    private final StringProperty name;

    public adminInfo(String name){
        this.name=new SimpleStringProperty(name);
    }

    public StringProperty getName() {
        return name;
    }

    public StringProperty nameProperty(){
        return name;
    }
    public void setname(String name){
        this.name.set(name);
    }



}
