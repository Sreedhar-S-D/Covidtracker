package sample;

public class indiavschinesevirus {
    private String Country;
    private String Date;
    private int Cases;
    private String Status;

    public indiavschinesevirus(String country, String date, int cases, String status) {
        this.Country = country;
        this.Date = date;
        this.Cases = cases;
        Status = status;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public int getCases() {
        return Cases;
    }

    public void setCases(int cases) {
        Cases = cases;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
