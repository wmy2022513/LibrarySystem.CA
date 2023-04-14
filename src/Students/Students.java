package Students;

public class Students {
    
    private int id;
    private String fName;
    private String sName;
    private String gender;
    private String country;
    private int age;
    private String DOB;
    private int eCode;

    public Students(int id, String fName, String sName, String gender, String country,int age, String DOB, int eCode) {
        
        this.id = id;
        this.fName = fName;
        this.sName = sName;
        this.gender = gender;
        this.country = country;
        this.age = age;
        this.DOB = DOB;
        this.eCode = eCode;
    }

    public int getId() {
        return id;
    }

    public String getfName() {
        return fName;
    }

    public String getStudentName() {
        return fName+ " "+sName;
    }


    public String getCountry() {
        return country;
    }

    public int getAge() {
        return age;
    }

    public String getDOB() {
        return DOB;
    }

    public int geteCode() {
        return eCode;
    }

    @Override
    public String toString() {
        return "**********************\nStudent ID: "+ this.id + "\nStudent name: " + getStudentName() +"\nGender: "+ this.gender + "\nCountry: " + this.country + "\nAge: " + this.age + "\nDate of Birth: " + this.DOB +"\neCode: "+ this.eCode + "\n**********************";
    }
    
}