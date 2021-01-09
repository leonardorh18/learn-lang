# learn-lang
Linguagem de programação learn

## declaracao de variavel

para de declarar uma variavel double:
numero = 0
ou
numero = 1+1

ou

numero = 4+4

Só aceita uma operação 

## condicao SE (IF)
se: numero > 0

  numero = 0
  
fimse

é preciso ter o fimse e só aceita uma condição por vez

## laço PARA (for)
para: i = 0; i < 10; i = i + 1

 -codigo-
 
fimpara

é preciso ter o fim para e nao aceita looping dentro de looping

## saidas (print)
mostrarln: Ola tudo bem?  (desta forma tera um \n no final)

mostrar: Ola tudo bem? (desta forma nao tera um \n no final)

 Mostrar variaveis:
 
nome = Leonardo

mostrarln: nome

mostrar: nome

as variaveis devem ser mostradas em um "mostar" separado com somente elas

## EXEMPLO 1
numero = 0

para: i = 0; i < 20; i = i + 1

    numero = i%2

    se: numero == 0

        mostrar: i

        mostrarln: eh par!!

    fimse

    se: numero != 0

        mostrar: i

        mostrarln: eh impar!!

    fimse


fimpara

mostrarln: acabou!!

## EXEMPLO 2

qtd = 0

mostrarln: Digite quantos numeros quer digitar 

ler: qtd 

v = 0

aux = 0

count = 0

para: i = 0; i < qtd; i = i + 1

    mostrarln: Digite um valor

    ler: aux

    v = v + aux

    count = count + 1

fimpara

mostrar: A media final eh 

res = v / count

mostrarln: res

## EXEMPLO 3
leitura1 = 0

leitura2 = 0

mostrarln: Digite o primeiro numero

ler: leitura1 

mostrarln: Digite o segundo numero

ler: leitura2

v = leitura2 + leitura1 

v = v/2

mostrarln: a media eh 

mostrar: v