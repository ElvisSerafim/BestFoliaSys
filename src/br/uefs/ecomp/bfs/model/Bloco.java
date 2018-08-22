
package br.uefs.ecomp.bfs.model;
import br.uefs.ecomp.bfs.util.ListaEncadeada;
import java.util.Objects;

//Classe Bloco.
public class Bloco {

    private int id;
    private String nome;
    private String local;
    private int saida;
    private ListaEncadeada listaTransporte;

    //Construtor da classe Bloco.
    public Bloco(String nome, String local, int saida) {
        this.id = id;
        this.nome = nome;
        this.local = local;
        this.saida = saida;
        this.listaTransporte = new ListaEncadeada();
    }

    //Getters e Setters e o equals da classe.
    public ListaEncadeada getListaTransporte() {
        return listaTransporte;
    }

    public void setListaTransporte(ListaEncadeada listaTransporte) {
        this.listaTransporte = listaTransporte;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getSaida() {
        return saida;
    }

    public void setSaida(int saida) {
        this.saida = saida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Bloco other = (Bloco) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.saida != other.saida) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.local, other.local)) {
            return false;
        }
        return true;
    }

}
