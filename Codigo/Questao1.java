import java.util.Scanner;
import java.util.Random;
import java.util.LinkedList;
public class Questao1 {
    Random r = new Random();
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
            array.add(new Ponto(x,y));
            //System.out.printf("(%d,%d)\n",x,y); //VERIFICAR SE O PONTO JA FOI CRIADO ANTES
        }
        return array;
    }
}
