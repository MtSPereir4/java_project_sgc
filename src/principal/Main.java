//  Definindo o pacote
package principal ;

//  Importando biblioteca e pacotes
import java.util.Scanner ;
import controle.Agenda;
// import modelo.Contato;
import modelo.ContatoPessoal;
import modelo.ContatoProfissional;


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
            agendaDeContatos.menu();
            
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
                System.out.println("\n\033[1;31mEntrada Inválida. Digite apenas números inteiros.\033[0m") ;
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
                        System.out.println("\n\033[1;31mEntrada Inválida. Digite apenas números inteiros.\033[0m") ;
                        continue ;
                    }
                        
                    //  Tratando a entrada para erro de opção inválida
                    if (opcaoTipoContato != 1 && opcaoTipoContato != 2) {
                        System.out.println("\n\033[1;31mEntrada Inválida. Tente novamente.\033[0m") ;
                    }
                    //  Adicionando um contato
                    else {
                        //  Declarando variáveis para armazenarem os valores referentes as propriedades da classe Contato
                        String inputNome;
                        String inputEmail;
                        String inputTelefone;

                        //  Recebendo valores referentes as propriedades de Contato
                        System.out.print("\033[1;33mNome: \033[0m");
                        inputNome = input.nextLine() ;
                        System.out.print("\033[1;33mEmail: \033[0m");
                        inputEmail = input.nextLine() ;
                        System.out.print("\033[1;33mTelefone: \033[0m");
                        inputTelefone = input.nextLine() ;

                        //  Adição de ContatoPessoal
                        if (opcaoTipoContato == 1) {
                            //  Declarando variáveis para armazenarem os valores referentes as propriedades da classe ContatoPessoal
                            String inputDataAniversario;
                            String inputEndereco;

                            //  Recebendo valores referentes as propriedades de ContatoPessoal
                            System.out.print("\033[1;33mData de Aniversário: \033[0m");
                            inputDataAniversario = input.nextLine() ;
                            System.out.print("\033[1;33mEndereço: \033[0m");
                            inputEndereco = input.nextLine() ;

                            //  Adicionando contato
                            agendaDeContatos.adicionarContato(new ContatoPessoal(inputNome, inputEmail, inputTelefone, inputDataAniversario, inputEndereco)) ;
                            break;
                        }
                        //  Adição de ContatoProfissional
                        else if (opcaoTipoContato == 2) {
                            //  Declarando variáveis para armazenarem os valores referentes as propriedades da classe ContatoProfissional
                            String inputEmpresa;
                            String inputCargo;

                            //  Recebendo valores referentes as propriedades de ContatoPessoal
                            System.out.print("\033[1;33mEmpresa: \033[0m");
                            inputEmpresa = input.nextLine() ;
                            System.out.print("\033[1;33mCargo: \033[0m");
                            inputCargo = input.nextLine() ;
                            
                            //  Adicionando um objeto ContatoProfissioal na lista de contatos
                            agendaDeContatos.adicionarContato(new ContatoProfissional(inputNome, inputEmail, inputTelefone, inputEmpresa, inputCargo));
                            break;
                        }
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
                    int idRemocao ;

                    //  Validação do id informado para remoçao do contato
                    while (true) {
                        //  Interção com o usuário
                        System.out.print("\n\033[1;33mID do contato a ser removido: \033[0m");
                        entrada = input.nextLine() ;
                        
                        //  Validando o tipo da entrada
                        try {
                            //  Tenta realizar a conversão de String para int
                            idRemocao = Integer.parseInt(entrada) ;
                            break;
                        }
                        //  Falha na conversão
                        catch (NumberFormatException x) {
                            System.out.println("\n\033[1;31mEntrada Inválida. Digite apenas números inteiros.\033[0m") ;
                            continue ;
                        }
                    }
                    // Chamando o métedo para remover o contato
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
                            System.out.println("\n\033[1;31mEntrada Inválida. Digite apenas números inteiros.\033[0m") ;
                            continue ;
                        }

                        //  Valindando a opção de busca
                        if (opcaoBusca != 1 && opcaoBusca != 2 && opcaoBusca != 3) {
                            System.out.println("\n\033[1;31mEntrada Inválida. Tente novamente.\033[0m") ;
                        }
                        //  Opção de busca válida
                        else {
                            //  Variavel que receberá o valor a ser buscado
                            String parBusca ;

                            //  Busca por nome
                            if (opcaoBusca == 1) {
                                //  Interação com o usuário
                                System.out.print("\n\033[1;37mInforme o nome: \033[0m");
                                parBusca = input.nextLine() ;
                            }
                            //  Busca por Telefone
                            else if (opcaoBusca == 2) {
                                //  Interação com o usuário
                                System.out.print("\n\033[1;37mInforme o telefone: \033[0m");
                                parBusca = input.nextLine();
                            }
                            //  Busca por email
                            else {
                                //  Interação com o usuário
                                System.out.print("\n\033[1;37mInforme o email: \033[0m");
                                parBusca = input.nextLine() ;
                            }
                            //  Buscando contatos
                            agendaDeContatos.buscarContatos(opcaoBusca, parBusca);
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
                            System.out.println("\n\033[1;31mEntrada Inválida. Digite apenas números inteiros.\033[0m") ;
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


//  javac -d bin src\modelo\*.java src\controle\Agenda.java src\principal\Main.java
//  java principal.Main