import java.util.*;
public class Ponto implements Comparable<Ponto>{
    int X;
    int Y;
    int conflitos;
    int posicao;
    TreeSet<Ponto> lista_de_conflitos;
    LinkedList<Ponto> lista_de_conflitos_nao_ordenado;
    HashMap<Ponto, Integer> tipo_de_conflito;
    Ponto(){
        lista_de_conflitos = new TreeSet<Ponto>();
    }
    Ponto(int X, int Y){
        this.X = X;
        this.Y = Y;
        lista_de_conflitos = new TreeSet<Ponto>();
        lista_de_conflitos_nao_ordenado = new LinkedList<Ponto>();
        tipo_de_conflito = new HashMap<Ponto,Integer>();
    }

    public String toString(){
        return "(" + X + "," + Y + ")";
    }

    @Override
    public int compareTo(Ponto p){
        if(conflitos < p.conflitos) return -1;
        else return 1;
    }
    
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Ponto n = (Ponto) o;
        return (n.X == X && n.Y == Y);
    }

}

//javac Ponto.java