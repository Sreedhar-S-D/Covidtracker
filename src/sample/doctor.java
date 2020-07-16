package sample;

public class doctor extends hospital{

    String Name;
    String Hospital;
    int Refno;


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getHospital() {
        return Hospital;
    }

    public void setHospital(String hospital) {
        Hospital = hospital;
    }

    public int getRefno() {
        return Refno;
    }

    public void setRefno(int refno) {
        Refno = refno;
    }
}
