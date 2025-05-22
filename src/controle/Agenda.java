//  Definindo o pacote
package controle ;

//  Importando biblioteca e pacotes
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Contato;
import modelo.ContatoPessoal;
import modelo.ContatoProfissional;

public class Agenda {
    //  Declarando um arraylist para armazenar os contatos
    private ArrayList<Contato> listaDeContatos ;
    
    //  Criando o construtor da classe
    public Agenda() {
        listaDeContatos = new ArrayList<>() ;
    }

    //  Definição da função para adicionar contatos
    public void adicionarContato(int parOpcaoContato, Scanner parInput) {        
        //  Declarando variáveis para armazenarem os valores referentes as propriedades da classe Contato
        String inputId;
        String inputNome;
        String inputEmail;
        String inputTelefone;
        boolean flag = true;
        
        //  Recebendo valores referentes as propriedades de Contato
        System.out.print("\n\033[1;33mID: \033[0m");
        inputId = parInput.nextLine() ;
        System.out.print("\033[1;33mNome: \033[0m");
        inputNome = parInput.nextLine() ;
        System.out.print("\033[1;33mEmail: \033[0m");
        inputEmail = parInput.nextLine() ;
        System.out.print("\033[1;33mTelefone: \033[0m");
        inputTelefone = parInput.nextLine() ;

        //  Tratando caso de contato já adicionado
        for (Contato c : listaDeContatos) {
            if (c.getId().equals(inputId)) {
                System.out.println("\n\033[1;31mErro. Contato repetido\033[0m");
                flag = false;
                return;
            }
        }

        //  Adição de ContatoPessoal
        if (parOpcaoContato == 1) {
            //  Declarando variáveis para armazenarem os valores referentes as propriedades da classe ContatoPessoal
            String inputDataAniversario;
            String inputEndereco;

            //  Recebendo valores referentes as propriedades de ContatoPessoal
            System.out.print("\033[1;33mData de Aniversário: \033[0m");
            inputDataAniversario = parInput.nextLine() ;
            System.out.print("\033[1;33mEndereço: \033[0m");
            inputEndereco = parInput.nextLine() ;
            
            //  Adicionando um objeto ContatoPessoal na lista de contatos
            listaDeContatos.add(new ContatoPessoal(inputId, inputNome, inputEmail, inputTelefone, inputDataAniversario, inputEndereco)) ;
        }
        //  Adição de ContatoProfissional
        else if (parOpcaoContato == 2) {
            //  Declarando variáveis para armazenarem os valores referentes as propriedades da classe ContatoProfissional
            String inputEmpresa;
            String inputCargo;

            //  Recebendo valores referentes as propriedades de ContatoPessoal
            System.out.print("\033[1;33mEmpresa: \033[0m");
            inputEmpresa = parInput.nextLine() ;
            System.out.print("\033[1;33mCargo: \033[0m");
            inputCargo = parInput.nextLine() ;
            
            //  Adicionando um objeto ContatoProfissioal na lista de contatos
            listaDeContatos.add(new ContatoProfissional(inputId, inputNome, inputEmail, inputTelefone, inputEmpresa, inputCargo)) ;
        }
        //  Exibindo mensagem caso contato adicionado bem sucessido
        if (flag) {
            System.out.println("\n\033[1;32mContato adicionado com sucesso\033[0m");
        }
    }   //  Fim do método adicionarContatos


    //  Função para removar contatos
    public void removerContatos(String parIdRemocao) {
        //  Variável que armazena o index do contato a ser removido
        int index = -1;
        
        //  Encontrando o índice do objeto a ser removido
        for (Contato c : listaDeContatos) {
            //  Comparando IDs
            if (c.getId().equals(parIdRemocao)) {
                index = listaDeContatos.indexOf(c) ;
                break ;
            }
        }
        //  Removendo um objeto ContatoPessoal da lista de contatos
        if (index != -1) {
            listaDeContatos.remove(index) ;
            System.out.println("\n\033[1;32mContato removido com sucesso\033[0m");
        }
        //  Tratando caso para contato não encontrado
        else {
            System.out.println("\n\033[1;31mObjeto não encontrado\033[0m\n");
        }
    }   //  Fim da função removerContato


    //  Função para buscar contatos
    public void buscarContatos(int parOpcaoBusca, Scanner parInput) {
        //  Variavel que receberá o valor a ser buscado
        String parBusca ;
        //  Variável que armazena um valor booleano representando uma busca bem sucessidada ou não
        boolean flag = false ;
        
        if (parOpcaoBusca == 1) {
            //  Interação com o usuário
            System.out.print("\n\033[1;37mInforme o nome: \033[0m");
            parBusca = parInput.nextLine() ;

            //  Busca por nome
            for (Contato c : listaDeContatos) {
                if (c.getNome().equals(parBusca)) {
                    flag = true ;
                    System.out.println("\n\033[1;32mID: " + c.getId() + "\033[0m");
                    System.out.println("\033[1;32mNome: " + c.getNome() + "\033[0m");
                    System.out.println("\033[1;32mE-mail: " + c.getEmail() + "\033[0m");
                    System.out.println("\033[1;32mTelefone: " + c.getTelefone() + "\033[0m");
                    if (c instanceof ContatoPessoal) {
                        ContatoPessoal cPes = (ContatoPessoal) c ;
                        System.out.println("\033[1;32mData de aniversário: " + cPes.getDataAniversario() + "\033[0m");
                        System.out.println("\033[1;32mEndereço: " + cPes.getEndereco() + "\033[0m");
                    }
                    else if (c instanceof ContatoProfissional) {
                        ContatoProfissional cPr = (ContatoProfissional) c ;
                        System.out.println("\033[1;32mEmpresa: " + cPr.getEmpresa() + "\033[0m");
                        System.out.println("\033[1;32mCargo: " + cPr.getCargo() + "\033[0m");
                    }
                }
            }
        }   //  Fim do bloco busca por nome

        else if (parOpcaoBusca == 2) {
            //  Interação com o usuário
            System.out.print("\n\033[1;37mInforme o telefone: \033[0m");
            parBusca = parInput.nextLine() ;
        
            //  Busca por telefone
            for (Contato c : listaDeContatos) {
                if (c.getTelefone().equals(parBusca)) {
                    flag = true ;
                    System.out.println("\n\033[1;32mID: " + c.getId() + "\033[0m");
                    System.out.println("\033[1;32mNome: " + c.getNome() + "\033[0m");
                    System.out.println("\033[1;32mE-mail: " + c.getEmail() + "\033[0m");
                    System.out.println("\033[1;32mTelefone: " + c.getTelefone() + "\033[0m");
                    if (c instanceof ContatoPessoal) {
                        ContatoPessoal cPes = (ContatoPessoal) c ;
                        System.out.println("\033[1;32mData de aniversário: " + cPes.getDataAniversario() + "\033[0m");
                        System.out.println("\033[1;32mEndereço: " + cPes.getEndereco() + "\033[0m");
                    }
                    else if (c instanceof ContatoProfissional) {
                        ContatoProfissional cPr = (ContatoProfissional) c ;
                        System.out.println("\033[1;32mEmpresa: " + cPr.getEmpresa() + "\033[0m");
                        System.out.println("\033[1;32mCargo: " + cPr.getCargo() + "\033[0m");
                    }
                }
            }
        }   //  Fim do bloco busca por telefone

        //  Busca por email
        else if (parOpcaoBusca == 3) {
            //  Interação com o usuário
            System.out.print("\n\033[1;37mInforme o e-mail: \033[0m");
            parBusca = parInput.nextLine() ;

            //  Busca por E-mail
            for (Contato c : listaDeContatos) {
                if (c.getEmail().equals(parBusca)) {
                    flag = true ;
                    System.out.println("\n\033[1;32mID: " + c.getId() + "\033[0m");
                    System.out.println("\033[1;32mNome: " + c.getNome() + "\033[0m");
                    System.out.println("\033[1;32mE-mail: " + c.getEmail() + "\033[0m");
                    System.out.println("\033[1;32mTelefone: " + c.getTelefone() + "\033[0m");
                    if (c instanceof ContatoPessoal) {
                        ContatoPessoal cPes = (ContatoPessoal) c ;
                        System.out.println("\033[1;32mData de aniversário: " + cPes.getDataAniversario() + "\033[0m");
                        System.out.println("\033[1;32mEndereço: " + cPes.getEndereco() + "\033[0m");
                    }
                    else if (c instanceof ContatoProfissional) {
                        ContatoProfissional cPr = (ContatoProfissional) c ;
                        System.out.println("\033[1;32mEmpresa: " + cPr.getEmpresa() + "\033[0m");
                        System.out.println("\033[1;32mCargo: " + cPr.getCargo() + "\033[0m");
                    }
                }
            }
        }   //  Fim do bloco busco por email
        //  Mensagem para o caso de contato não encontrado
        if (!flag) {
            System.out.println("\n\033[1;31mContato não encontrado\033") ;
        }
        
    }   //  Fim do método buscarContatos


    public void listarContatos(int parOpcao) {
        //  Tratando o caso de lista vazia
        if (listaDeContatos.isEmpty()) {
            System.out.println("\n\033[1;31mLista vazia\033[0m");
            return ;
        }
        //  Lista não vazia
        else {
            //  Variável que representa se existem ou não contatos pessoais na lista
            boolean pesFlag = false ;
            //  Variável que representa se existem ou não contatos profissionais na lista
            boolean proFlag = false ;

            //  Exibindo lista de contatos pessoais
            if (parOpcao == 1) {
                System.out.println("\n\033[1;33mLista de Contatos Pessoais:\033[0m");
                
                for (Contato c : listaDeContatos) {
                    if (c instanceof ContatoPessoal) {
                        //  Reatribuição da flag caso exista contatos pessoais na lista
                        pesFlag = true ;
                        //  Exibindo os valores das propriedades referentes a classe Contato
                        System.out.println("\n\033[1;32mID: " + c.getId() + "\033[0m");
                        System.out.println("\033[1;32mNome: " + c.getNome() + "\033[0m");
                        System.out.println("\033[1;32mE-mail: " + c.getEmail() + "\033[0m");
                        System.out.println("\033[1;32mTelefone: " + c.getTelefone() + "\033[0m");
                        //  Realizando o downcasting de Contato para ContatoPessoal
                        ContatoPessoal cPes = (ContatoPessoal) c ;
                        //  Exibindo os valores das propriedades referentes a classe ContatoPessoal
                        System.out.println("\033[1;32mData de aniversário: " + cPes.getDataAniversario() + "\033[0m");
                        System.out.println("\033[1;32mEndereço: " + cPes.getEndereco() + "\033[0m");
                    }
                }
                //  Tratando o caso que não há contatos pessoais na lista
                if (!pesFlag) {
                    System.out.println("\n\033[1;31mNão há Contatos Pessoais na lista\033");
                }
            }   //  Fim do bloco listar contatos pessoais

            //  Exibindo lista de contatos profissionais
            else if (parOpcao == 2) {
                System.out.println("\n\033[1;33mLista de Contatos Profissionais:\033[0m");

                for (Contato c : listaDeContatos) {
                    if (c instanceof ContatoProfissional) {
                        //  Reatribuição da flag caso exista contatos profissionais na lista
                        proFlag = true ;
                        //  Exibindo os valores das propriedades referentes a classe Contato
                        System.out.println("\n\033[1;32mID: " + c.getId() + "\033[0m");
                        System.out.println("\033[1;32mNome: " + c.getNome() + "\033[0m");
                        System.out.println("\033[1;32mE-mail: " + c.getEmail() + "\033[0m");
                        System.out.println("\033[1;32mTelefone: " + c.getTelefone() + "\033[0m");
                        //  Realizando o downcasting de Contato para ContatoProfissional
                        ContatoProfissional cPr = (ContatoProfissional) c ;
                        //  Exibindo os valores das propriedades referentes a classe ContatoProfissional
                        System.out.println("\033[1;32mEmpresa: " + cPr.getEmpresa() + "\033[0m");
                        System.out.println("\033[1;32mCargo: " + cPr.getCargo() + "\033[0m");
                    }
                }
                //  Tratando o caso que não há contatos pessoais na lista
                if (!proFlag) {
                    System.out.println("\n\033[1;31mNão há Contatos Profissinais na lista\033");
                }
            }   //  Fim do bloco listar contatos profissionais

            else {
                System.out.println("\n\033[1;33mLista de todos os contatos:\033[0m");
                //  Exibindo lista de todos os contatos
                for (Contato c : listaDeContatos) {
                    System.out.println("\n\033[1;32mID: " + c.getId() + "\033[0m");
                    System.out.println("\033[1;32mNome: " + c.getNome() + "\033[0m");
                    System.out.println("\033[1;32mE-mail: " + c.getEmail() + "\033[0m");
                    System.out.println("\033[1;32mTelefone: " + c.getTelefone() + "\033[0m");

                    if (c instanceof ContatoPessoal) {
                        ContatoPessoal cPes = (ContatoPessoal) c ;
                        System.out.println("\033[1;32mData de aniversário: " + cPes.getDataAniversario() + "\033[0m");
                        System.out.println("\033[1;32mEndereço: " + cPes.getEndereco() + "\033[0m");
                    }
                    else if (c instanceof ContatoProfissional) {
                        ContatoProfissional cPr = (ContatoProfissional) c ;
                        System.out.println("\033[1;32mEmpresa: " + cPr.getEmpresa() + "\033[0m");
                        System.out.println("\033[1;32mCargo: " + cPr.getCargo() + "\033[0m");
                    }
                }
            }   //  Fim do bloco listar todos os contatos
        }
    }   //  Fim do método listarContatos

    public boolean agendaIsEmpty(){
        return listaDeContatos.isEmpty() ;
    }
}
