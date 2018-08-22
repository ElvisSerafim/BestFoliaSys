
package br.uefs.ecomp.bfs.model;

import java.util.Objects;

//Classe Foliao.
public class Foliao {

    private String cpf;
    private String rg;
    private String nome;
    private int idade;
    private Transporte transporte;

    //Construtor da classe Foliao.
    public Foliao(String cpf, String rg, String nome, int idade) {
        this.cpf = cpf;
        this.rg = rg;
        this.nome = nome;
        this.idade = idade;
        this.transporte = transporte;

    }

    //Getters Setters e o equals da classe.
    public Transporte getTransporte() {
        return transporte;
    }

    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
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
        final Foliao other = (Foliao) obj;
        if (this.idade != other.idade) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.rg, other.rg)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

}
