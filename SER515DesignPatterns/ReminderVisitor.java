public class ReminderVisitor extends NodeVisitor {

	private Reminder m_Reminder;

	private ClassProductList classProductList;

	public ReminderVisitor(Reminder r)
	{
		m_Reminder = r;
	}

	public void visitProduct(Product product) {

	}

	public void visitTrading(Trading trading) {

	}

	public void visitFacade(Facade facade) {
		System.out.println("Visited facade data structure");
		System.out.println(facade.nProductCategory + " is the current Product Category");
	}

}
