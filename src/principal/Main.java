//  Definindo o pacote
package principal ;

//  Importando biblioteca e pacotes
import java.util.Scanner ;
import controle.Agenda;

public class Main {
    public static void main(String[] args) {
        //  Criando o objeto para acessar os métodos de Agenda
        Agenda agendaDeContatos = new Agenda() ;
        //  Criando o objeto para receber valores do usuário
        Scanner input = new Scanner(System.in) ;

        //  Variável que armazena a entrada afim de valida-la
        String entrada ;
        //  variável que representa a opção escolhida pelo usuário
         int opcao;
        
         //  Looping de execução do programa
        while (true) {
            //  Exibindo o menu de opções
            System.out.println("\n\033[1;37mMenu de Opções:\033[0m\n") ;
            System.out.println("\033[1;33m0 - Encerrar o Programa\n1 - Adicionar Contato\n2 - Excluir Contato\n3 - Buscar Contato\n4 - Listar Contatos\033[0m\n") ;
            
            //  Interação com o susuário
            System.out.print("\033[1;37mInforme a opção desejada: \033[0m") ;
            entrada = input.nextLine() ;
            
            //  Validando o tipo da entrada
            try {
                //  Tenta realizar a conversão de String para int
                 opcao = Integer.parseInt(entrada) ;
            }
            //  Falha na conversão
            catch (NumberFormatException x) {
                System.out.println("\n\033[1;31mEntrada Inválida. Digite apenas números inteiro.\033[0m") ;
                continue ;
            }

            //  Opção encerrar programa
            if (opcao == 0) {
                System.out.println("\n\033[1;33mPrograma encerrado.\033[0m\n"); 
                //  Fechando o objeto input
                input.close() ;
                break ;
                }


            //  Opção adicionar contatos
            else if (opcao == 1) {
                //  Looping para o tratamento da entrada do tipo de contato a ser adicionado
                while(true) {
                    //  Variável que representa o tipo de contato escolhido pelo usuário
                    int opcaoTipoContato ;
                    
                    //  Exibindo o menu de tipos de contatos
                    System.out.println("\n\033[1;33m1 - Contato Pessoal\n2 - Contato Profissional\033[0m\n");
                    
                    //  Interação com o usuário
                    System.out.print("\033[1;37mInforme o tipo de contato: \033[0m");
                    entrada = input.nextLine() ;
                    
                    //  Validando o tipo da entrada
                    try {
                        opcaoTipoContato = Integer.parseInt(entrada) ;
                    }
                    //  Falha na conversão
                    catch (NumberFormatException x) {
                        System.out.println("\n\033[1;31mEntrada Inválida. Digite apenas números inteiro.\033[0m") ;
                        continue ;
                    }
                        
                    //  Tratando a entrada para erro de opção inválida
                    if (opcaoTipoContato != 1 && opcaoTipoContato != 2) {
                        System.out.println("\n\033[1;31mEntrada Inválida. Tente novamente.\033[0m") ;
                    }
                    //  Adicionando um contato
                    else {
                        agendaDeContatos.adicionarContato(opcaoTipoContato, input) ;
                        //  Saíndo do looping da adição de contatos
                        break ;
                    }
                }   //  Fim do looping de tratamento de entrada para adição de contato
            }   //  Fim do bloco adição de contatos


            //  Opção remover contatos
            else if (opcao == 2) {   
                //  Tratando o caso de lista vazia
                if (agendaDeContatos.agendaIsEmpty()) {
                    System.out.println("\n\033[1;31mLista vazia\033[0m");
                }
                //  Lista não vazia
                else {
                    //  Variável que armazena o id do contato a ser removido
                    String idRemocao ;
            
                    //  Interção com o usuário
                    System.out.print("\n\033[1;33mID do contato a ser removido: \033[0m");
                    idRemocao = input.nextLine() ;
                    
                    //  Chamando o métedo para remover o contato
                    agendaDeContatos.removerContatos(idRemocao) ;
                }
            }   //  Fim do bloco remover contatos


            //  Opção buscar contatos
            else if (opcao == 3) {
                //  Tratando o caso de lista vazia
                if (agendaDeContatos.agendaIsEmpty()) {
                    System.out.println("\n\033[1;31mLista vazia\033[0m");
                }
                //  Lista não vazia
                else {
                    //  Variável que representa a opção de busca de contatos
                    int opcaoBusca ;

                    //  Looping para o tratamento do tipo da entrada
                    while (true) {
                        //  Exibindo as opções de busca
                        System.out.println("\n\033[1;33m1 - Nome\n2 - Telefone\n3 - E-mail\033[0m");

                        //  Intereação com o usuário
                        System.out.print("\n\033[1;37mInforme a opção de busca: \033[0m");
                        entrada = input.nextLine() ;

                        //  Validando o tipo da entrada
                        try {
                            opcaoBusca = Integer.parseInt(entrada) ;
                        }
                        catch (NumberFormatException x) {
                            System.out.println("\n\033[1;31mEntrada Inválida. Digite apenas números inteiro.\033[0m") ;
                            continue ;
                        }

                        //  Valindando a opção de busca
                        if (opcaoBusca != 1 && opcaoBusca != 2 && opcaoBusca != 3) {
                            System.out.println("\n\033[1;31mEntrada Inválida. Tente novamente.\033[0m") ;
                        }
                        //  Opção de busca válida
                        else {
                            //  Buscando contatos
                            agendaDeContatos.buscarContatos(opcaoBusca, input) ;
                            break ;
                        }
                    }
                }
            }   //  Fim do bloco buscar contatos


            //  Opção listar contatos
            else if (opcao == 4) {
                //  Tratando o caso de lista vazia
                if (agendaDeContatos.agendaIsEmpty()) {
                    System.out.println("\n\033[1;31mLista vazia\033[0m");
                }
                //  Lista não vazia
                else {
                    //  Variável que representa a opção de listagem de contatos
                    int opcaoListagem;

                    //  Looping para o tratamento do tipo da entrada
                    while(true) {
                        //  Exibindo opções de listagem
                        System.out.println("\n\033[1;33m1 - Contatos Pessoais\n2 - Contatos Profissionais\n3 - Todos os Contatos\033[0m\n");

                        //  Interação com o usuário
                        System.out.print("\033[1;37mInforme a opção de listagem: \033[0m");
                        entrada = input.nextLine() ;

                        //  Validando o tipo da entrada
                        try {
                            opcaoListagem = Integer.parseInt(entrada) ;
                        }
                        catch (NumberFormatException x) {
                            System.out.println("\n\033[1;31mEntrada Inválida. Digite apenas números inteiro.\033[0m") ;
                            continue ;
                        }

                        //  Valindando a opção de listagem
                        if (opcaoListagem != 1 && opcaoListagem != 2 && opcaoListagem != 3) {
                            System.out.println("\n\033[1;31mEntrada Inválida. Tente novamente.\033[0m") ;
                        }
                        else {
                            //  Listando os contatos
                            agendaDeContatos.listarContatos(opcaoListagem) ;
                            break ;
                        }
                    }
                }
            }   //  Fim do bloco listagem de contatos


            //  Opção tipo inteiro mas inválida
            else {
                System.out.println("\n\033[1;31mEntrada Inválida. Tente novamente.\033[0m") ;
            }
        }   //  Fim do programa
    }   //  Fim da função main
}   //  Fim da classe Main
