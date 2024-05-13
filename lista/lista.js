const fs = require('fs');
const readline = require('readline');

// Definindo a Classe para os Nós
class No {
    constructor(valor) {
        // variaveis com _ para não conflitar.
        this.valor_ = valor;
        this.proximo_ = null;
    }

    // Definindo os gets e sets

    get valor() {
        return this.valor_;
    }

    set valor(novoValor) {
        this.valor_ = novoValor;
    }

    get proximo() {
        return this.proximo_;
    }

    set proximo(novoProximo) {
        this.proximo_ = novoProximo;
    }
}

// Definindo a Classe para a Lista Ligada

class Lista {
    constructor() {
        this.cabeca = null;
    }

    // Metodo para inserir elementos no fim da lista

    inserirFim(valor) {
        let novoNo = new No(valor);
        if (this.cabeca === null) {
            this.cabeca = novoNo;
        } else {
            let atual = this.cabeca;
            while (atual.proximo !== null) {
                atual = atual.proximo;
            }
            atual.proximo = novoNo;
        }
    }

    // Metodo para inserir elementos no indice especificado

    inserirIndice(valor, indice) {
        let novoNo = new No(valor);

        if (indice === 0) {
            novoNo.proximo = this.cabeca;
            this.cabeca = novoNo;
            return;
        }

        let atual = this.cabeca;
        let contador = 0;

        while (atual !== null) {
            if (contador === indice - 1) {
                novoNo.proximo = atual.proximo;
                atual.proximo = novoNo;
                return;
            }
            atual = atual.proximo;
            contador++;
        }

        console.log("Índice fora dos limites.");
    }

    // Metodo para remover valores especificos

    remover(valor) {
        if (this.cabeca === null) {
            return;
        }

        if (this.cabeca.valor === valor) {
            this.cabeca = this.cabeca.proximo;
            return;
        }

        let anterior = this.cabeca;
        let atual = this.cabeca.proximo;

        while (atual !== null) {
            if (atual.valor === valor) {
                anterior.proximo = atual.proximo;
                return;
            }
            anterior = atual;
            atual = atual.proximo;
        }
    }

    // Metodo para imprimir toda a lista

    imprimir() {
        let atual = this.cabeca;
        while (atual !== null) {
            console.log(atual.valor);
            atual = atual.proximo;
        }
    }


}


function lerArquivo(path) {
    const lista = new Lista();

    const rl = readline.createInterface({
        input: fs.createReadStream(path),
        crlfDelay: Infinity
    });

    let primeiraLinha = true;

    console.log('Arquivo sendo lido');

    rl.on('line', (linha) => {
        console.log('Nova linha lida:', linha);
        if (primeiraLinha) {
            console.log('Primeira linha do arquivo');

            const numeros = linha.trim().split(' ').map(Number);
            console.log('Números sendo adicionados:', numeros);

            // Adiciona os números à lista
            for (let numero of numeros) {
                lista.inserirFim(numero);
            }

            primeiraLinha = false;
        } else {
            console.log('Operação:', linha);
            const operacao = linha.trim().split(' ');
            const comando = operacao[0];
            const args = operacao.slice(1);

            // Executa as operações na lista
            if (comando === 'P') {
                lista.imprimir();
            } else if (comando === 'A') {
                const valor = parseInt(args[0]);
                const indice = parseInt(args[1]);
                lista.inserirIndice(valor, indice);
            } else if (comando === 'R') {
                const valor = parseInt(args[0]);
                lista.remover(valor);
            }
        }
    });

    rl.on('close', () => {
        console.log('Fim da leitura do arquivo');
        // Aqui você pode adicionar qualquer lógica que deseja executar
        // quando terminar de ler o arquivo
    });
}
    

lerArquivo("rsc\\arqnovo.txt")
