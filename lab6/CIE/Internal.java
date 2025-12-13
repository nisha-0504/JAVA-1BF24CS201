package CIE;

public class Internal extends Student{
    public int internalMarks[]=new int[5];
    public Internal(String usn, String name, int sem, int marks[]){
        super(usn,name,sem);
        for (int i=0;i<5;i++){
            internalMarks[i]=marks[i];
        }
    }
}
