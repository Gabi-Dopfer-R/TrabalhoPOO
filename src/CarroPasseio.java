public class CarroPasseio extends VeiculoMotorizado {

    public CarroPasseio(int id){
        this.cte = 1.3;
        this.qtdBlocos = 5;
        this.gastoCombustivel = 0.75F;
        this.id = id;
        this.valorIPVA = CalcularIPVA(cte);

        for (int i = 0; i < 4; i++) {
            roda.add(new Roda());
        }

        //Imagem do carro de passeio
        veiculo.add("  ______");
        veiculo.add(" /|_||_\\`.__");
        veiculo.add("(   _    _ _\\");
        veiculo.add("=`-(_)--(_)-'");
    }

    public CarroPasseio(int id, int valorVenda){
        this.cte = 1.3;
        this.qtdBlocos = 5;
        this.gastoCombustivel = 0.75;
        this.id = id;
        this.valorVenda = valorVenda;

        for (int i = 0; i < 4; i++) {
            roda.add(new Roda());
        }

        //Imagem do carro de passeio
        veiculo.add("  ______");
        veiculo.add(" /|_||_\\`.__");
        veiculo.add("(   _    _ _\\");
        veiculo.add("=`-(_)--(_)-'");
    }

    public void MostrarInfo() {
        System.out.println("Tipo: Carro de Passeio.");
        super.MostrarInfo();
    }
}
