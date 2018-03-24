# AST for genetic algorithms

An abstract syntax tree, implemented for use in genetic algorithms as an item instance in a population. 

## Context

The trees generated are abstract, however, in order to later evaluate the tree and give it a fitness score we must provide the tree with context containing information regarding its environment.

This implementation currently supports a simple context object containing variable values.

```
Context context = new Context(0.123 ,3.456, 6.789);
Integer id = context.getRandomVarId();
System.out.println(“Var” + id + “ = ”context.getVarValue(id));
```
Here a Context object is created containing three variables, each variable is assigned an integer Id.
A random id is selected from the context and the value is printed.
Output will be one of the following:
```
Var0 = 0.123
```
```
Var1 = 3.456
```
```
Var2 = 6.789
```

## Tree

Multiple random AST is needed in order to initialize the population.
A random tree can be generated and limited to a minimum and maximum depth.

```
Context context = new Context(0.123 ,3.456, 6.789);
Tree tree = new Tree(context);
tree.randomTree(2,5);
```
Here a Tree object is created with the a given context, a minimum depth of 2 and a maximum depth of 5.

The tree can be printed in pre-order and evaluated:

```
System.out.println(tree);
System.out.println("value for test context: " + tree.parse());
```

A possible output could be:
```
	IF_ELSE
		>
			VAR1
			/
				4.8384364202537835
				MAX
					VAR2
					MIN
						3.8938190322623463
						VAR1
		IF_ELSE
			<
				VAR0
				-3.3787454345746837
			*
				MAX
					MIN
						4.9138656390546345
						VAR1
					-4.080204168206379
				VAR1
			1.202133789377969
		IF_ELSE
			<
				MIN
					VAR2
					/
						VAR0
						VAR2
				VAR2
			IF_ELSE
				AND
					VAR1
					VAR0
				VAR0
				-
					VAR0
					VAR2
			/
				VAR1
				IF_ELSE
					<
						-3.36724944035945
						VAR1
					VAR2
					VAR0

value for test context: 1.202133789377969
```



## Upcoming

The following features and improvements are planned:
* Trees Crossover function
* Context dependent function tree nodes
* Random node types probability control
and more...

