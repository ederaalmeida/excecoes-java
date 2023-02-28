package model.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
    private Integer numeroQuarto;
    private Date dataEntrada;
    private Date dataSaida;

    private static SimpleDateFormat formatacaoData = new SimpleDateFormat("dd/MM/yyyy");

    public Reserva(Integer numeroQuarto, Date dataEntrada, Date dataSaida) {
        this.numeroQuarto = numeroQuarto;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    public Integer getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(Integer numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    private long duracao() {
        long diferencaData = dataSaida.getTime() - dataEntrada.getTime();
        return TimeUnit.DAYS.convert(diferencaData, TimeUnit.MILLISECONDS);
    }

    public String atualizaDatas(Date dataEntrada, Date dataSaida) {

        Date agora = new Date();

        if (dataEntrada.before(agora) || dataSaida.before(agora)) {
            return "Reserva para datas futuras para atualizar reserva";
        }
        if (!dataSaida.after(dataEntrada)) {
            return "Data saída precisa ser depois da data entrada";
        }

        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;

        return null;
    }


    @Override
    public String toString() {
        return "Quarto " + numeroQuarto +
                " Data Entrada " + formatacaoData.format(dataEntrada) +
                " Data Saída " + formatacaoData.format(dataSaida) +
                " Duração " + duracao() +
                " noites";
    }
}
