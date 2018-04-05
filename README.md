# AST for genetic algorithms

An abstract syntax tree, implemented for use in genetic algorithms as an item instance in a population. 

## Context

The trees generated are abstract, however, in order to later evaluate the tree and give it a fitness score we must provide the tree with context containing information regarding its environment.

This implementation currently presents a simple context object containing variable values, this is done only to illustrate the Context concept.
The Context class could be a game board or any other environment containing the relevant information

```
Context context = new Context(0.123 ,3.456, 6.789);
Integer id = context.getRandomVarId();
System.out.println("Var" + id + " = " + context.getVarValue(id));
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
Tree tree = new Tree();
tree.randomTree(3,5);
```
Here a Tree object is created with the a given context, a minimum depth of 2 and a maximum depth of 5.

The tree can be printed in pre-order and evaluated:

```
System.out.println(tree);
Context context = new Context(0.123 ,3.456, 6.789);
System.out.println("value for test context: " + tree.parse(context));
```

A possible output could be:
```
	|ADD
	|	|IF_ELSE
	|	|	|GT
	|	|	|	|SUB
	|	|	|	|	|VAR1
	|	|	|	|	|ADD
	|	|	|	|	|	|VAR1
	|	|	|	|	|	|3.572
	|	|	|	|MIN
	|	|	|	|	|VAR1
	|	|	|	|	|SUB
	|	|	|	|	|	|2.021
	|	|	|	|	|	|VAR0
	|	|	|SUB
	|	|	|	|ADD
	|	|	|	|	|VAR2
	|	|	|	|	|-1.954
	|	|	|	|VAR2
	|	|	|IF_ELSE
	|	|	|	|GT
	|	|	|	|	|ADD
	|	|	|	|	|	|-1.933
	|	|	|	|	|	|-4.821
	|	|	|	|	|SUB
	|	|	|	|	|	|VAR2
	|	|	|	|	|	|VAR1
	|	|	|	|DIV
	|	|	|	|	|-4.824
	|	|	|	|	|3.234
	|	|	|	|VAR1
	|	|SUB
	|	|	|IF_ELSE
	|	|	|	|GT
	|	|	|	|	|MAX
	|	|	|	|	|	|VAR1
	|	|	|	|	|	|-4.167
	|	|	|	|	|MAX
	|	|	|	|	|	|3.052
	|	|	|	|	|	|3.435
	|	|	|	|-3.534
	|	|	|	|VAR1
	|	|	|ADD
	|	|	|	|DIV
	|	|	|	|	|MIN
	|	|	|	|	|	|VAR2
	|	|	|	|	|	|-1.392
	|	|	|	|	|MAX
	|	|	|	|	|	|VAR2
	|	|	|	|	|	|VAR2
	|	|	|	|MIN
	|	|	|	|	|0.257
	|	|	|	|	|VAR0
```

## Probability Tree

The probability tree controls the chances to get any type of node when a random tree is created.
The tree is constructed out of factories and class objects as leaves.
Probabilities (weights) come pre determined but can be adjusted.

In order to visually see the probabilities construct the following tree and print the content:

```
ProbabilityTree probabilityTree = new ProbabilityTree(FunctionNodeFactory.getInstance());
probabilityTree.printProbabilityTree();
```

The output will be:
```
	{}Function Node
		{0.167}Conditional Node
			{1.000}IfElseNode
		{0.333}Arithmetic Node
			{0.167}SubNode
			{0.167}DivNode
			{0.167}MinNode
			{0.167}MulNode
			{0.167}AddNode
			{0.167}MaxNode
		{0.500}Leaf Node
			{0.500}ConstantNode
			{0.500}VariableNode
```

The leaf probability is not valid where the depth restrictions given for the tree apply.
in our case the Leaf Node is only relevant when the depth is between depths 3 and 5.

The ```LogicalNodeFactory``` tree can be printed in the same manner, the output will be:

```
	{}Logical Node
		{0.333}Compare Node
			{0.500}LessThanNode
			{0.500}GreaterThanNode
		{0.167}Logical Operator Node
			{0.500}OrNode
			{0.500}AndNode
		{0.500}Leaf Node
			{0.500}ConstantNode
			{0.500}VariableNode
```

Every factory is a LinkedHashMap of Factory/Class and Double (weight), Therefor probabilities can be adjusted in the following manner:
```
FunctionNodeFactory functionFactory = FunctionNodeFactory.getInstance();
functionFactory.put(LeafFactory.getInstance(), functionFactory.get(LeafFactory.getInstance()) / 2); // Decrease the chance for a leaf node

ArithmeticFunctionNodeFactory arithmeticFactory = ArithmeticFunctionNodeFactory.getInstance();
arithmeticFactory.put(SubNode.class, 2.0); // Set SubNode's weight to 2.0
arithmeticFactory.remove(DivNode.class); // Remove div node

ProbabilityTree probabilityTree = new ProbabilityTree(FunctionNodeFactory.getInstance());
probabilityTree.printProbabilityTree();
```

The output will be:

```
	{}Function Node
		{0.222}Conditional Node
			{1.000}IfElseNode
		{0.444}Arithmetic Node
			{0.333}SubNode
			{0.167}MinNode
			{0.167}MulNode
			{0.167}AddNode
			{0.167}MaxNode
		{0.333}Leaf Node
			{0.500}ConstantNode
			{0.500}VariableNode
```

Changing the tree structure can be done as shown above, also extending a Node class will automatically add the new class to the tree.
for example, creating a class:

```
public class MyNode extends ConditionalNode{
    ...
}
```

Will change the tree structure at class setup stage to be:

```
	{}Function Node
		{0.167}Conditional Node
			{0.500}IfElseNode
			{0.500}MyNode
		{0.333}Arithmetic Node
			{0.167}SubNode
			{0.167}DivNode
			{0.167}MinNode
			{0.167}MulNode
			{0.167}AddNode
			{0.167}MaxNode
		{0.500}Leaf Node
			{0.500}ConstantNode
			{0.500}VariableNode
```

This is done using java reflection.
Note that the probabilities for end nodes are evenly distributed as default.

## Upcoming

The following features and improvements are planned:
* Adding unary function nodes
* Trees Crossover function
* Tree mutation function

and more...

