import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ExceptionTest {
    private String url;
    private String user;
    private String password;
    private Connection conn;
    private Statement statement;
    private Student student;

    @Test
    public void throwTest1(){
        if(student==null){
            //throw new NullPointerException();
            //throw new NullPointerException("student=null");
        }
       System.out.println("------------");
    }

    @Test
    public void throwTest2(){
        try{
            student.getName();
            System.out.println("------------");
        }catch(Exception e){
            System.out.println("这是异常处理程序做的处理");
        }
    }

    @Test
    public void throwsTest1()throws IOException{
        File file=new File("1.txt");
        FileInputStream in=new FileInputStream(file);
        int result=in.read();
        System.out.println(result);
        /*try{
            File file=new File("1.txt");
            FileInputStream in=new FileInputStream(file);
            int result=in.read();
            System.out.println(result);
        }catch(IOException e){
            System.out.println("caught it!");
        }*/
    }
    public void throwsTest2()throws IOException{
        throwsTest1();
    }

    /**
     * 创建自定义异常并测试
     */
    class SimpleException extends RuntimeException {
    }
    class InheritingExceptions{
        public void f(){
            System.out.println("Throw SimpleException from f()");
            throw new SimpleException();
        }
    }
    @Test
    public void myExceptionTest(){
        InheritingExceptions ihe=new InheritingExceptions();
        try{
            ihe.f();
        }catch(SimpleException e){
            System.out.println("caught it!");
        }
    }

    /**
     * finally测试
     */
    class ThreeException extends Exception{}
    static int count=0;
    @Test
    public void finallyTest1(){
        while(true){
            try{
                if(count++==0){
                    throw new ThreeException();
                }
                System.out.println("No Exception!");
            }catch(ThreeException e){
                System.out.println("ThreeException");
            } finally {
                System.out.println("In Finally Clause");
                if(count==2)
                    break;
            }
        }
    }
    @Test
    public void finallyTest2(){
        int num=3;
        try{
            System.out.println(num++);
            return;
        }finally{
            System.out.println(num);
        }
    }

    @Test
    public void finallyTest3(){
        String driver="com.mysql.jdbc.Driver";
        url="jdbc:mysql://localhost:3306/easy_mybatis";
        user="root";
        password="admin";
        try {
            Class.forName(driver);
            conn= DriverManager.getConnection(url,user,password);
            statement=conn.createStatement();
            statement.executeQuery("select * from user ");
        } catch(ClassNotFoundException e) {
            System.out.println("驱动不存在");
        } catch(SQLException e){
            e.printStackTrace();
        }finally{
            if(statement!=null)
                try{
                    statement.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            if(conn!=null)
                try{
                    conn.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
        }
    }
}
