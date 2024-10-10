package br.com.conversor;

import java.util.Scanner;

public class Main {
    private static Conversor conversor = new Conversor();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        byte escolha = 0;
        double valor = 0;

        do {
            System.out.print("""
                ===== Conversor de moedas =====
                1- BRL (Reais) para USD (Dolar)
                2- USD (Dolar) para BRL (Reais)
                3- BRL (Reais) para CNY (Yuan)
                4- CNY (Yuan) para BRL (Reais)
                5- BRL (Reais) para EUR (Euro)
                6- EUR (Euro) para BRL (Reais)
                """);
            escolha = input.nextByte();

            System.out.print("Digite o valor: ");
            valor = input.nextDouble();
        } while (!selecionarEscolha(escolha));

        conversor.mostrarResultado(valor);
    }

    public static boolean selecionarEscolha(byte escolha) {
        String url = "https://v6.exchangerate-api.com/v6/fe3de2d647fbc0bac88ad3df/pair/";
        String moedaInicial = null;
        String moedaFinal = null;

        switch (escolha) {
            case 1:
                moedaInicial = "BRL";
                moedaFinal = "USD";
                url += moedaInicial + '/' + moedaFinal;
                break;
            case 2:
                moedaInicial = "USD";
                moedaFinal = "BRL";
                url += moedaInicial + '/' + moedaFinal;
                break;
            case 3:
                moedaInicial = "BRL";
                moedaFinal = "CNY";
                url += moedaInicial + '/' + moedaFinal;
                break;
            case 4:
                moedaInicial = "CNY";
                moedaFinal = "BRL";
                url += moedaInicial + '/' + moedaFinal;
                break;
            case 5:
                moedaInicial = "BRL";
                moedaFinal = "EUR";
                url += moedaInicial + '/' + moedaFinal;
                break;
            case 6:
                moedaInicial = "EUR";
                moedaFinal = "BRL";
                url += moedaInicial + '/' + moedaFinal;
                break;
            default:
                System.out.println("Essa escolha não existe");
                return false;
        }

        ApiService apiService = new ApiService(url);
        Main.conversor = apiService.pegarApi();
        Main.conversor.setMoedaInicial(moedaInicial);
        Main.conversor.setMoedaFinal(moedaFinal);
        return true;
    }
}
