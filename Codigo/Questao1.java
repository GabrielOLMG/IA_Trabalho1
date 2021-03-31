import java.util.Scanner;
import java.util.Random;
import java.util.LinkedList;
import java.util.Arrays;

public class Questao1 {
    Random r = new Random();
    Arquivo arquivo = new Arquivo();
    /**
     * Gera valores aleatorios entre o intervalo minimo e maximo
     * @param max Valor superior do intervalo
     * @param min Valor inferior do intervalo
     * @return Valor randomizao
     */
    public int rand(int max, int min){
        return r.nextInt((max-min) + 1) + min;//[min,max]
    }

    /**
     * Gerar aleatoriamente N pontos no plano com coordenadas inteiras, de −M a M, para N e M dados
     */
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
        System.out.println(Arrays.toString(arrayP));
        arquivo.escreveCoordenada(arrayP);
        return array;
    }
}
