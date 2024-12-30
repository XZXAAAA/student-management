package XZXcom.student.model;

public class Student {
    private int id;
    private String name;
    private int age;
    private String gender;
    private String className;
    private double score;
    
    public Student() {}
    
    public Student(int id, String name, int age, String gender, String className, double score) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.className = className;
        this.score = score;
    }
    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    
    public String getClassName() { return className; }
    public void setClassName(String className) { this.className = className; }
    
    public double getScore() { return score; }
    public void setScore(double score) { this.score = score; }
}