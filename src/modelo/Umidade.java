package modelo;

/**
 *
 * @author usuario
 */
public class Umidade extends Model {

    private int id_umidade;
    private String data_hora;
    private float umidade;
    private String classe;

    public int getId_umidade() {
        return id_umidade;
    }

    public void setId_umidade(int id_umidade) {
        this.id_umidade = id_umidade;
    }

    public String getData_hora() {
        return data_hora;
    }

    public void setData_hora(String data_hora) {
        this.data_hora = data_hora;
    }

    public float getUmidade() {
        return umidade;
    }

    public void setUmidade(float umidade) {
        this.umidade = umidade;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    @Override
    public String toString() {
        return "(" + id_umidade + "," + data_hora + "," + umidade + "," + classe + ")";
    }

}
