package modelo;

/**
 *
 * @author usuario
 */
public class Temperatura extends Model {

    private int id_temperatura;
    private String data_hora;
    private float temperatura;
    private String classe;

    public int getId_temperatura() {
        return id_temperatura;
    }

    public void setId_temperatura(int id_temperatura) {
        this.id_temperatura = id_temperatura;
    }

    public String getData_hora() {
        return data_hora;
    }

    public void setData_hora(String data_hora) {
        this.data_hora = data_hora;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    @Override
    public String toString() {
        return "(" + id_temperatura + "," + data_hora + "," + temperatura + "," + classe + ")";
    }

}
