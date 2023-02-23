package lab11.com;

import javax.management.openmbean.InvalidOpenTypeException;

class ArrayQueue {
    private Object[] a;
    private int size;
    public ArrayQueue(int capacity){
        if(capacity<1)throw new IllegalArgumentException("Capacity must be greater than 0");
        a=new Object[capacity];
    }
    public boolean isEmpty(){
        return size==0;
    }
    public void resize(){
        Object[] aa=a;
        a=new Object[size*2];
        System.arraycopy(a,0,aa,0,size);
    }
    public void add(Object obj){
        if(size==a.length)resize();
        a[size++]=obj;
    }
    public Object remove(){
        if(isEmpty())throw new InvalidOpenTypeException("Queue is empty");
        Object obj=a[0];
        System.arraycopy(a,1,a,0,size--);
        return obj;
    }
    public Object first(){
        if(isEmpty())throw new InvalidOpenTypeException("Queue is empty");
        return a[0];
    }
    public int size(){
        return size;
    }
}
public class Task_2 {

	public static void main(String[] args) {
		ArrayQueue queue=new ArrayQueue(5);
		System.out.println("\n\n");
        System.out.println("isEmpty() method "+queue.isEmpty());
        queue.add(6);
        queue.add(7);
        queue.add(8);
        queue.add(9);
        System.out.println("first() method called : "+queue.first());
        System.out.println("Size method    called :"+queue.size());
        System.out.println("remove method  called :"+queue.remove());
        System.out.println("Size method    called :"+queue.size());
	}

}
