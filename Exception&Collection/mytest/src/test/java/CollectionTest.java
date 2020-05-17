import org.junit.Test;

import java.util.*;

public class CollectionTest {
    /**
     * ArrayList测试
     */
    @Test
    public void arrayListTest(){
        List<Integer> arrayList=new ArrayList();
        for(int i=0;i<=9;i++){
            arrayList.add(i);//usage1:add(obj)
        }
        System.out.println(arrayList.toString());
        System.out.println(arrayList.contains(4));//contains(obj)判断对象obj是否在集合内
        System.out.println(arrayList.indexOf(4));//indexOf(obj)判断obj在容器中的位置
        arrayList.add(6,8);
        System.out.println(arrayList);//usage2:add(index,obj)在index位置加入obj
        arrayList.set(3,14);//set(index,obj)将下标为index位置的元素更改为obj
        System.out.println(arrayList);
        Collections.sort(arrayList);
        System.out.println(arrayList);
    }
    /**
     * LinkedList测试
     */
    @Test
    public void linkedListTest(){
        LinkedList<Integer> linkedList=new LinkedList<>();
        for(int i=0;i<=9;i++){
            linkedList.add(i);
        }
        System.out.println("打印linkedList:"+linkedList);
        System.out.println("getFirst():"+linkedList.getFirst());//getFirst()获取链表第一个元素
        System.out.println("element():"+linkedList.element());
        System.out.println("peek():"+linkedList.peek());
        System.out.println("remove():"+linkedList.removeFirst());
        linkedList.addFirst(16);
        System.out.println("after addFirst():"+linkedList);
        linkedList.addLast(100);
        System.out.println("after addLast():"+linkedList);
    }

    /**
     * 测试栈
     */
    @Test
    public void stackTest(){
        Stack<String> stack=new Stack<>();
        for(String s:"i love jiangrongxin".split(" ")){
            System.out.print(s+" ");
            stack.push(s);
        }
        System.out.println();
        while(!stack.empty()){
            System.out.print(stack.pop()+" ");
        }
    }

    /**
     * Set测试
     */
    @Test
    public void setTest() {
        HashSet<String> hashSet = new HashSet<>();
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        TreeSet<String> treeSet = new TreeSet<>();

        for (String data : Arrays.asList("B", "E", "D", "C", "A")) {
            hashSet.add(data);
            linkedHashSet.add(data);
            treeSet.add(data);
        }
        //不保证有序
        System.out.println("Ordering in HashSet :" + hashSet);
        //FIFO保证安装插入顺序排序
        System.out.println("Order of element in LinkedHashSet :" + linkedHashSet);
        //内部实现排序
        System.out.println("Order of objects in TreeSet :" + treeSet);
    }

    /**
     * 通过基本类型测试
     */
    @Test
    public void treeSetTest1() {
        // 基本类型数据测试
        TreeSet<Integer> ts = new TreeSet<Integer>();
        // 创建元素并添加20,18,23,22,17,24,19,18,24
        ts.add(20);
        ts.add(18);
        ts.add(23);
        ts.add(22);
        ts.add(17);
        ts.add(24);
        ts.add(19);
        ts.add(18);
        ts.add(24);
        // 遍历
        for (Integer i : ts) {
            System.out.print(i + " ");
        }
    }

    /**
     * 通过实现comparable接口中的compareTo方法
     */
    @Test
    public void treeSetTest2() {
        //容器内部对象实现comparable接口
        TreeSet<Student> ts = new TreeSet<Student>();
        //创建元素对象
        Student s1 = new Student("韩信", 20);
        Student s2 = new Student("宫本武藏", 22);
        Student s3 = new Student("程咬金", 24);
        Student s4 = new Student("凯", 26);
        Student s5 = new Student("花木兰", 22);
        Student s6 = new Student("马可波罗", 24);
        //将元素对象添加到集合对象中
        ts.add(s1);
        ts.add(s2);
        ts.add(s3);
        ts.add(s4);
        ts.add(s5);
        ts.add(s6);
        for (Student s : ts) {
            System.out.println(s.getName() + "-----------" + s.getAge());
        }
    }

    @Test
    public void treeSetTest3(){
        //TreeSet(Comparator<? super E> comparator) 构造一个新的空 TreeSet，它根据指定比较器进行排序。
        TreeSet<Student> ts=new TreeSet<Student>(new MyComparator());
        Student s1=new Student("zhangsan",20);
        Student s2=new Student("lis",22);
        Student s3=new Student("wangwu",24);
        Student s4=new Student("chenliu",26);
        Student s5=new Student("zhangsan",22);
        Student s6=new Student("qianqi",24);
        //将元素对象添加到集合对象中
        ts.add(s1);
        ts.add(s2);
        ts.add(s3);
        ts.add(s4);
        ts.add(s5);
        ts.add(s6);
        //遍历
        for(Student s:ts){
            System.out.println(s.getName()+"-----------"+s.getAge());
        }
    }

    /**
     * Queue测试
     */
    class QueueDemo{
        public void printQ(Queue queue){
            while(queue.peek()!=null){
                System.out.println(queue.remove()+" ");
            }
            System.out.println();
        }
    }
    @Test
    public void queueTest(){
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<=9;i++){
            queue.offer(i);//offer(obj)将obj插入到队列尾部
        }
        System.out.println("打印Queue："+queue);
        System.out.println("peek():"+queue.peek());//返回队头元素
        System.out.println("element():"+queue.element());//返回队头元素
        System.out.println("poll():"+queue.poll());//返回并删除队头元素
        System.out.println("remove():"+queue.remove());//返回并删除队头元素
    }

    /**
     * Map测设
     */
    @Test
    public void testMap(){
        //1.创建Map集合
        Map persons = new HashMap();   //HashMap的默认初始化容量是16，加载因子是0.75
        //2.存储键值对
        persons.put("10000","JACK");persons.put("10000","TOM");persons.put("10001","KING");
        persons.put("10002","PIG");persons.put("10003","LINDA");persons.put("10004","KIDS");
        //3.判断键值对的个数
        //Map中的key是无序不可重复的，和HashSet相同
        System.out.println(persons.size());   //5
        //4.判断集合中是否包含这样的key
        System.out.println(persons.containsKey("10000"));  //true
        //5.判断集合中是否包含这样的value
        System.out.println(persons.containsValue("JACK")); //false
        //6.通过key获取value
        String k="10001";
        Object v=persons.get(k);
        System.out.println(v);   //KING
        //7.通过key删除键值对
        persons.remove("10002");
        System.out.println(persons.size());  //4
        //8.获取所有的value
        Collection values = persons.values();
        Iterator it=values.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        for (Object obj:values){

        }
        //9.获取所有的key后遍历
        Set keys=persons.keySet();
        Iterator it2=keys.iterator();
        while(it2.hasNext()){
            Object id=it2.next();
            Object name=persons.get(id);
            System.out.println(id+"-->"+name);
        }
        //10.entrySet() 将Map转换成Set集合
        Set entrySet=persons.entrySet();
        Iterator it3=entrySet.iterator();
        while(it3.hasNext()){
            System.out.println(it3.next());
        }
    }

    /**
     * HashMap测试
     */
    @Test
    public void hashMapTest() {
        //	HashMap<String, String> map = new HashMap<String,String>();
        Map<String, String> map = new HashMap<String, String>(); //接口的引用变量指向实现类的对象
        //创建HashMap对象，也就是创建一个Map容器
        map.put("jay", "张三"); //添加键值对元素
        map.put("jay", "李四");
        //有相同的键时，后面添加的键对应的值会覆盖掉之前键对应的值
        map.put("john", "李四");
        //键名不同，键值相同，会保存重名的键值，也就是说值是可以重复的，键是不能重复的
        map.put("rose", "玫瑰"); //添加键值对元素
        map.put("mary", "小红"); //添加键值对元素
        System.out.println(map);

        Set<String> keys = map.keySet();//	获取map中所有键,返回的是一个Set容器，可以用迭代器对象或者foreach来进行输出
        System.out.println("******输出map容器中所有的键：");
        for(String key : keys) {
            System.out.print(key + " "); //用String类型的变量key来遍历keys容器
        }

        //获取map中所有的值：使用map接口中的values方法，返回Collection接口的实现类
        Collection<String> values = map.values();
        System.out.println("\n******输出map容器中所有的值：");
        for (String value : values) {
            System.out.print(value + " "); //用String类型的变量value来遍历values容器
        }

        //得到key的同时，得到key所对应的值
        System.out.println("\n******用获取的键来得到对应的值并输出：");
        for (String key : keys) {
            System.out.print(key + "--" + map.get(key)); //用String类型的变量key来遍历keys容器
        }
        //map.get(Object key)方法返回的是指定的键所对应 的值，
        System.out.println("\nmap容器中键值对的个数是：" + map.size());
        System.out.println("判断map容器中是否为空：" + map.isEmpty());

        //	map.entrySet()返回的是一个set容器，其中放的是map.Entry内部接口
        Set<Map.Entry<String, String>> entrys = map.entrySet();
        System.out.println("使用map接口的entrySet()方法获取map容器中所有的键值对：");
        for (Map.Entry<String, String> entry : entrys) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
        map.clear();
        System.out.println("判断map容器中是否为空：" + map.isEmpty());
    }
}

