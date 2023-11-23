import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        double[] moedas = {0.05, 0.1, 0.25, 0.50, 1, 2, 5, 10, 20, 50, 100, 200};
        System.out.println("Entre com o valor para calcular o mapa de troco: ");

        Scanner entrada = new Scanner(System.in);
        double valor = 0;

        try {
            valor = obterValor(entrada);
        } catch (NumberFormatException e) {
            System.out.println("Erro: o valor deve ser numérico.");
        } finally {
            System.out.println("A entrada foi processada.");
        }

        TrocoMoeda[] troco = calcularTroco(moedas, valor);
        System.out.println("O troco é: ");
        for (TrocoMoeda trocoMoeda : troco) {
            if (trocoMoeda.getQuantidade() > 0) {
                System.out.println(trocoMoeda.getQuantidade() + " moeda(s) de " + trocoMoeda.getMoeda() );
            }
        }
        entrada.close();
    }

    public static double obterValor(Scanner entrada) throws NumberFormatException {
        double valor;
        String input = entrada.nextLine();

        try {
            valor = Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Erro: o valor deve ser numérico.");
        }
        return valor;
    }

    public static TrocoMoeda[] calcularTroco(double[] moedas, double valor) {
        TrocoMoeda[] troco = new TrocoMoeda[moedas.length];

        for (int i = moedas.length - 1; i >= 0; i--) {
            int quantidade = 0;
            while (valor >= moedas[i]) {
                quantidade++;
                valor -= moedas[i];
                valor = arredondar(valor, 2); // arredonda o valor para evitar problemas com pontos flutuantes
            }
            troco[i] = new TrocoMoeda(moedas[i], quantidade);
        }
        return troco;
    }

    public static double arredondar(double valor, int casasDecimais) {
        double arredondado = valor * Math.pow(10, casasDecimais);
        arredondado = Math.round(arredondado);
        arredondado = arredondado / Math.pow(10, casasDecimais);
        return arredondado;
    }
}
