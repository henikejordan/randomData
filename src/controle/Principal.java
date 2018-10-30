package controle;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import modelo.Gases;
import modelo.Poeira10;
import modelo.Poeira25;
import modelo.Pressao;
import modelo.Temperatura;
import modelo.Umidade;
import util.ConectaBanco;

/**
 *
 * @author usuario
 */
public class Principal {

    /**
     * @param args the command line arguments
     * @throws java.text.ParseException
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws ParseException, SQLException {
        String dataHoraIniBase = "2018-10-19 15:57:00", dataHoraFimBase = "2018-10-19 16:00:00";
        String dataHoraNovo = "2018-10-19 16:00:06";
        int segundos = 1200;
        String classe = "Fase 6";

        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        ConectaBanco conecta = ConectaBanco.getInstance();
        Random gerador = new Random();
        List<Gases> gases = new ArrayList<>();
        List<Poeira10> poeira10s = new ArrayList<>();
        List<Poeira25> poeira25s = new ArrayList<>();
        List<Pressao> pressaos = new ArrayList<>();
        List<Temperatura> temperaturas = new ArrayList<>();
        List<Umidade> umidades = new ArrayList<>();
        float medMq2 = 0, medMq3 = 0, medMq4 = 0, medMq5 = 0, medMq6 = 0, medMq7 = 0, medMq8 = 0,
                medMq9 = 0, medMq135 = 0, medTgs822 = 0, medTgs2600 = 0, medTgs2602 = 0, medTgs2603 = 0,
                desvMq2 = 0, desvMq3 = 0, desvMq4 = 0, desvMq5 = 0, desvMq6 = 0, desvMq7 = 0, desvMq8 = 0,
                desvMq9 = 0, desvMq135 = 0, desvTgs822 = 0, desvTgs2600 = 0, desvTgs2602 = 0, desvTgs2603 = 0;
        float medPoeira10 = 0, desvPoeira10 = 0;
        float medPoeira25 = 0, desvPoeira25 = 0;
        float medPressao = 0, desvPressao = 0;
        float medTemperatura = 0, desvTemperatura = 0;
        float medUmidade = 0, desvUmidade = 0;

        ////////////////////////////////////////////////////////////////////////
        ////////////////////////////////Média///////////////////////////////////
        ////////////////////////////////////////////////////////////////////////
        ResultSet resultGases = conecta.executaSQL("select * from gases "
                + "where data_hora >= '" + dataHoraIniBase + "' "
                + "and data_hora <= '" + dataHoraFimBase + "' "
                + "order by data_hora");

        ResultSet resultPoeira10s = conecta.executaSQL("select * from poeira_10 "
                + "where data_hora >= '" + dataHoraIniBase + "' "
                + "and data_hora <= '" + dataHoraFimBase + "' "
                + "order by data_hora");

        ResultSet resultPoeira25s = conecta.executaSQL("select * from poeira_25 "
                + "where data_hora >= '" + dataHoraIniBase + "' "
                + "and data_hora <= '" + dataHoraFimBase + "' "
                + "order by data_hora");

        ResultSet resultPressaos = conecta.executaSQL("select * from pressao "
                + "where data_hora >= '" + dataHoraIniBase + "' "
                + "and data_hora <= '" + dataHoraFimBase + "' "
                + "order by data_hora");

        ResultSet resultTemperaturas = conecta.executaSQL("select * from temperatura "
                + "where data_hora >= '" + dataHoraIniBase + "' "
                + "and data_hora <= '" + dataHoraFimBase + "' "
                + "order by data_hora");

        ResultSet resultUmidades = conecta.executaSQL("select * from umidade "
                + "where data_hora >= '" + dataHoraIniBase + "' "
                + "and data_hora <= '" + dataHoraFimBase + "' "
                + "order by data_hora");

        int n = 0;
        while (resultGases.next()) {
            Gases gas = new Gases();
            gas.setId_gases(resultGases.getInt("id_gases"));
            gas.setData_hora(resultGases.getString("data_hora"));

            gas.setMq2(resultGases.getFloat("mq2"));
            medMq2 += resultGases.getFloat("mq2");

            gas.setMq3(resultGases.getFloat("mq3"));
            medMq3 += resultGases.getFloat("mq3");

            gas.setMq4(resultGases.getFloat("mq4"));
            medMq4 += resultGases.getFloat("mq4");

            gas.setMq5(resultGases.getFloat("mq5"));
            medMq5 += resultGases.getFloat("mq5");

            gas.setMq6(resultGases.getFloat("mq6"));
            medMq6 += resultGases.getFloat("mq6");

            gas.setMq7(resultGases.getFloat("mq7"));
            medMq7 += resultGases.getFloat("mq7");

            gas.setMq8(resultGases.getFloat("mq8"));
            medMq8 += resultGases.getFloat("mq8");

            gas.setMq9(resultGases.getFloat("mq9"));
            medMq9 += resultGases.getFloat("mq9");

            gas.setMq135(resultGases.getFloat("mq135"));
            medMq135 += resultGases.getFloat("mq135");

            gas.setTgs822(resultGases.getFloat("tgs822"));
            medTgs822 += resultGases.getFloat("tgs822");

            gas.setTgs2600(resultGases.getFloat("tgs2600"));
            medTgs2600 += resultGases.getFloat("tgs2600");

            gas.setTgs2602(resultGases.getFloat("tgs2602"));
            medTgs2602 += resultGases.getFloat("tgs2602");

            gas.setTgs2603(resultGases.getFloat("tgs2603"));
            medTgs2603 += resultGases.getFloat("tgs2603");

            gas.setClasse(resultGases.getString("classe"));
            gases.add(gas);
            n++;
        }
        medMq2 = medMq2 / n;
        medMq3 = medMq3 / n;
        medMq4 = medMq4 / n;
        medMq5 = medMq5 / n;
        medMq6 = medMq6 / n;
        medMq7 = medMq7 / n;
        medMq8 = medMq8 / n;
        medMq9 = medMq9 / n;
        medMq135 = medMq135 / n;
        medTgs822 = medTgs822 / n;
        medTgs2600 = medTgs2600 / n;
        medTgs2602 = medTgs2602 / n;
        medTgs2603 = medTgs2603 / n;
        n = 0;

        while (resultPoeira10s.next()) {
            Poeira10 poeira10 = new Poeira10();
            poeira10.setId_poeira10(resultPoeira10s.getInt("id_poeira_10"));
            poeira10.setData_hora(resultPoeira10s.getString("data_hora"));

            poeira10.setPoeira10(resultPoeira10s.getFloat("poeira_10"));
            medPoeira10 += resultPoeira10s.getFloat("poeira_10");

            poeira10.setClasse(resultPoeira10s.getString("classe"));
            poeira10s.add(poeira10);
            n++;
        }
        medPoeira10 = medPoeira10 / n;
        n = 0;

        while (resultPoeira25s.next()) {
            Poeira25 poeira25 = new Poeira25();
            poeira25.setId_poeira25(resultPoeira25s.getInt("id_poeira_25"));
            poeira25.setData_hora(resultPoeira25s.getString("data_hora"));

            poeira25.setPoeira25(resultPoeira25s.getFloat("poeira_25"));
            medPoeira25 += resultPoeira25s.getFloat("poeira_25");

            poeira25.setClasse(resultPoeira25s.getString("classe"));
            poeira25s.add(poeira25);
            n++;
        }
        medPoeira25 = medPoeira25 / n;
        n = 0;

        while (resultPressaos.next()) {
            Pressao pressao = new Pressao();
            pressao.setId_pressao(resultPressaos.getInt("id_pressao"));
            pressao.setData_hora(resultPressaos.getString("data_hora"));

            pressao.setPressao(resultPressaos.getFloat("pressao"));
            medPressao += resultPressaos.getFloat("pressao");

            pressao.setClasse(resultPressaos.getString("classe"));
            pressaos.add(pressao);
            n++;
        }
        medPressao = medPressao / n;
        n = 0;

        while (resultTemperaturas.next()) {
            Temperatura temperatura = new Temperatura();
            temperatura.setId_temperatura(resultTemperaturas.getInt("id_temperatura"));
            temperatura.setData_hora(resultTemperaturas.getString("data_hora"));

            temperatura.setTemperatura(resultTemperaturas.getFloat("temperatura"));
            medTemperatura += resultTemperaturas.getFloat("temperatura");

            temperatura.setClasse(resultTemperaturas.getString("classe"));
            temperaturas.add(temperatura);
            n++;
        }
        medTemperatura = medTemperatura / n;
        n = 0;

        while (resultUmidades.next()) {
            Umidade umidade = new Umidade();
            umidade.setId_umidade(resultUmidades.getInt("id_umidade"));
            umidade.setData_hora(resultUmidades.getString("data_hora"));

            umidade.setUmidade(resultUmidades.getFloat("umidade"));
            medUmidade += resultUmidades.getFloat("umidade");

            umidade.setClasse(resultUmidades.getString("classe"));
            umidades.add(umidade);
            n++;
        }
        medUmidade = medUmidade / n;
        ////////////////////////////////////////////////////////////////////////
        ////////////////////////////Desvio padrão///////////////////////////////
        ////////////////////////////////////////////////////////////////////////
        resultGases = conecta.executaSQL("select * from gases "
                + "where data_hora >= '" + dataHoraIniBase + "' "
                + "and data_hora <= '" + dataHoraFimBase + "' "
                + "order by data_hora");

        resultPoeira10s = conecta.executaSQL("select * from poeira_10 "
                + "where data_hora >= '" + dataHoraIniBase + "' "
                + "and data_hora <= '" + dataHoraFimBase + "' "
                + "order by data_hora");

        resultPoeira25s = conecta.executaSQL("select * from poeira_25 "
                + "where data_hora >= '" + dataHoraIniBase + "' "
                + "and data_hora <= '" + dataHoraFimBase + "' "
                + "order by data_hora");

        resultPressaos = conecta.executaSQL("select * from pressao "
                + "where data_hora >= '" + dataHoraIniBase + "' "
                + "and data_hora <= '" + dataHoraFimBase + "' "
                + "order by data_hora");

        resultTemperaturas = conecta.executaSQL("select * from temperatura "
                + "where data_hora >= '" + dataHoraIniBase + "' "
                + "and data_hora <= '" + dataHoraFimBase + "' "
                + "order by data_hora");

        resultUmidades = conecta.executaSQL("select * from umidade "
                + "where data_hora >= '" + dataHoraIniBase + "' "
                + "and data_hora <= '" + dataHoraFimBase + "' "
                + "order by data_hora");

        n = 0;
        while (resultGases.next()) {
            Gases gas = new Gases();
            gas.setId_gases(resultGases.getInt("id_gases"));
            gas.setData_hora(resultGases.getString("data_hora"));

            gas.setMq2(resultGases.getFloat("mq2"));
            desvMq2 += Math.pow(resultGases.getFloat("mq2") - medMq2, 2);

            gas.setMq3(resultGases.getFloat("mq3"));
            desvMq3 += Math.pow(resultGases.getFloat("mq3") - medMq3, 2);

            gas.setMq4(resultGases.getFloat("mq4"));
            desvMq4 += Math.pow(resultGases.getFloat("mq4") - medMq4, 2);

            gas.setMq5(resultGases.getFloat("mq5"));
            desvMq5 += Math.pow(resultGases.getFloat("mq5") - medMq5, 2);

            gas.setMq6(resultGases.getFloat("mq6"));
            desvMq6 += Math.pow(resultGases.getFloat("mq6") - medMq6, 2);

            gas.setMq7(resultGases.getFloat("mq7"));
            desvMq7 += Math.pow(resultGases.getFloat("mq7") - medMq7, 2);

            gas.setMq8(resultGases.getFloat("mq8"));
            desvMq8 += Math.pow(resultGases.getFloat("mq8") - medMq8, 2);

            gas.setMq9(resultGases.getFloat("mq9"));
            desvMq9 += Math.pow(resultGases.getFloat("mq9") - medMq9, 2);

            gas.setMq135(resultGases.getFloat("mq135"));
            desvMq135 += Math.pow(resultGases.getFloat("mq135") - medMq135, 2);

            gas.setTgs822(resultGases.getFloat("tgs822"));
            desvTgs822 += Math.pow(resultGases.getFloat("tgs822") - medTgs822, 2);

            gas.setTgs2600(resultGases.getFloat("tgs2600"));
            desvTgs2600 += Math.pow(resultGases.getFloat("tgs2600") - medTgs2600, 2);

            gas.setTgs2602(resultGases.getFloat("tgs2602"));
            desvTgs2602 += Math.pow(resultGases.getFloat("tgs2602") - medTgs2602, 2);

            gas.setTgs2603(resultGases.getFloat("tgs2603"));
            desvTgs2603 += Math.pow(resultGases.getFloat("tgs2603") - medTgs2603, 2);

            gas.setClasse(resultGases.getString("classe"));
            gases.add(gas);
            n++;
        }
        desvMq2 = (float) Math.sqrt(desvMq2 / n);
        desvMq3 = (float) Math.sqrt(desvMq3 / n);
        desvMq4 = (float) Math.sqrt(desvMq4 / n);
        desvMq5 = (float) Math.sqrt(desvMq5 / n);
        desvMq6 = (float) Math.sqrt(desvMq6 / n);
        desvMq7 = (float) Math.sqrt(desvMq7 / n);
        desvMq8 = (float) Math.sqrt(desvMq8 / n);
        desvMq9 = (float) Math.sqrt(desvMq9 / n);
        desvMq135 = (float) Math.sqrt(desvMq135 / n);
        desvTgs822 = (float) Math.sqrt(desvTgs822 / n);
        desvTgs2600 = (float) Math.sqrt(desvTgs2600 / n);
        desvTgs2602 = (float) Math.sqrt(desvTgs2602 / n);
        desvTgs2603 = (float) Math.sqrt(desvTgs2603 / n);
        n = 0;

        while (resultPoeira10s.next()) {
            Poeira10 poeira10 = new Poeira10();
            poeira10.setId_poeira10(resultPoeira10s.getInt("id_poeira_10"));
            poeira10.setData_hora(resultPoeira10s.getString("data_hora"));

            poeira10.setPoeira10(resultPoeira10s.getFloat("poeira_10"));
            desvPoeira10 += Math.pow(resultPoeira10s.getFloat("poeira_10") - medPoeira10, 2);

            poeira10.setClasse(resultPoeira10s.getString("classe"));
            poeira10s.add(poeira10);
            n++;
        }
        desvPoeira10 = (float) Math.sqrt(desvPoeira10 / n);
        n = 0;

        while (resultPoeira25s.next()) {
            Poeira25 poeira25 = new Poeira25();
            poeira25.setId_poeira25(resultPoeira25s.getInt("id_poeira_25"));
            poeira25.setData_hora(resultPoeira25s.getString("data_hora"));

            poeira25.setPoeira25(resultPoeira25s.getFloat("poeira_25"));
            desvPoeira25 += Math.pow(resultPoeira25s.getFloat("poeira_25") - medPoeira25, 2);

            poeira25.setClasse(resultPoeira25s.getString("classe"));
            poeira25s.add(poeira25);
            n++;
        }
        desvPoeira25 = (float) Math.sqrt(desvPoeira25 / n);
        n = 0;

        while (resultPressaos.next()) {
            Pressao pressao = new Pressao();
            pressao.setId_pressao(resultPressaos.getInt("id_pressao"));
            pressao.setData_hora(resultPressaos.getString("data_hora"));

            pressao.setPressao(resultPressaos.getFloat("pressao"));
            desvPressao += Math.pow(resultPressaos.getFloat("pressao") - medPressao, 2);

            pressao.setClasse(resultPressaos.getString("classe"));
            pressaos.add(pressao);
            n++;
        }
        desvPressao = (float) Math.sqrt(desvPressao / n);
        n = 0;

        while (resultTemperaturas.next()) {
            Temperatura temperatura = new Temperatura();
            temperatura.setId_temperatura(resultTemperaturas.getInt("id_temperatura"));
            temperatura.setData_hora(resultTemperaturas.getString("data_hora"));

            temperatura.setTemperatura(resultTemperaturas.getFloat("temperatura"));
            desvTemperatura += Math.pow(resultTemperaturas.getFloat("temperatura") - medTemperatura, 2);

            temperatura.setClasse(resultTemperaturas.getString("classe"));
            temperaturas.add(temperatura);
            n++;
        }
        desvTemperatura = (float) Math.sqrt(desvTemperatura / n);
        n = 0;

        while (resultUmidades.next()) {
            Umidade umidade = new Umidade();
            umidade.setId_umidade(resultUmidades.getInt("id_umidade"));
            umidade.setData_hora(resultUmidades.getString("data_hora"));

            umidade.setUmidade(resultUmidades.getFloat("umidade"));
            desvUmidade += Math.pow(resultUmidades.getFloat("umidade") - medUmidade, 2);

            umidade.setClasse(resultUmidades.getString("classe"));
            umidades.add(umidade);
            n++;
        }
        desvUmidade = (float) Math.sqrt(desvUmidade / n);
        ////////////////////////////////////////////////////////////////////////
        /////////////////////////////Atualização////////////////////////////////
        ////////////////////////////////////////////////////////////////////////
        PreparedStatement pst = conecta.getConnection().prepareStatement("insert into gases "
                + "(mq2, mq3, mq4, mq5, mq6, mq7, mq8, mq9, mq135, tgs822, tgs2600, tgs2602, tgs2603, data_hora, classe) "
                + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        int s = 0;
        while (s != segundos) {
            s++;
            pst.setFloat(1, (gerador.nextFloat() * ((medMq2 + (desvMq2)) - (medMq2 - (desvMq2)))) + (medMq2 - (desvMq2)));
            pst.setFloat(2, (gerador.nextFloat() * ((medMq3 + (desvMq3)) - (medMq3 - (desvMq3)))) + (medMq3 - (desvMq3)));
            pst.setFloat(3, (gerador.nextFloat() * ((medMq4 + (desvMq4)) - (medMq4 - (desvMq4)))) + (medMq4 - (desvMq4)));
            pst.setFloat(4, (gerador.nextFloat() * ((medMq5 + (desvMq5)) - (medMq5 - (desvMq5)))) + (medMq5 - (desvMq5)));
            pst.setFloat(5, (gerador.nextFloat() * ((medMq6 + (desvMq6)) - (medMq6 - (desvMq6)))) + (medMq6 - (desvMq6)));
            pst.setFloat(6, (gerador.nextFloat() * ((medMq7 + (desvMq7)) - (medMq7 - (desvMq7)))) + (medMq7 - (desvMq7)));
            pst.setFloat(7, (gerador.nextFloat() * ((medMq8 + (desvMq8)) - (medMq8 - (desvMq8)))) + (medMq8 - (desvMq8)));
            pst.setFloat(8, (gerador.nextFloat() * ((medMq9 + (desvMq9)) - (medMq9 - (desvMq9)))) + (medMq9 - (desvMq9)));
            pst.setFloat(9, (gerador.nextFloat() * ((medMq135 + (desvMq135)) - (medMq135 - (desvMq135)))) + (medMq135 - (desvMq135)));
            pst.setFloat(10, (gerador.nextFloat() * ((medTgs822 + (desvTgs822)) - (medTgs822 - (desvTgs822)))) + (medTgs822 - (desvTgs822)));
            pst.setFloat(11, (gerador.nextFloat() * ((medTgs2600 + (desvTgs2600)) - (medTgs2600 - (desvTgs2600)))) + (medTgs2600 - (desvTgs2600)));
            pst.setFloat(12, (gerador.nextFloat() * ((medTgs2602 + (desvTgs2602)) - (medTgs2602 - (desvTgs2602)))) + (medTgs2602 - (desvTgs2602)));
            pst.setFloat(13, (gerador.nextFloat() * ((medTgs2603 + (desvTgs2603)) - (medTgs2603 - (desvTgs2603)))) + (medTgs2603 - (desvTgs2603)));

            Date dataInicial = new Date(dt.parse(dataHoraNovo).getTime());
            Date dataAtual = new Date(dataInicial.getTime() + (1000 * s));
            Timestamp timestamp = new Timestamp(dataAtual.getTime());

            pst.setTimestamp(14, timestamp);
            pst.setString(15, classe);
            pst.execute();
        }

        pst = conecta.getConnection().prepareStatement("insert into poeira_10 (poeira_10, data_hora, classe) values "
                + "(?,?,?)");
        s = 0;
        while (s != segundos) {
            s++;
            pst.setFloat(1, (gerador.nextFloat() * ((medPoeira10 + (desvPoeira10)) - (medPoeira10 - (desvPoeira10)))) + (medPoeira10 - (desvPoeira10)));

            Date dataInicial = new Date(dt.parse(dataHoraNovo).getTime());
            Date dataAtual = new Date(dataInicial.getTime() + (1000 * s));
            Timestamp timestamp = new Timestamp(dataAtual.getTime());

            pst.setTimestamp(2, timestamp);
            pst.setString(3, classe);
            pst.execute();
        }

        pst = conecta.getConnection().prepareStatement("insert into poeira_25 (poeira_25, data_hora, classe) values "
                + "(?,?,?)");
        s = 0;
        while (s != segundos) {
            s++;
            pst.setFloat(1, (gerador.nextFloat() * ((medPoeira25 + (desvPoeira25)) - (medPoeira25 - (desvPoeira25)))) + (medPoeira25 - (desvPoeira25)));

            Date dataInicial = new Date(dt.parse(dataHoraNovo).getTime());
            Date dataAtual = new Date(dataInicial.getTime() + (1000 * s));
            Timestamp timestamp = new Timestamp(dataAtual.getTime());

            pst.setTimestamp(2, timestamp);
            pst.setString(3, classe);
            pst.execute();
        }

        pst = conecta.getConnection().prepareStatement("insert into pressao (pressao, data_hora, classe) values "
                + "(?,?,?)");
        s = 0;
        while (s != segundos) {
            s++;
            pst.setFloat(1, (gerador.nextFloat() * ((medPressao + (desvPressao)) - (medPressao - (desvPressao)))) + (medPressao - (desvPressao)));

            Date dataInicial = new Date(dt.parse(dataHoraNovo).getTime());
            Date dataAtual = new Date(dataInicial.getTime() + (1000 * s));
            Timestamp timestamp = new Timestamp(dataAtual.getTime());

            pst.setTimestamp(2, timestamp);
            pst.setString(3, classe);
            pst.execute();
        }

        pst = conecta.getConnection().prepareStatement("insert into temperatura (temperatura, data_hora, classe) values "
                + "(?,?,?)");
        s = 0;
        while (s != segundos) {
            s++;
            pst.setFloat(1, (gerador.nextFloat() * ((medTemperatura + (desvTemperatura)) - (medTemperatura - (desvTemperatura)))) + (medTemperatura - (desvTemperatura)));

            Date dataInicial = new Date(dt.parse(dataHoraNovo).getTime());
            Date dataAtual = new Date(dataInicial.getTime() + (1000 * s));
            Timestamp timestamp = new Timestamp(dataAtual.getTime());

            pst.setTimestamp(2, timestamp);
            pst.setString(3, classe);
            pst.execute();
        }

        pst = conecta.getConnection().prepareStatement("insert into umidade (umidade, data_hora, classe) values "
                + "(?,?,?)");
        s = 0;
        while (s != segundos) {
            s++;
            pst.setFloat(1, (gerador.nextFloat() * ((medUmidade + (desvUmidade)) - (medUmidade - (desvUmidade)))) + (medUmidade - (desvUmidade)));

            Date dataInicial = new Date(dt.parse(dataHoraNovo).getTime());
            Date dataAtual = new Date(dataInicial.getTime() + (1000 * s));
            Timestamp timestamp = new Timestamp(dataAtual.getTime());

            pst.setTimestamp(2, timestamp);
            pst.setString(3, classe);
            pst.execute();
        }
    }
}
