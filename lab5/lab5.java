import java.util.Scanner;
class Book{
    private String name;
    private String author;
    private double price;
    private int num_pages;
    public Book(String name,String author,double price,int num_pages){
        this.name=name;
        this.author=author;
        this.price=price;
        this.num_pages=num_pages;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setAuthor(String author){
        this.author=author;
    }
    public void setPrice(double price){
        this.price=price;
    }
    public void setNumPages(int num_pages){
        this.num_pages=num_pages;
    }
    public String getName(){
        return name;
    }
    public String getAuthor(){
        return author;
    }
    public int getNumPages(){
        return num_pages;
    }
    public String toString(){
        return "Book Name: "+name+"\nAuthor: "+author+"\nPrice: Rs."+price+"\nNumber of pages: "+num_pages+"\n";
    }
}
public class BookDemo{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of books:");
        int n=sc.nextInt();
        sc.nextLine();
        Book[] books=new Book[n];
        for (int i=0;i<n;i++){
            System.out.println("\nEnter details of Book "+(i+1)+":");
            System.out.println("Name:");
            String name=sc.nextLine();
            System.out.println("Author: ");
            String author=sc.nextLine();
            System.out.println("Price: ");
            double price=sc.nextDouble();
            System.out.println("Number of Pages: ");
            int pages=sc.nextInt();
            sc.nextLine();
            books[i]=new Book(name,author,price,pages);
        }
        System.out.println("\nBook Details: ");
        for (Book b: books){
            System.out.println(b.toString());
        }
        sc.close();
    }
}
