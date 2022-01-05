# Java Twitter-Bot

This Java Twitter bot tweets quotes from a text file in the resources directory called
tweets.txt every 10 minutes. 

To add quotes to the list, navigate to the resources directory, open tweets.txt and 
add the desired number of quotes. 

To change the sleep time locate `Thread.sleep(600000);` in the TwitterBot.java class 
and adjust the numerical value. Note that the sleep time is in milliseconds 
