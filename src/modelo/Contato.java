//  Definindo o pacote
package modelo ;

public class Contato {
    //  Determinando as propriedades da classe Contato
    private int id;
    private String nome ;
    private String email ;
    private String telefone ;

    //  Cirando um construtor para a classe contato
    public Contato(String inputNome, String inputEmail, String inputTelefone) {
        //  Alimentando as propriedades da classe Contato
        nome = inputNome ;
        email = inputEmail ;
        telefone = inputTelefone ;
    }

    // getters
    public int getId() {return id ;}
    public String getNome() {return nome;}
    public String getEmail() {return email;}
    public String getTelefone() {return telefone;}
    
    // Setters
    public void setId(int parId) {id = parId;}
    public void setNome(String parNome) {nome = parNome;}
    public void setEmail(String parEmail) {email = parEmail;}
    public void setTelefone(String parTelefone) {telefone = parTelefone;}

    public void exibirInfo(){
        System.out.println("\033[1;32mID: " + id + "\033[0m");
        System.out.println("\033[1;32mNome: " + nome + "\033[0m");
        System.out.println("\033[1;32mEmail: " + email + "\033[0m");
        System.out.println("\033[1;32mTelefone: " + telefone + "\033[0m");
    }

}
