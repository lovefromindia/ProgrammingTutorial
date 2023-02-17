public class LearningJavaDocs {

    /**
    Returns the minutes
    I: hour (int)
    O: minutes(int)
    */
    int getMinutes(int hour) {

        return hour * 60;

    }

    /**
     * Returns the seconds
     * I: hour (int)
     * O: minutes(int)
     */
    int getSeconds(int hour) {

        return hour * 60 * 60;

    }

    /**
     * Main method
     */
    public static void main(String[] args) {

        LearningJavaDocs javaDocs =  new LearningJavaDocs();

        System.out.print(javaDocs.getMinutes(100));

    }
}
