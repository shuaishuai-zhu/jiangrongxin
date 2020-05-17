import java.util.LinkedList;

public class Stack<T> {
    private LinkedList<T> storage=new LinkedList<>();
    //压栈
    public void push(T t){
        storage.addFirst(t);
    }
    //获取栈顶对象
    public T peek(){
        return storage.getFirst();
    }
    //出栈
    public T pop(){
        return storage.removeFirst();
    }
    //判断栈是否为空
    public boolean empty(){
        return storage.isEmpty();
    }
    //打印栈
    public String toString(){
        return storage.toString();
    }
}
