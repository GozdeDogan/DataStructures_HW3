/**
 * Created by GozdeDogan on 7.03.2017.
 */
public class testing {
    public static void main(String[] args) {
        System.out.println("testing Integer>>>");
        SLL<Integer> mylist = new SLL<Integer>();
        mylist.add(1);
        mylist.add(2);
        mylist.add(3);
        mylist.add(4);
        mylist.add(5);
        System.out.println("before reversing >>> " + mylist.toString());
        System.out.println("after reversing >>> " + mylist.reverseToString());

        System.out.println("\n\n\ntesting Character>>>");
        SLL<Character> myCList = new SLL<Character>();
        myCList.add('d');
        myCList.add('a');
        myCList.add('t');
        myCList.add('a');

        System.out.println("before reversing >>> " + myCList.toString());
        System.out.println("after reversing >>> " + myCList.reverseToString());
    }
}
