import java.util.*;
class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int age = 0;
    System.out.println("Enter your age: ");
    while(!in.hasNextInt()){// checks if scanner's next input is an int, return true if next input is not an Int and the while loop continues till the next input is an Int
      System.out.println("Please enter a valid age: ");
      in.nextLine();//move the scanner to receive the next nextLine
      //this is important so the hasNextInt() wont keep checking the same thing
    }
    //it will only exit the while loop when user have successfully enter an interger for the first word they inputted.
    age = in.nextInt();
    System.out.println("Your age is: " + age);

    in.close();;
  }
}