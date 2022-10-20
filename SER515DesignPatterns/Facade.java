import java.util.Scanner;

public class Facade {
	public static final Scanner scan = new Scanner(System.in);

	private int UserType; // buyer = 0, seller = 1

	private Product theSelectedProduct; // The object that holds the currently selected product.

	private int nProductCategory; //The selected product category: 0: Meat, 1: Produce.

	private ClassProductList theProductList;//The list of products of the entire system.

	private Person thePerson;//The current user.

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
			return true;
		}
		if(userInput.equals("1"))
		{
			System.out.println("Hello seller!");
			this.UserType = 1;
			this.thePerson = new Seller();
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

	}
	/*
	* Create a user object according to the userinfoitem, the object
	can be a buyer or a seller*/
	public void createUser(UserInfoItem userinfoitem) {

	}
	//Create the product list of the entire system.
	public void createProductList() {

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
		return null;
	}
	/*
	* This function will call the thePerson. CreateProductMenu0
	According to the real object (buyer or seller) and the
	productLevel, it will call different menu creator and show the
	menu differently according to the usertype.*/
	public void productOperation() {

	}

}
