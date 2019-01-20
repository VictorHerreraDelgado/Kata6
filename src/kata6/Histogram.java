/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata6;
/**
 *
 * @author Usuario
 */
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public class Histogram <T> {
    private final HashMap <T,Integer> map = new HashMap<T,Integer>();

    public Histogram(Iterator<T> iterator) {
        while (iterator.hasNext()) add(iterator.next());
    }
    public Histogram (Iterable iterable){
        Iterator<T> iterator = iterable.iterator();
        while (iterator.hasNext()) add(iterator.next());
                
    }
    private void add(T item) {
        map.put(item, get(item) + 1);
    }

    private int get(T item) {
        return map.containsKey(item) ? map.get(item) : 0;
    }
}

