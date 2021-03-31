----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Intruções Gerais:
    ->Para a questão 1 usamos apenas o input N e M, logo é um arquivo txt diferente, o dominio_input.txt.
    ->Para executar as questões 2,3 e 4 deve-se ir no arquivo pontos_input.txt e mudar para a questão desejada (Explicado na próxima sessão e no arquivo).
    ->As questões 2 e 4 foram feitas de forma que dê para plotar o gráfico, então por isso temos que usar o python ao compilar.
    ->Atualmente só foram feitos os exercícios: 1, 2, 3, 4b e 4c.

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Explicando Cada Arquivo txt:
    ->pontos_input.txt
        <>Recebe um inteiro 0 ou 1, que ira definir se sera ATIVADO PONTOS ALEATORIOS OU NÃO
        <>Recebe o número da questão na segunda linha. (Só serve para as questões 2,3 e 4).
        <>Recebe a letra da questão na terceira linha.  (Se a questão não tiver letra, então esta linha pode ser apagada).
        <>Recebe N quantidades de pontos na quarta linha.
        <>Caso 1(Modo aleatorio ATIVADO)
            <>Recebe um inteiro M na quinta linha, que ira definir o dominio dos pontos aleatorios
        <>Caso 0(Modo aleatorio DESATIVADO)
            <>Recebe N pontos nas N linhas seguintes no formato: X Y

    ->py_input.txt
        <>Recebe o número de pontos na primeira linha. (Obs: neste arquivo é acrescentado o ponto inicial novamente no final do arquivo para que seja criado a ligação entre o início e o fim, por isso tem N+1 pontos).
        <>Recebe N pontos nas N linhas seguintes no formato: X Y

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Compilação:
    ->Questão 1: javac Main.java && java Main < dominio_input.txt 
    ->Questão 2: javac Main.java && java Main < pontos_input.txt  && py plot.py < py_input.txt
    ->Questão 3: javac Main.java && java Main < pontos_input.txt  && py plot.py < py_input.txt
    ->Questão 4: javac Main.java && java Main < pontos_input.txt  && py plot.py < py_input.txt
    ->Questão 5: javac Main.java && java Main < pontos_input.txt  && py plot.py < py_input.txt
    
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------