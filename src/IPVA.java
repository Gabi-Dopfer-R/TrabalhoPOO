public interface IPVA {
    public final double ValorBase = 500.00;

    //todo declarar as variaveis relacionadas ao ipva
    default double CalcularIPVA(double cte) {
        return ValorBase*cte;
    }
}
