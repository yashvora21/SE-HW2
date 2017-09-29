# HW2
This Repo has all the files related to HW2 of Software Engineering for Fall 17

## Design Patterns
Design patterns generally help in speeding up the development process by defining tested, and proven development paradigms. There may be many issues that stay hidden until we actually start the implementation and use of the design patterns effectively helps us consider these issues well in advance which may cause major problems in the later stages of the project. Design Patterns are very well documented in a format and are mostly used for a generalized problem as a whole while not just focussing on a single problem. For Object-Oriented design patterns, they can be described in the following categories:

### 1. Creational Design Patterns
These design patterns generally focus on the class instantiation which can be further divided into class-creation patterns and object-creational patterns. The class-creation patterns use inheritance effectively in the instantiation process while object-creation patterns use delegation effectively to get the job done. These type of design patterns includes but not limited to the following patterns:

#### i. Abstract Factory Design Pattern
The Abstract Factory Design basically provides an interface for creating families of related or dependent objects without specifying their concrete classes. This factory creates the platform objects directly for the clients  as the "factory" object holds the responsibility for providing creation services for the entire platform family. The exchanging of product families becomes quite easy by this mechanism as the specific class of the factory object appears only once in the application - where it is instantiated. The application can completely replace the entire family of products simply by instantiating a different concrete instance of the abstract factory. This factory is usually implemented as a Singleton as the services provided by it are quite widespread. 

The Abstract Factory defines a Factory Method per product. Each Factory Method encapsulates the new operator and the concrete, platform-specific, product classes. Each "platform" is then modeled with a Factory derived class.  

#### Few facts about Abstract Factory Design Pattern
**1.** Abstract Factory classes are often implemented with Factory Methods, but they can also be implemented using Prototype.  
**2.** Abstract Factory can be used as an alternative to Facade to hide platform-specific classes.  
**3.** Often, designs start out using Factory Method (less complicated, more customizable, subclasses proliferate) and evolve toward Abstract Factory, Prototype, or Builder (more flexible, more complex) as the designer discovers where more flexibility is needed.


#### ii. Prototype Design Pattern
The Prototype is an early sample, model, or release of a product built in any Design to test a concept or process or to act as a thing to be replicated or learned from. Likewise, the Prototype Design Pattern basically specifies the kinds of objects to create using a prototypical instance, and also create new objects by copying this prototype. This is basically achieved by declaring an abstract base class that specifies a pure virtual "clone" method, and, maintains a dictionary of all "cloneable" concrete derived classes. Any class that needs a "polymorphic constructor" capability: derives itself from the abstract base class, registers its prototypical instance, and implements the clone() operation. The client then, basically does not invoke the "new" operator on a hard-wired class name, but calls a "clone" operation on the abstract base class, supplying a string or enumerated data type that designates the particular concrete derived class desired.

#### Some Checklist points to maintain for this design pattern:  
* Add a clone() method to the existing "product" hierarchy.
* Design a "registry" that maintains a cache of prototypical objects. The registry could be encapsulated in a new Factory class, or in the base class of the "product" hierarchy.
* Design a factory method that: may (or may not) accept arguments, finds the correct prototype object, calls clone() on that object, and returns the result.
* The client replaces all references to the new operator with calls to the factory method.

#### Few facts about Prototype Design Pattern
**1.** Prototype doesn't require subclassing, but it does require an "initialize" operation. Factory Method requires subclassing, but doesn't require Initialize.  
**2.** Protoype is often beneficial for designs that make heavy use of the Composite and Decorator patterns.  
**3.** Prototype co-opts one instance of a class for use as a breeder of all future instances.  
**4.** Prototypes are useful when object initialization is expensive, and few variations are anticipated on the initialization parameters. In this context, Prototype can avoid expensive "creation from scratch", and support cheap cloning of a pre-initialized prototype.  

### 2. Structural Patterns
Structural Patterns are very important in Software Engineering as they help in better understanding of the design by identifying a simple way to realize relationships between entities. The Structural design patterns includes but not limited to the following patterns:  

#### i. Facade Design Pattern
Facade Design Pattern basically defines a higher-level interface and provides a unified interface to a set of interfaces in a subsystem making it easier to use. Facade basically wraps and encapsulates a complicated subsystem with a single simpler interface object, thus reducing the efforts in the learning involved to successfully leverage the subsystem. It also encourages decoupling of the subsystem from its potentially many clients. Also, if the Facade is the only access point for the subsystem, it will limit the features and flexibility that "power users" may need. The facade object should be a pretty simple advocate or facilitator.

#### Things to note for a Facade Design pattern:  
* Identify a simpler, unified interface for the subsystem or component.
* Design a 'wrapper' class that encapsulates the subsystem.
* The facade/wrapper captures the complexity and collaborations of the component, and delegates to the appropriate methods.
* The client uses (is coupled to) the Facade only.
* Consider whether additional Facades would add value.

#### Use Case for a Facade:
One of the best use cases for a facade is a customer care representative answering calls for an online ordering portal where a consumer calls a number to order something. In that case, the customer care representative acts as an inteface between several departments such as the order delivery department or the billing or the quality department.

#### ii. Private Class Data
Private Class Data is very important type of design pattern required by every application which provides control over the write access to class attributes, seperates data from the methods that use it and encapsulates class data initialization. This design pattern basically addresses a problem where a class may expose its class variables to be accessed and manipulated by anyone but it should no longer be modified. The protection of the class state by minimizing the visibility of its attribute was the sole motivation behind devising this design pattern.

#### Things to note for the Private Class Data
* Create data class. Move to data class all attributes that need hiding.
* Create in main class instance of data class.
* Main class must initialize data class through the data class's constructor.
* Expose each attribute (variable or property) of data class through a getter.
* Expose each attribute that will change in further through a setter.

### 3. Behavioral Patterns
Behavioral Patterns are those design patterns in software engineering that identify common communication patterns between objects and realize these patterns thus increasing flexibility in carrying out this communication. The very fundamental duties of this pattern are the assignment of responsibilities between objects, or, encapsulating behavior in an object and delegating requests to it. The following Behavioral patterns helps to understand this design pattern better:

#### i. Command Design Pattern
This pattern basically encapsulates a request as an object, that basically parameterizes clients with different requests, queue or log requests, and support undoable operations. It is an object-oriented callback which invokes a method on an object to full object status. There could be situations where we need to issue requests to objects without having any knowledge about the operation being requested or the receiver of the request. 





