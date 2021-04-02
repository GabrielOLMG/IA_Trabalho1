import java.util.*;
public class Questao5 extends Questao4{

    public void simulated_annealing(char f, Ponto[] candidato ){ 
        Ponto[] atual = new Ponto[candidato.length]; 
        System.arraycopy(candidato, 0, atual, 0, candidato.length); 
        double alfa = 0.99;
        double T = 100; 
        int i = 0; 
        System.out.println("Original: " + Arrays.toString(atual));
        while(true){
            i++;
            if(T == 0){ 
                System.out.println("TEMP = 0");
                return;
            }
            Ponto[] Vizinho = proximo(atual,f); 
            if(Qconflitos(atual)==0){ 
                arquivo.escreveCoordenada(Vizinho); 
                System.out.println("Estado Final: " + Arrays.toString(atual));
                return;
            }
            int varEnrg = Qconflitos(Vizinho) - Qconflitos(atual); 
            if(varEnrg < 0)  System.arraycopy(Vizinho, 0, atual, 0, candidato.length); 
            else{
                double p = Math.random(); 
                if(p < Math.exp(-varEnrg/T)){ 
                    System.arraycopy(Vizinho, 0, atual, 0, candidato.length); 
                }
            }
            if(i%20 == 0) T=T*alfa; 
            if(i > 5000){
                System.out.println("----Fim das Tentativas----");
                System.out.println("Estado Final: " + Arrays.toString(atual)); 
                arquivo.escreveCoordenada(Vizinho);
                return;
            }
        }
    }


    public void q5(Scanner in,char f, boolean aleatorio){
        LinkedList<Ponto> a;
        if(!aleatorio){
            int N = in.nextInt();      
            a = le_pontos(in,N); 
        }else{
            a = q1(in); 
        }
        NearestNeighbourFirst(a); 
        candidatoArray = candidato.toArray(new Ponto[candidato.size()]);
        simulated_annealing(f,candidatoArray); 
    }
}
