import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created and implemented by GozdeDogan on 12.03.2017.
 * iterator ve size metotlarinin implementine izin vermiyor.
 * appendAnything metodu implement edildi.
 * test edilmedi.
 */
public class myAbstractCollection<E> extends AbstractCollection<E> {

    protected myAbstractCollection() {
        super();
    }


    /**
     * Bir myAbstractCollection parametresi aliyor ve bu parametre bos degilse ve null da degilse
     * uzerinde bulundugumuz objeye eklenir.
     * @param mAB -> myAbstractCollection parametresi, uzerinde calstigimiz objeye eklenir
     * @return    -> uzerinde calisilan objenin yeni hali return edilir.
     */
    public myAbstractCollection<E> appendAnything(myAbstractCollection<E> mAB){
        if(!mAB.isEmpty() && mAB != null)
            addAll(mAB);
        return this;
    }


    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return super.contains(o);
    }

    @Override
    public Object[] toArray() {
        return super.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return super.toArray(a);
    }

    @Override
    public boolean add(E e) {
        return super.add(e);
    }

    @Override
    public boolean remove(Object o) {
        return super.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return super.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return super.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return super.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return super.retainAll(c);
    }

    @Override
    public void clear() {
        super.clear();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
