import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.List;
public class Questao4 extends Questao3{
    /**
     * Aplica o alg hill_Climbing
     * @param candidato Configuração original
     * @param f flag para a questão. a,b,c,d.
     */
    public void hill_Climbing(char f, Ponto[] candidato ){ 
        Ponto[] atual = new Ponto[candidato.length];
        System.arraycopy(candidato, 0, atual, 0, candidato.length);
        int tentativas = 0;
        while(true){
            Ponto[] Vizinho = proximo(atual,f);
            System.out.println("Atual: " + Arrays.toString(atual) + " Vizinho: " + Arrays.toString(Vizinho));
            System.out.println(Qconflitos(atual) + " " + Qconflitos(Vizinho) );
            if(Qconflitos(Vizinho) >= Qconflitos(atual)){
                if(Qconflitos(atual) == 0 || tentativas >= 100){ //faz com q ele pare quando chega a um max d interações
                    arquivo.escreveCoordenada(Vizinho);
                    System.out.println("Fim");
                    return;
                }else{ // parte do reset
                    System.out.println("-----------------------------------");
                    List<Ponto> list = Arrays.asList(atual);
                    LinkedList<Ponto> linkedList = new LinkedList<Ponto>(list);
                    linkedList = criaPermutacoes(new LinkedList<Ponto>(), linkedList);
                    atual = linkedList.toArray(new Ponto[linkedList.size()]);
                    System.out.println("Reset");
                }
            }else{
                System.arraycopy(Vizinho, 0, atual, 0, candidato.length);
            }
        }
    }

    public int Qconflitos(Ponto[] atual){//so retorna quantidade d conflitos
        int N = atual.length;
        int n = 0; //local da origem
        int count = 0;
        for(int i = 0 ; i < N ; i++){
            count += quantidade_cruzamentos(n,N, atual);
            n++;
        }
        return count;
    }


    public void q4(Scanner in,char f,boolean aleatorio){
        LinkedList<Ponto> a;
        if(!aleatorio){
            int N = in.nextInt();       
            a = le_pontos(in,N);
        }else{
            a = q1(in);
        }
        NearestNeighbourFirst(a); //Caminho formado
        candidatoArray = candidato.toArray(new Ponto[candidato.size()]);
        hill_Climbing(f,candidatoArray);
    }

}
