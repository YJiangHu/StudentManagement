
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manager.dao.StudentDetailMapper;
import com.manager.dao.StudentMapper;
import com.manager.domain.Student;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PageTest extends BaseTest {

    @Autowired
    StudentMapper studentMapper;
    @Autowired
    StudentDetailMapper studentDetailMapper;
    @Test
    public void test() {
        PageHelper.startPage(2, 4);
        List<Student> list = studentMapper.getAllStudent();
        PageInfo pageInfo = new PageInfo(list);
        System.out.println("总 " + pageInfo.getSize() + " 页");
        System.out.println("当前第 " + pageInfo.getPageNum() + " 页");
        System.out.println("总共 " + pageInfo.getTotal() + " 条记录");
        System.out.println(pageInfo.isHasNextPage());
        System.out.println(pageInfo.isHasPreviousPage());
        System.out.println(pageInfo.isIsFirstPage());
        System.out.println(pageInfo.isIsLastPage());
    }
//
//    @Test
//    public void test2() {
//        Student student = new Student();
//        student.setId(117);
//        student.setName("胡远江");
//        student.setSex("男");
//        student.setClazz("1501");
//        student.setPhone(1654849);
//        studentMapper.insertStudent(student);
//        System.out.println(studentMapper.getStudent(117));
//    }

    @Test
    public void test3() {
        System.out.println(studentDetailMapper.getStudentDetail(102));
    }

    @Test
    public void test4() {
        Student student = new Student();
        student.setId(112);
        student.setName("赵江");
        student.setSex('女');
        student.setClazz("1501");
        student.setPhone(1654849);
        studentMapper.updateStudent(student, student.getId());
        System.out.println(studentMapper.getStudent(112));
    }
}
