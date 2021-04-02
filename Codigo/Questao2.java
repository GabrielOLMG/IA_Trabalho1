import java.util.*;
public class Questao2 extends Questao1{
    LinkedList<Ponto> candidato = new LinkedList<Ponto>(); 
    Ponto[] candidatoArray; 

    public void q2(Scanner in,char flag, boolean aleatorio){
        LinkedList<Ponto> a; 
        LinkedList<Ponto> permutacao; 
        if(!aleatorio){
            int N = in.nextInt();       
            a = le_pontos(in,N);
        }else{
            a = q1(in);
        }
        
        if(flag == 'a'){
            permutacao = criaPermutacoes(new LinkedList<Ponto>(),a);
            candidatoArray = permutacao.toArray(new Ponto[permutacao.size()]);
        }else{
            NearestNeighbourFirst(a); 
            candidatoArray = candidato.toArray(new Ponto[candidato.size()]);
        }
        System.out.println(Arrays.toString(candidatoArray));
        arquivo.escreveCoordenada(candidatoArray); 
    }

    public LinkedList<Ponto> le_pontos(Scanner in,int N){
        LinkedList<Ponto> pontos = new LinkedList<Ponto>();
        for(int i = 0 ; i < N ; i++){ 
            pontos.add(new Ponto(in.nextInt(),in.nextInt()));
        }
        return pontos;
    }
    
    public LinkedList<Ponto> criaPermutacoes(LinkedList<Ponto> lista, LinkedList<Ponto> vetor){
        while(true){
            if(vetor.size() == 1){ 
                lista.add(vetor.removeFirst());
                return lista;
            }
            int n = rand(vetor.size()-1, 0); 
            lista.add(vetor.remove(n));
        }
    }

    public int distancia(int x1, int y1, int x2, int y2){ 
        return (int)(Math.pow((x1-x2),2) + Math.pow((y1-y2),2)); 
    }

    public Ponto proximoPonto(Ponto origem, LinkedList<Ponto> lista){ 
        int menor = 1000000000; 
        int n = 0; 
        for(int i = 0 ; i < lista.size() ; i++){
            int distanciaP = distancia(origem.X,origem.Y, lista.get(i).X, lista.get(i).Y); 
            if(distanciaP < menor){ 
                menor = distanciaP;
                n = i; 
            }
        }
        return lista.remove(n);
    }

    private void NearestNeighbourFirst(Ponto origem, LinkedList<Ponto> lista){
        if(lista.size()  == 0 ) return; 
        Ponto px = proximoPonto(origem, lista); 
        candidato.add(px); 
        px.posicao = candidato.size()-1; 
        NearestNeighbourFirst(px, lista); 
    }

    public void NearestNeighbourFirst(LinkedList<Ponto> lista){ 
        int posicao = rand(lista.size()-1, 0); 
        Ponto origem = lista.remove(posicao); 
        candidato.add(origem); 
        origem.posicao = 0;
        NearestNeighbourFirst(origem, lista);
    }
    
}
