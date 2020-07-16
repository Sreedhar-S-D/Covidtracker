package sample;

public class hospital {
    int no_masks;
    int chloroquine;
    int paracetamol;

    hospital()
    {
        no_masks = 0;
        chloroquine = 0;
        paracetamol = 0;

    }
    public hospital(int no_masks, int chloroquine, int paracetamol) {
        this.no_masks = no_masks;
        this.chloroquine = chloroquine;
        this.paracetamol = paracetamol;
    }
}
