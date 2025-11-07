//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class BancoApp {
    public static void main(String[] args) {

        ContaCorrente corrente = new ContaCorrente(257, "Genivaldo", 1000);
        ContaPoupanca poupanca = new ContaPoupanca(456, "Juvenaldo", 500);

    try {

        corrente.depositar(200);
        poupanca.depositar(100);

        corrente.sacar(100);
        poupanca.sacar(25);

        corrente.transferir(poupanca, 200);

        corrente.atualizarSaldo();
        poupanca.atualizarSaldo();

        corrente.imprimirExtrato();
        poupanca.imprimirExtrato();
    } catch (SaldoInsuficiente e){
        System.out.println("Problema ao sacar: " + e.getMessage());
    } finally {
        System.out.println("Operacao finalizada!");
    }
    }
}