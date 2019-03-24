import java.util.Iterator;

class myIterator<Type> implements Iterator<Type> {
    private int current;
    private Type[] items;

    public myIterator(Type[] items) {
        this.current = 0;
        this.items = items;
    }

    public boolean hasNext() {
        return (current < items.length);
    }

    public Type next() {
        return items[current++];
    }
}

