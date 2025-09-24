class Student{
    int stdId;
    String stdName;

    Student(int stdId, String stdName){
        this.stdId=stdId;
        this.stdName=stdName;
    }

    public boolean equals(Object obj){
        Student s = (Student) obj;
        return this.stdId==s.stdId && this.stdName==s.stdName;

    }
}


public class CompareObjects {
    public static void main(String[] args) {
        Student s1 = new Student(5,"J");
        Student s2 = new Student(5,"J");

        System.out.println("Equals method overridden to check this.stdId==s.stdId and this.stdName=s.stdName");
        if (s1.equals(s2)) {System.out.println("s1 equal to s2");}
        else System.out.println("s1 not equal to s2");

        
    }
}
