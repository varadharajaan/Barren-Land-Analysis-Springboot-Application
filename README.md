** # Barren-Land-Analysis-Springboot-Application **
Barren Land Analysis application is done using springboot. where the business logic can be accessed using API's
You have a farm of 400m by 600m where coordinates of the field are from (0, 0) to (399, 599). A portion of the farm is barren, and all the barren land is in the form of rectangles. Due to these rectangles of barren land, the remaining area of fertile land is in no particular shape. An area of fertile land is defined as the largest area of land that is not covered by any of the rectangles of barren land.

**#input**

You are given a set of rectangles that contain the barren land. These rectangles are defined in a string, which consists of four integers separated by single spaces, with no additional spaces in the string. The first two integers are the coordinates of the bottom left corner in the given rectangle, and the last two integers are the coordinates of the top right corner.

**#Output**

Output all the fertile land area in square meters, sorted from smallest area to greatest, separated by a space.

**Sample Data:**

Input: {“0 292 399 307”}

Output: 116800 116800

Input: {“48 192 351 207”, “48 392 351 407”, “120 52 135 547”, “260 52 275 547”}

Output: 22816 192608

**Steps to Follow to Make Code Run:**

Project can run in Java 1.8 compatible IDE(Intellij). Download zip file or clone your machine, and Run as Java Application.

**Testing**

BarrenLandAnalysisText.java contains basic JUnit tests to test given test cases plus a few additional cases including tests for edge cases if entire grid is barren or if a very small portion is barren.

**Build TOOL**

GRADLE DEPENDENCY MANAGEMENT.


**STEPS TO ACCESS THE APPLICATION**

1. Clone the project.
2. Run the application in embedded tomcat server.
3. Hit the url -> localhost:8080 , which gives default response " Hello Barren Land successfully deployed and started..."
4. Now hit swagger URL -> http://localhost:8080/swagger-ui.html
5. Go to Controller section and click on input give string array values and give exceute.
6. output or exception response will be shown in the response area with valid status code.

**Tech Stacks Covered**

1.Spring boot application from scratch.
2. global exception.
3. global logging with custom names
4. git version control usage.
5. swagger implemenation.
