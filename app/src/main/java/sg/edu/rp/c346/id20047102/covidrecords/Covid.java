package sg.edu.rp.c346.id20047102.covidrecords;

public class Covid {

    private String covidCases;
    private String clinicalStatus;
    private String ageGroups;
    private String date;

    public Covid(String covidCases, String clinicalStatus, String ageGroups, String date) {
        this.covidCases = covidCases;
        this.clinicalStatus = clinicalStatus;
        this.ageGroups = ageGroups;
        this.date = date;
    }

    public String getCovidCases() {
        return covidCases;
    }

    public void setCovidCases(String covidCases) {
        this.covidCases = covidCases;
    }

    public String getClinicalStatus() {
        return clinicalStatus;
    }

    public void setClinicalStatus(String clinicalStatus) {
        this.clinicalStatus = clinicalStatus;
    }

    public String getAgeGroups() {
        return ageGroups;
    }

    public void setAgeGroups(String ageGroups) {
        this.ageGroups = ageGroups;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Number of cases: " + covidCases +
                "\nClinical Status: " + clinicalStatus +
                "\nAge Group: " + ageGroups +
                "\nDate: " + date +
                "\n";
    }
}
