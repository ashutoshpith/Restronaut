
package sample;

/**
 *
 * @author Ashutosh
 */
public enum option {
    stater,desert,biryani,seafood;
    
    private option(){
        
    }
    public String value(){
        return name();
        
    }
    public static option fromvalue(String v){
        return valueOf(v);
    }
}
