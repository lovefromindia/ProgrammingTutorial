class Base {

    protected void run() {

        System.out.print("Running is protected");

    }

    public void eat(){

        System.out.print("Eating is public");

    }

    void sleep(){

        System.out.println("Sleeping is default");

    }

}

class Child extends Base{

    public void run() {

        System.out.print("Running is no long protected but it is public");

    }

    /**
     * Below two methods decrease the visibility so will give compile time errors
     */

//    protected void eat(){
//
//        System.out.println("Eating is protected");
//
//    }
//
//    private void sleep(){
//
//        System.out.println("Sleeping is default");
//
//    }

}

public class LearningClassVisibility {

    public static void main(String[] args) {

        Base chObj = new Child();

        chObj.run();

    }

}
