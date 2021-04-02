import java.util.*;
public class Ponto implements Comparable<Ponto>{
    int X; // posicao x
    int Y; // posicao Y
    int conflitos; // quantidade de conflitos
    int posicao; // posicao no array candidato
    TreeSet<Ponto> lista_de_conflitos; // lista ordenada pela quantidade de conflitos
    LinkedList<Ponto> lista_de_conflitos_nao_ordenado; // lista nao ordenada contendo todos os conflitos com o ponto 

    Ponto(){
        lista_de_conflitos = new TreeSet<Ponto>(); // inicia a lista de conflitos ordenada
    }

    Ponto(int X, int Y){
        this.X = X; // inicia a posicao x
        this.Y = Y; // inicia a posicao y
        lista_de_conflitos = new TreeSet<Ponto>(); // inicia a lista de conflitos ordenada
        lista_de_conflitos_nao_ordenado = new LinkedList<Ponto>(); // inicia a lista de conflitos nao ordenada
    }

    public String toString(){
        return "(" + X + "," + Y + ")"; // forma que iremos representar um ponto ao imprimir a classe ponto
    }

    @Override
    public int compareTo(Ponto p){ //forma que iremos ordenar os pontos, dando prioridade aos pontos com menos conflitos
        if(conflitos < p.conflitos) return -1; 
        else return 1;
    }
    
    @Override
    public boolean equals(Object o){
        if(this == o) return true; // verifica se é o mesmo objeto
        if(o == null || getClass() != o.getClass()) return false; // verifica se estamos comparando com um objeto nulo ou se tem classe diferentes
        Ponto n = (Ponto) o; // definimos o como um ponto
        return (n.X == X && n.Y == Y); // retorna true se for exatamente o mesmo ponto e false se tiver algum ponto diferente
    }
}
