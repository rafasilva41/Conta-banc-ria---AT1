public abstract class Conta {
    protected int numero;
    protected String titular;
    protected double saldo;

    public Conta(int numero, String titular, double saldo) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar (double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Deposito de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Desculpe, mas esse valor para depositar esta invalido!");
        }
    }



        public void sacar(double valor) throws SaldoInsuficiente {
            if (valor > saldo) {
                throw new SaldoInsuficiente("Saldo insuficiente para realizar o saque" + "Saldo em conta: " + saldo + "Valor do saque: " + valor);
            }
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
        }

    public abstract void atualizarSaldo();
}
