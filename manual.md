# learn-lang
Linguagem de programação learn

# COMO EXECUTAR
para executar bastar compilar os arquivos e exercutas da seguinte forma

java Main nomedoarquivo (sem o .learn)

se meu arquivo se chama teste.learn

java Main teste



## declaracao de variavel

# para  declarar uma variavel double:
numero = 0

ou

numero = 1+1

ou

num = 1

numero = 4 + num

ou 

num = 0-3 (para variaveis negativas)

num = 0-6 (input sera de -6)

num = 0-3045 (input sera de -3045)

Só aceita uma operação 


# para  declarar uma variavel string:
nome =Leonardo (desse jeito ele considera "Leonardo")

nome = Leonardo (desse jeito ele considera " Leonardo", note o espaço antes do L)

---- exemplo ----

sobrenome = rocha

nome = leonardo

nomecompleto = nome + sobrenome

mostrarln: nomecompleto 

(saida vai ser: leonardo rocha)

só é possivel somar strings declaradas


## leitura 
para ler dados usa-se o comando ler:

numero = 0

mostrarln: digite um numero

ler: numero

## condicao SE (IF)
numero = 4

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

mostrar: Ola tudo bem? (desta forma NAO tera um \n no final)

#Mostrar variaveis:
 
nome = Leonardo

mostrarln: nome

mostrar: nome

as variaveis devem ser mostradas em um "mostar" separado com somente elas

## EXEMPLO 1
# Par e impar
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
# media a partir da quantidade de numeros digitados

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
# media simples

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

# EXEMPLOS EXTRAS:
## 1

numero = 0

qntd = 0 

mostrarln: Digite ate que numero quer saber pares e impares

ler: qntd

para: i = 1; i <= qntd; i = i + 1

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

## 2

num = 10

para: i = 0; i <= num; i = i +1

mostrarln: i 

fimpara

## 3

a = 1 + 1

b = 3 + a

mostrar: Valor de A 

mostrarln: a 

mostrar: Valor de B 

mostrarln: b

## 4 

i = 0
j = i 

para: i = 0; i < 3; i = i + 1

    se: i == 0

        mostrarln: Eh zero!!

    fimse 

    se: i != 0 

        mostrarln: Eh diferente de 0!!

    fimse 

    fimpara 

se: i == 3

    se: j == 0:

        mostrarln: OK!!

    fimse 

    se: j != 0

        mostrarln: Erro!!

    fimse 

fimse
 ## 5
nome =Leonardo

acerta = x

para: i = 0; nome != acerta; i = i +1

    mostrarln: Digite o nome para acertar 

    ler: acerta

    se: nome == acerta

        mostrarln: Acertou!!!

    fimse
    
fimpara

## 6

sobrenome = rocha

nome = leonardo

nome = nome + sobrenome

mostrarln: nome

## 7 

mostrarln: Digite o numero da tabuada

ler: num

mostrarln: Tabuada ate que quanto?

ler: quanto

res = 0

para: i = 0; i <= quanto; i = i +1

    res = num * i 

    mostrar: num

    mostrar: x 

    mostrar: i 

    mostrar: eh igual a 

    mostrarln: res 
    
fimpara

## 8 exemplo da tabuada 1 ate 11


num1 = 1 
 

para: i = 1; i <= 11; i = i + 1
    res = num1 * i
    mostrar: num1 
    mostrar: x 
    mostrar: i
    mostrar: =  
    mostrarln: res

    aux = aux + 1

    se: aux == 10
        aux = 0
        se: num1 <= 10
            num1 = num1 + 1
            i = 0
            mostrarln:  
        fimse
        
    fimse

fimpara