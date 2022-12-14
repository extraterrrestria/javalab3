import java.util.Scanner;
import java.util.regex.*;


public class lab3_2 {
    public static void main(String [] args) {

        Scanner input = new Scanner(System.in);
        StringBuilder user_elements = new StringBuilder();
        int size = 0;
        Pattern non_digit = Pattern.compile("\\D");

        System.out.print("Массив: ");
        boolean indicator = true;

        while (indicator) {
            String user_input = input.next();
            if (user_input.equals("quit")) {
                break;
            } else {
                Matcher valid = non_digit.matcher(user_input);
                if (!valid.find()) {
                    user_elements.append(user_input).append(" ");
                } else {
                    System.out.println("Ошибка, массив и число к удалению должны быть целыми");
                    System.exit(-1);
                }
            }
        }

        String[] auxiliary = user_elements.toString().split("\s");
        int n = auxiliary.length;
        int[] int_auxiliary = new int[n];

        for (int i = 0; i < n; i++) {
            int_auxiliary[i] = Integer.parseInt(auxiliary[i]);
        }

        System.out.println("\nРазмерность массива:  " + n);

        int del = 0;
        System.out.print("Число к удалению: ");


        try {
            del = input.nextInt();
        } catch (Exception e) {
            System.out.println("Ошибка, массив и число к удалению должны быть целыми");
            System.exit(-1);
        }


        for (int element : int_auxiliary) {
            if (element != del) {
                size += 1;
            }
        }

        int index = 0;
        int[] proper_arr = new int[size];

        for (int element_1 : int_auxiliary) {
            if (element_1 != del) {
                proper_arr[index] = element_1;
                index += 1;
            }
        }

        StringBuilder base_arr = new StringBuilder();
        for (int number_2 : int_auxiliary) {
            base_arr.append(" ").append(number_2);
        }
        StringBuilder modified_arr = new StringBuilder();
        for (int number_1 : proper_arr) {
            modified_arr.append(" ").append(number_1);
        }

        System.out.println("Исходный массив: " + base_arr);
        System.out.println("Массив после обработки: " + modified_arr);

    }

}