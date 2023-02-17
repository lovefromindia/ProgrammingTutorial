//  overloading
class Test1 {

    public int add(int a, int b) {

        return a + b;
    }

    public int add(int a, int b, int c) {

        return a + b + c;

    }

    public static void main(String[] args) {

        Test1 t = new Test1();

        System.out.print(t.add(2, 3));

        System.out.print(t.add(2, 3, 4));

    }

}

