package net.yuanmomo.springboot.test.dao;

import net.yuanmomo.springboot.Application;
import net.yuanmomo.springboot.bean.Demo;
import net.yuanmomo.springboot.bean.ToDo;
import net.yuanmomo.springboot.business.mybatis.DemoBusiness;
import net.yuanmomo.springboot.business.mybatis.ToDoBusiness;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Hongbin.Yuan on 2017-06-07 17:38.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class MultiDataSourceTest  {
    @Autowired protected DemoBusiness demoBusiness = null;
    @Autowired protected ToDoBusiness toDoBusiness = null;

    @Test
    public void testMultiDataSource(){
        try {
            Demo demo = new Demo();
            demo.setId(1L);
            demo.setNumber(100);
            demo.setVersion(999L);
            Assert.assertTrue(this.demoBusiness.insertSelective(demo) > 0);

            Demo insertedDemo = this.demoBusiness.getDemoByKey(1L);
            Assert.assertTrue(insertedDemo != null);
            Assert.assertTrue(insertedDemo.equals(demo));

            ToDo todo = new ToDo();
            todo.setId(1L);
            todo.setRemark(888L);
            todo.setToDo(7777);
            Assert.assertTrue(this.toDoBusiness.insertSelective(todo) > 0);

            ToDo insertedTodo = this.toDoBusiness.getToDoByKey(1L);
            Assert.assertTrue(insertedTodo != null);
            Assert.assertTrue(insertedTodo.equals(todo));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}
