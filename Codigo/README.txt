----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Intruções Gerais:
    ->Para executar as questões 1,2,3 e 4 deve-se ir no arquivo pontos_input.txt e mudar para a questão desejada (Explicado na próxima sessão e no arquivo).
    ->As questões foram feitas de forma que dê para plotar o gráfico, então por isso temos que usar o python ao compilar.

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Explicando Cada Arquivo txt:
    ->pontos_input.txt
        <>Linha 1:  tem entrada “1” ou “0”.
            0: valores aleatórios não são ativados, ou seja, o gráfico deverá ser pré-definido. 
            1: valores aleatórios ativados, o gráfico será gerado pelo programa depois.
        <>Linha 2: tem valores de entrada “1”, “2”, “3”, “4” ou 5”. Cada valor representa o número da questão desejada.
        <>Linha 3: caso a linha 2 receba “2” ou “4”:
            Se a linha 2 for “2”: pode receber “a” ou “b” :
                ‘a’: usa uma permutação aleatória para iniciar as ligações do polígono.
                ‘b’: faz as ligações de acordo com o ponto mais próximo.
            Se a linha 2 for “4”: pode receber “a”, “b”, “c” ou ”d”.
                ‘a’: Faz o hill climbing com vizinho que reduz mais o perímetro.
                ‘b’: Faz o hill climbing com o primeiro candidato que reduz o perímetro.
                ‘c’: Faz o hill climbing com o candidato que tem menos conflito na aresta.
                ‘d’: Faz o hill climbing com qualquer candidato da vizinhança .
        <>Linha 4:
            Linha 1 - “1”: recebe o número total de pontos que serão criados .
            Linha 1 - “0”: recebe o número total de pontos que serão lidos .
        <>Linha 5: 
            Linha 1 - “1”: recebe o valor M que representa o intervalo [-M, M] onde os valores X e Y serão criados.
            Linha 1 – “0”:  recebe os N pares ordenados no formato “X Y” nas próximas N linhas.

    ->py_input.txt
        <>Não devera ser modificado, já que so serve de base para o codigo principal
        <>Recebe o número de pontos na primeira linha. (Obs: neste arquivo é acrescentado o ponto inicial novamente no final do arquivo para que seja criado a ligação entre o início e o fim, por isso tem N+1 pontos).
        <>Recebe N pontos nas N linhas seguintes no formato: X Y

    ->dados.csv
        <>Dados usados para fazer o teste final para decidir qual flag sera fixada na questão 5.
        <>Para usar uma das seed presente nesse arquivoé necessario alterado o codigo. Para fazer essa alteração basta ir no arquivo Questão1.java, linha 4, e alterar o valor dentro do "()" em Random r = new Random(140297167) para uma seed desejada. 
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Compilação:
    ->javac Main.java && java Main < pontos_input.txt  && py plot.py < py_input.txt
    
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------