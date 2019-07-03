package unimas.my.examresultn;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public
class Model{
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("semester")
    @Expose
    private String semester;
    @SerializedName("gpa")
    @Expose
    private String gpa;
    @SerializedName("cgpa")
    @Expose
    private String cgpa;
    @SerializedName("totalTakenCredits")
    @Expose
    private String totalTakenCredits;
    @SerializedName("totalCalculatedCredits")
    @Expose
    private String totalCalculatedCredits;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getGpa() {
        return gpa;
    }

    public void setGpa(String gpa) {
        this.gpa = gpa;
    }

    public String getCgpa() {
        return cgpa;
    }

    public void setCgpa(String cgpa) {
        this.cgpa = cgpa;
    }

    public String getTotalTakenCredits() {
        return totalTakenCredits;
    }

    public void setTotalTakenCredits(String totalTakenCredits) {
        this.totalTakenCredits = totalTakenCredits;
    }

    public String getTotalCalculatedCredits() {
        return totalCalculatedCredits;
    }

    public void setTotalCalculatedCredits(String totalCalculatedCredits) {
        this.totalCalculatedCredits = totalCalculatedCredits;
    }
}
