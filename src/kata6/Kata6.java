
package kata6;

import java.io.File;
import java.nio.file.Files;
import java.util.Iterator;

/**
 *
 * @author Usuario
 */
public class Kata6 {

 
    public static void main(String[] args) {
        File file = new File("\\Users\\Asus\\Documents");
        Iterator<Integer> iterator = megabytes(lengthsOf(recursiveFileIterator(file.listFiles())));
        while (iterator.hasNext()){
             System.out.println(iterator.next() + " MB");   
        }
      
    }
  
    private static <T> Iterator<File> recursiveFileIterator(File[] items){
        //if(depth < 1) return null;
        return new Iterator<File>() {
            private Iterator<File> nextIterator = null;
            private int index = 0;
            @Override
            public boolean hasNext() {
                return (nextIterator != null && nextIterator.hasNext()) || index < items.length  ;
            }

            @Override
            public File next() {
                if (nextIterator != null && nextIterator.hasNext()) return nextIterator.next();
                File item = items[index++];
                 if (item.isDirectory())
                    nextIterator =  (item.listFiles() == null )? null : recursiveFileIterator(item.listFiles());
                return item;
            }
            
        };
        
    }
    private static <T> Iterator<T> iteratorOf(T[] items){
        
        return new Iterator<T>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < items.length;
            }

            @Override
            public T next() {
                //System.out.println(items[index]);
                return items[index++];
            }
            
        };
        
    }

    private static <T> Iterator<Long> lengthsOf(Iterator<File> iterator) {
        
        return new Iterator<Long>(){
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Long next() {
                File x = iterator.next();
                System.out.println(x); 
                return x.length();
            }
            
        };
        
    }

    private static Iterator<Integer> megabytes(Iterator<Long> iterator) {
        return new Iterator<Integer>(){
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return (int) (iterator.next() / (1024*1024));
            }
            
        };
    }
    
}
