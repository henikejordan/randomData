package modelo;

/**
 *
 * @author usuario
 */
public class Pressao extends Model {

    private int id_pressao;
    private String data_hora;
    private float pressao;
    private String classe;

    public int getId_pressao() {
        return id_pressao;
    }

    public void setId_pressao(int id_pressao) {
        this.id_pressao = id_pressao;
    }

    public String getData_hora() {
        return data_hora;
    }

    public void setData_hora(String data_hora) {
        this.data_hora = data_hora;
    }

    public float getPressao() {
        return pressao;
    }

    public void setPressao(float pressao) {
        this.pressao = pressao;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    @Override
    public String toString() {
        return "(" + id_pressao + "," + data_hora + "," + pressao + "," + classe + ")";
    }

}
