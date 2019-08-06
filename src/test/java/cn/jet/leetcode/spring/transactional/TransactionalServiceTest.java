package cn.jet.leetcode.spring.transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *    *@ClassName: TransactionalServiceTest
 *
 * @Description:
 * @Author: Jet.Chen
 * @Date: 2019-08-05 21:03
 * @Version: 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionalServiceTest {

    @Autowired
    TransactionalService transactionalService;

    @Test
    public void test() {
        transactionalService.updateD();
    }

}
