# CompoundingInterestCalculator
User interacts with a Java GUI to calculate future money values based on initial deposit, interest rate, frequency of compounding, and total length of time 

## Installing

Pull the directory as is.


## Implementation
To handle actions, class actionHandler was declared as a subclass of actionListener.  Action handlers are attached to the 'calculate' button, as well as the 'continuous' and 'non-continuous' toggle buttons.  Upon a click, the method actionPerformed() is called and this method searches for the source of the click.  If the source of the click is determined to be the 'calculate' button, the method checks to see whether user selected the 'continuous' or 'non-continuous' toggle button. If 'continuous' is selected, the equation A = P(1+(r/n))^(nt) is used in the calculation; if 'non-continuous' is selected, the equation A = Pe^(rt) is used in the calculation step.  <br/>
After determining which toggle button was selected, the actionPerformed method checks to see which fields were entered by the user and which fields were left blank through a series of conditional statements.  Many of the conditional blocks are triggered when all but one variable contains user input; in this case, the program applies the previously-determined equation to solve for the one missing variable.  Other conditional blocks are triggered when all variables have user input; in this case, the program applies the previously-determined equation to check whether the values are true/consistent or whether the values are false/inconsistent.  The last possibility is that more than one variable does not contain user input; in this case, the program tells the user that a calculation cannot be performed due to insufficient information.


## Built With

* [javax.awt](https://docs.oracle.com/javase/7/docs/api/javax/swing/package-summary.html) - Package used for GUI layout and event dispatching.
* [java.swing](https://docs.oracle.com/javase/7/docs/api/java/awt/package-summary.html) - Package used for GUI features



## License

This project is licensed under the MIT License. The rest are copyright/licensed by their respective authors.

## Acknowledgments




