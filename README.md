# README

Get started by logging into your GitHub account and clicking the green `Use this template button` to create your own version of this repository. 

![Image showing the use this template button](images/Screenshot_15-11-2024_115623_github.com.jpeg)

Create your new repository as is shown below.

![Image showing the new repository set-up page](images/Screenshot_15-11-2024_115538_github.com.jpeg)

Then, follow the instructions below to set-up CI for this repository.

## Step 1

Add the following your `pom.xml` file:

```
<build>
  <plugins>
    <plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-surefire-plugin</artifactId>
      <version>2.22.2</version>
    </plugin>
  </plugins>
</build>
```
Afterwards, your `pom.xml` file should look like this:

```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.example</groupId>
    <artifactId>MinimalCIStarter</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>22</maven.compiler.source>
        <maven.compiler.target>22</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>
    
    <dependencies>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>5.8.1</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>2.22.2</version>
            </plugin>
        </plugins>
    </build>
</project>
```

🧠 **Explanation (why are we doing this):** This code configures the Maven Surefire Plugin, which is used during the test phase of the build lifecycle to execute the unit tests of an application. It integrates well with continuous integration pipelines, as we will (hopefully) see very soon!

## Step 2

Create 2 new folders. The first should be a `.github` folder at the top level of this repository. The second should a `workflows` folder inside the `.github` folder.

Any easy way of doing this is by changing the url that is shown in your browser from `github.com/your_user_name/MinimalCIStarter` to `github.dev/your_user_name/MinimalCIStarter`. Doing this will open up a browser-based version of Visual Studio Code that you can use to create the folders.

After you have created the folders, be sure to commit and push your changes.

After you've created the folder and returned to `github.com/your_user_name/MinimalCIStarter` your repository should look a bit like this:

![Image showing the .github and workflows folders](images/Screenshot_15-11-2024_10118_github.com.jpeg)

🧠 **Explanation (why are we doing this):** The `.github` folder is used to store configuration files specific to GitHub. The `workflows` folder inside the `.github` folder is specifically for storing workflow files. These files define the automated processes that GitHub Actions will run as a part of our CI pipeline. As we will see in the next step, each workflow is defined in a separate YAML file and can include steps for building, testing, and deploying your code, among other tasks.

## Step 3

Inside your `workflows` folder create a `tests.yml` file. Add the following contents to the file (again, you might like to use `github.dev` to do this):

```
name: Java CI with Maven

on: [push, pull_request]

jobs:
  test:
    runs-on: ubuntu-latest

    steps:
    - name: Checkout code
      uses: actions/checkout@v2

    - name: Set up JDK 22
      uses: actions/setup-java@v2
      with:
        java-version: 22
        distribution: 'adopt'

    - name: Run tests
      run: mvn test
```

After you have done this, be sure to commit and push your changes.

After you've returned to `github.com/your_user_name/MinimalCIStarter` your should notice an orange circle icon next to your commit message, like this:

![Image showing an orange circle icon next to a commit message](images/Screenshot_15-11-2024_102331_github.com.jpeg)

After waiting a couple of minutes, refresh the page. You should then notice that orange circle has changed to a green tick, like this:

![Image showing a green tick icon next to a commit message](images/Screenshot_15-11-2024_10244_github.com.jpeg)

🧠 **Explanation (why are we doing this):** In this crucial step we have defined a workflow that will run as a part of our CI pipeline. In the workflow we make use of some existing actions to checkout the code and set-up the relevant JDK (i.e., `uses: actions/checkout@v2` and `uses: actions/setup-java@v2`) before running our tests with `run: mvn test`.

## Step 4

To better understand the value of CI you could now create a pull request to see it in action. There are many ways you could do this, but using the `github.dev` interface as detailed below is one option.

To begin creating a pull request, you should first create a new branch. Do this by clicking the name of your current branch (i.e., main); It should be visible towards the bottom left corner of your the `github.dev` IDE, like this:

![Image showing the current/main branch icon/button](images/Screenshot_15-11-2024_10568_github.dev.jpeg)

After clicking the button, a pop-up will appear. When it does, select the `Create new branch...` option and enter a name for your branch when prompted. You should then see a dialog that looks like this:

![Image showing the Switch to branch dialog/button](images/Screenshot_15-11-2024_105713_github.dev.jpeg)

Click the green `Switch to Branch` button. After doing this, you should notice that your current branch has changed, with a different branch name being visible towards the bottom left corner, like this:

![Image showing button/icon for the new branch, indicating a successful switch](images/Screenshot_15-11-2024_105748_github.dev.jpeg)

Now that you're on a new branch, make some changes to the code to better understand the value of CI. To do this, navigate to the following file using the Sidebar: `src/test/java/BookStoreTest.java`:

![Image showing the BookStoreTest.java file in the siderbar](images/Screenshot_15-11-2024_111547_github.dev.jpeg)

After opening this file, scroll down to the end of it and you should notice a test that has been commented out, like this:

```java
/* @Test
void aFailingTest() {
  fail();
} */
```

Uncomment this test (which is clearly designed to fail), like this:

```java
@Test
void aFailingTest() {
  fail();
} 
```

Now commit and push your changes.

Navigate back to `github.com` and you should notice that a yellow pop-up has appeared towards the top of the page:

![Image showing the yellow pull request pop-up](images/Screenshot_15-11-2024_112214_github.com.jpeg)

Click the green `Compare & pull request` button. After doing this, you should see a screen that looks like this:

![Image showing the yellow pull request pop-up](images/Screenshot_15-11-2024_112236_github.com.jpeg)

Click the green `Create pull request` button. Eventually, you should see that the tests are run automatically, and that the failing test causes the check to fail, like this:

![Image showing the yellow pull request pop-up](images/Screenshot_15-11-2024_112322_github.com.jpeg)

🧠 **Explanation (why are we doing this):** We completed setting-up our workflow/CI pipeline in the previous step. Here, we have gone through the process of raising a pull request that includes a deliberately failing test to demonstrate the value of CI. Notice how the failing test is automatically and clearly flagged before the changes are merged into the main/production branch.

## 🥇 Step 5

 Well done. You have have now completed this learning activity. Be sure to ask the facilitator if anything was unclear (a fully worked example is available: https://github.com/samattwood9/MinimalCI).











