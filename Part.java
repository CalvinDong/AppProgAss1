import java.text.*;
/**
 * Write a description of class Part here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Part
{
    private String name;
    private String type;
    private double price;
    public Part(String name, String type, double price){
        this.name = name;
        this.type = type.toUpperCase();
        this.price = price;
    }
    
    public boolean hasType(String choice){
        choice = choice.toUpperCase();
        return(choice.equals(type) || choice.equals("ALL")); 
    }
    
    public boolean hasPrice(double priceFilterMin, double priceFilterMax){
        return (price > priceFilterMin && price < priceFilterMax || priceFilterMin == -1);
    }
    
    @Override
    public String toString(){
        return type + ": " + name + " @ $" + formatted(price); 
    }
    
    private String formatted(double money) {
        return new DecimalFormat("######0.00").format(money);
    }
}
