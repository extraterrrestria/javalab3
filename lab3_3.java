import java.util.Scanner;
import java.util.regex.*;

public class lab3_3 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        StringBuilder user_input = new StringBuilder();

        int count = 0;
        int size = 0;

        System.out.print("Размерность массива: ");
        try {
            size = input.nextInt();
        } catch (Exception e) {
            System.out.println("Ожидался ввод целого значения");
            System.exit(-1);
        }

        double[] base_arr = new double[size];

        System.out.print("Массив: ");
        for (int i = 0; i < size; i++) {
            try {
                base_arr[i] = input.nextDouble();
            } catch (Exception e) {
                System.out.println("Ожидался ввод числового значения");
                System.exit(-1);
            }
        }

        double value = base_arr[0];
        for (double element : base_arr) {
            if (value <= element) {
                user_input.append(element).append(" ");
                value = element;
                count += 1;
            }
        }

        double[] proper_arr = new double[count];
        Pattern separator = Pattern.compile("[\\S]+");
        Matcher valid = separator.matcher(user_input.toString());

        int i = 0;
        while (valid.find()){
            proper_arr[i] = Double.parseDouble(valid.group());
            i++;
        }
        
        String base_arr_f = output(base_arr);
        String proper_arr_f = output(proper_arr);
        
        System.out.println("Исходный массив: " + base_arr_f);
        System.out.println("Массив после обработки: " + proper_arr_f);
    }

   public static String output(double[] insert_array) {
        StringBuilder output_str = new StringBuilder();
        for (double piece : insert_array) {
            output_str.append(piece).append(", ");
        }

        int last = output_str.length() - 1;
        output_str.replace(last-1, last + 1, "");

        return output_str.toString();
    }
}
