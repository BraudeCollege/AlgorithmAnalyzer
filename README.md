Aplicativo criado para a matéria Análise Algoritmos da Universidade Federal do ABC.
Gera relatório por tempo para cada tipo de algoritmo de ordenação estudado, são eles:

MergeSort
SelectionSort
InsertionSort
BubbleSort
HeapSort
QuickSort

Há também a possibilidade de salvar o relatório gerado e alterar configurações para rodar o algoritmo, 
por exemplo o tamanho do vetor a ser organizado e sua ordenação inicial (aleatória, crescente, decrescente).

DESCRIÇÃO DOS ALGORITMOS

2.1 – BubbleSort
A ordenação por bolha é a ordenação menos complexa para implementação, porém só é 
recomendada para pequenos valores de ordenação, uma vez que ela possui a 
complexidade da ordem de O(n²) aumentando muito o tempo de ordenação para grandes 
vetores. Seu funcionamento se baseia em verificar cada valor do vetor afim de verificar 
se ele é o menor e assim ordená-lo de forma correta.

2.2 – MergeSort
O MergeSort se basei no conceito de divisão de problemas, ou seja, a cada interação no 
momento de ordenação o algoritmo quebra o problema em 2, e assim por diante. Este algoritmo 
tem complexidade da ordem de O(nlogn) ou seja, extremamente rápido, portanto é um dos algoritmos 
recomendados para grandes valores de n.

2.3 – InsertionSort
A ordenação por inserção acontece similarmente como a ordenação por bolha, onde o algoritmo 
verifica se um determinado valor é menor que todos os outros e o alinha mais a esquerda. 
Este algoritmo possui complexidade da ordem de O(n²).

2.4 – HeapSort
O HeapSort é outra variação de algoritmos que utilizam o conceito de divisão de trabalho 
para concluir um projeto maior. Para ordenar o heap cria uma estrutura de dados que ao ir 
inserindo também vai organizando, o tornando extremanente rápido. Ele possui uma complexidade 
da ordem de O(nlogn).

2.5 – QuickSort
Este algoritmo é um dos mais rápidos e eficientes, e também se baseia no conceito de divisão 
para conquistar. A estratégia básica deste algoritmo é a ordenação por chave, montando um 
vetor com o tamanho menor. Este algoritmo possui complexidade da ordem de O(nlogn).

2.6 – SelectionSort
O SelectionSort faz parte dos algoritmos de ordenação da ordem de O(n²) e é muito lento para 
grandes vetores, porém possui uma fácil implementação assim como o BubbleSort. Sua ordenação 
consiste em sempre passar o menor valor do vetor para a primeira posição e assim sucessivamente.
