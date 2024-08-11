package array;

public class Main {
    public static void main(String[] args) {
        Array array = new Array(10);
        array.add(10);
        array.add(20);
        array.add(30);
        array.add(40);
        array.add(50);
        System.out.println(array.remove(1));//20
        System.out.println(array);//[10,30,40,50]
        System.out.println(array.size());//20

    }

}