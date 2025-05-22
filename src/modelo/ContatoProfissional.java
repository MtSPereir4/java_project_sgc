//  Definindo o pacote
package modelo ;

public class ContatoProfissional extends Contato{
    //  Determinando as propriedades da sub-classe ContatoProfissional.
    private String empresa ;
    private String cargo ;

    //  Criando o construtor para a subclasse ContatoProfissional
    public ContatoProfissional(String parId, String parNome, String parEmail, String parTelefone, String parEmpresa, String parCargo) {
        //  Alimentando as propriedas herdadas da classe pai
        super(parId, parNome, parEmail, parTelefone) ;
        //  Alimentanto as propriedas da subclasse
        empresa = parEmpresa ;
        cargo = parCargo ;
    }

    // Getters
    public String getEmpresa() {
        return empresa ;
    }
    public String getCargo() {
        return cargo;
    }
    
    // Setters
    public void setEmpresa(String parEmpresa) {
        empresa = parEmpresa;
    }
    public void setCargo(String parCargo) {
        cargo = parCargo;
    }
}