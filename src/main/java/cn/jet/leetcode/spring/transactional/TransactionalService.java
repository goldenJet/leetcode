package cn.jet.leetcode.spring.transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *    *@ClassName: TransactionalService
 *
 * @Description:
 * @Author: Jet.Chen
 * @Date: 2019-08-05 20:55
 * @Version: 1.0
 **/
@Service
public class TransactionalService {

    @Autowired
    CommonTransactionalService commonTransactionalService;

    @Autowired
    CustomerRepository customerRepository;

//    @Transactional(propagation = Propagation.SUPPORTS)
    @Transactional
    public void updateA() {
        commonTransactionalService.updateB();
        commonTransactionalService.updateC();
    }

    @Transactional
    public void updateD() {
        Customer customer = new Customer();
        customer.setName("D");
        customerRepository.save(customer);

        commonTransactionalService.updateB();
        commonTransactionalService.updateC();
    }

}
