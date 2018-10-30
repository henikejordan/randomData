package modelo;

/**
 *
 * @author usuario
 */
public class Gases extends Model {

    private int id_gases;
    private String data_hora;
    private float mq2;
    private float mq3;
    private float mq4;
    private float mq5;
    private float mq6;
    private float mq7;
    private float mq8;
    private float mq9;
    private float mq135;
    private float tgs822;
    private float tgs2600;
    private float tgs2602;
    private float tgs2603;
    private String classe;

    public int getId_gases() {
        return id_gases;
    }

    public void setId_gases(int id_gases) {
        this.id_gases = id_gases;
    }

    public String getData_hora() {
        return data_hora;
    }

    public void setData_hora(String data_hora) {
        this.data_hora = data_hora;
    }

    public float getMq2() {
        return mq2;
    }

    public void setMq2(float mq2) {
        this.mq2 = mq2;
    }

    public float getMq3() {
        return mq3;
    }

    public void setMq3(float mq3) {
        this.mq3 = mq3;
    }

    public float getMq4() {
        return mq4;
    }

    public void setMq4(float mq4) {
        this.mq4 = mq4;
    }

    public float getMq5() {
        return mq5;
    }

    public void setMq5(float mq5) {
        this.mq5 = mq5;
    }

    public float getMq6() {
        return mq6;
    }

    public void setMq6(float mq6) {
        this.mq6 = mq6;
    }

    public float getMq7() {
        return mq7;
    }

    public void setMq7(float mq7) {
        this.mq7 = mq7;
    }

    public float getMq8() {
        return mq8;
    }

    public void setMq8(float mq8) {
        this.mq8 = mq8;
    }

    public float getMq9() {
        return mq9;
    }

    public void setMq9(float mq9) {
        this.mq9 = mq9;
    }

    public float getMq135() {
        return mq135;
    }

    public void setMq135(float mq135) {
        this.mq135 = mq135;
    }

    public float getTgs822() {
        return tgs822;
    }

    public void setTgs822(float tgs822) {
        this.tgs822 = tgs822;
    }

    public float getTgs2600() {
        return tgs2600;
    }

    public void setTgs2600(float tgs2600) {
        this.tgs2600 = tgs2600;
    }

    public float getTgs2602() {
        return tgs2602;
    }

    public void setTgs2602(float tgs2602) {
        this.tgs2602 = tgs2602;
    }

    public float getTgs2603() {
        return tgs2603;
    }

    public void setTgs2603(float tgs2603) {
        this.tgs2603 = tgs2603;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    @Override
    public String toString() {
        return "(" + id_gases + "," + data_hora + "," + mq2 + "," + mq3 + ","
                + mq4 + "," + mq5 + "," + mq6 + "," + mq7 + ","
                + mq8 + "," + mq9 + "," + mq135 + "," + tgs822 + ","
                + tgs2600 + "," + tgs2602 + "," + tgs2603 + "," + classe + ")";
    }

}
