public class Main {
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
    }
}
