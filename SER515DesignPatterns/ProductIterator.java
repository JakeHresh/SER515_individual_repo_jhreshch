public class ProductIterator implements ListIterator {

	public ClassProductList classProductList;
	private int dex = 0;
	//private ClassProductList classProductList;

	public boolean hasNext() {
		try{
			if(classProductList.product.get(dex) != null)
			{
				return true;
			}
		}
		catch(Exception e)
		{

		}
		return false;
	}

	public Product Next() {
		try{
			Product p = classProductList.product.get(dex);
			dex++;
			return p;
		}
		catch(Exception e)
		{

		}
		return null;
	}

	public void MoveToHead() {
		dex = 0;
	}

	public void Remove() {
		classProductList.product.remove(dex);
	}

}
