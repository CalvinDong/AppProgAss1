import java.util.*;
import java.text.*;
/**
 * Write a description of class Catalogue here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Catalogue
{
    private List<Part> parts;
    
    public Catalogue(){
        parts = new ArrayList<Part>();
        parts.add(new Part("evo 860","storage",155.00));
        parts.add(new Part("daskeyboard","keyboard",239.00));
        parts.add(new Part("i5","cpu",365.00));
        parts.add(new Part("Corsair 16G","memory",299.00));
        parts.add(new Part("ASUS ROG","motherboard",159.00));
        parts.add(new Part("sheetmetal box","case",39.00));
        parts.add(new Part("Ryzen 7","cpu",299.00));
    }
    
    public void addPart(String name, String type, double price){
        parts.add(new Part(name,type,price));
    }
    
    public void removePart(int number){
        if ((number-1) > parts.size() || (number-1) <= 0){
            System.out.println("The build has no part with that number.");
        }
        else{
            parts.remove(number - 1);
        }
    }
    
    public void filter(String choice, double priceFilterMin, double priceFilterMax){
        for (Part part: parts){
            if (part.hasType(choice) && part.hasPrice(priceFilterMin, priceFilterMax)){
                System.out.println((parts.indexOf(part)+1) + ". " + part);
            }
        }
    }
    
    public Part part(int choice){
        return (parts.get(choice-1));
    }

    @Override
    public String toString(){
        /*for (Part part: parts){
            return((parts.indexOf(part)+1) + ". " + part);
        }*/
        String s = "1. " + parts.get(0);
        for (int i=1; i<parts.size(); ++i){
            s = s + (System.lineSeparator() + (i+1) + ". " + parts.get(i));
        }
        return s;
    }
}
