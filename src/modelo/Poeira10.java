package modelo;

/**
 *
 * @author usuario
 */
public class Poeira10 extends Model {

    private int id_poeira10;
    private String data_hora;
    private float poeira10;
    private String classe;

    public int getId_poeira10() {
        return id_poeira10;
    }

    public void setId_poeira10(int id_poeira10) {
        this.id_poeira10 = id_poeira10;
    }

    public String getData_hora() {
        return data_hora;
    }

    public void setData_hora(String data_hora) {
        this.data_hora = data_hora;
    }

    public float getPoeira10() {
        return poeira10;
    }

    public void setPoeira10(float poeira10) {
        this.poeira10 = poeira10;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    @Override
    public String toString() {
        return "(" + id_poeira10 + "," + data_hora + "," + poeira10 + "," + classe + ")";
    }

}
