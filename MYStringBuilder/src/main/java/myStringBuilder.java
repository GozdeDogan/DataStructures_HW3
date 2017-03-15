import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created and implemented by GozdeDogan on 7.03.2017.
 */
public class myStringBuilder<E> {
    private SingleLinkedList mySB;

    myStringBuilder(){
        mySB = new SingleLinkedList();
    }

   /* public void insert(int index, Object item){
        mySB.add(index, item);
    }*/

    public void insert(int index, char item){
        mySB.add(index, item);
    }
    public void insert(int index, int item){
        mySB.add(index, item);
    }
    public void insert(int index, boolean item){
        mySB.add(index, item);
    }
    public void insert(int index, double item){
        mySB.add(index, item);
    }
    public void insert(int index, float item){
        mySB.add(index, item);
    }
    public void insert(int index, long item){
        mySB.add(index, item);
    }
    public void insert(int index, char[] item){
        for(int i=0; i<item.length; i++)
            mySB.add(index, item[i]);
    }
    public void insert(int index, char[] item, int offset, int len){
        if(offset != len-1)
        {
            char[] elm = new char[len-offset];
            int k=0;
            for(int i=offset; i<len; i++) {
                elm[k] = item[i];
                k++;
            }
            for(int i=0; i<item.length; i++)
                mySB.add(index, item[i]);
        }
    }
    public void insert(int index, String item){
        mySB.add(index, item);
    }
    public void insert(int index, CharSequence item){
        for(int i=0; i<item.length(); i++)
            mySB.add(index, item.charAt(i));
    }
    public void insert(int index, CharSequence item, int start, int end){
        if (start != end) {
            String elm = new String();
            for (int i = start; i < end; i++)
                elm = elm + item.charAt(i);

            for(int i=0; i<item.length(); i++)
                mySB.add(index, item.charAt(i));
        }
    }


    public void insert(int index, E item){
            mySB.add(index, item);
    }


    public int size(){
        return mySB.size();
    }

   public SingleLinkedList<E> get(){
       return mySB;
   }


    public void append(int item){
        insert(size(), item);
    }

    public void append(String item){
        insert(size(), item);
    }
    public void append(char item){
        insert(size(), item);
    }
    public void append(double item){
        insert(size(), item);
    }

    public void append(boolean item){
        insert(size(), item);
    }

    public void append(char[] item){
        insert(size(), item);
    }

    public void append(char[] item, int offset, int len){
        insert(size(), item, offset, len);
    }

    public void append(float item){
        insert(size(), item);
    }

    public void append(long item){
        insert(size(), item);
    }

    /*public void append(Object item){
        insert(size(), item);
    }*/

    public void append(StringBuffer item){
        insert(size(), item);
    }

    public void append(CharSequence item){
        insert(size(), item);
    }

    public void append(CharSequence item, int start, int end) {
        insert(size(), item, start, end);
    }

    public void appendCodePoint(int item){
        insert(size(), item);
    }


  /*  public void append(myStringBuilder items){
        for(int i=0; i<items.size(); i++){
            append(items.get().get(i));
        }
        //System.out.println("size:" + size() + "\titemSize:" + items.size());
        //size = size + items.size();
    }*/


    public void append(myStringBuilder<E> items){
        for(int i=0; i<items.size(); i++){
            append(items.get().get(i));
        }
        //System.out.println("size:" + size() + "\titemSize:" + items.size());
        //size = size + items.size();
    }

    public void append(E item){
        insert(size(), item);
    }

    public String toString1(){
        String res = new String("[");
        for(int i=0; i<mySB.size(); i++)
            if(i<mySB.size()-1)
                res = res + mySB.get(i) + ", ";
            else
                res = res + mySB.get(i);
        res = res + "]";
        return res;
    }

    public String toString2(){
        Iterator iter = mySB.iterator();
        String res = new String("[");
        for(Object temp : mySB) {
            res = res + temp + " ==> ";
        }
        res = res + mySB.get(size()-1) + "]";
        return res;
    }


    public String toString3(){
        return mySB.toString();
    }



}
