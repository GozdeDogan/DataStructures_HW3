import java.io.*;

/**
 * Created by GozdeDogan on 7.03.2017.
 */
public class testing {
    public static void main(String[] args) {

        SLL<Integer> mylist = new SLL<Integer>();
        try {
            File file = new File("Integers.txt");
            FileReader inputFil = new FileReader(file);
            BufferedReader in = new BufferedReader(inputFil);

            readFile(in, mylist, 100);

            System.out.println("mylist elements ->\n" + mylist.toString()+ "\n\n");

           // try {
                for (int i = 0; i < 50; i++) {
                    mylist.remove();
                }
            //}catch (Exception e){

            //}
            System.out.println(mylist.deletedToString() + "\n\n");

            readFile(in, mylist, mylist.size()+100);
            System.out.println("mylist elements ->\n" + mylist.toString() + "\n\n");

            in.close();
        }
        catch(IOException e){

        }

    }


    public static void readFile(BufferedReader in, SLL<Integer> mylist, int size){
        try {
            String s;

            do{
                s = in.readLine();
                mylist.add(Integer.parseInt(s));
            }while (s != null && mylist.size() < size);
        }catch(IOException e){

        }
    }
}
