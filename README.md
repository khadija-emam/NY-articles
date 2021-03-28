# NY-articles
an app which shows the most popular articles in NY Times and some details of every article 

## **Installation**
Clone this repository and import into Android Studio

git clone (https://github.com/khadija-emam/NY-articles.git)


## **Open and Run**
Now that you have cloned the repo:

1. open the project up in Android Studio.
2. Open the AVD Manager (Tools -> Android -> AVD Manager)
3. Create a new Virtual Device. The size/model doesn't matter that much
4. Finish and click play! 
* or connect your phone and run the project on it


## **Test**
- ui test with esspresso in com.sia.nyarticles(androidTest)
- unit test in com.sia.nyarticles(test) for the AricleView Screen
-  open homeTestViewModel to run the test cases
click the green button beside the class name and hit unit test

if you want to see the test conerage:
1. Double-click the unit test you want to run.
2. In the editor, place your cursor in the line you want to run with coverage
3. Right-click the line where you placed your cursor.
4. In the context menu, choose Run test-name with coverage


## **Android Version Targeting**
-----------------------------
app is currently built to work with Android API 30(Android 11).
However, Egg's minimum SDK support is 21(lollipop).
