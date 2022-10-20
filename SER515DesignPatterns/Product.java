public class Product {

	private ClassProductList classProductList;

	private Trading trading;

	public String ProductName;

	public Product(ClassProductList cpl, Trading t, String pn)
	{
		classProductList = cpl;
		trading = t;
		ProductName = pn;
	}
}
