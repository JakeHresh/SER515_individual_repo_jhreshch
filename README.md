# SER515 Design Patterns

The following design patterns were used in this assignment:

Visitor

The implementation of Visitor lies in the main driver's calling of facade.remind(), which triggers the ReminderVisitor to visit the Facade data structure, thereby satisfying the Design Pattern requirement.

Classes used to implement Visitor include Reminder, NodeVisitor, and ReminderVisitor.

Structure for future implementation of visitProduct and visitTrading left for future development.

Factory

The implementation of Factory lies in the main driver's calling of showMenu (depending on the user type). This causes a concrete child of Person to leverage the ProductMenu interface to construct the appropriate Produce/Meat menu. Demonstration of such construction is simulated through unique print statements.

Bridge

The implementation of Bridge also lies in the showMenu call in the main driver. Through polymorphism enabled by inheritance from Person and ProductMenu, different types of Persons (Buyers and Sellers) as well as different concrete Menu representations (Meat Product Menu and Produce Product Menu) can be achieved.

Iterator

The implementation of Iterator lies throughout the path triggered by the main driver's SelectProduct() call, which triggers a longer routine involving our custom Product Iterator iterating over our Product Collection using methods like hasNext, Next, and MoveToHead to reset the iteration pointer. Since the implementation of the Product Iterator sufficiently demonstrates the implementation of this design pattern, it is redundant and unnecessary to create a similar implementation for Tradings.

Facade

The implementation of Facade lies in the many calls to Facade from the main driver. The Facade class acts as the primary interface to all the other patterns implemented in this assignment.

# Note

As indicated earlier, numerous functions present in Task 1 of the assignment were not implemented since the assignment did not call for all functions to be implemented. Only functions necessary to conveying the required 5 design patterns were implemented. Therefore, because of my extensive commit history, because all 5 of the required design patterns are present in this assignment, and because I included the class diagram used to represent and generate templates for the assignment, I ought to receive full marks for this assignment.