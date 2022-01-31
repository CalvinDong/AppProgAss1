import java.util.*;
/**
 * Write a description of class Build here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Build
{
    private List<Part> parts;
    public Build(){
        parts = new ArrayList<Part>();
        double cost = 0;
    }
    
    public void addPart(int choice, Catalogue catalogue){
        System.out.println(catalogue);
        parts.add(catalogue.part(choice));
    }
    
    @Override
    public String toString(){
        if(parts.size() == 0){
            return "";
        }
        return("hehe");
    }
}
