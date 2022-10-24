package test.com.wangxin.ssm.mybatis;

import com.wangxin.ssm.mybatis.dao.BookDAO;
import com.wangxin.ssm.mybatis.model.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class BookDAOTest {
    public static void main(String[] args) {
        ApplicationContext ac=
                new ClassPathXmlApplicationContext("spring-mybatis.xml");
        BookDAO dao=(BookDAO) ac.getBean("bookDAO");
        try{
//         //1 添加图书
//         //1.1 通过容器获得book对象
//             Book book = (Book) ac.getBean("book");
//         //1.2 设置book属性
//            book.setName("Effective Java中⽂版");
//             book.setPublisher("机械⼯业出版社");
//            book.setPrice(52.00);
//         //1.3 使⽤bookDAO对象的addBook⽅法添加图书
//            dao.addBook(book);


//         //2 更新数据库中已有图书的信息
//         // 2.1 获得book对象
//            Book book = (Book) ac.getBean("book");
//         //2.2 设置book属性,主键id⼀定要赋值
//            book.setId(4);
//            book.setName("Python编程-从⼊⻔到实践");
//            book.setPublisher("⼈⺠邮电出版社");
//            book.setPrice(89.00);
//         //2.3 使⽤bookDAO对象的updateBook⽅法修改图书
//            dao.updateBook(book);


//        //3 通过id删除图书,id必须为表中已有的图书id
//            dao.deleteBook(14);

//
//        //4 通过id查询图书
//        //4.1 通过bookDAO.findBookById⽅法查询图书,参数为已有图书的id
//            Book tempbook = dao.findBookById(4);
//        //4.2 打印查询结果
//            System.out.println("\n通过id查询图书:");
//            System.out.println(tempbook);


        //5 通过图书名称模糊查询图书
        //5.1 通过bookDAO.findBookByName⽅法模糊查询图书
        // 参数为已有图书的名称
            List<Book> bookList = dao.findBookByName("Spring");
        //5.2 打印查询结果
            System.out.println("\n\n名称有spring的图书:");
            for (Book newbook:bookList) {
                System.out.println(newbook);
            }

//            //6 查询图书
//            //6.1 通过bookDAO.findAllBook查询所有图书
//            List<Book> list=dao.findAllBook();
//            //jdk8 循环list
//            for(Book newbook:list){
//                System.out.println(newbook.toString());
//            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
