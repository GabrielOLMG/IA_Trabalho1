import java.util.*;

public class Questao1 {
    Random r = new Random(140297167); 
    Arquivo arquivo = new Arquivo(); 

    public int rand(int max, int min){ 
        return r.nextInt((max-min) + 1) + min;
    }

    public LinkedList<Ponto> q1(Scanner in){ 
        int N = in.nextInt();
        int M = in.nextInt();
        LinkedList<Ponto> array = new LinkedList<Ponto>();
        for(int i = 0 ; i < N ; i++){
            int x = rand(M,-M);
            int y = rand(M,-M);
            Ponto novo = new Ponto(x,y);
            if(array.contains(novo)) i--; 
            else array.add(novo);
        }
        Ponto[] arrayP = array.toArray(new Ponto[array.size()]); 
        arquivo.escreveCoordenada(arrayP); 
        return array;
    }
}
