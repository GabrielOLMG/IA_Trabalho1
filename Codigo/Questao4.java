import java.util.*;
public class Questao4 extends Questao3{

    public void hill_Climbing(char f, Ponto[] atual ){ 
        int tentativas = 0; 
        //System.out.println("Orignal: " + Arrays.toString(atual)); 
        while(true){
            Ponto[] Vizinho = proximo(atual,f); 
            if((f != 'a' && f != 'b' && Qconflitos(Vizinho) >= Qconflitos(atual)) || 
               ((f == 'a' || f == 'b') && Perimetro(Vizinho) >= Perimetro(atual))){ 
                if(Qconflitos(atual) == 0){
                    System.out.println("Estado Final: " + Arrays.toString(atual)); 
                    System.out.println(tentativas);
                    arquivo.escreveCoordenada(Vizinho);
                    System.out.println("Fim");
                    return;
                }else{
                    List<Ponto> list = Arrays.asList(atual);
                    LinkedList<Ponto> linkedList = new LinkedList<Ponto>(list);
                    linkedList = criaPermutacoes(new LinkedList<Ponto>(), linkedList);
                    atual = linkedList.toArray(new Ponto[linkedList.size()]);
                }
            }else System.arraycopy(Vizinho, 0, atual, 0, atual.length);
            if(tentativas > 5000){ 
                System.out.println("----Fim das Tentativas----");
                System.out.println("Estado Final: " + Arrays.toString(atual)); 
                arquivo.escreveCoordenada(Vizinho);
                return;
            }
            tentativas++;
        }
    }

    public int Perimetro(Ponto[]Array){
        int perimetro = 0;
        for(int i = 0 ; i < Array.length - 1; i++){
            perimetro +=  distancia(Array[i].X, Array[i].Y, Array[i+1].X, Array[i+1].Y);
        }
        perimetro +=  distancia(Array[Array.length-1].X, Array[Array.length-1].Y, Array[0].X, Array[0].Y); 
        return perimetro;
    }

    public int Qconflitos(Ponto[] atual){
        int N = atual.length; 
        int n = 0; 
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
        NearestNeighbourFirst(a);
        candidatoArray = candidato.toArray(new Ponto[candidato.size()]);
        hill_Climbing(f,candidatoArray); 
        
    }

}
