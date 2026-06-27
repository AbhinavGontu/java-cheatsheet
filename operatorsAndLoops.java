public class operatorsAndLoops{
    public static void main(String[] args) {
        System.out.println(true && false);
        System.out.println(true || false);
        System.out.println(!false);

        System.out.println(2>3);
        System.out.println(2<3);
        System.out.println(2>=3);
        System.out.println(2<=3);
        System.out.println(2==3);
        System.out.println(2!=3);

        if (18>= 20){
            System.out.println("It is false");
        }
        else if(17==18){
            System.out.println("It is True");
        }
        else System.out.println("It is something else");

        String even = (2%2==0) ? "even" : "odd";
        System.out.println(even);

        switch (0){
            case 0: System.out.println("Zero");
                    break;
            case 1: System.out.println("One");
                    break;
            default:System.out.println("Default");
        }
        String switchStatus = switch (1){
            case 0,2 -> "Zero";
            case 1 -> {
                System.out.println("One");
                yield "one";
            }
            default -> "Default";
        };
        System.out.println(switchStatus);

        int[] userArray = {1,2,3,4,5};
        for(int num: userArray) System.out.println(num);
        for(int i = 0; i < 5; i++) System.out.println(userArray[i]);
        int i = 0;
        while(i<5) System.out.println(userArray[i++]);
        i = 0;
        do System.out.println("do while "+userArray[i++]);   while (i<5);

    }
}