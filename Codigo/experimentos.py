import pandas as pd
import matplotlib.pyplot as plt
import numpy as np

dados = pd.read_csv('dados.csv')
media = []
X = ['a', 'b', 'c', 'd']
Y = []
for i in X:
    exp = dados.loc[dados['letra'] == i]
    y = np.array(exp[' interacoes'])
    Y.append(np.mean(y))

plt.bar(X,Y)
plt.xlabel('Metodo de escolha do vizinho') 
plt.ylabel('Media das interações') 
plt.title("Comparação entre os diferentes metodos de escolha do proximo")
plt.show()
