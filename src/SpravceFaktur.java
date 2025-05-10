import java.util.ArrayList;

public class SpravceFaktur {

    private ArrayList<Faktura> faktury;

    public SpravceFaktur() {
        faktury = new ArrayList<>();
    }

    public void pridatFakturu(Faktura faktura){
        if(faktura == null){
            throw new IllegalArgumentException("Faktura nesmí být null");
        }else{
            faktury.add(faktura);
        }
    }
}
