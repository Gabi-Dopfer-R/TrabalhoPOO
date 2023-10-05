import java.util.Random;

public abstract class VeiculoMotorizado extends Veiculo implements IPVA{
    double cte;//multiplicador do IPVA
    double gastoCombustivel;//quanto combústivel gasta por movimentação
    private float qtdCombustivel;
    private final boolean IPVA;//se IPVA pago ou não
    double valorIPVA;


    public VeiculoMotorizado(){
        this.valorVenda = new Random().nextInt(100000);
        qtdCombustivel = 2.5F;
        IPVA =  new Random().nextBoolean();
    }

    //mover veículo com base nas rodas calibradas, gasolina e IPVA
    public void Mover(){
        if(this.qtdCombustivel >= gastoCombustivel && this.IPVA && RodasCalibradas()) {
            this.distPercorrida += qtdBlocos;
            this.qtdCombustivel = (float) (this.qtdCombustivel - gastoCombustivel);
            System.out.printf("\nVeiculo %d se movimentou\n", this.id);
        } else {
            System.out.printf("\nVeiculo %d nao se movimentou devido a problemas\n", this.id);
        }
    }

    //mostrar info dos veículos motorizados
    public void MostrarInfo() {
        super.MostrarInfo();
        System.out.printf("Combustivel: %.2f \n", qtdCombustivel);
        System.out.println(
                "Valor IPVA: " + valorIPVA + "\n" +
                "IPVA pago: " + IPVA + "\n" +
                "Valor comercial: " + valorVenda + "\n"
        );
    }

    //abastecer o veículo
    public void Abastecer(float qtdCombustivel){
        this.qtdCombustivel += qtdCombustivel;
    }

}
