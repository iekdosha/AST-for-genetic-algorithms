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
tree.randomTree(3,5);
```
Here a Tree object is created with the a given context, a minimum depth of 2 and a maximum depth of 5.

The tree can be printed in pre-order and evaluated:

```
System.out.println(tree);
System.out.println("value for test context: " + tree.parse());
```

A possible output could be:
```
	|IF_ELSE
	|	|GT
	|	|	|IF_ELSE
	|	|	|	|LT
	|	|	|	|	|ADD
	|	|	|	|	|	|VAR1
	|	|	|	|	|	|-1.5299720926406222
	|	|	|	|	|VAR0
	|	|	|	|DIV
	|	|	|	|	|VAR2
	|	|	|	|	|VAR1
	|	|	|	|VAR0
	|	|	|VAR1
	|	|IF_ELSE
	|	|	|AND
	|	|	|	|LT
	|	|	|	|	|-2.4596438258446462
	|	|	|	|	|VAR1
	|	|	|	|GT
	|	|	|	|	|2.793188613935202
	|	|	|	|	|VAR1
	|	|	|IF_ELSE
	|	|	|	|GT
	|	|	|	|	|VAR2
	|	|	|	|	|MUL
	|	|	|	|	|	|VAR1
	|	|	|	|	|	|VAR2
	|	|	|	|DIV
	|	|	|	|	|MIN
	|	|	|	|	|	|VAR0
	|	|	|	|	|	|VAR1
	|	|	|	|	|VAR2
	|	|	|	|VAR2
	|	|	|IF_ELSE
	|	|	|	|OR
	|	|	|	|	|VAR1
	|	|	|	|	|LT
	|	|	|	|	|	|VAR2
	|	|	|	|	|	|VAR1
	|	|	|	|VAR2
	|	|	|	|ADD
	|	|	|	|	|MIN
	|	|	|	|	|	|VAR1
	|	|	|	|	|	|VAR2
	|	|	|	|	|VAR2
	|	|MUL
	|	|	|ADD
	|	|	|	|MUL
	|	|	|	|	|VAR1
	|	|	|	|	|VAR0
	|	|	|	|DIV
	|	|	|	|	|MIN
	|	|	|	|	|	|-0.12484554171563467
	|	|	|	|	|	|VAR2
	|	|	|	|	|VAR2
	|	|	|MIN
	|	|	|	|MUL
	|	|	|	|	|2.8466134133913084
	|	|	|	|	|VAR2
	|	|	|	|VAR1

value for test context: 27.540763968451653
```



## Upcoming

The following features and improvements are planned:
* Trees Crossover function
* Context dependent function tree nodes
* Random node types probability control

and more...

