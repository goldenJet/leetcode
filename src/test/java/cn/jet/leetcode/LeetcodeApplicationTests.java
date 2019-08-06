package cn.jet.leetcode;

import cn.jet.leetcode.spring.transactional.TransactionalService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LeetcodeApplicationTests {

    @Autowired
    TransactionalService transactionalService;

    @Test
    public void contextLoads() {
//        transactionalService.updateA();
        transactionalService.updateD();
    }

}
