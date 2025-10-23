# CMPUT 301 : Lab 7 - Android UI Testing with Espresso
Android UI Testing - CMPUT 301 Lab 7   
Compile SDK - 34

## Student Details

- **Full Name:** `Jeanard Sinfuego`
- **CCID:** `sinfuego`

## References and Resources

https://stackoverflow.com/questions/3591465/on-android-how-do-you-switch-activities-programmatically
- How to switch activities, explaining AppCompactActivity and Intents and startActivity()
Especially this code snippit:
```java
Intent myIntent = new Intent(this, MyActivityName.class);
startActivity(myIntent);
```
answered Aug 28, 2010 at 16:20 Chris Thompson


https://stackoverflow.com/questions/3913592/start-an-activity-with-a-parameter
- How to pass arguments when you switch activity.
Especially these two code snippits:
```java
Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
Bundle b = new Bundle();
b.putInt("key", 1); //Your id
intent.putExtras(b); //Put your id to your next Intent
startActivity(intent);
finish();
```
And in the second acivity I could get City like such
```java 
Bundle b = getIntent().getExtras();
int value = -1; // or other values
if(b != null)
    value = b.getInt("key");
```
answered Oct 12, 2010 at 10:35Wroclai

https://stackoverflow.com/questions/3591465/on-android-how-do-you-switch-activities-programmatically
- Had a problem with activity resetting when returning
- I used implementation of OnSaveInstanceState() and onRestoreInstanceState()


## Verbal Collaboration

`N/A`


