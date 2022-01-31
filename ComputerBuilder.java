
/**
 * Write a description of class ComputerBuilder here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ComputerBuilder
{
    private Catalogue catalogue;
    private Build currentBuild;
    
    public static void main(String args[]){
        ComputerBuilder computerbuilder = new ComputerBuilder();
        System.out.println("Welcome to Jaime's Computer Store");
        System.out.println("Quality Parts at the Best Prices");
        System.out.println("================================= ");
        computerbuilder.use();
    }
    
    public ComputerBuilder(){
        catalogue = new Catalogue();
        currentBuild = new Build();
    }
    
    private void use(){
        System.out.println("1. Catalogue Menu");
        System.out.println("2. Build Menu");
        System.out.println("3. Exit");
        System.out.print("Select option: ");
        char choice = readChoice();
        switch(choice){
            case'1': System.out.println("Welcome to the parts catalogue.");
                     catalogueMenu();break;
            case'2': System.out.println("Let's build a 1337 box!");
                     buildMenu();break;
            case'3': break;
            default: help(choice);break;
        }
    }
    
    private void catalogueMenu(){
        System.out.print("Enter choice (a/r/s/f/x): ");
        char choice = readChoice();
        switch(choice){
            case'a': askPartToAdd();break;
            case'r': removePartCat();break;
            case's': viewCatalogue();break;
            case'f': filterCatalogue();break;
            case'x': use();break;
            default: helpCatalogue(choice);break;
        }
    }
    
    private void askPartToAdd(){
        System.out.print("Enter part name: ");
        String name = readWords();
        System.out.print("Enter part type: ");
        String type = readWords();
        System.out.print("Enter part price: ");
        double price = readPrice();
        catalogue.addPart(name,type,price);
        catalogueMenu();
    }
    
    private void removePartCat(){
        System.out.print("Enter catalogue number of part to remove: ");
        int number = readNumber();
        catalogue.removePart(number);
        catalogueMenu();
    }
    
    private void viewCatalogue(){
        System.out.println(catalogue);
        catalogueMenu();
    }
    
    private void filterCatalogue(){
        System.out.print("Enter type of part to view ('all' for no filtering): ");
        String choice = readWords();
        System.out.print("Enter minimum price ('-1' for no filtering): ");
        double priceFilterMin = readNumber();
        double priceFilterMax = 0;
        if (priceFilterMin != -1){
            System.out.print("Enter maximum price: ");
            priceFilterMax = readNumber();
            if (priceFilterMax < priceFilterMin){
                System.out.println("Minimum price shouldn't be greater than maximum price.");
            }
        }
        if (priceFilterMax >= priceFilterMin){
                catalogue.filter(choice,priceFilterMin,priceFilterMax);
        }
        catalogueMenu();
    }
    
    private void buildMenu(){
        System.out.print("Enter choice (n/a/r/v/c/x): ");
        char choice = readChoice();
        switch(choice){
            case'n': newBuild();break;
            case'a': addToBuild();break;
            case'r': removeFromBuild();break;
            case'c': checkBuild();break;
            case'v': viewBuild();break;
            case'x': use();break;
            default: helpBuild(choice);break;
        }
    }
    
    private void newBuild(){
        
    }
    
    private void addToBuild(){
        System.out.print("Enter catalogue number of the part: ");
        int choice = In.nextInt();
        currentBuild.addPart(choice, catalogue);
        buildMenu();
    }
    
    private void removeFromBuild(){
        
    }
    
    private void viewBuild(){
        
    }
    
    private void checkBuild(){
        
    }
    
    public char readChoice(){
        return In.nextChar();
    }
    
    public String readWords(){
        return In.nextLine();
    }
    
    public double readPrice(){
        return In.nextDouble();
    }
    
    public int readNumber(){
        return In.nextInt();
    }
    
    private void help(char choice){
        System.out.println("1 = interact with the catalogue");
        System.out.println("2 = build your computer!");
        System.out.println(choice + " = this help message");
        use();
    }
    
    private void helpCatalogue(char choice){
        System.out.println("a = add a new part to the catalogue");
        System.out.println("r = remove a part from the catalogue");
        System.out.println("s = show the catalogue");
        System.out.println("f = show a filtered view of the catalogue");
        System.out.println(choice + " = this help message");
        catalogueMenu();
    }
    
    private void helpBuild(char choice){
        System.out.println("n = start a new build (clears old build) ");
        System.out.println("a = add a part from the catalogue to the build  ");
        System.out.println("r = remove a part from the build  ");
        System.out.println("v = show the current state of the build");
        System.out.println("c = check if the build is a functional computer ");
        System.out.println(choice + " = this help message");
        buildMenu();
    }
}
