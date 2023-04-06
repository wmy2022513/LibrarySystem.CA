public class Students {
    private int id;
    private String fName;
    private String sName;
    private String country;
    private String bDate;
    private int eCode;

    public Students(int id, String fName, String sName, String country, String bDate, int eCode) {
        this.id = id;
        this.fName = fName;
        this.sName = sName;
        this.country = country;
        this.bDate = bDate;
        this.eCode = eCode;
    }

    public int getId() {
        return id;
    }

    public String getStudentName() {
        return fName+ " "+sName;
    }

    public String getsName() {
        return sName;
    }

    public String getCountry() {
        return country;
    }

    public String getbDate() {
        return bDate;
    }

    public int geteCode() {
        return eCode;
    }

    @Override
    public String toString() {
        return "Students{" + "id=" + id + ", fName=" + fName + ", sName=" + sName + ", country=" + country + ", bDate=" + bDate + ", eCode=" + eCode + '}';
    }
    
}