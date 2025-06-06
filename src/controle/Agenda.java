//  Definindo o pacote
package controle ;

//  Importando biblioteca e pacotes
import java.util.ArrayList;
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

    //  Variável que armazena o id dos contatos adiconados
    int inputId = 0;
    
    //  Definição da função para adicionar contatos
    public void adicionarContato(Contato novoContato) {        
        novoContato.setId(++inputId);
        //  Adicionando um objeto ContatoPessoal na lista de contatos
        listaDeContatos.add(novoContato) ;
    }   //  Fim do método adicionarContatos


    //  Função para removar contatos
    public void removerContatos(int parIdRemocao) {
        //  Variável que armazena o index do contato a ser removido
        int index = -1;
        
        //  Encontrando o índice do objeto a ser removido
        for (Contato c : listaDeContatos) {
            //  Comparando IDs
            if (c.getId() == parIdRemocao) {
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
    public void buscarContatos(int parOpcaoBusca, String parBusca) {
        //  Variável que armazena um valor booleano representando uma busca bem sucessidada ou não
        boolean flagErro = true ;
        
        if (parOpcaoBusca == 1) {
            //  Busca por nome
            for (Contato c : listaDeContatos) {
                if (c.getNome().equals(parBusca)) {
                    flagErro = false ;
                    c.exibirInfo();
                }
            }
        }   //  Fim do bloco busca por nome

        else if (parOpcaoBusca == 2) {
            //  Busca por telefone
            for (Contato c : listaDeContatos) {
                if (c.getTelefone().equals(parBusca)) {
                    flagErro = false ;
                    c.exibirInfo();
                }
            }
        }   //  Fim do bloco busca por telefone

        //  Busca por email
        else if (parOpcaoBusca == 3) {
            //  Busca por E-mail
            for (Contato c : listaDeContatos) {
                if (c.getEmail().equals(parBusca)) {
                    flagErro = false ;
                    c.exibirInfo();
                }
            }
        }   //  Fim do bloco busco por email
        //  Mensagem para o caso de contato não encontrado
        if (flagErro) {
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
            boolean pesFlagErro = true ;
            //  Variável que representa se existem ou não contatos profissionais na lista
            boolean proFlagErro = true ;

            //  Exibindo lista de contatos pessoais
            if (parOpcao == 1) {
                System.out.println("\n\033[1;33mLista de Contatos Pessoais:\033[0m");
                
                for (Contato c : listaDeContatos) {
                    if (c instanceof ContatoPessoal) {
                        //  Reatribuição da flag caso exista contatos pessoais na lista
                        pesFlagErro = false ;
                        //  Exibindo os valores das propriedades referentes a classe Contato
                        c.exibirInfo();
                    }
                }
                //  Tratando o caso que não há contatos pessoais na lista
                if (pesFlagErro) {
                    System.out.println("\n\033[1;31mNão há Contatos Pessoais na lista\033");
                }
            }   //  Fim do bloco listar contatos pessoais

            //  Exibindo lista de contatos profissionais
            else if (parOpcao == 2) {
                System.out.println("\n\033[1;33mLista de Contatos Profissionais:\033[0m");

                for (Contato c : listaDeContatos) {
                    if (c instanceof ContatoProfissional) {
                        //  Reatribuição da flag caso exista contatos profissionais na lista
                        proFlagErro = false ;
                        //  Exibindo os valores das propriedades referentes a classe Contato
                        c.exibirInfo();
                    }
                }
                //  Tratando o caso que não há contatos pessoais na lista
                if (proFlagErro) {
                    System.out.println("\n\033[1;31mNão há Contatos Profissinais na lista\033");
                }
            }   //  Fim do bloco listar contatos profissionais

            else {
                System.out.println("\n\033[1;33mLista de todos os contatos:\033[0m");
                //  Exibindo lista de todos os contatos
                for (Contato c : listaDeContatos) {
                    c.exibirInfo();
                    //  Formatação
                    System.out.println("");
                }
            }   //  Fim do bloco listar todos os contatos
        }
    }   //  Fim do método listarContatos

    //  Função para verificar se a lista está vazia
    public boolean agendaIsEmpty(){
        return listaDeContatos.isEmpty() ;
    }

    //  Função para exibir o menu de opções
    public void menu() {
        System.out.println("\n\033[1;37mMenu de Opções:\033[0m\n") ;
        System.out.println("\033[1;33m0 - Encerrar o Programa\n1 - Adicionar Contato\n2 - Excluir Contato\n3 - Buscar Contato\n4 - Listar Contatos\033[0m\n") ;
    }
}
