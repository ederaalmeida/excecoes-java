package aplicacao;

import model.entidades.Reserva;
import model.excecoes.TratamentoExcecoes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        SimpleDateFormat formatacaoData = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Numero Quarto: ");
            int numeroQuarto = entrada.nextInt();
            System.out.print("Data Entrada (dd/MM/yyyy): ");
            Date dataEntrada = formatacaoData.parse(entrada.next());
            System.out.print("Data Saída (dd/MM/yyyy): ");
            Date dataSaida = formatacaoData.parse(entrada.next());


            Reserva reserva = new Reserva(numeroQuarto, dataEntrada, dataSaida);
            System.out.println("Reserva: " + reserva);

            System.out.println();

            System.out.println("Entrar com data para atualizar reserva: ");
            System.out.print("Data Entrada (dd/MM/yyyy): ");
            dataEntrada = formatacaoData.parse(entrada.next());
            System.out.print("Data Saída (dd/MM/yyyy): ");
            dataSaida = formatacaoData.parse(entrada.next());

            reserva.atualizaDatas(dataEntrada, dataSaida);
            System.out.println("Reserva: " + reserva);
        }
        catch (ParseException e){
            System.out.println("Formato de data invalida");
        }
        catch (TratamentoExcecoes e){
            System.out.println("Erro na reserva: " + e.getMessage());
        }
        catch (InputMismatchException e){
            System.out.println("Erro inesperado");
        }
        entrada.close();
    }
}


