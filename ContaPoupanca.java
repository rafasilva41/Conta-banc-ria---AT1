public class ContaPoupanca extends Conta implements OperacoesBancarias{

    public ContaPoupanca(int numero, String titular, double saldo) {
        super(numero, titular, saldo);
    }

    @Override
    public void atualizarSaldo() {
        double rendimento = saldo * 0.003;
        saldo += rendimento;
        System.out.println("Conta poupanca aplicada com rendimento mensal de R$" + rendimento);
    }

    @Override
    public void transferir(Conta destino, double valor) throws SaldoInsuficiente {
        if (valor > saldo) {
            throw new SaldoInsuficiente("Saldo insuficiente para a transferencia.");
        }
        saldo -= valor;
        destino.depositar(valor);
            System.out.println("R$" + valor + " transferidos para " + destino.getTitular());

    }

    @Override
    public void imprimirExtrato() {
        System.out.println("EXTRATO DA CONTA POUPANCA");
        System.out.println("Titular: " + getTitular());
        System.out.println("Numero:" + getNumero());
        System.out.println("Saldo atual: R$" + getSaldo());
    }
}
