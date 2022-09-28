/**
 * Desafio
 * O professor Girafales organizou a confecção de um uniforme para as turmas da escola para comemorar o final do ano.
 * Após algumas conversas, ficou decidido com os alunos que eles poderiam escolher a cor do uniforme entre branco ou
 * vermelho. Assim sendo, Girafales precisa de sua ajuda para organizar as listas de quem quer o uniforme em cada uma
 * das turmas, relacionando estas camisetas pela cor, tamanho (P, M ou G) e por último pelo nome.
 * <p>
 * Entrada
 * Cada caso de teste inicia com um valor N, (1 ≤ N ≤ 60) inteiro e positivo, que indica a quantidade de uniformes a
 * serem feitas para aquela turma. As próximas N*2 linhas contém informações de cada um dos uniformes (serão duas
 * linhas de informação para cada uniforme). A primeira linha irá conter o nome do estudante e a segunda linha irá
 * conter a cor do uniforme ("branco" ou "vermelho") seguido por um espaço e pelo tamanho do uniforme "P" "M" ou "G".
 * A entrada termina quando o valor de N for igual a zero (0) e esta valor não deverá ser processado.
 * <p>
 * Saída
 * Para cada caso de entrada deverão ser impressas as informações ordenadas pela cor em ordem ascendente,
 * seguido pelos tamanhos em ordem descendente e por último por ordem ascendente de nome, conforme o exemplo abaixo.
 * <p>
 * <p>
 * 9
 * Maria Jose
 * branco P
 * Mangojata Mancuda
 * vermelho P
 * Cezar Torres Mo
 * branco P
 * Baka Lhau
 * vermelho P
 * JuJu Mentina
 * branco M
 * Amaro Dinha
 * vermelho P
 * Adabi Finho
 * branco G
 * Severina Rigudinha
 * branco G
 * Carlos Chade Losna
 * vermelho P
 * 0
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;


public class UniformesFimDeAno {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        String owner = "", l, color, size;
        Tshirt[] tshirts = null;
        Tshirt tshirt = null;
        int N = 0;
        int linesAlreadyRead = 0;
        boolean firstCase = true;
        while (!(l = read()).equals("0")) {

            if (firstCase) {
                firstCase = false;
                N = toInt(l);
                tshirts = new Tshirt[(N)];
                continue;
            }

            if (N <= 1 || N >= 60) break;
            if (linesAlreadyRead > (2 * N) - 1) break;

            if ((linesAlreadyRead % 2) == 0) {
                owner = l;
            } else {
                String[] colorAndSizeArray = l.split(" ");
                color = colorAndSizeArray[0];
                size = colorAndSizeArray[1];
                tshirt = new Tshirt(color, size, owner);
                tshirts[linesAlreadyRead] = tshirt;
            }

            linesAlreadyRead++;
            out.close();
        }


        Arrays.sort(tshirts, new Comparator<Tshirt>() {
            @Override
            public int compare(Tshirt t1, Tshirt t2) {
                String color1 = t1.getColor();
                String color2 = t2.getColor();
                int diff = color1.compareTo(color2);

                return diff;
            }
        });

        Arrays.stream(tshirts).sorted((t1, t2) -> t1.getSize().compareTo(t2.getSize()));

        System.out.println(Arrays.stream(tshirts).collect(Collectors.toList()));
    }

    private static String read() throws IOException {
        return in.readLine();
    }

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }

}


class Tshirt {

    private String size;
    private String color;
    private String owner;

    public Tshirt(String size, String color, String owner) {
        this.size = size;
        this.color = color;
        this.owner = owner;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return this.getColor() + " " + this.getSize() + " " + this.getOwner();
    }
}

