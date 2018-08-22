/*******************************************************************************
Autor: Elvis Michael Souza Serafim
Componente Curricular: MI - Programação
Concluido em: 27/04/2018
Declaro que este código foi elaborado por mim de forma individual e não contém nenhum
trecho de código de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
******************************************************************************************/

package br.uefs.ecomp.bfs.facade;

import br.uefs.ecomp.bfs.model.Bloco; // importando a classe Bloco
import br.uefs.ecomp.bfs.model.Foliao; // importando a classe Foliao
import br.uefs.ecomp.bfs.model.Transporte; // importando a classe Transporte
import br.uefs.ecomp.bfs.util.Iterador; // importando a classe Iterador 
import br.uefs.ecomp.bfs.util.ListaEncadeada; // importando a classe ListaEncadeada

//Classe ControllerBFS.
public class ControllerBFS {

    // atributos referentes a lista encadeada de cada classe.
    public ListaEncadeada blocos;
    public ListaEncadeada folioes;
    public ListaEncadeada transportes;
    
    // atributos para gerar o id do transporte e do bloco.
    public int idTransporte;
    public int idBloco;

    // Construtor da classe ControllerBFS
    public ControllerBFS() {
        this.transportes = new ListaEncadeada();
        this.blocos = new ListaEncadeada();
        this.folioes = new ListaEncadeada();
        this.idTransporte = 0;
        this.idBloco = 0;
    }

    // método para cadastro de um bloco.
    public Bloco cadastrarBloco(String nome, String local, int saida) {
        // ação para verificar se bloco criado já existe na lista de blocos 
        Iterador iterador = blocos.iterador();
        while (iterador.temProximo()) {
            Bloco bloco2 = (Bloco) iterador.proximo();
            if (nome.equals(bloco2.getNome()) && local.equals(bloco2.getLocal()) && saida == bloco2.getSaida()) {
                return null; // se o bloco já existir, ele retorna null e não insere o bloco na lista.
            }
        }
        // Se não existir na lista, ele instancia um objeto bloco, o bloco criado recebe um id e é inserido no final da lista de blocos.
        Bloco bloco = new Bloco(nome, local, saida);
        bloco.setId(idBloco);
        idBloco++;
        blocos.insereFinal(bloco);
        return bloco; // retornando o bloco criado 
    }
   
    // método para obter o bloco através do seu atributo id.
    public Bloco obterBloco(int id) {
        Iterador iterador;
        iterador = (Iterador) blocos.iterador();
       
        // Usando o iterador, procura-se o bloco com o id passado. Se achar, retorna o bloco, senão retorna null. 
        while (iterador.temProximo()) {
            Bloco bloco = (Bloco) iterador.proximo();
            if (bloco.getId() == id) {
                return bloco;
            }
        }
        return null;

    }

    // Método para listar os blocos, usando os atributos 
    public Iterador listarBlocos(String local, int dataInicio, int dataFim) {
        ListaEncadeada listaBlocos = new ListaEncadeada();
        Iterador iterador2 = listaBlocos.iterador();
        Iterador iterador = (Iterador) transportes.iterador();

        while (iterador.temProximo()) {
            Transporte transporte = (Transporte) iterador.proximo();
            if ((local.equals(transporte.getLocalChegada()) && dataInicio == transporte.getSaida() && dataFim == transporte.getChegada())) {
                while (iterador2.temProximo()) {
                    Bloco bloco = (Bloco) iterador2.proximo();
                    if (bloco.getId() != transporte.getBloco().getId()) {
                        listaBlocos.insereFinal(transporte.getBloco());
                    }
                }
            }
        }
        return listaBlocos.iterador();
    }

    // Método para cadastro de um transporte.
    public Transporte cadastrarTransporte(String nome, String tipo, double valor, int capacidade, int saida, String localSaida, int retorno, String localRetorno, int chegada, String localChegada, Bloco bloco) {
        
        // Usando o iterador, percorre-se a lista de transporte para verficar se já existe um transporte com os mesmos valores.
        Iterador iterador = transportes.iterador();
        while (iterador.temProximo()) {
            Transporte transporte2 = (Transporte) iterador.proximo();
            // Se existir, retorna null.
            if (nome.equals(transporte2.getNome()) && (transporte2.getSaida() == saida)) {
                return null;
            }
        }
        
        // Se não existir, instancia um transporte. 
        Transporte transporte = new Transporte(nome, tipo, valor, capacidade, saida, localSaida, retorno, localRetorno, chegada, localChegada, bloco);
        transporte.setId(idTransporte);// O transporte recebe um id.
        idTransporte++; // O atributo é incrementado.
        transportes.insereFinal(transporte); // O transporte é inserido no final da lista de transportes.
        bloco.getListaTransporte().insereFinal(transporte); // E o transporte é inserido na lista de transportes do determinado bloco.
        return transporte;
    }

    // Método para procurar um transporte na lista usando o atributo id.
    public Transporte obterTransporte(int id) {
        Iterador iterador;
        iterador = (Iterador) transportes.iterador();
        
        // Usando o iterador, o método verifica se algum transporte da lista tem o mesmo id que o passado 
        // Se sim, retorna o transporte, senão, retorna null.
        while (iterador.temProximo()) {
            Transporte transporte = (Transporte) iterador.proximo();
            if (transporte.getId() == id) {
                return transporte;
            }
        }
        return null;
    }

     // Metodo retorna o metodo iterador contido na lista de foliões do transporte passado.
    public Iterador listarFolioes(Transporte transporte) {
        return transporte.getListafolioes().iterador();

    }

     // Metodo retorna o metodo iterador contido na lista de transportes do bloco passado.
    public Iterador listarTransportes(Bloco bloco) {
        return bloco.getListaTransporte().iterador();
    }

    // Método para cadastrar um folião.
    public Foliao cadastrarFoliao(String cpf, String rg, String nome, int idade) {

        // Usando o iterador, percorre-se a lista de foliões para verficar se já existe um folião com o mesmo cpf passado.
        Iterador iterador = folioes.iterador();
        while (iterador.temProximo()) {
            Foliao foliao2 = (Foliao) iterador.proximo();
            // Se existir um folião com o mesmo cpf, retorna null.
            if (cpf.equals(foliao2.getCpf())) {
                return null;
            }
        }
       
        // Se não existir, instancia um folião.
        Foliao foliao = new Foliao(cpf, rg, nome, idade);
        folioes.insereFinal(foliao); // insere o folião no final da lista de foliões.
        return foliao;
    }

    // Método para obter folião usando o cpf.
    public Foliao obterFoliao(String cpf) {
        
        // Usando o iterador, percorre a lista de foliões para verificar se tem um folião com o mesmo cpf passado.
        Iterador iterador = (Iterador) folioes.iterador();
        while (iterador.temProximo()) {
            Foliao foliao = (Foliao) iterador.proximo();
            
            // Se o cpf for igual, retorna o folião, senão retorna null.
            if (foliao.getCpf().equals(cpf)) {
                return foliao;
            }
        }
        return null;

    }

    // Método para registrar um folião em um transporte.
    public boolean registrarFoliaoEmTransporte(Foliao foliao, Transporte transporte) {
        
        int vagas;// Variavel para guardar a quantidade disponivel de vagas do transporte.
        
        // Usando o iterador, inicialmente se procura o transporte.
        Iterador iterador = (Iterador) transportes.iterador();
        while (iterador.temProximo()) {
            Transporte transporte2 = (Transporte) iterador.proximo();
            
            //Após encontrar, verifica se ainda tem vagas no transporte.
            if (transporte.equals(transporte2)) {
                
                // O valor da variavel vagas será igual ao tamanho da lista de transporte subtraido da capacidade do transporte. 
                vagas = transporte.getCapacidade() - transporte.getListafolioes().tamanho();
                
                // Se vagas for igual a 0, ou seja, não ter vagas dispóniveis, retorna false, pois não pode registrar o folião.
                if (vagas == 0) {
                    return false;
                } 
                
                // Se ainda tiver vagas..
                else {
                    
                    //Usa o iterador para percorrer a lista de foliões do transporte passado
                    // Para verificar se o folião já não está registrado naquele transporte.
                    Iterador iterador2 = (Iterador) transporte.getListafolioes().iterador();
                    while (iterador2.temProximo()) {
                        Foliao foliao2 = (Foliao) iterador2.proximo();
                        
                        // Se estiver na lista, retorna false, pois o folião já está registrado.
                        if (foliao2.getCpf().equals(foliao.getCpf())) {
                            return false;
                        }
                    }
                    
                    // Se não estiver na lista de foliões do transporte passado
                    // Insere o folião no final da lista de foliões do transporte.
                    transporte.getListafolioes().insereFinal(foliao);
                    foliao.setTransporte(transporte);// E seta que o transporte do folião
                    return true; // E retorna true, pois o registro foi realizado com sucesso.
                }
            }

        }
        return false;
    }
}
