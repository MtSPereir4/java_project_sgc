//  Definindo o pacote
package modelo ;

public class Contato {
    //  Determinando as propriedades da classe Contato
    private String id ;
    private String nome ;
    private String email ;
    private String telefone ;

    //  Cirando um construtor para a classe contato
    public Contato(String inputId, String inputNome, String inputEmail, String inputTelefone) {
        //  Alimentando as propriedades da classe Contato
        id = inputId ;
        nome = inputNome ;
        email = inputEmail ;
        telefone = inputTelefone ;
    }

    // getters
    public String getId() {
        return id ;
    }
    public String getNome() {
        return nome;
    }
    public String getEmail() {
        return email;
    }
    public String getTelefone() {
        return telefone;
    }
    
    // Setters
    public void setId(String parId) {
        id = parId;
    }
    public void setNome(String parNome) {
        nome = parNome;
    }
    public void setEmail(String parEmail) {
        email = parEmail;
    }
    public void setTelefone(String parTelefone) {
        telefone = parTelefone;
    }


}
