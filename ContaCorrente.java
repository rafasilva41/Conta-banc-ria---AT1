public class ContaCorrente extends Conta implements OperacoesBancarias{


    public ContaCorrente(int numero, String titular, double saldo) {
        super(numero, titular, saldo);
    }

    @Override
    public void sacar(double valor) throws SaldoInsuficiente {
        double valorTaxado = valor + (valor * 0.005);
        if (valorTaxado > saldo) {
            throw new SaldoInsuficiente("Saldo insuficiente para realizar o saque. " + "Saldo em conta: " + saldo + ". Valor do saque: " + valor);
        }
        saldo -= valorTaxado;
        System.out.println("Saque de R$" + valor + " realizado com sucesso com uma taxa de R$" + valorTaxado + ".");
    }

    @Override
    public void atualizarSaldo() {
        System.out.println("Saldo da conta corrente mantido (sem rendimento).");
    }

    @Override
    public void transferir(Conta destino, double valor) throws SaldoInsuficiente {
        if (valor > saldo) {
            throw new SaldoInsuficiente("Saldo insuficiente para a transferencia.");
        }
        saldo -= valor;
        destino.depositar(valor);
        System.out.println("R$" + valor + " transferidos para " + destino.getTitular() + ".");
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("EXTRATO DA CONTA CORRENTE");
        System.out.println("Titular: " + getTitular());
        System.out.println("Numero: " + getNumero());
        System.out.println("Saldo atual: R$" + getSaldo());
    }
}
