import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Darion Higgins on 7/24/2019
 * TSO2438
 */
public class ImplementXORLinkedList {

    public static void main(String[] args) {
        new ImplementXORLinkedList().test();
    }

    void test(){
    }

    class XORLinkedList {
        Element root;

        public XORLinkedList(Element root) {
            this.root = root;
        }

        void add(Element element){

        }

        Element get(int index){
            Element curr = root;
            for(int i=0;i<index - 1;i++){
                curr.both
            }
            return curr;
        }

        Map<Long, Element> addressMap = new HashMap<>();
        long getPointer(Element e){
            addressMap.put(e.pointer, e);
            return e.pointer;
        }

        Element dereferencePointer(long pointer){
            return addressMap.get(pointer);
        }
    }

    class Element {
        String val;
        int both;
        long pointer = UUID.randomUUID().getMostSignificantBits();
    }
}
