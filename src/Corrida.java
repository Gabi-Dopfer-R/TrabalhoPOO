import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.io.Serializable;

public class Corrida implements Serializable {
    public static void main(String[] args) throws InterruptedException, IOException {
        //abre o arquivo
        File arquivo = new File("veiculo.dat");
        Simulador Corrida = new Simulador();
        Scanner teclado = new Scanner(System.in);

        int i;
        int id;
        float gasolina;
        String acao;
        String tipo;
   
        do {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
    

            System.out.println("\n1: Incluir veiculo");
            System.out.println("2: Remover veiculo");
            System.out.println("3: abastecer veiculo");
            System.out.println("4: Movimentar veiculo especifico");
            System.out.println("5: Movimentar veiculo por tipo");
            System.out.println("6: Movimentar todos os veiculos");
            System.out.println("7: Imprimir todos os dados de todos os veiculos");
            System.out.println("8: Imprimir dados de veiculos por tipo");
            System.out.println("9: esvaziar/calibrar um pneu especifico");
            System.out.println("10: Calibrar todos os pneus de veiculos por tipo");
            System.out.println("11: Esvaziar todos os pneus de veiculos por tipo");
            System.out.println("12: Imprimir pista de corrida");
            System.out.println("13: Gravar veiculos em arquivo");
            System.out.println("14: Ler veiculos do arquivo");
            System.out.println("15: Sair da aplicacao");

            i = teclado.nextInt();
            switch (i) {
                case 1://Incluir veiculo
                    System.out.println(
                            "Insira o tipo:\n" +
                            "B : Bicicleta\n"  +
                            "E : Esportivo\n" +
                            "M : Motocicleta\n" +
                            "C : Carro de passeio"
                    );

                    tipo = teclado.next();
                    tipo = tipo.toUpperCase();
                    Corrida.CriarVeiculo(tipo);
                    break;

                case 2://Remover veiculo
                    System.out.print("Informe o id do veiculo:");
                    id = teclado.nextInt();
                    Corrida.RemoverVeiculo(id);
                    break;

                case 3://abastecer veiculo
                    System.out.print("Informe o id do veiculo:");
                    id = teclado.nextInt();
                    System.out.print("Informe a quantidade de gasolina");
                    gasolina = teclado.nextFloat();
                    Corrida.AbastecerVeiculo(id, gasolina);
                    break;

                case 4://Movimentar veiculo especifico
                    System.out.print("Informe o id do veiculo:");
                    id = teclado.nextInt();
                    Corrida.MoverUm(id);
                    break;

                case 5://Movimentar veiculo por tipo
                    System.out.println(
                        "Informe o tipo de veiculo:\n" +
                        "B : Bicicleta\n"  +
                        "E : Esportivo\n" +
                        "M : Motocicleta\n" +
                        "C : Carro de passeio"
                    );
                    tipo = teclado.next();
                    tipo = tipo.toUpperCase();
                    Corrida.MoverPorTipo(tipo);
                    break;

                case 6://Movimentar todos os veiculos
                    Corrida.MoverTodos();
                    break;

                case 7:// Imprimir todos os dados de todos os veiculos
                    Corrida.MostrarInfoTodos();
                    break;

                case 8://Imprimir dados de veiculos por tipo
                    System.out.println(
                        "Informe o tipo de veiculo:\n" +
                        "B : Bicicleta\n"  +
                        "E : Esportivo\n" +
                        "M : Motocicleta\n" +
                        "C : Carro de passeio"
                    );
                    tipo = teclado.next();
                    tipo = tipo.toUpperCase();
                    Corrida.MostrarInfoPorTipo(tipo);
                    break;

                case 9://esvaziar ou calibrar um pneu especifico
                    System.out.print("Informe o id do veiculo:");
                    while(true) {
                        id = teclado.nextInt();

                        if (id > 19 || id < 0 || Corrida.veiculo[id] == null) {
                            System.out.println("Veiculo Nao encontrado. Insira outro id");
                        }
                        else { break;}
                    }

                    System.out.print("Insira a roda desejada:");
                    while(true) {
                        i = teclado.nextInt();

                        if((i >= Corrida.veiculo[id].GetQtdRodas())||(i < 0)){
                            System.out.println("Roda Nao encontrada. Insira outra roda");
                        }
                        else { break; }
                    }

                    System.out.print("Insira a acao (esvaziar ou calibrar):");
                    while (true) {
                        acao = teclado.next();
                        acao = acao.toUpperCase();

                        if (acao.equals("ESVAZIAR")) {
                            Corrida.veiculo[id].UmaRoda(i, false);
                            System.out.print("Roda esvaziada com sucesso.");
                            break;
                        } else if (acao.equals("CALIBRAR")) {
                            Corrida.veiculo[id].UmaRoda(i, true);
                            System.out.print("Roda calibrada com sucesso.");
                            break;
                        } else {
                            System.out.println("Acao nao encontrada. Insira novamente");
                        }
                    }
                    break;

                case 10://Calibrar todos os pneus de veiculos por tipo
                case 11://Esvaziar todos os pneus de veiculos por tipo
                    //determinar se é a opção 10 ou 11
                    boolean aux;
                    if(i == 10){ aux = true; }
                    else{ aux = false; }

                    System.out.println(
                            "Insira tipo do veiculo:\n" +
                            "B : Bicicleta\n"  +
                            "E : Esportivo\n" +
                            "M : Motocicleta\n" +
                            "C : Carro de passeio"
                    );

                    tipo = teclado.next();
                    tipo = tipo.toUpperCase();
                    Corrida.EsvaziarCalibrarPorTipo(tipo, aux);
                    break;

                case 12://Imprimir pista de corrida
                    Corrida.Pista();
                    break;

                case 13://Gravar veiculos em arquivo
                    try {
                        FileOutputStream fout = new FileOutputStream(arquivo);
                        ObjectOutputStream oos = new ObjectOutputStream(fout);
                        // gravando o vetor de pessoas no arquivo
                        oos.writeObject(Corrida.veiculo);
                        oos.flush();
                        oos.close();
                        fout.close();
                    } catch (Exception ex) {
                        System.err.println("erro : " + ex.toString());
                    }
                    break;

                case 14://Ler veiculos do arquivo
                    try {
                        FileInputStream fin = new FileInputStream(arquivo);
                        ObjectInputStream oin = new ObjectInputStream(fin);

                        Veiculo[] veiculoarc = (Veiculo[]) oin.readObject();
                        oin.close();
                        fin.close();

                        Corrida.veiculo = veiculoarc;

                        Veiculo.ZerarQtdVeiculos();
                        for(i=0; i<20; i++){
                            if(Corrida.veiculo[i] != null){
                                Veiculo.AlterarQtdVeiculos(true);
                            }
                        }
                    } catch (Exception ex) {
                        System.err.println("erro : " + ex.toString());
                    }
                    break;

                case 15://Sair da aplicacao
                    return;
            }

            System.out.println("\nInsira 0 para continuar");
            acao = teclado.next();

        } while (acao.equals("0"));
        teclado.close();
    }
}

