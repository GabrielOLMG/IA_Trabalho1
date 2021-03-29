import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
public class Questao5 extends Questao4{


    public void simulated_annealing(char f, Ponto[] candidato ){ 
        Ponto[] atual = new Ponto[candidato.length];
        System.arraycopy(candidato, 0, atual, 0, candidato.length);
        double alfa = 0.99; // o quanto a temperatura vai ser diminuida por turno
        double T = 100; // temperatura inicial
        int i = 0;
        while(true){
            i++;
            if(T == 0){
                System.out.println("TEMP = 0");
                return;
            }
            Ponto[] Vizinho = proximo(atual,f);
            System.out.println("Atual: " + Arrays.toString(atual) + " Vizinho: " + Arrays.toString(Vizinho));
            System.out.println(Qconflitos(atual) + " " + Qconflitos(Vizinho) + "-----> " + T );
            if(Qconflitos(atual)==0){ //faz com q ele pare quando chega a um max d interações
                arquivo.escreveCoordenada(Vizinho);
                System.out.println("Fim " + i);
                return;
            }
            int varEnrg = Qconflitos(Vizinho) - Qconflitos(atual);
            if(varEnrg < 0)  System.arraycopy(Vizinho, 0, atual, 0, candidato.length);
            else{
                double p = Math.random(); //OBS:SEMPRE Q VAR=0 ELE ESTA ACEITANDO O VALOR VIZINHO, JA Q E^(-DELTA/T) = 1.
                if(p < Math.exp(-varEnrg/T)){ //vizinho teve mais conflitos, então vamos verificar se devemos considerar pegar ele ou n, usando probabilidade e^(-VariancaDoConflito/T)
                    System.arraycopy(Vizinho, 0, atual, 0, candidato.length);
                    System.out.println("So desta vez ein " + Math.exp(-varEnrg/T));
                }
            }
            if(i%20 == 0) T=T*alfa;
        }
    }

    public void q5(Scanner in,char f){
        boolean aleatorio = true;
        LinkedList<Ponto> a;
        if(!aleatorio){
            int N = in.nextInt();       
            a = le_pontos(in,N);
        }else{
            a = q1(in);
        }
        NearestNeighbourFirst(a); //Caminho formado
        candidatoArray = candidato.toArray(new Ponto[candidato.size()]);
        simulated_annealing(f,candidatoArray);
    }
}
