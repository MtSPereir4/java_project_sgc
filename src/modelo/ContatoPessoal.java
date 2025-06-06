//  Definindo o pacote
package modelo ;

public class ContatoPessoal extends Contato {
    //  Determinando as propriedades da sub-classe ContatoPessoal.
    private String dataAniversario ;
    private String endereco ;

    //  Criando o construtor para a subclasse ContatoPessoal
    public ContatoPessoal(String parNome, String parEmail, String parTelefone, String parDataAniversario, String parEndereco) {
        //  Alimentando as propriedas herdadas da classe pai
        super(parNome, parEmail, parTelefone) ;
        //  Alimentanto as propriedas da subclasse
        dataAniversario = parDataAniversario ;
        endereco = parEndereco ;
    }

    // Getters
    public String getDataAniversario() {return dataAniversario ;}
    public String getEndereco() {return endereco;}
    
    // Setters
    public void setDataAniversario(String parDataAniversario) {dataAniversario = parDataAniversario;}
    public void setEndereco(String parEndereco) {endereco = parEndereco;}

    //  Complementando o método exibir info para incluir campos da classe ContatoPessoal
    @Override
    public void exibirInfo() {
        //  Mantendo o comportamento da superclasse
        super.exibirInfo();
        //  Adicionando novos campos
        System.out.println("\033[1;32mData de aniversário: " + dataAniversario + "\033[0m");
        System.out.println("\033[1;32mEndereço: " + endereco + "\033[0m");
    }

}