**Style Rule #1: Variable Naming**
Use camelCase when defining a variable name, with the first character lowercase. Variable names should be descriptive! Avoid single-letter variable names. Although syntactically allowed. It is best to avoid using underscores, dollar signs, and even digits in variable names.

**Style Rule #2: Code Comments (// for one to two lines)**
It is considered good style to comment on tricky or clever parts of your code to make it easier for others (and even yourself) to read and understand in the future. It's important that comments accurately reflect the code that they explain. An incorrect comment is worse than none! Full-line comments (as opposed to end-of-line comments) are almost always the best choice, as they are easier to read and don't cause formatting problems when you print the code. A comment should always appear before the statement(s) it describes.

**Style Rule #3: Header Comments**
A header comment is a comment that appears at the top of a JavaScript file. It is considered a good programming style to include information about the author, a general description of what the program does, and the date it was last modified. In Java, the header comment is enclosed in /\* ... \*/, not in//comments. We'll see later that docstrings are very useful for automatically producing online help for our code. I expect you to follow this style rule in all of your exercises and assignments this year.

**Style Rule #4: Blank Lines**
Use blank lines to improve the readability of your code. Group related code together and separate sections with a blank line.

**Style Rule #5: Function Naming**
Function names should follow the same five rules as variable names (see Style Rule #1). Because functions perform actions, it's considered a good style to use verbs in function names. For example, a function that figures out the high score in the game might be called calculateHighScore(). This makes it very clear what task the function performs.

**Style Rule #6: Function Commenting**
Every function that you write should include an indented docstring as the first line of the function body, clearly explaining 3 details:  Purpose: A brief (1-2 sentence) explanation of what the function does.  Parameter(s): Any data to be passed into the function should be explained.  Return Value(s): Any return value(s) should be explained. Including all three of these details in your function comments makes the IPO model very clear to others reading your code (and perhaps calling your function). Note that in some of my examples, I may leave out function docstrings to keep the notes shorter if you are printing them.

**Style Rule #9: Importing Packages**
Import each class separately so that it is clear what classes you are actually using in your program from Java.API. Never use the wildcard (\*) shortcut.

**Style Rule 10 -  Exception Handling.&#xA0;**
Except clauses should always explicitly name the exception they are handling.  Avoid using an except clause without an exception name, as this leaves the purpose of the exception handling code very vague.  Also, it is considered a good style to focus on handling your exceptions. Do not put your entire program in a single, large exceptio&#x6E;**&#xA0;**&#x62;lock!  

**Style Rule #11: Defining a Class**
In terms of style, class names **always** start with a capital letter.  If there is more than one word in the name, camelCase is used for the rest. Class names are usually nouns since they describe an object.  As with defining a function, each class should have a docstring at the top explaining its purpose.

**Style Rule #12: Accessor and Mutator Naming**
Accessor methods should always start with get, followed by the name of the instance variable they return, in camelCase. Similarly, mutator methods should always start with a set followed by the name of the instance variable they modify.

**Style Rule #13: constructor methods and static void main method**
The constructor methods should **always** be placed first in a class; the main method should be placed last.
The main method should **always** be placed first in a class if no constructor method is provided.
However, in assignments or projects, organize your code so that the main method and the constructor do not reside in the same class, as demonstrated in class (this rule will be applied strictly in assignments and projects). &#x20;
