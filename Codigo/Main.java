import java.util.*;
class Main {
    public static void main(String[] args){
        long start;
        long end;
        start = System.currentTimeMillis();
        Questao1 q_1 = new Questao1();
        Questao2 q_2 = new Questao2();
        Questao3 q_3 = new Questao3();
        Questao4 q_4 = new Questao4();
        Questao5 q_5 = new Questao5();
        Scanner in = new Scanner(System.in);
        int alt = in.nextInt();
        boolean aleatorio;
        if(alt == 1) aleatorio = true;
        else aleatorio = false;
        int N_questao = in.nextInt();
        String letra;
        switch(N_questao){
            case 1:
                q_1.q1(in);
                break;
            case 2:
                letra = in.next();
                q_2.q2(in,letra.charAt(0),aleatorio);
                break;
            case 3:
                q_3.q3(in, aleatorio);
                break;
            case 4:
                letra = in.next();
                q_4.q4(in,letra.charAt(0), aleatorio);
                break;
            case 5:
                letra = "a";
                q_5.q5(in,letra.charAt(0), aleatorio);
                break;
        }
        end = System.currentTimeMillis();
        System.out.println(end-start); 
    }   
}