Java Journal!
This bullet journal program allows you to write and save task and events for a week.
You can save these to a file for later. This journa also supports adding a limit for how many
tasks you can have in a day. This is a great way to keep track of your tasks and events for the week!

GUI:

- https://ibb.co/Qk6m2nH

SOLID Principles:

- Single Responsibility Principle: Each class is only responsible for a single job in the bullet
  journal.
- Open/Closed Principle: The controller class and its supporting model classes are open for
  extension but closed for modification. This is because the Journal class can be extended to
  add more functionality, but the classes do not need to be modified to add more functionality.
- Liskov Substitution Principle: This application makes use of an abstract "Commitment" class.
  This allows for the use of the "Commitment" class to be used in place of its subclasses.
- Interface Segregation Principle: Interfaces and classes in this BuJo project contain only the methods
  that they require to function.
- Dependency Inversion Principle: The controller class is injected with the Week that it displays.
  This allows for the controller to be independent of the Week class.

Possible Extensions:

- With my "initButton" method in the controller class, we could add a popup that allows a user to
  enter a quote to be saves on the main screen. This popup would save its data to the Week class,
  where it would be persisted.