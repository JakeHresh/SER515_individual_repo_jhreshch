public class Seller extends Person {
	public Facade facade;

	public void showMenu() {
		System.out.println("Showing Seller Menu");
		theProductMenu = CreateProductMenu();
		if(theProductMenu != null)
		{
			theProductMenu.showAddButton();
			theProductMenu.showViewButton();
			theProductMenu.showRadioButton();
			theProductMenu.showLabels();
			theProductMenu.showComboxes();
		}
	}

	public ProductMenu CreateProductMenu() {
		if(facade.nProductCategory == 0)
			return new MeatProductMenu();
		if(facade.nProductCategory == 1)
			return new ProduceProductMenu();
		return null;
	}

}
