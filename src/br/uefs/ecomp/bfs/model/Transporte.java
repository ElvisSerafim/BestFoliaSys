
package br.uefs.ecomp.bfs.model;

import br.uefs.ecomp.bfs.util.ListaEncadeada;
import java.util.Objects;

// Classe Transporte.
public class Transporte {

    private int id;
    private String nome;
    private String tipo;
    private double valor;
    private int capacidade;
    private int saida;
    private String localSaida;
    private int retorno;
    private String localRetorno;
    private int chegada;
    private String localChegada;
    private Bloco bloco;
    private ListaEncadeada listafolioes;

    //Construtor da classe Transporte.
    public Transporte(String nome, String tipo, double valor, int capacidade, int saida, String localSaida, int retorno, String localRetorno, int chegada, String localChegada, Bloco bloco) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
        this.capacidade = capacidade;
        this.saida = saida;
        this.localSaida = localSaida;
        this.retorno = retorno;
        this.localRetorno = localRetorno;
        this.chegada = chegada;
        this.localChegada = localChegada;
        this.bloco = bloco;
        this.listafolioes = new ListaEncadeada();
    }

    //Getters e Setters e equals ds classe.
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getSaida() {
        return saida;
    }

    public void setSaida(int saida) {
        this.saida = saida;
    }

    public String getLocalSaida() {
        return localSaida;
    }

    public void setLocalSaida(String localSaida) {
        this.localSaida = localSaida;
    }

    public int getRetorno() {
        return retorno;
    }

    public void setRetorno(int retorno) {
        this.retorno = retorno;
    }

    public String getLocalRetorno() {
        return localRetorno;
    }

    public void setLocalRetorno(String localRetorno) {
        this.localRetorno = localRetorno;
    }

    public int getChegada() {
        return chegada;
    }

    public void setChegada(int chegada) {
        this.chegada = chegada;
    }

    public String getLocalChegada() {
        return localChegada;
    }

    public void setLocalChegada(String localChegada) {
        this.localChegada = localChegada;
    }

    public Bloco getBloco() {
        return bloco;
    }

    public void setBloco(Bloco bloco) {
        this.bloco = bloco;
    }

    public ListaEncadeada getListafolioes() {
        return listafolioes;
    }

    public void setListafolioes(ListaEncadeada listafolioes) {
        this.listafolioes = listafolioes;
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
        final Transporte other = (Transporte) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.valor) != Double.doubleToLongBits(other.valor)) {
            return false;
        }
        if (this.capacidade != other.capacidade) {
            return false;
        }
        if (this.saida != other.saida) {
            return false;
        }
        if (this.retorno != other.retorno) {
            return false;
        }
        if (this.chegada != other.chegada) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.localSaida, other.localSaida)) {
            return false;
        }
        if (!Objects.equals(this.localRetorno, other.localRetorno)) {
            return false;
        }
        if (!Objects.equals(this.localChegada, other.localChegada)) {
            return false;
        }
        if (!Objects.equals(this.bloco, other.bloco)) {
            return false;
        }
        return true;
    }

}
