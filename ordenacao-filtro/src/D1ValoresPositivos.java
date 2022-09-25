import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Stream;

/**
 * Desafio
 * Crie um programa onde você receberá valores inteiros não negativos como entrada.
 * <p>
 * Ordene estes valores de acordo com o seguinte critério:
 * <p>
 * Primeiro os Pares
 * Depois os Ímpares
 * Você deve exibir os pares em ordem crescente e na sequência os ímpares em ordem decrescente.
 * <p>
 * Entrada
 * A primeira linha de entrada contém um único inteiro positivo N (1 < N < 10000)
 * Este é o número de linhas de entrada que vem logo a seguir. As próximas N linhas terão, cada uma delas,
 * um valor inteiro não negativo.
 */

public class D1ValoresPositivos {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> oddNumbers = new ArrayList<Integer>();
        List<Integer> evenNumbers = new ArrayList<Integer>();
        int currentNumber = 0;

        int qtyOfNumber = Integer.parseInt(br.readLine());
        if (qtyOfNumber > 1 && qtyOfNumber < 10000){
            while (currentNumber < qtyOfNumber) {
                String sn = br.readLine();
                    int n = Integer.parseInt(sn);
                    if (n < 0) return;
                    if (n % 2 == 0) {
                        evenNumbers.add(n);
                    } else {
                        oddNumbers.add(n);
                    }

                currentNumber++;
            }
        }

        evenNumbers.sort(Comparator.naturalOrder());
        oddNumbers.sort(Comparator.reverseOrder());
        evenNumbers.forEach(System.out::println);
        oddNumbers.forEach(System.out::println);
    }
}
