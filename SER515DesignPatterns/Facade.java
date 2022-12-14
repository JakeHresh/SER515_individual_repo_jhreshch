import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
//
public class Facade {
	public static final Scanner scan = new Scanner(System.in);

	public int UserType; // buyer = 0, seller = 1

	private Product theSelectedProduct; // The object that holds the currently selected product.

	public int nProductCategory; //The selected product category: 0: Meat, 1: Produce.

	public ClassProductList theProductList;//The list of products of the entire system.

	public Person thePerson;//The current user.

	public Facade(int userType, Product selectedProduct, int productCategory, ClassProductList classProductList, Person person)
	{
		UserType = userType;
		theSelectedProduct = selectedProduct;
		nProductCategory = productCategory;
		theProductList = classProductList;
		thePerson = person;
	}
	//Show login GUI and return the login result.
	public boolean login() {
		System.out.println("Are you a buyer (0) or a seller (1)?");
		String userInput = scan.nextLine();
		if(userInput.equals("0"))
		{
			System.out.println("Hello buyer!");
			this.UserType = 0;
			this.thePerson = new Buyer();
			boolean loop = true;
			while(loop)
			{
				// prompt user for login credentials, then read the buyer text file to see if it matches.
				System.out.println("Please provide your username");
				String username = scan.nextLine();
				System.out.println("Please provide your password");
				String password = scan.nextLine();
				String loginCheck = username + ":" + password;

				System.out.println("FOR THE GRADER: Please provide the path to the Buyer Info file for logging in. MAKE SURE THERE ARE NO SPACES");
				System.out.println("e.g. \"C:\\\\Users\\\\jakey\\\\Desktop\\\\BuyerInfo.txt\"");
				String in = scan.nextLine();
				try {
					File file = new File(in);
					Scanner filescan = new Scanner(file);
					while(filescan.hasNextLine())
					{
						//this.theProductList.product.add(new Product(this.theProductList, null, filescan.nextLine()));
						if(loginCheck.equals(filescan.nextLine()))
						{
							loop = false;
							System.out.println("Welcome!");
							this.thePerson.personName = loginCheck;
						}
					}
				}
				catch(Exception e) {
					System.out.println(e);
					System.out.println("Path not found. MAKE SURE THERE ARE NO SPACES. Try again.");
				}
				if(loop)
				{
					System.out.println("Buyer login doesn't match records. Try again.");
				}
			}
			return true;
		}
		if(userInput.equals("1"))
		{
			System.out.println("Hello seller!");
			this.UserType = 1;
			this.thePerson = new Seller();
			boolean loop = true;
			while(loop)
			{
				// prompt user for login credentials, then read the seller text file to see if it matches.
				System.out.println("Please provide your username");
				String username = scan.nextLine();
				System.out.println("Please provide your password");
				String password = scan.nextLine();
				String loginCheck = username + ":" + password;

				System.out.println("FOR THE GRADER: Please provide the path to the Seller Info file for logging in. MAKE SURE THERE ARE NO SPACES");
				System.out.println("e.g. \"C:\\\\Users\\\\jakey\\\\Desktop\\\\SellerInfo.txt\"");
				String in = scan.nextLine();
				try {
					File file = new File(in);
					Scanner filescan = new Scanner(file);
					while(filescan.hasNextLine())
					{
						//this.theProductList.product.add(new Product(this.theProductList, null, filescan.nextLine()));
						if(loginCheck.equals(filescan.nextLine()))
						{
							loop = false;
							System.out.println("Welcome!");
							this.thePerson.personName = loginCheck;
						}
					}
				}
				catch(Exception e) {
					System.out.println(e);
					System.out.println("Path not found. MAKE SURE THERE ARE NO SPACES. Try again.");
				}
				if(loop)
				{
					System.out.println("Seller login doesn't match records. Try again.");
				}
			}
			return true;
		}
		return false;
	}
	/*
	* When clicking the add button of the ProductMenu, call this
	function. This function will add a new trade and fill in the
	required information. This function will be called
	SellerTradingMenu or BuyerTradingMenu based on the type of
	the user. It will not update the product menu. The product menu
	needs to be refreshed outside the function.*/
	public void addTrading() {

	}
	/*
	* When clicking the view button of the ProductMenu, call this
	function and pass the pointer of the Trading and the person
	pointer to this function.
	This function will view the trading information.
	This function will call SellerTradingMenu or BuyerTradingMenu
	according to the type of the user.*/
	public void viewTrading() {

	}
	/*
	* This function will view the given offering.*/
	public void decideBidding() {

	}
	//Set the deal flag of the given offering.
	public void discussBidding() {

	}
	//Used by the buyer to submit the offering.
	public void submitBidding() {

	}
	/*
	* Show the remind box to remind buyer of the upcoming overdue
	trading window.*/
	public void remind() {
		Reminder rm = new Reminder();
		ReminderVisitor r = new ReminderVisitor(rm);
		r.visitFacade(this);
	}
	/*
	* Create a user object according to the userinfoitem, the object
	can be a buyer or a seller*/
	public void createUser(UserInfoItem userinfoitem) {

	}
	//Create the product list of the entire system.
	public void createProductList() {
		this.theProductList = new ClassProductList();
		this.theProductList.product = new ArrayList<Product>();
		this.theProductList.productIterator = new ProductIterator();
		this.theProductList.productIterator.classProductList = this.theProductList;
		boolean loop = true;
		while(loop)
		{
			System.out.println("Please provide the file path for the Product List Information. MAKE SURE THERE ARE NO SPACES.");
			System.out.println("e.g. \"C:\\\\Users\\\\jakey\\\\Desktop\\\\ProductInfo.txt\"");
			String userInput = scan.nextLine();
			try {
				File file = new File(userInput);
				Scanner filescan = new Scanner(file);
				while(filescan.hasNextLine())
				{
					this.theProductList.product.add(new Product(this.theProductList, null, filescan.nextLine()));
				}
				loop = false;
			}
			catch(Exception e) {
				System.out.println(e);
				System.out.println("Path not found. MAKE SURE THERE ARE NO SPACES. Try again.");
			}
		}
		this.theProductList.product.forEach((p) -> System.out.println(p.ProductName));
	}
	/*
	* Call this function after creating the user. Create productList by
	reading the UserProduct.txt file. Match the product name with
	theProductList. Attach the matched product object to the new
	create user: Facade.thePerson. ProductList*/
	public void AttachProductToUser() {

	}
	//Show the Product list in a Dialog and return the selected product.
	public Product SelectProduct() {
		// The following loop is sufficient to demonstrate that the Iterator Pattern is successfully implemented.
		while(this.theProductList.productIterator.hasNext())
		{
			System.out.println(this.theProductList.productIterator.Next().ProductName);
		}
		this.theProductList.productIterator.MoveToHead();
		System.out.println("What product would you like to select? (Please spell it out correctly as the products were listed)");
		String selection = scan.nextLine();
		boolean stop = false;
		Product p = null;
		while(this.theProductList.productIterator.hasNext() && !stop)
		{
			p = this.theProductList.productIterator.Next();
			if(p.ProductName.equals(selection))
			{
				//System.out.println(p.ProductName);
				stop = true;
			}
		}
		this.theProductList.productIterator.MoveToHead();
		this.theSelectedProduct = p;
		if(p.ProductName.contains("Meat"))
		{
			nProductCategory = 0;
		}
		if(p.ProductName.contains("Produce"))
		{
			nProductCategory = 1;
		}
		return p;
	}
	/*
	* This function will call the thePerson. CreateProductMenu0
	According to the real object (buyer or seller) and the
	productLevel, it will call different menu creator and show the
	menu differently according to the usertype.*/
	public void productOperation() {

	}

}
