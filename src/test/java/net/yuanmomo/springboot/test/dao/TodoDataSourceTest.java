package net.yuanmomo.springboot.test.dao;

import net.yuanmomo.springboot.BaseUnitTest;
import net.yuanmomo.springboot.bean.ToDo;
import net.yuanmomo.springboot.bean.ToDoParam;
import net.yuanmomo.springboot.business.mybatis.ToDoBusiness;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Hongbin.Yuan on 2017-06-07 17:38.
 */
@Transactional(value = "todoTxManager")
public class TodoDataSourceTest extends BaseUnitTest{
    @Autowired protected ToDoBusiness toDoBusiness = null;

    @Test
    public void testMultiDataSource(){
        try {
            ToDo todo = new ToDo();
            todo.setId(1L);
            todo.setRemark(888L);
            todo.setToDo(7777);
            Assert.assertTrue(this.toDoBusiness.insertSelective(todo) > 0);

            ToDoParam toDoParam = new ToDoParam();
            toDoParam.createCriteria();
            toDoParam.setStart(0);
            toDoParam.setStart(1);
            toDoParam.setOrderByClause("id desc");
            List<ToDo> toDoList = this.toDoBusiness.selectToDoList(toDoParam);
            Assert.assertTrue(toDoList.size() == 1);
            Assert.assertTrue(toDoList.get(0) != null);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}
