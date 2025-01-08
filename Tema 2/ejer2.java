

class ejer2 {
    public static void main(String[] args) {
        divide(5, 2);
        divide(5, 3);
        divide(5, 0);

    }

    public static void divide(int a, int b) {
        try {
            System.out.println("resultado: " + a + " / " + b + " = " + a / b);       
        } catch (Exception e) {
            System.err.println("Error al dividir: " + a + " / " + b);

        }

    }

}