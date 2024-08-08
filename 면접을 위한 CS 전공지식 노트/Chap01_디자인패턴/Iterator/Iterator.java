import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

interface IteratorPattern {
    boolean hasNext();
    Object next();
}

class NameIterator implements IteratorPattern {
    List<String> names;
    int index = 0;

    public NameIterator(List<String> names) {
        this.names = names;
    }

    @Override
    public boolean hasNext() {
        return index < names.size();
    }

    @Override
    public Object next() {
        if (this.hasNext()) {
            return names.get(index++);
        }
        return null;
    }
}

class NameRepository {
    List<String> names = new ArrayList<>();

    public void addName(String name) {
        names.add(name);
    }

    public IteratorPattern getIterator() {
        return new NameIterator(names);
    }
}

public class Main {
    public static void main(String[] args) {
        NameRepository nameRepository = new NameRepository();
        nameRepository.addName("Alice");
        nameRepository.addName("Bob");
        nameRepository.addName("Charlie");

        IteratorPattern iterator = nameRepository.getIterator();
        while (iterator.hasNext()) {
            String name = (String) iterator.next();
            System.out.println("Name: " + name);
        }
    }
}

