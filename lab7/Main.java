import java.util.Scanner;
class WrongAgeException extends Exception {
    public WrongAgeException(String message) {
        super(message);
    }
}

class Father {
    protected int fatherAge;
    public Father(int age) throws WrongAgeException {
        if(age < 0) {
            throw new WrongAgeException("Father's age cannot be negative!");
        }
        this.fatherAge = age;
        System.out.println("Father's age: " + fatherAge);
    }
}

class Son extends Father {
    private int sonAge;
    public Son(int fatherAge, int sonAge) throws WrongAgeException {
        super(fatherAge); 

        if(sonAge >= fatherAge) {
            throw new WrongAgeException("Son's age cannot be greater than or equal to Father's age!");
        }

        this.sonAge = sonAge;
        System.out.println("Son's age: " + sonAge);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int ch=1;
        while (ch!=0){
            System.out.println("Enter father's age: ");
            int f=sc.nextInt();
            System.out.println("Enter son's age: ");
            int s=sc.nextInt();
            try {
                Son s1 = new Son(f, s);   
            } 
            catch (WrongAgeException e) {
                System.out.println("Exception caught: " + e.getMessage());
            }
        }  
    }
}
