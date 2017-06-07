package net.yuanmomo.springboot.test.dao;

import net.yuanmomo.springboot.BaseUnitTest;
import net.yuanmomo.springboot.bean.Demo;
import net.yuanmomo.springboot.bean.DemoParam;
import net.yuanmomo.springboot.business.mybatis.DemoBusiness;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Hongbin.Yuan on 2017-06-07 17:38.
 */
@Transactional(value = "txManager")
public class DemoDataSourceTest extends BaseUnitTest{
    @Autowired protected DemoBusiness demoBusiness = null;

    @Test
    public void testMultiDataSource(){
        try {
            Demo demo = new Demo();
            demo.setId(1L);
            demo.setNumber(100);
            demo.setVersion(999L);
            Assert.assertTrue(this.demoBusiness.insertSelective(demo) > 0);

            DemoParam demoParam = new DemoParam();
            demoParam.createCriteria();
            demoParam.setStart(0);
            demoParam.setStart(1);
            demoParam.setOrderByClause("id desc");

            List<Demo> demoList = this.demoBusiness.selectDemoList(demoParam);
            Assert.assertTrue(demoList.size() == 1);
            Assert.assertTrue(demoList.get(0) != null);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}
