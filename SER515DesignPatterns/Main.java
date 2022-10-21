import java.util.Scanner;

public class Main {
    public static final Scanner scan = new Scanner(System.in);
    public static void main(String args[]) {
        System.out.println("Hello!");
        Facade facade = new Facade(0, null, 0, null, null);
        System.out.println("Welcome to the SER515 Design Patterns Demo!");
        System.out.println("For demonstration purposes, the system will assume you are already known in the system.");
        System.out.println("Therefore, to login, just indicate whether you are a buyer (0) or a seller (1).");
        boolean login = facade.login();
        while(!login)
        {
            login = facade.login();
        }
        facade.createProductList();
        // Below acts as the main loop.
        while(true)
        {
            // Use Product Iterator to Display Class Product List or Use Offering Iterator to Display Trading List
            // To Select Product from List, start with Reminder, which creates a Node Visitor.
            // Node Visitor has a Reminder Visitor child.
            // Facade's Class Product List Accepts Reminder Visitor.
            // Reminder Visitor then Visits Product or Trading
            System.out.println("What would you like to do? (Select option by number)");
            System.out.println("1. Trigger Reminder Visitor For Visiting Facade");
            System.out.println("2. Select Product"); // This will trigger the question "What product would you like to select?" and display all products. After product is selected, Product Menu will be built
            System.out.println("3. Exit");
            String decision = scan.nextLine();
            if(decision.equals("1")){
                // The following triggers the Remind Visitor, which in this case visits the Facade data structure.
                facade.remind();
            }
            if(decision.equals("2")){
                System.out.println(facade.SelectProduct().ProductName);
                // The following conditionals checking User Types demonstrates the use of the Bridge Pattern,
                // which loads a different menu based on the User Type.

                // The showMenu calls also help kick off the functionality of the Factory Pattern,
                // which builds different menus (using print lines) based on whether the selected
                // product is Meat or Produce.
                if(facade.UserType == 0)
                {
                    Buyer b = (Buyer)facade.thePerson;
                    b.facade = facade;
                    b.showMenu();
                }
                if(facade.UserType == 1)
                {
                    Seller s = (Seller)facade.thePerson;
                    s.facade = facade;
                    s.showMenu();
                }
            }
            if(decision.equals("3"))
            {
                return;
            }
        }
    }
}
