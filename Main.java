//visibility can only increase in inheritance and be decreased

class Main{
    public static void main(String[] args) {
        C obj = new C();
        System.out.printf(obj.sing());
    }
}

abstract class B{
    protected abstract String sing();
}

class C extends B{
     public String sing(){
        return "I am singing";
    }
}