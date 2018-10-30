package modelo;

/**
 *
 * @author usuario
 */
public class Poeira25 extends Model {

    private int id_poeira25;
    private String data_hora;
    private float poeira25;
    private String classe;

    public int getId_poeira25() {
        return id_poeira25;
    }

    public void setId_poeira25(int id_poeira25) {
        this.id_poeira25 = id_poeira25;
    }

    public String getData_hora() {
        return data_hora;
    }

    public void setData_hora(String data_hora) {
        this.data_hora = data_hora;
    }

    public float getPoeira25() {
        return poeira25;
    }

    public void setPoeira25(float poeira25) {
        this.poeira25 = poeira25;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    @Override
    public String toString() {
        return "(" + id_poeira25 + "," + data_hora + "," + poeira25 + "," + classe + ")";
    }

}
