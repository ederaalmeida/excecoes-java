package aplicacao;

import model.entidades.Reserva;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) throws ParseException {

        Scanner entrada = new Scanner(System.in);
        SimpleDateFormat formatacaoData = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Numero Quarto: ");
        int numeroQuarto = entrada.nextInt();
        System.out.print("Data Entrada (dd/MM/yyyy): ");
        Date dataEntrada = formatacaoData.parse(entrada.next());
        System.out.print("Data Saída (dd/MM/yyyy): ");
        Date dataSaida = formatacaoData.parse(entrada.next());

        if (!dataSaida.after(dataEntrada)) {
            System.out.println("Erro na Reserva: Data saída precisa ser depois da data entrada");
        } else {
            Reserva reserva = new Reserva(numeroQuarto, dataEntrada, dataSaida);
            System.out.println("Reserva: " + reserva);

            System.out.println();

            System.out.println("Entrar com data para atualizar reserva: ");
            System.out.print("Data Entrada (dd/MM/yyyy): ");
            dataEntrada = formatacaoData.parse(entrada.next());
            System.out.print("Data Saída (dd/MM/yyyy): ");
            dataSaida = formatacaoData.parse(entrada.next());

            String error = reserva.atualizaDatas(dataEntrada, dataSaida);
            if (error != null) {
                System.out.println("Erro na reserva: " + error);
            } else {
                System.out.println("Reserva: " + reserva);
            }
        }
        entrada.close();
    }
}

