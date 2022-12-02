package AtividadeC3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class LocadoraApp {

  static Scanner lerString = new Scanner(System.in);
  static ArrayList<Veiculo> veiculo = new ArrayList<Veiculo>();

  public static void main(String[] args) {
    AcessarMenuPrincipal();
  }
  
  /*Menus */
  private static void AcessarMenuPrincipal() {
    Scanner lerInt = new Scanner(System.in);
    System.out.println("Ola, Bem vindo a Locadora SemNome");
    System.out.printf(
      "\nEscolha uma das opções [1] ou [2]: " +
      "\n[1] Admin" +
      "\n[2] Usuario" +
      "\n[3] Sair" +
      "\n");

    int opcoes = lerInt.nextInt();

    do {
      switch (opcoes) {
        case 1:
          AcessarContaAdmin();
          break;
          
        case 2:
          AcessarContaUsuario();
          break;
          
        case 3:
          break;
          
        default:
          System.out.println(
            "O número escolhido é inválido ! escolha uma opção valida."
          );
          opcoes = 0;
      }
      
    } while (opcoes != 0);
  }

  private static void AcessarContaAdmin() {
    Scanner lerInteiro = new Scanner(System.in);
    System.out.println("\nVocê está acessando a area admnistrativa");
    System.out.printf(
      "\nEscolha uma das opções [1], [2], [3], [4], [5]: " +
      "\n[1] Cadastrar veiculo" +
      "\n[2] Consultar veiculo" +
      "\n[3] Remover veiculo" +
      "\n[4] Leitura de arquivo de veiculos" +
      "\n[5] Exportar listagem de veiculos" +
      "\n[6] Voltar" +
      "\n");

    int escolhaAdmin = lerInteiro.nextInt();

    do {
      switch (escolhaAdmin) {
        case 1:
          CadastrarVeiculo();
          escolhaAdmin = 0;
          break;
          
        case 2:
          ConsultarVeiculo(veiculo);
          escolhaAdmin = 0;
          break;
          
        case 3:
          RemoverVeiculo(veiculo);
          escolhaAdmin = 0;
          break;
          
        case 4:
          LeituraArquivo(veiculo);
          escolhaAdmin = 0;
          break;
          
        case 5:
          ExportarListagem(veiculo);
          escolhaAdmin = 0;
          break;
          
        case 6:
          AcessarMenuPrincipal();
          break;
          
        default:
          System.out.println(
            "O número escolhido é inválido ! escolha uma opção valida.");
          escolhaAdmin = 0;
      }
      
    } while (escolhaAdmin != 0);
  }

  private static void AcessarContaUsuario() {
    Scanner lerInteiro = new Scanner(System.in);
    System.out.println("\nVocê está acessando a area do usuario");
    System.out.printf(
      "\nEscolha uma das opções [1] ou [2]: " +
      "\n[1] Consultar veiculo" +
      "\n[2] Alugar veiculo" +
      "\n[3] Voltar" +
      "\n");

    int escolhaUsuario = lerInteiro.nextInt();

    do {
      switch (escolhaUsuario) {
        case 1:
          ConsultarVeiculoDisponivel(veiculo);
          escolhaUsuario = 0;
          break;
          
        case 2:
          AlugarVeiculo(veiculo);
          escolhaUsuario = 0;
          break;
          
        case 3:
          AcessarMenuPrincipal();
          escolhaUsuario = 0;
          break;
          
        default:
          System.out.println(
            "O número escolhido é inválido ! escolha uma opção valida."
          );
          escolhaUsuario = 0;
      }
      
    } while (escolhaUsuario != 0);
  }

  /*Area do admin */
  private static void CadastrarVeiculo() {
    Scanner scanString = new Scanner(System.in);
    Scanner scanInteiro = new Scanner(System.in);

    System.out.println("Deseja cadastrar Carro ou Caminhao");
    String veiculoInformado = scanString.nextLine();

    if (veiculoInformado.equalsIgnoreCase("Carro")) {
      System.out.printf(
        "\nPara cadastrar um veiculo siga as orientações abaixo: " +
        "\n Placa" +
        "\n Chassi" +
        "\n Modelo" +
        "\n Ano do veiculo" +
        "\n Veiculo de luxo" +
        "\n");

      String placa, chassi, modelo, veiculoLuxo;
      int anoVeiculo;

      System.out.print("\nPlaca: ");
      placa = scanString.nextLine();

      System.out.print("Chassi: ");
      chassi = scanString.nextLine();

      System.out.print("Modelo: ");
      modelo = scanString.nextLine();

      System.out.print("Ano do veiculo: ");
      anoVeiculo = scanInteiro.nextInt();

      System.out.print("Veiculo de luxo [S] ou [N]: ");
      veiculoLuxo = scanString.nextLine();

      if (
        veiculoLuxo.equalsIgnoreCase("Sim") || veiculoLuxo.equalsIgnoreCase("S")
      ) {
        veiculo.add(new Carro(placa, chassi, modelo, anoVeiculo, true));
        System.out.println(
          "\nCadastro do carro de luxo realizado com sucesso.\n");
      } 
      
      else if (veiculoLuxo.equalsIgnoreCase("Nao") || veiculoLuxo.equalsIgnoreCase("N")) {
        veiculo.add(new Carro(placa, chassi, modelo, anoVeiculo, false));
        System.out.println("\nCadastro do carro popular realizado com sucesso.\n");
      } 
      
      else {System.err.println("\nInforme se o veiculo é de Luxo.");
      }
      
    } 
    
    else if (veiculoInformado.equalsIgnoreCase("Caminhao")) {
      System.out.printf(
        "\nPara cadastrar um veiculo siga as orientações abaixo: " +
        "\n Placa" +
        "\n Chassi" +
        "\n Modelo" +
        "\n Ano do veiculo" +
        "\n Carga" +
        "\n");

      String placa, chassi, modelo;
      int anoVeiculo, carga;

      System.out.print("\nPlaca: ");
      placa = scanString.nextLine();

      System.out.print("Chassi: ");
      chassi = scanString.nextLine();

      System.out.print("Modelo: ");
      modelo = scanString.nextLine();

      System.out.print("Ano do veiculo: ");
      anoVeiculo = scanInteiro.nextInt();

      System.out.print("Carga do veiculo: ");
      carga = scanInteiro.nextInt();

      veiculo.add(new Caminhao(placa, chassi, modelo, anoVeiculo, carga));

      if (carga >= 250) System.out.println("\nCadastro do caminhão realizada com sucesso.\n"); 
      else System.out.println("\nCadastro da carreta realizada com sucesso.\n");
      
    } 
    
    else System.err.println("\nTipo do veiculo informado errado.");
  }

  private static void ConsultarVeiculo(ArrayList<Veiculo> veiculos) {
    Scanner scanString = new Scanner(System.in);
    Scanner scanInteiro = new Scanner(System.in);

    System.out.println("Qual tipo de veiculo está buscando [Carro] ou [Caminhão]: ");
    String tipoVeiculo = scanString.nextLine();

    if (tipoVeiculo.equalsIgnoreCase("Carro")) {
    	System.out.println("O tipo de carro que você procura é de Luxo [Sim] ou [Não]: ");
      String veiculoLuxo = scanString.nextLine();

      if (veiculoLuxo.equalsIgnoreCase("Sim") || veiculoLuxo.equalsIgnoreCase("S")) {
        System.out.printf("\nComo deseja filtrar pela [Modelo] ou [Ano do veiculo]: ");
        String filtroVeiculo = scanString.nextLine();

        if (filtroVeiculo.equalsIgnoreCase("Modelo")) {
          System.out.println("\nInforme o modelo do veiculo: ");
          String modeloInformado = scanString.nextLine();

          int idModelo = consultarModeloVeiculo(veiculos, modeloInformado);

          if (idModelo == -1) 
            System.out.println("Modelo não registrado.");
           
          
          else {
            for (Veiculo veiculo : veiculos) {
              if (veiculo instanceof Carro) {
                Carro veiculoCarro = (Carro) veiculo;
                String modeloVeiculo = veiculoCarro.getModelo();

                if (modeloVeiculo.equalsIgnoreCase(modeloInformado) && veiculoCarro.isLuxo() == true) {
                  System.out.printf(veiculo.consultar());
                }
              }
            }
          }
        } 
        
        else if (filtroVeiculo.equalsIgnoreCase("Ano do veiculo") || filtroVeiculo.equalsIgnoreCase("Ano")) {
          System.out.println("\nInforme o ano do veiculo: ");
          int anoVeiculo = scanInteiro.nextInt();

          int idAnoVeiculo = consultarAnoVeiculo(veiculos, anoVeiculo);

          if (idAnoVeiculo == -1) 
            System.out.println("Ano não registrado.");
          
          else {
            for (Veiculo veiculo : veiculos) {
              if (veiculo instanceof Carro) {
                Carro veiculoCarro = (Carro) veiculo;
                int anoCarro = veiculoCarro.getAnoVeiculo();

                if (anoCarro == anoVeiculo && veiculoCarro.isLuxo() == true) {
                  System.out.printf(veiculo.consultar());
                }
              }
            }
          }
        }
      } 
      
      else if (veiculoLuxo.equalsIgnoreCase("Nao") || veiculoLuxo.equalsIgnoreCase("N")) {
        System.out.printf("\nComo deseja filtrar pela [Modelo] ou [Ano do veiculo]: ");
        String filtroVeiculo = scanString.nextLine();

        if (filtroVeiculo.equalsIgnoreCase("Modelo")) {
          System.out.println("\nInforme o modelo do veiculo: ");
          String modeloInformado = scanString.nextLine();

          int idModelo = consultarModeloVeiculo(veiculos, modeloInformado);

          if (idModelo == -1) 
            System.out.println("Modelo não registrado.");
           
          
          else {
            for (Veiculo veiculo : veiculos) {
              if (veiculo instanceof Carro) {
                Carro veiculoCarro = (Carro) veiculo;
                String modeloVeiculo = veiculoCarro.getModelo();

                if (modeloVeiculo.equalsIgnoreCase(modeloInformado) && veiculoCarro.isLuxo() == false) {
                  System.out.printf(veiculo.consultar());
                }
              }
            }
          }
        } 
        
        else if (filtroVeiculo.equalsIgnoreCase("Ano do veiculo") || filtroVeiculo.equalsIgnoreCase("Ano")) {
          System.out.println("\nInforme o ano do veiculo: ");
          int anoVeiculo = scanInteiro.nextInt();

          int idAnoVeiculo = consultarAnoVeiculo(veiculos, anoVeiculo);

          if (idAnoVeiculo == -1) 
            System.out.println("Ano não registrado.");
           
          
          else {
            for (Veiculo veiculo : veiculos) {
              if (veiculo instanceof Carro) {
                Carro veiculoCarro = (Carro) veiculo;
                int anoCarro = veiculoCarro.getAnoVeiculo();

                if (anoCarro == anoVeiculo && veiculoCarro.isLuxo() == false) {
                  System.out.printf(veiculo.consultar());
                }
              }
            }
          }
        }
      } 
      
      else System.out.println("Informe se o veiculo é de Luxo.");
      
    } 
    
    else if (tipoVeiculo.equalsIgnoreCase("Caminhao")) {
      System.out.print("\nO modelo que procura é [Caminhão] ou [Carreta]: ");
      String tipoCaminhao = scanString.nextLine();

      System.out.printf("\nComo deseja filtrar pela [Modelo] ou [Ano do veiculo]: ");
      String filtroVeiculo = scanString.nextLine();

      if (filtroVeiculo.equalsIgnoreCase("Modelo")) {
        System.out.println("\nInforme o modelo do veiculo: ");
        String modeloInformado = scanString.nextLine();

        int idModelo = consultarModeloVeiculo(veiculos, modeloInformado);

        if (idModelo == -1) {
          System.out.println("Modelo não registrado.");
        } 
        
        else {
          for (Veiculo veiculo : veiculos) {
            if (veiculo instanceof Caminhao) {
              Caminhao veiculoCaminhao = (Caminhao) veiculo;
              String modeloVeiculo = veiculoCaminhao.getModelo();
              int cargaVeiculo = veiculoCaminhao.getCarga();

              if (modeloVeiculo.equalsIgnoreCase(modeloInformado) && tipoCaminhao.equalsIgnoreCase("Caminhao") && cargaVeiculo >= 250) {
                System.out.printf(veiculo.consultar());
              } 
              
              else if (modeloVeiculo.equalsIgnoreCase(modeloInformado) && tipoCaminhao.equalsIgnoreCase("Carreta") && cargaVeiculo < 250) {
                System.out.printf(veiculo.consultar());
              } 
            }
          }
        }
      } 
      
      else if (filtroVeiculo.equalsIgnoreCase("Ano")) {
        System.out.println("\nInforme o ano do veiculo: ");
        int anoInformado = scanInteiro.nextInt();

        int idAno = consultarAnoVeiculo(veiculos, anoInformado);

        if (idAno == -1) {
          System.out.println("Modelo não registrado.");
        } 
        
        else {
          for (Veiculo veiculo : veiculos) {
            if (veiculo instanceof Caminhao) {
              Caminhao veiculoCaminhao = (Caminhao) veiculo;
              int anoVeiculo = veiculoCaminhao.getAnoVeiculo();
              int cargaVeiculo = veiculoCaminhao.getCarga();

              if (anoVeiculo == anoInformado && tipoCaminhao.equalsIgnoreCase("Caminhao") && cargaVeiculo >= 250) {
                System.out.printf(veiculo.consultar());
              } 
              
              else if (anoVeiculo == anoInformado && tipoCaminhao.equalsIgnoreCase("Carreta") && cargaVeiculo < 250) {
                System.out.printf(veiculo.consultar());
              } 
            }
          }
        }
      }
    }
  }

  private static void RemoverVeiculo(ArrayList<Veiculo> veiculos) {
    Scanner scanString = new Scanner(System.in);

    System.out.print("Veiculos registrados: \n");
    for (Veiculo veiculoRecuperado : veiculos) {
      System.out.print(veiculoRecuperado.consultar());
    }

    System.out.print("\nPara remover um veiculo informe a placa do veiculo: ");
    String placa;

    System.out.print("\nPlaca: ");
    placa = scanString.nextLine();

    int idVeiculo = pesquisarVeiculo(veiculo, placa);

    if (idVeiculo == -1) {
      System.out.println("Veiculo de placa: " + placa + " não cadastrado.");
    } 
    
    else {
      veiculos.remove(idVeiculo);
      System.out.println(
        "Veiculo de placa: " + placa + " Removido com sucesso."
      );
    }
  }

  private static void ExportarListagem(ArrayList<Veiculo> veiculos) {
    try {
      Scanner scanString = new Scanner(System.in);

      System.out.println("Deseja exportar listagem de [Carro] ou [Caminhão]: ");
      String escolhaTipo = scanString.nextLine();

      if (escolhaTipo.equalsIgnoreCase("Carro")) {
        File csvFile = new File("listagemCarros.csv");

        PrintWriter outFile = new PrintWriter(csvFile);
        for (Veiculo veiculo : veiculos) {
          if(veiculo instanceof Carro) {
        	  Carro exportarCarro = (Carro) veiculo;
        	  outFile.printf(veiculo.exportar());
          }
        }

        System.out.println("Arquivo gerado com sucesso");
        outFile.close();
      } 
      
      else if (escolhaTipo.equalsIgnoreCase("Caminhao")) {
        File csvFile = new File("listagemCaminhão.csv");

        PrintWriter outFile = new PrintWriter(csvFile);
        for (Veiculo veiculo : veiculos) {
        	if(veiculo instanceof Caminhao) {
        		Caminhao exportarCaminhao = (Caminhao) veiculo;
        		outFile.printf(veiculo.exportar());
        	}
        }

        System.out.println("Arquivo gerado com sucesso");
        outFile.close();
      } 
      
      else {
        System.out.println("Tipo informado invalido. ");
      }
    } 
    
    catch (Exception ex) {
      System.out.println("Arquivo não pode ser gerado");
      ex.printStackTrace();
    }
  }

  private static void LeituraArquivo(ArrayList<Veiculo> veiculos) {
    try {
      Scanner scanString = new Scanner(System.in);

      System.out.println(
        "Deseja listar arquivo de qual tipo [Carro] ou [Caminhão]: "
      );
      String escolhaTipo = scanString.nextLine();

      if (escolhaTipo.equalsIgnoreCase("Carro")) {
        File file = new File("listagemCarros.csv");
        Scanner lerArquivo = new Scanner(file);

        while (lerArquivo.hasNextLine()) {
          System.out.print(lerArquivo.nextLine());
        }

        lerArquivo.close();
      } 
      
      else if (escolhaTipo.equalsIgnoreCase("Caminhao")) {
        File file = new File("listagemCaminhão.csv");
        Scanner lerArquivo = new Scanner(file);

        while (lerArquivo.hasNextLine()) {
          System.out.print(lerArquivo.nextLine());
        }

        lerArquivo.close();
      } 
      
      else {
        System.out.println("Tipo informado invalido. ");
      }
    } 
    
    catch (Exception ex) {
      System.out.println("Arquivo não pode ser lido");
      ex.printStackTrace();
    }
  }
 
  
  /*Area do usuario */
  private static void ConsultarVeiculoDisponivel(ArrayList<Veiculo> veiculos) {
    Scanner scanString = new Scanner(System.in);

    System.out.print("\nQual modelo deseja consultar: [Carro] ou [Caminhão]: ");
    String escolhaConsulta = scanString.nextLine();

    if (escolhaConsulta.equalsIgnoreCase("Carro")) {
      System.out.println("O tipo de carro que você procura é de Luxo: [Sim] ou [Não]");
      String veiculoLuxo = scanString.nextLine();

      if (veiculoLuxo.equalsIgnoreCase("Sim") || veiculoLuxo.equalsIgnoreCase("S")) {
        System.out.println("\nInforme o modelo do veiculo: ");
        String modeloInformado = scanString.nextLine();

        int idModelo = consultarModeloVeiculo(veiculos, modeloInformado);

        if (idModelo == -1 ) 
          System.out.println("Modelo não registrado.");

        else {
          for (Veiculo veiculo : veiculos) {
            if (veiculo instanceof Carro) {
              Carro veiculoCarro = (Carro) veiculo;
              String modeloVeiculo = veiculoCarro.getModelo();
              boolean carroAlugado = veiculoCarro.isLocado();
              boolean carroLuxo = veiculoCarro.isLuxo();

              if (modeloInformado.equalsIgnoreCase(modeloVeiculo) && carroAlugado == false && carroLuxo == true ) {
                System.out.println("Veiculos disponiveis para alugar: ");
                System.out.print(veiculo.consultar());
              } 
              else if(modeloInformado.equalsIgnoreCase(modeloVeiculo) && carroAlugado == true && carroLuxo == true ) {
                System.err.println("\nVeiculo indisponivel para alugar.");
              }
            }
          }
        }
      } 
      
      else if (veiculoLuxo.equalsIgnoreCase("Nao") || veiculoLuxo.equalsIgnoreCase("N")) {
        System.out.println("\nInforme o modelo do veiculo: ");
        String modeloInformado = scanString.nextLine();

        int idModelo = consultarModeloVeiculo(veiculos, modeloInformado);

        if (idModelo == -1) 
          System.out.println("Modelo não registrado.");
        
        
        else {
          for (Veiculo veiculo : veiculos) {
            if (veiculo instanceof Carro) {
              Carro veiculoCarro = (Carro) veiculo;
              String modeloVeiculo = veiculoCarro.getModelo();
              boolean carroAlugado = veiculoCarro.isLocado();
              boolean carroLuxo = veiculoCarro.isLuxo();

              if (modeloInformado.equalsIgnoreCase(modeloVeiculo) && carroAlugado == false && carroLuxo == false) {
                System.out.println("Veiculos disponiveis para alugar: ");
                System.out.print(veiculo.consultar());
              } 
              else if(modeloInformado.equalsIgnoreCase(modeloVeiculo) && carroAlugado == true && carroLuxo == false ) {
                System.err.println("\nVeiculo indisponivel para alugar.");
              }
            }
          }
        }
      }
    } 
    
    else if (escolhaConsulta.equalsIgnoreCase("Caminhao")) {
      System.out.print("\nO modelo que procura é [Caminhão] ou [Carreta]: ");
      String tipoCaminhao = scanString.nextLine();

      if (tipoCaminhao.equalsIgnoreCase("Caminhao")) {
        System.out.println("\nInforme o modelo do veiculo: ");
        String modeloInformado = scanString.nextLine();

        int idModelo = consultarModeloVeiculo(veiculos, modeloInformado);

        if (idModelo == -1) 
          System.err.println("Modelo não registrado."); 
        
        else {
          for (Veiculo veiculo : veiculos) {
            if (veiculo instanceof Caminhao) {
              Caminhao veiculoCaminhao = (Caminhao) veiculo;
              String modeloCaminhao = veiculoCaminhao.getModelo();
              int cargaCaminhao = veiculoCaminhao.getCarga();
              boolean caminhaoAlugado = veiculoCaminhao.isLocado();

              if (modeloInformado.equalsIgnoreCase(modeloCaminhao) && cargaCaminhao >= 250 && caminhaoAlugado == false) {
                System.out.println("Veiculos disponiveis para alugar: ");
            	  System.out.print(veiculo.consultar());
              }
              else if (modeloInformado.equalsIgnoreCase(modeloCaminhao) && cargaCaminhao >= 250 && caminhaoAlugado == true) {
                System.err.println("Veiculo indisponivel para alugar.");
              }
            }
          }
        }
      } 
      
      else if (tipoCaminhao.equalsIgnoreCase("Carreta")) {
        System.out.println("\nInforme o modelo do veiculo: ");
        String modeloInformado = scanString.nextLine();

        int idModelo = consultarModeloVeiculo(veiculos, modeloInformado);

        if (idModelo == -1) 
          System.out.println("Modelo não registrado.");
        
        else {
          for (Veiculo veiculo : veiculos) {
            if (veiculo instanceof Caminhao) {
              Caminhao veiculoCarreta = (Caminhao) veiculo;
              String modeloCarreta = veiculoCarreta.getModelo();
              int cargaCarreta = veiculoCarreta.getCarga();
              boolean carretaAlugado = veiculoCarreta.isLocado();

              if (modeloInformado.equalsIgnoreCase(modeloCarreta) && cargaCarreta < 250 && carretaAlugado == false) {
                System.out.println("Veiculos disponiveis para alugar: ");
            	  System.out.print(veiculo.consultar());
              }
              else if(modeloInformado.equalsIgnoreCase(modeloCarreta) && cargaCarreta < 250 && carretaAlugado == false){
                System.err.println("Veiculo indisponivel para alugar.");
              }
            }
          }
        }
      } 
      
      else System.err.println("Modelo informado indisponivel");
    } 
    
    else System.err.println("Tipo de veiculo escolhido indisponivel.");
  }

  private static void AlugarVeiculo(ArrayList<Veiculo> veiculos) {
	  Scanner scanString = new Scanner(System.in);
	  Scanner scanInt = new Scanner(System.in);
	  
	  System.out.print("\nDeseja alugar um [Carro] ou [Caminhão]: ");
	  String escolhaAluguel = scanString.nextLine();
	  
	  if(escolhaAluguel.equalsIgnoreCase("Carro")) {
		  System.out.println("\nDeseja alugar um carro de [Luxo] ou [Popular]: ");
		  String escolhaCarro = scanString.nextLine();
		  
		  if(escolhaCarro.equalsIgnoreCase("Luxo")) {
			  System.out.println("\nInforme o modelo do veiculo: ");
			  String modeloInformado = scanString.nextLine();
			  
			  System.out.print("Quantas diarias deseja alugar: ");
			  float dias = scanInt.nextFloat();
			  
			  int idModelo = consultarModeloVeiculo(veiculos, modeloInformado);			  
			  if (idModelo == -1) System.err.println("Modelo não registrado.");
			  
			  else {
				  for(Veiculo veiculo: veiculos) {
					  if(veiculo instanceof Carro) {
						  Carro veiculoCarro = (Carro) veiculo;
						  String modeloVeiculo = veiculo.getModelo();
						  boolean carroAlugado = veiculo.isLocado();
						  boolean carroLuxo = veiculoCarro.isLuxo();
						  
						  if(modeloVeiculo.equalsIgnoreCase(modeloInformado) && carroAlugado == false && carroLuxo == true) {
							  System.out.println(veiculo.veiculoAlugado(dias));
                System.out.println("Veiculo alugado com sucesso.");
							  veiculoCarro.setLocado(true);
						  }
              else System.out.println("Veiculo indisponivel");
					  }
				  }
			  }  
		  }
		  
		  else if(escolhaCarro.equalsIgnoreCase("Popular")) {
			  System.out.println("\nInforme o modelo do veiculo: ");
			  String modeloInformado = scanString.nextLine();
			  
			  System.out.print("Quantas diarias deseja alugar: ");
			  float dias = scanInt.nextFloat();
			  
			  int idModelo = consultarModeloVeiculo(veiculos, modeloInformado);			  
			  if (idModelo == -1) System.err.println("Modelo não registrado.");
			  
			  else {
				  for(Veiculo veiculo: veiculos) {
					  if(veiculo instanceof Carro) {
						  Carro veiculoCarro = (Carro) veiculo;
						  String modeloVeiculo = veiculo.getModelo();
						  boolean carroAlugado = veiculo.isLocado();
						  boolean carroLuxo = veiculoCarro.isLuxo();
						  
						  if(modeloVeiculo.equalsIgnoreCase(modeloInformado) && carroAlugado == false && carroLuxo == false) {
							  System.out.println(veiculo.veiculoAlugado(dias));
                System.out.println("\nVeiculo alugado com sucesso.");
							  veiculoCarro.setLocado(true);
						  }
              else System.out.println("Veiculo indisponivel");
					  }
				  }
			  }  
		  }
	  }
	  
	  else if(escolhaAluguel.equalsIgnoreCase("Caminhao")) {
	      System.out.print("\nO modelo que procura é [Caminhão] ou [Carreta]: ");
	      String tipoCaminhao = scanString.nextLine();

	      if (tipoCaminhao.equalsIgnoreCase("Caminhao")) {
	        System.out.println("\nInforme o modelo do veiculo: ");
	        String modeloInformado = scanString.nextLine();
	        
			  System.out.print("Quantas diarias deseja alugar: ");
			  float diarias = scanInt.nextFloat();

        int idModelo = consultarModeloVeiculo(veiculos, modeloInformado);

        if (idModelo == -1) 
          System.err.println("Modelo não registrado."); 
	        
        else {
          for (Veiculo veiculo : veiculos) {
            if (veiculo instanceof Caminhao) {
              Caminhao veiculoCaminhao = (Caminhao) veiculo;
              String modeloCaminhao = veiculoCaminhao.getModelo();
              int cargaCaminhao = veiculoCaminhao.getCarga();
              boolean caminhaoAlugado = veiculoCaminhao.isLocado();

              if (modeloInformado.equalsIgnoreCase(modeloCaminhao) && cargaCaminhao >= 250 && caminhaoAlugado == false) {
                System.out.println(veiculo.veiculoAlugado(diarias));
                System.out.println("Veiculo alugado com sucesso.");
                veiculoCaminhao.setLocado(true);
              }
              else System.out.println("Veiculo indisponivel");
            }
          }
        }
      } 
	      
      else if (tipoCaminhao.equalsIgnoreCase("Carreta")) {
        System.out.println("\nInforme o modelo do veiculo: ");
        String modeloInformado = scanString.nextLine();
		        
			  System.out.print("Quantas diarias deseja alugar: ");
		  	float diarias = scanInt.nextFloat();

        int idModelo = consultarModeloVeiculo(veiculos, modeloInformado);

        if (idModelo == -1) System.err.println("Modelo não registrado."); 
		        
        else {
          for (Veiculo veiculo : veiculos) {
            if (veiculo instanceof Caminhao) {
              Caminhao veiculoCaminhao = (Caminhao) veiculo;
              String modeloCaminhao = veiculoCaminhao.getModelo();
              int cargaCaminhao = veiculoCaminhao.getCarga();
              boolean caminhaoAlugado = veiculoCaminhao.isLocado();

              if (modeloInformado.equalsIgnoreCase(modeloCaminhao) && cargaCaminhao < 250 && caminhaoAlugado == false) { 
                  System.out.println(veiculo.veiculoAlugado(diarias));
                  System.out.println("\nVeiculo alugado com sucesso.");
                  veiculoCaminhao.setLocado(true);
              }
              else System.out.println("Veiculo indisponivel");
              }
            }
	  	    }
        } 
	  }
	  else System.err.println("Escolha de veiculo indisponivel");
  }	

  
  /*Metodos Auxiliares */
  private static int pesquisarVeiculo(ArrayList<Veiculo> veiculo, String placa) {
    for (int i = 0; i < veiculo.size(); i++) {
      if (veiculo.get(i).getPlaca().equalsIgnoreCase(placa)) {
        return i;
      }
    }
    return -1;
  }

  private static int consultarModeloVeiculo(ArrayList<Veiculo> veiculo, String modelo) {
    for (int i = 0; i < veiculo.size(); i++) {
      if (veiculo.get(i).getModelo().equalsIgnoreCase(modelo)) {
        return i;
      }
    }
    return -1;
  }

  private static int consultarAnoVeiculo(ArrayList<Veiculo> veiculo, int ano) {
    for (Veiculo veiculos : veiculo) {
      int anoVeiculos = veiculos.getAnoVeiculo();

      if (anoVeiculos == ano) {
        return veiculos.getIdentificador();
      }
    }
    return -1;
  }
}