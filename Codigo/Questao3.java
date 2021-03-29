import java.util.TreeSet;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner; 
public class Questao3 extends Questao2{
    
    /**
     * Produto interno entre os pontos
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return
     */
    static public int prod_int(int x1,int y1, int x2, int y2){
        return (x1*y2 - x2*y1);
    }
    
    /**
     * Função retirada do slide compartilhado pela professora para verificar se  2 retas se cruzam
     * @param p1
     * @param p2
     * @param p3
     * @param p4
     * @return
     */
    public boolean SegmentsInt(Ponto p1,Ponto p2,Ponto p3,Ponto p4){
        int d123 = prod_int((p3.X-p1.X),(p3.Y-p1.Y), (p2.X-p1.X), (p2.Y-p1.Y));
        int d124 = prod_int((p4.X-p1.X),(p4.Y-p1.Y), (p2.X-p1.X), (p2.Y-p1.Y));
        int d341 = prod_int((p1.X-p3.X),(p1.Y-p3.Y), (p4.X-p3.X), (p4.Y-p3.Y));
        int d342 = prod_int((p2.X-p3.X),(p2.Y-p3.Y), (p4.X-p3.X), (p4.Y-p3.Y));
        
        if((d123 * d124 < 0) && (d341 * d342 < 0)) return true;
        else if( (d123 == 0) && InBox(p1,p2,p3)) return true;
        else if( (d124 == 0) && InBox(p1,p2,p4)) return true;
        else if( (d341 == 0) && InBox(p3,p4,p1)) return true;
        else if( (d342 == 0) && InBox(p3,p4,p2)) return true;
        else return false;
    }
    
    /**
     * Função retirada do slide compartilhado pela professora para verificar se  2 retas se cruzam
     * @param p1
     * @param p2
     * @param p3
     * @param p4
     * @return
     */
    public boolean InBox (Ponto p1,Ponto p2,Ponto p3) {
        return ((Math.min(p1.X, p2.X)<= p3.X) && (p3.X<= Math.max(p1.X, p2.X))) && ((Math.min(p1.Y, p2.Y) <= p3.Y) && (p3.Y <= Math.max(p1.Y, p2.Y)));
    }

    /**
     * Faz a troca dos pontos em um array que é representado pelo cainho feito entre as retas 
     * @param p1 ponto1
     * @param p2 ponto2 
     * @param candidato array contendo os pontos na ordem
     */
    public void exchange(int p1, int p2, Ponto[] candidato){
        Ponto aux = new Ponto(candidato[p2].X,candidato[p2].Y);
        aux.conflitos = candidato[p2].conflitos;
        aux.posicao = p1;
        aux.lista_de_conflitos = new TreeSet<Ponto>(candidato[p2].lista_de_conflitos);
        aux.lista_de_conflitos_nao_ordenado= new LinkedList<Ponto>(candidato[p2].lista_de_conflitos_nao_ordenado);
        
        candidato[p2] = candidato[p1];
        candidato[p2].posicao = p2;

        candidato[p1] = aux;
        
    }

    
    public int  localiza_cruzamentos(int P ,int N, Ponto[] candidato){
        candidato[P].lista_de_conflitos.clear();
        candidato[P].lista_de_conflitos_nao_ordenado.clear();
        int count = 0;
        int vizinhoO;
        int vizinhoA;
        int analise;

        if(P == N-1){
            analise = 1;
            vizinhoO = 0;
        }else if(P == N-2){
            analise =  0;
            vizinhoO = P+1;
        }else{
            analise = P+2;
            vizinhoO = P+1;
        }

        for(int i = 0 ; i < N-3 ; i++){
            if(analise == N-1) vizinhoA = 0;
            else vizinhoA = analise+1;
            if(SegmentsInt(candidato[P],candidato[vizinhoO],candidato[analise],candidato[vizinhoA])){
                count++;
                candidato[P].lista_de_conflitos.add(candidato[analise]);
                candidato[P].lista_de_conflitos_nao_ordenado.add(candidato[analise]);
            }
            analise++;
            if(analise >= N) analise = 0;
        }
        candidato[P].conflitos = count;
        return count;
    }

    public int  quantidade_cruzamentos(int P ,int N, Ponto[] candidato){
        int count = 0;
        int vizinhoO;
        int vizinhoA;
        int analise;

        if(P == N-1){
            analise = 1;
            vizinhoO = 0;
        }else if(P == N-2){
            analise =  0;
            vizinhoO = P+1;
        }else{
            analise = P+2;
            vizinhoO = P+1;
        }

        for(int i = 0 ; i < N-3 ; i++){
            if(analise == N-1) vizinhoA = 0;
            else vizinhoA = analise+1;
            if(SegmentsInt(candidato[P],candidato[vizinhoO],candidato[analise],candidato[vizinhoA])){
                count++;
            }
            analise++;
            if(analise >= N) analise = 0;
        }
        candidato[P].conflitos = count;
        return count;
    }


    public Ponto[] perimetroConflito(LinkedList<Ponto> todosConflitos, Ponto[] arrayPontos){
        int posicaoPontoP = -1;
        int posicaoPontoP2 = -1;
        for (Ponto p : todosConflitos){
            LinkedList<Ponto> conflitosP = p.lista_de_conflitos_nao_ordenado;
            Ponto pxP;
            if(p.posicao == arrayPontos.length - 1) pxP = arrayPontos[0];
            else pxP = arrayPontos[p.posicao+1];
            int minPerimetro = 1000;
            for(Ponto p2 : conflitosP){
                Ponto pxP2;
                if(p2.posicao == arrayPontos.length - 1) pxP2 = arrayPontos[0];
                else pxP2 = arrayPontos[p2.posicao+1];
                int somaDist = (distancia(p.X, p.Y, p2.X, p2.Y) + distancia(pxP.X, pxP.Y, pxP2.X, pxP2.Y)) - ( distancia(p.X, p.Y, pxP.X, pxP.Y) + distancia(p2.X, p2.Y, pxP2.X, pxP2.Y));

                if(somaDist < minPerimetro){
                    minPerimetro = somaDist;
                    posicaoPontoP = p.posicao;
                    posicaoPontoP2 = p2.posicao;
                } 
            }
        }
        if(posicaoPontoP == -1 || posicaoPontoP2 == -1) System.out.println("ERRO NO PERIMETRO");
        int posicaoDoConflito = posicaoPontoP2; 
        if(posicaoPontoP == arrayPontos.length - 1){
            exchange(0, posicaoDoConflito, arrayPontos);
        }else exchange(posicaoPontoP + 1, posicaoDoConflito, arrayPontos);
        return arrayPontos;

    }

    /**
     * Gera o vizinho para o grafico atual
     * @param atual grafico
     * @param flag representa a letra da questão
     * @return vizinho
     */
    public Ponto[] proximo(Ponto[] atual, char flag){
        Ponto[] atualCopia = new Ponto[atual.length];
        System.arraycopy(atual, 0, atualCopia, 0, atual.length);
        int menor = 1000000; // qtt d conflitos do menor ponto
        int menorPonto = -1; // posicao do ponto
        int N = atualCopia.length;
        int n = 0; //local da origem
        LinkedList<Integer> pontosComConflitos = new LinkedList<Integer>();
        LinkedList<Ponto> pontosComConflitosObjetos = new LinkedList<Ponto>();
        for(int i = 0 ; i < N ; i++){
            int count = localiza_cruzamentos(n,N, atualCopia);
            if(flag == 'b' && count > 0){
                menor = count;
                menorPonto = n;
                break;
            }
            if(count < menor && count > 0){
                menor = count;
                menorPonto = n;
            }
            if(count > 0){ // se tiver conflito, então coloca n lista
                pontosComConflitos.add(n);
                pontosComConflitosObjetos.add(atualCopia[n]);
            }
            n++;
        }

        

        if(menorPonto == -1){
            System.out.println("igual");
            return atualCopia;
        }
        
        if(flag == 'a') return perimetroConflito(pontosComConflitosObjetos,atualCopia);

        int posicaoDoConflito = atualCopia[menorPonto].lista_de_conflitos.pollFirst().posicao;
        if(flag == 'd'){
            menorPonto = pontosComConflitos.get(rand(pontosComConflitos.size()-1,0));
            int conflitoAleatorio = rand(atualCopia[menorPonto].lista_de_conflitos_nao_ordenado.size()-1,0);
            posicaoDoConflito = atualCopia[menorPonto].lista_de_conflitos_nao_ordenado.get(conflitoAleatorio).posicao;
        }

        if(menorPonto == N-1){
            exchange(0, posicaoDoConflito, atualCopia);
        }else exchange(menorPonto+1, posicaoDoConflito, atualCopia);
        return atualCopia;
        
    }

    public Boolean pontosColineares(Ponto[] pontos){
        for(int i=0; i<pontos.length; i++){
            for(int j=0; j<i; j++){
                for(int k=j+1; k<i; k++){
                    if(((pontos[j].X)*(pontos[k].Y) + (pontos[k].X)*(pontos[i].X)+(pontos[k].Y)*(pontos[i].Y)-(pontos[k].Y)*(pontos[i].X)-(pontos[j].X)*(pontos[i].Y)-(pontos[k].Y)*(pontos[k].X))==0){
                         return true; 
                        }
                    }
            }
          }
          return false;
    }

    public void q3(Scanner in) {
        int N = in.nextInt();       
        LinkedList<Ponto> a = le_pontos(in,N);
        NearestNeighbourFirst(a); //Caminho formado
        candidatoArray = candidato.toArray(new Ponto[candidato.size()]);
        System.out.println("Antes: " + Arrays.toString(candidatoArray));
        Ponto[] px = proximo(candidatoArray, 'c');
        System.out.println("Depois: " + Arrays.toString(px));
    }
}
