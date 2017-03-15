import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.*;
import java.util.DoubleSummaryStatistics;

/**
 * Created and implemented by GozdeDogan on 7.03.2017.
 */
public class testing {
    public static void main(String[] args) {
        myStringBuilder<Integer> mSB = new myStringBuilder();
        System.out.println("myStringBuilder objesine 100.000 integer eklemesi yapiliyor.\n"
                + "Bu islem dosyadan okuma yapidigi icin biraz uzun suruyor.\n"
                + "(2-3 dakika kadar)Bekleyin....");
        readFile(mSB);
        System.out.println("Dosyadan okuma yapilip myStringBuilder objesine eklendi.\n"
                + "Simdi obje dosyalara yazdiriliyor.");
        long startTime = System.nanoTime();
        printFile(mSB, "results1.txt", 1);
        long endTime = System.nanoTime();
        long duration = endTime-startTime;
        System.out.println("results1.txt dosyasina toString1(index ve get metodu kullanilan toString) metodu ile obje yazdirildi!"
                + " toString1 metodunun execution time: " + duration + " milisaniye!\n");
        startTime = System.nanoTime();
        printFile(mSB, "results2.txt", 2);
        endTime = System.nanoTime();
        duration = endTime-startTime;
        System.out.println("results2.txt dosyasina toString2(iterator kullanilan toString) metodu ile obje yazdirildi!"
                + " toString2 metodunun execution time: " + duration + " milisaniye!\n");
        startTime = System.nanoTime();
        printFile(mSB, "results3.txt", 3);
        endTime = System.nanoTime();
        duration = endTime-startTime;
        System.out.println("results3.txt dosyasina toString3(singleLinkedList'in toString metodunun kullanildigi toString) metodu ile obje yazdirildi!"
                + " toString3 metodunun execution time: " + duration + " milisaniye!\n");

        System.out.println("\n100.000 integer eklendi\n"
                + "myStringBuilder objesi results1.txt, results2.txt ve results3.txt dosyalarina yazdirildi\n"
                + "simdi append metodunun calismasini gorecegiz.");

        System.out.println("mSB'ye bir eleman ekleme>>>");
        int a = 338;
        mSB.append(a);
        System.out.println("mSB'ye ekleme islemi gerceklestirildi\n");
        System.out.println("mSB Size:" + mSB.size() + "\nmSB elements -> " + mSB.toString3());

        System.out.println("append testing>>>>>>>");
        System.out.println("\n\n\nInteger testing>>>");
        myStringBuilder temp = new myStringBuilder();
        for(int i=0; i<57; i++)
            temp.append(i);

        System.out.println("temp elements -> " + temp.toString3());
        myStringBuilder temp1= new myStringBuilder();
        for(int i=78; i<125; i++)
            temp1.append(i);
        System.out.println("temp1 elements -> " + temp1.toString3());

        temp.append(temp1);
        System.out.println("\ntemp Size:" + temp.size() + ",\ttemp1 Size:" + temp1.size() + "\ntemp elements -> " + temp.toString3());

        System.out.println("\n\n\nChar testing>>>");
        myStringBuilder temp2 = new myStringBuilder();
        char ch = '-';
        for(int i=0; i<57; i++)
            temp2.append(ch);

        System.out.println("temp2 elements -> " + temp2.toString3());
        myStringBuilder temp3= new myStringBuilder();
        ch = '*';
        for(int i=0; i<125; i++)
            temp3.append(ch);
        System.out.println("temp3 elements -> " + temp3.toString3());
        System.out.println("\ntemp3 temp2'ye eklendi");
        temp2.append(temp3);
        System.out.println("temp2 Size:" + temp2.size() + ",\ttemp3 Size:" + temp3.size() + "\ntemp2 elements -> " + temp2.toString3());


        System.out.println("\n\n\nDouble testing>>>");
        myStringBuilder temp4 = new myStringBuilder();
        double d = 1.1;
        for(int i=0; i<57; i++)
            temp4.append(d);
        System.out.println("temp4 elements -> " + temp4.toString3());

        myStringBuilder temp5= new myStringBuilder();
        d = 2.5;
        for(int i=78; i<125; i++)
            temp5.append(d);
        System.out.println("temp5 elements -> " + temp5.toString3());
        System.out.println("\ntemp5 temp4'e eklendi");
        temp4.append(temp5);
        System.out.println("temp Size:" + temp4.size() + ",\ttemp1 Size:" + temp5.size() + "\ntemp elements -> " + temp4.toString3());


        System.out.println("\n\n\nString testing>>>");
        myStringBuilder temp6 = new myStringBuilder();
        String s = new String("Gozde");
        for(int i=0; i<5; i++)
            temp6.append(s);
        System.out.println("temp6 elements -> " + temp6.toString3());

        myStringBuilder temp7= new myStringBuilder();
        s = new String("Dogan");
        for(int i=0; i<7; i++)
            temp7.append(s);
        System.out.println("temp7 elements -> " + temp7.toString3());
        System.out.println("\ntemp7 temp6'ya eklendi");
        temp6.append(temp7);
        System.out.println("temp6 Size:" + temp6.size() + ",\ttemp7 Size:" + temp7.size() + "\ntemp6 elements -> " + temp6.toString3());


        System.out.println("\n\n\nchar[] testing>>>");
        myStringBuilder temp8 = new myStringBuilder();
        char[] sc = {'d', 'a', 't', 'a'};
        for(int i=0; i<5; i++)
            temp8.append(sc);
        System.out.println("temp8 elements -> " + temp8.toString3());

        myStringBuilder temp9= new myStringBuilder();
        char[] sc1 = {'s', 't', 'r', 'u', 'c', 't', 'u', 'r', 'e', 's'};
        for(int i=0; i<7; i++)
            temp9.append(sc1);
        System.out.println("temp9 elements -> " + temp9.toString3());
        System.out.println("\ntemp9 temp8'e eklendi");
        temp8.append(temp9);
        System.out.println("temp8 Size:" + temp8.size() + ",\ttemp9 Size:" + temp9.size() + "\ntemp8 elements -> " + temp8.toString3());


        System.out.println("\n\n\nboolean testing>>>");
        myStringBuilder temp10 = new myStringBuilder();
        boolean b = true;
        for(int i=0; i<5; i++)
            temp10.append(b);
        System.out.println("temp10 elements -> " + temp10.toString3());

        myStringBuilder temp11= new myStringBuilder();
        b = false;
        for(int i=0; i<7; i++)
            temp11.append(b);
        System.out.println("temp11 elements -> " + temp11.toString3());
        System.out.println("\ntemp11 temp10'a eklendi");
        temp10.append(temp11);
        System.out.println("temp10 Size:" + temp10.size() + ",\ttemp11 Size:" + temp11.size() + "\ntemp10 elements -> " + temp10.toString3());

    }



    public static void readFile(myStringBuilder mSB){
        try {
            File file = new File("numbers.txt");
            FileReader inputFil = new FileReader(file);
            BufferedReader in = new BufferedReader(inputFil);

            String s = in.readLine();

            while (s != null){
                mSB.append(Integer.parseInt(s));
                s = in.readLine();
            }

            in.close();
        }catch(IOException e){

        }
    }

    public static void printFile(myStringBuilder mSB, String fileName, int type){
        BufferedWriter output = null;
        try {
            File file = new File(fileName);
            output = new BufferedWriter(new FileWriter(file));
            if(type == 1)
                output.write(mSB.toString1());
            else if(type == 2)
                output.write(mSB.toString2());
            else if (type == 3)
                output.write(mSB.toString3());
            else
                output.write("type invalid!");
            output.close();
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }
}
