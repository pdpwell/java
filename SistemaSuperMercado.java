/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_final;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Breno
 */
public class Projeto_final {

    // Menu1<=1 então:
    static void MENU1_1(int menu1, int menu2) throws IOException {
        Scanner teclado = new Scanner(System.in);
        String produto = " ", produtoretirado = " ";

        String DATA = "DATA E HORA.txt";
        String VENDA_DO_MOMENTO = "VENDA DO MOMENTO.txt";
        String VENDA_DO_DIA = "VENDA DO DIA.txt";
        String TODOS_OS_PRODUTOS = "TODOS OS PRODUTOS.txt";
        String VALOR_DE_VENDA = "VALORES DE VENDA.txt";

        System.out.println(METODOS.Read(TODOS_OS_PRODUTOS));
        
        float TotalFinal = 0;
        
        boolean continuar = true;

        if (menu1 == 1) {

            // Se o menu1 <= 1 = menu2. Se menu2<=1. Então:
            if (menu2 == 1) {
                float TotalParcial = 0;
                //Metodo para marcar a data e hora de entrada no menu.

                METODOS.WritePERMANENTE(DATA, "*****************************");
                METODOS.WritePERMANENTE(DATA, "Menu 1, opção 1:");
                METODOS.WritePERMANENTE(DATA, METODOS.DATA(DATA));
                METODOS.WritePERMANENTE(DATA, "*****************************");
                System.out.println("*****************************");
                System.out.println("Menu 1, opção 1:");
                System.out.println("*****************************");
                System.out.println("Digite SAIR para concluir compra");
                METODOS.WritePERMANENTE(VENDA_DO_MOMENTO, "*****************************");
                System.out.println("VENDA DO MOMENTO");
                while (continuar) {
                    System.out.println("Informe o produto que desaja incluir:");
                    produto = teclado.next().toUpperCase();

                    if (produto.equals("SAIR")) {
                        continuar = false;
                        break;
                    }
                    //Buscar o nome do produto e valor.

                    String aux = METODOS.BUSCA(TODOS_OS_PRODUTOS, produto);
                    if (aux.equals("")) {
                        System.out.println("PRODUTO NÃO CADASTRADO");
                    } else {
                        float preco = Float.parseFloat(aux.split("@")[1]);
                        TotalParcial = TotalParcial + preco;
                        //Para guarda as vendas do momento
                        METODOS.WritePERMANENTE(VENDA_DO_MOMENTO, "*" + produto);
                    }

                }
                //Guarda o nome e valor  e o valor.
                METODOS.WritePERMANENTE(VALOR_DE_VENDA, "Valor parcial de soma@" + TotalParcial);
                System.out.println("*****************************************");
                System.out.println("Soma inicial dos valores:" + TotalParcial + " reais");
                System.out.println("*****************************************");

                // Se o menu1 <= 1 = menu2. Se menu2<=2. Então:
            } else if (menu2 == 2) {
                //Metodo para marcar a data e hora de entrada no menu.
                METODOS.WritePERMANENTE(DATA, "*****************************");
                METODOS.WritePERMANENTE(DATA, "Menu 1, opção 2:");
                METODOS.WritePERMANENTE(DATA, METODOS.DATA(DATA));
                METODOS.WritePERMANENTE(DATA, "*****************************");
                System.out.println("*****************************");
                System.out.println("Menu 1, opção 2:");
                System.out.println("*****************************");
                //Mostrar as vendas do momento.
                System.out.println(METODOS.Read(VENDA_DO_MOMENTO));
                System.out.println();
                System.out.println("Informe o produto que deseja excluir");
                produtoretirado = teclado.next().toUpperCase();

                //Vai na lista de "VENDAS DO MOMENTO" e retira o produto escolhido.
                String aux1 = METODOS.BUSCA(TODOS_OS_PRODUTOS, produtoretirado);
                float preco = Float.parseFloat(aux1.split("@")[1]);
                TotalFinal = TotalFinal - preco;

                //Guardar o nome do produto e o valor dele.
                METODOS.WritePERMANENTE(VALOR_DE_VENDA, "Valor parcial@" + TotalFinal);
                //Após completar a venda, apagar o arquivo de venda do momento.
                METODOS.Delete(VENDA_DO_MOMENTO, produtoretirado);

            }
        }

    }

    // Menu1<=2 então:
    static void MENU1_2(int menu1, int menu3) throws IOException {

        String DATA = "DATA E HORA.txt";
        String VENDA_DO_MOMENTO = "VENDA DO MOMENTO.txt";
        String VENDA_DO_DIA = "VENDA DO DIA.txt";
        String VALOR_DE_VENDA = "VALORES DE VENDA.txt";

        if (menu1 == 2) {
            // Se o menu1 <= 2 = menu3. Se menu3<=1. Então:
            if (menu3 == 1) {
                //Metodo para marcar a data e hora de entrada no menu.
                METODOS.WritePERMANENTE(DATA, "*****************************");
                METODOS.WritePERMANENTE(DATA, "Menu 2, opção 1:");
                METODOS.WritePERMANENTE(DATA, METODOS.DATA(DATA));
                METODOS.WritePERMANENTE(DATA, "*****************************");
                System.out.println("*****************************");
                System.out.println("Menu 2, opção 1:");
                System.out.println("*******VENDA DO MOMENTO*******");
                //Mostrar a venda do momento.
                System.out.println(METODOS.Read(VENDA_DO_MOMENTO));
                System.out.println();

                // Se o menu1 <= 2 = menu3. Se menu3<=2. Então:
            } else if (menu3 == 2) {
                float preco1 = 0;
                //Metodo para marcar a data e hora de entrada no menu.
                METODOS.WritePERMANENTE(DATA, "*****************************");
                METODOS.WritePERMANENTE(DATA, "Menu 2, opção 2:");
                METODOS.WritePERMANENTE(DATA, METODOS.DATA(DATA));
                METODOS.WritePERMANENTE(DATA, "*****************************");
                System.out.println("*****************************");
                System.out.println("Menu 2, opção 2:");

                //Ele vai no arquivo "VALORES DE VENDA" e retorna o valor da soma de todos os produtos sem remover nenhum.
                String aux = METODOS.BUSCA(VALOR_DE_VENDA, "Valor parcial de soma");
                float preco = Float.parseFloat(aux.split("@")[1]);

                //Ele vai no arquivo "VALORES DE VENDA" e retorna o valor dos produtos removidos.
                String aux1 = METODOS.BUSCA(VALOR_DE_VENDA, "Valor parcial");
                if (aux1.equals("")) {
                    preco1 = 0;
                } else {
                    preco1 = Float.parseFloat(aux1.split("@")[1]);
                }
                //Mostrar o valor total da compra.
                System.out.println("VALOR DE COMPRAS FINAL: " + (preco + preco1) + " REAIS");
                System.out.println("*****************************");
                System.out.println();

                System.out.println();
                // Metodo para copiar do txt momento para txt dia.
                METODOS.COPIAR(VENDA_DO_MOMENTO, VENDA_DO_DIA);
                //Apagamos tudo do arquivo "VENDA DO MOMENTO"                
                METODOS.APAGADOR_DE_TXT(VENDA_DO_MOMENTO, " ");
                //Apagamos tudo do arquivo "VALOR DE VENDA" 
                METODOS.APAGADOR_DE_TXT(VALOR_DE_VENDA, " ");
            }
        }

    }

    // Menu1<=3 então:
    static void MENU1_3(int menu1, int menu4) {
        Scanner teclado = new Scanner(System.in);
        String produto = " ", produtoretirado = " ";

        String DATA = "DATA E HORA.txt";
        String VENDA_DO_DIA = "VENDA DO DIA.txt";

        if (menu1 == 3) {
            // Se o menu1 <= 3 = menu4. Se menu4<=1. Então:
            if (menu4 == 1) {
                //Metodo para marcar a data e hora de entrada no menu.
                METODOS.WritePERMANENTE(DATA, "*****************************");
                METODOS.WritePERMANENTE(DATA, "Menu 3, opção 1:");
                METODOS.WritePERMANENTE(DATA, METODOS.DATA(DATA));
                METODOS.WritePERMANENTE(DATA, "*****************************");
                System.out.println("*****************************");
                System.out.println("Menu 3, opção 1:");
                System.out.println("*****************************");
                System.out.println();
                System.out.println("*****VENDA DO DIA*****");
                //Mostrar todas as vendas do dia.
                System.out.println(METODOS.Read(VENDA_DO_DIA));
            }
        }
    }

    // Menu1<=4 então:
    static void MENU1_4(int menu1, int menu5) {
        Scanner teclado = new Scanner(System.in);
        String produto = " ", produtoderetira = " ";
        float valor = 0;

        boolean continuar = true;

        String DATA = "DATA E HORA.txt";
        String TODOS_OS_PRODUTOS = "TODOS OS PRODUTOS.txt";

        if (menu1 == 4) {
            // Se o menu1 <= 4 = menu5. Se menu5<=1. Então:
            if (menu5 == 1) {
                //Metodo para marcar a data e hora de entrada no menu.
                METODOS.WritePERMANENTE(DATA, "*****************************");
                METODOS.WritePERMANENTE(DATA, "Menu 4, opção 1:");
                METODOS.WritePERMANENTE(DATA, METODOS.DATA(DATA));
                METODOS.WritePERMANENTE(DATA, "*****************************");
                System.out.println("*****************************");
                System.out.println("Menu 4, opção 1:");
                System.out.println("*****************************");
                System.out.println();
                System.out.println("*****TODOS OS PRODUTOS CADASTRADOS*****");
                //Mostrar todos os produtos Cadastrados.
                System.out.println(METODOS.Read(TODOS_OS_PRODUTOS));
                System.out.println();
            } // Se o menu1 <= 4 = menu5. Se menu5<=2. Então:
            else if (menu5 == 2) {
                //Metodo para marcar a data e hora de entrada no menu.
                METODOS.WritePERMANENTE(DATA, "*****************************");
                METODOS.WritePERMANENTE(DATA, "Menu 4, opção 2:");
                METODOS.WritePERMANENTE(DATA, METODOS.DATA(DATA));
                METODOS.WritePERMANENTE(DATA, "*****************************");
                System.out.println("*****************************");
                System.out.println("Menu 4, opção 2:");
                System.out.println("*****************************");
                System.out.println("Digite SAIR no produto ou digite um valor NEGATIVO para sair.");
                System.out.println("*****************************");
                while (continuar) {
                    System.out.println("Informe o produto:");
                    produto = teclado.next().toUpperCase();
                    if (produto.equals("SAIR")) {
                        continuar = false;
                        break;
                    }
                    System.out.println("Informe o valor do produto:");
                    valor = teclado.nextFloat();
                    if (valor < 0) {
                        continuar = false;
                        break;
                    }
                    //Guardar o nome e o valor do produto, separados por "@".
                    METODOS.WritePERMANENTE(TODOS_OS_PRODUTOS, produto + "@" + valor);
                }

            } // Se o menu1 <= 4 = menu5. Se menu5<=3. Então:
            else if (menu5 == 3) {
                //Metodo para marcar a data e hora de entrada no menu.
                METODOS.WritePERMANENTE(DATA, "*****************************");
                METODOS.WritePERMANENTE(DATA, "Menu 4, opção 3:");
                METODOS.WritePERMANENTE(DATA, METODOS.DATA(DATA));
                METODOS.WritePERMANENTE(DATA, "*****************************");
                System.out.println("*****************************");
                System.out.println("Menu 4, opção 3:");
                System.out.println("*****************************");
                System.out.println();
                System.out.println(METODOS.Read(TODOS_OS_PRODUTOS));
                System.out.println();
                System.out.println("Qual produto deseja retirado");
                produtoderetira = teclado.next().toUpperCase();
                //Para deletar a linha que tá o produto escolhido.
                METODOS.Delete(TODOS_OS_PRODUTOS, produtoderetira);
            }

        }

    }

    public static void main(String[] args) throws IOException {
        Scanner teclado = new Scanner(System.in);

        int menu1 = 0;

        String DATA = "DATA E HORA.txt";
        String VENDADODIA = "VENDA DO DIA.txt";
        String TODOS_OS_PRODUTOS = "TODOS OS PRODUTOS.txt";
        String INICIO = "INICIO";
       

        while (menu1 != 5) {
            int menu2 = 0, menu3 = 0, menu4 = 0, menu5 = 0;
            //Metodo para marcar a data e hora de entrada no menu.

            METODOS.WritePERMANENTE(TODOS_OS_PRODUTOS, "**");
            METODOS.WritePERMANENTE(DATA, "*****************************");
            METODOS.WritePERMANENTE(DATA, "Sistema de vendas, opções");
            METODOS.WritePERMANENTE(DATA, METODOS.DATA(DATA));
            METODOS.WritePERMANENTE(DATA, "*****************************");
            System.out.println("*****************************");
            System.out.println("Sistema de vendas, opções");
            System.out.println("*****************************");
            System.out.println("1- Iniciar venda");
            System.out.println("2- Finalizar venda");
            System.out.println("3- Resulmo geral do dia");
            System.out.println("4- Lista de produtos");
            System.out.println("5- Sair");

            System.out.print("Informe uma das opções:");
            menu1 = teclado.nextInt();

            if (menu1 == 1) {
                while (menu2 != 3) {
                    //Metodo para marcar a data e hora de entrada no menu.
                    METODOS.WritePERMANENTE(DATA, "*****************************");
                    METODOS.WritePERMANENTE(DATA, "MENU: 1- Iniciar venda");
                    METODOS.WritePERMANENTE(DATA, METODOS.DATA(DATA));
                    METODOS.WritePERMANENTE(DATA, "*****************************");
                    System.out.println("*****************************");
                    System.out.println("MENU: 1- Iniciar venda");
                    System.out.println("*****************************");
                    System.out.println("1- Inserir item");
                    System.out.println("2- Remover item");
                    System.out.println("3- Voltar");
                    System.out.print("Informe uma das opções:");
                    menu2 = teclado.nextInt();
                    //Chamando o método 
                    MENU1_1(menu1, menu2);
                }
            }
            if (menu1 == 2) {
                while (menu3 != 3) {
                    //Metodo para marcar a data e hora de entrada no menu.
                    METODOS.WritePERMANENTE(DATA, "*****************************");
                    METODOS.WritePERMANENTE(DATA, "MENU: 2- Finalizar venda");
                    METODOS.WritePERMANENTE(DATA, METODOS.DATA(DATA));
                    METODOS.WritePERMANENTE(DATA, "*****************************");
                    System.out.println("*****************************");
                    System.out.println("MENU: 2- Finalizar venda");
                    System.out.println("*****************************");
                    System.out.println("1- Lista de produtos");
                    System.out.println("2- Total de vendas");
                    System.out.println("3- Voltar");
                    System.out.print("Informe uma das opções:");
                    menu3 = teclado.nextInt();
                    //Chamando o método.
                    MENU1_2(menu1, menu3);
                }
            }

            if (menu1 == 3) {
                while (menu4 != 2) {
                    //Metodo para marcar a data e hora de entrada no menu.
                    METODOS.WritePERMANENTE(DATA, "*****************************");
                    METODOS.WritePERMANENTE(DATA, "MENU: 3- Resulmo geral do dia");
                    METODOS.WritePERMANENTE(DATA, METODOS.DATA(DATA));
                    METODOS.WritePERMANENTE(DATA, "*****************************");
                    System.out.println("*****************************");
                    System.out.println("MENU: 3- Resulmo geral do dia");
                    System.out.println("*****************************");
                    System.out.println("1- Lista de vendas do dia");
                    System.out.println("2- Voltar");
                    System.out.print("Informe uma das opções:");
                    menu4 = teclado.nextInt();
                    //Chamando o método.
                    MENU1_3(menu1, menu4);
                }
            }
            if (menu1 == 4) {
                while (menu5 != 4) {
                    //Metodo para marcar a data e hora de entrada no menu.
                    METODOS.WritePERMANENTE(DATA, "*****************************");
                    METODOS.WritePERMANENTE(DATA, "MENU: 4- Lista de produtos");
                    METODOS.WritePERMANENTE(DATA, METODOS.DATA(DATA));
                    METODOS.WritePERMANENTE(DATA, "*****************************");
                    System.out.println("*****************************");
                    System.out.println("MENU: 4- Lista de produtos");
                    System.out.println("*****************************");
                    System.out.println("1- Listar produtos");
                    System.out.println("2- Inserir item e valor");
                    System.out.println("3- Remover item");
                    System.out.println("4- Voltar");
                    System.out.print("Informe uma das opções:");
                    menu5 = teclado.nextInt();
                    //Chamando o método.
                    MENU1_4(menu1, menu5);
                }
            }
        }
        System.out.println("*******************************************");
        System.out.println("Obrigado(a) pela preferência e volte sempre");
        System.out.println("*******************************************");
        //Metodo para marcar a data e hora de saída do programa.
        METODOS.WritePERMANENTE(DATA, "*****************************");
        METODOS.WritePERMANENTE(DATA, "SAÍDA DO PROGRAMA");
        METODOS.WritePERMANENTE(DATA, METODOS.DATA(DATA));
        METODOS.WritePERMANENTE(DATA, "*****************************");

    }
}
