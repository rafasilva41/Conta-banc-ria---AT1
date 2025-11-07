public interface OperacoesBancarias {
    void transferir(Conta destino, double valor) throws SaldoInsuficiente;
    void imprimirExtrato();
}
