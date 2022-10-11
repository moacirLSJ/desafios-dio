import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Desafio
 * Nas férias de Dezembro, várias escolas se organizam e levam seus alunos para um acampamento de férias por uma semana.
 * Nestes acampamentos os alunos são divididos em cabanas coletivos por gênero e idade, sempre com um adulto que,
 * além de dormir com o grupo no cabana, também são responsáveis por criar e executar várias atividades, como
 * por exemplo jogos, excursões, Gincanas Noturnas, etc.
 * <p>
 * No primeiro dia foi realizada uma gincana em que a atividade constituia em agrupar os alunos em um círculo
 * (organizado no sentido anti-horário) do qual seriam retiradas uma a uma até que sobrasse apenas um aluno,
 * que seria o vencedor.
 * <p>
 * No momento em que entra no círculo, cada aluno recebe uma pequena ficha que contém um valor de 1 a 500.
 * Depois que o círculo é formado, conta-se, iniciando no aluno que está ao lado da primeira que entrou no
 * círculo, o número correspondente à ficha que o primeiro detém. O aluno onde o número contado cair, deve
 * ser retirado do grupo, e a contagem inicia novamente segundo a ficha do aluno que acabou de ser eliminado.
 * Para ficar mais interessante, quando o valor que consta na ficha é par, a contagem é feita no sentido horário e
 * quando o valor que consta na ficha é ímpar, a contagem é feita no sentido anti-horário.
 * <p>
 * Desenvolva um programa para que no próximo evento o responsável pela brincadeira saiba previamente qual
 * criança irá ser a vencedora de cada grupo, com base nas informações fornecidas.
 * <p>
 * Entrada
 * A entrada contém vários casos de teste. A primeira linha de cada caso de teste contém um inteiro N (1 ≤ N ≤ 100),
 * indicando a quantidade de alunos que farão parte de cada círculo. Em seguida, as N linhas de cada caso de teste
 * conterão duas informações, o Nome e o Valor (1 ≤ Valor ≤ 500) que consta na ficha de cada aluno, separados por um
 * espaço, na ordem de entrada na formação do círculo inicial.
 * <p>
 * OBS: O Nome de cada aluno não deverá ultrapassar 30 caracteres e contém apenas letras maiúsculas e minúsculas,
 * sem acentos, e o caractere “_”. O final da entrada é indicado pelo número zero.
 * <p>
 * Saída
 * Para cada caso de teste, deve-se apresentar a mensagem Vencedor(a): xxxxxx, com um espaço após o sinal ":"
 * indicando qual é o aluno do grupo que venceu a brincadeira.
 */


public class GincanaAcampamento {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> namesAndNumbersAntiClockWise = new HashMap<>();
        Map<String, Integer> namesAndNumbersClockWise = new HashMap<>();
        List<String, Integer> a = new ArrayList<>();
        int N = Integer.parseInt(bf.readLine());
        while (N != 0){
            for (int i = 0; i < N; i++) {

                String[]  name_number_tmp = bf.readLine().split(" ");
                String name = name_number_tmp[0];
                int number =Integer.parseInt(name_number_tmp[1]);

                namesAndNumbersAntiClockWise.put(name, number);
            }
            //************ processando o jogo *************************
            int basePosition = 0;
            int ticketNumber = namesAndNumbersAntiClockWise.get(0)[1];

            System.out.println(namesAndNumbersAntiClockWise.toString());
            N = Integer.parseInt(bf.readLine());
        }
    }
}
