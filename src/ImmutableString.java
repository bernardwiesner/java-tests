public class ImmutableString {
    public static void main(String[] args){

        String s1 = new String("Hello");
        String s2 = s1;
        System.out.println(s1);
        System.out.println(s2);

        s1 = "World";

        System.out.println(s1);
        System.out.println(s2);



    }

}
