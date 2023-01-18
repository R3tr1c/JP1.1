import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        float sideALength = getTriangleSideLength("a"),
              sideBLength = getTriangleSideLength("b"),
              sideCLength = getTriangleSideLength("c");

        checkTriangleValid(sideALength, sideBLength, sideCLength);

        float triangleArea = getTriangleArea(sideALength, sideBLength, sideCLength);

        float heightToSideALength = getTriangleHeightLength(sideALength, triangleArea),
              heightToSideBLength = getTriangleHeightLength(sideBLength, triangleArea),
              heightToSideCLength = getTriangleHeightLength(sideCLength, triangleArea);

        printTriangleHeight("a", heightToSideALength);
        printTriangleHeight("b", heightToSideBLength);
        printTriangleHeight("c", heightToSideCLength);
    }

    private static float getTriangleSideLength(String sideName) {
        System.out.printf("Длина стороны %s: ", sideName);
        Scanner inputScan = new Scanner(System.in);
        float sideLength = inputScan.nextFloat();
        if (sideLength <= 0) {
            throw new IllegalArgumentException("Длина каждой из сторон треугольника больше 0.");
        }
        return sideLength;
    }

    private static float getTriangleArea(float sideALength, float sideBLength, float sideCLength) {
        float semiPerimeter = (sideALength + sideBLength + sideCLength) / 2;
        return (float) Math.sqrt(semiPerimeter * (semiPerimeter - sideALength) * (semiPerimeter - sideBLength) * (semiPerimeter - sideCLength));
    }

    private static float getTriangleHeightLength(float sideLength, float triangleArea ){
        return 2 * triangleArea / sideLength;
    }

    private static void checkTriangleValid(float sideALength, float sideBLength, float sideCLength) {
        if (sideALength > (sideBLength + sideCLength) ||
            sideBLength > (sideCLength + sideALength) ||
            sideCLength > (sideBLength + sideALength)) {
            throw new IllegalArgumentException("Длина каждой из сторон треугольника не может быть больше суммы двух других сторон.");
        }
    }

    private static void printTriangleHeight(String toSideName, float heightLength){
        System.out.printf("\nВысота треугольника к стороне %s: %.2f;", toSideName, heightLength);
    }
}
