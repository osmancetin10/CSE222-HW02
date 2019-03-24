# CSE222-HW02
Homework 2 of CSE222 class at Gebze Technical University

In this program we created an ExperimentList class to keep track of some machine learning experiments and their results. A machine learning experiment consists of the following instance variables:
  setup (String): explains the experimental setup
  day(integer): represents the day of start
  time(Time): represents the time of start
  completed(boolean): indicates whether it is completed or not
  accuracy(float): represents the output (not a valid value if the experiment is not completed)
This class implement the basics of a single linked list to keep the experiments. In order to speed up add and remove operations, an additional list structure should be defined in the level of days. 
