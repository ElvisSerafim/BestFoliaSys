
package br.uefs.ecomp.bfs.util;

// Classe ListaEncadeada que implementa os métodos da interface ILista
public class ListaEncadeada implements ILista {

    private Celula first;
    
    //Construtor da classe ListaEncadeada.
    public ListaEncadeada() {
        this.first = null;
    }

    // Metodo boolean que verifica se a cabeça da lista é nula.
    public boolean estaVazia() {
        if (tamanho() == 0) {
            return true;
        } else {
            return false;
        }
    }

    // Metodo para obter o tamanho da lista;
    public int tamanho() {
        int tamanho = 0;
        for (Celula celula = first; celula != null; celula = celula.getProx()) {
            tamanho++;
        }
        return tamanho;
    }

    // Metodo para inserir no inicio da lista(Cabeça).
    public void insereInicio(Object object) {
        if (tamanho() == 0) {
            first = new Celula(object);
        } else {
            Celula celula = first;
            first = new Celula(object);
            first.setObject(object);
            first.setProx(celula);
        }
    }

    // Metodo para inserir no final da lista(Rabo);
    public void insereFinal(Object object) {
        if (tamanho() == 0) {
            first = new Celula(object);
            first.setObject(object);
        } else {
            Celula celula2 = first;
            int total = tamanho();
            for (int i = 0; i < total - 1; i++) {
                celula2 = celula2.getProx();
            }

            celula2.setProx(new Celula(object));
            celula2.getProx().setObject(object);
        }
    }

    // Método para remover objeto do inicio da lista.
    public Object removeInicio() {
        if (tamanho() == 0) {
            return null;
        } else {
            Celula celula = first;
            first = first.getProx();
            return celula.getObject();
        }
    }

    // Método para remover objecto do final da lista.
    public Object removeUltimo() {
        if (tamanho() == 1) {
            return removeInicio();
        } else {
            Celula celula = first;
            Celula celula2 = celula;

            while (celula.getProx() != null) {
                celula2 = celula;
                celula = celula.getProx();
            }
            Celula celula3 = celula2;
            Object object = celula.getObject();
            celula3.setProx(null);
            return object;
        }
    }

    // Método para pegar o objeto de uma posição da lista.
    public Object recupera(int index) {
        if (index >= 0 && index < tamanho()) {
            Celula celula = first;
            for (int i = 0; i < index; i++) {
                celula = celula.getProx();
            }
            return celula.getObject();
        }
        return null;
    }

    // Método que cria um novo iterador.
    public IteradorClass iterador() {
        
        Iterador iterador = new IteradorClass();
        return (IteradorClass) iterador;
    }

    // Classe IteradorClass que implementa a interface Iterador.
    public class IteradorClass implements Iterador {

        private Celula celula;
        
        // Construtor da classe IteradorClasse
        public IteradorClass() {
            this.celula = first;
        }
        
        // Método que determina se existem mais elementos para serem iterados.
        public boolean temProximo() {
            if (celula != null) {
                return true;
            } else {
                return false;
            }
        }
        
        // Método que retorna o próximo objeto da iteração.
        public Object proximo() {
            Object dado = celula.getObject(); // Object dado recebe o dado da celula.
            celula = celula.getProx(); // A celula vai ser igual próxima celula.
            return dado; // retorna o dado
        }

    }

    // Classe Celula
    public class Celula {

        private Celula prox;
        private Object object;

        //Construtor da classe Celula.
        public Celula(Object object) {
            this.prox = null;
            this.object = object;
        }
        
        // Getters e setters dos atributos da classe Celula.
        public void setObject(Object object) {
            this.object = object;
        }

        public Celula getProx() {
            return prox;
        }

        public void setProx(Celula prox) {
            this.prox = prox;
        }

        public Object getObject() {
            return object;
        }

    }

}
