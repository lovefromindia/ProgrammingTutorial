public class LearningConditionStatements {

    public static void main(String[] args) {

        String currentCourse = "java";

        if (currentCourse.equals("java")) {

            System.out.println("Hello to Java");

        }

//        below line will give error as java only works with boolean in control statements and cannot converts int to boolean
//        else if(1){
//
//        }

        else{

            System.out.println("Still doing Advance Networking");

        }

    }

}
