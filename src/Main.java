import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final char[] triangle_sides_name = {'a', 'b', 'c'};
        float[] triangle_heights = { 0, 0, 0 };

        triangle_heights = count_triangle_heights(ask_triangle_sides(triangle_sides_name));

        console_output_triangle_heights(triangle_heights, triangle_sides_name);

    }
    private static float[] ask_triangle_sides(char[] triangle_sides_name){
        float[] triangle_sides = { 0, 0, 0 };

        Scanner input_scan = new Scanner(System.in);

        System.out.println("\nВведите стороны треугольника:");
        for (int i = 0; i < 3; i++){
            System.out.printf("%s = ", triangle_sides_name[i]);
            triangle_sides[i] = input_scan.nextFloat();
        }
        System.out.println();
        return triangle_sides;
    }
    private static float[] count_triangle_heights(float[] triangle_sides){
        float[] triangle_heights = { 0, 0, 0 };

        float p = (triangle_sides[0] + triangle_sides[1] + triangle_sides[2]) / 2;

        float universal_count_part = (float) Math.sqrt( p * (p - triangle_sides[0]) * (p - triangle_sides[1]) * (p - triangle_sides[2]));

        for (int i = 0; i < 3; i++){
            triangle_heights[i] = (2 / triangle_sides[i]) * universal_count_part;
        }

        return triangle_heights;
    }

    private static void console_output_triangle_heights(float[] triangle_heights, char[] triangle_sides_name){
        System.out.println("\nВысоты треугольника: ");

        for (int i = 0; i < 3; i++){
            System.out.printf("h(%s) = %f \n", triangle_sides_name[i], triangle_heights[i]);
        }

    }
}
