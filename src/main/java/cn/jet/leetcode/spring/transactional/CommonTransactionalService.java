package cn.jet.leetcode.spring.transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 *    *@ClassName: CommonTransactionalService
 *
 * @Description:
 * @Author: Jet.Chen
 * @Date: 2019-08-05 20:40
 * @Version: 1.0
 **/
@Service
public class CommonTransactionalService {

    @Autowired
    CustomerRepository customerRepository;

    /**
     * @Description: 事务 B  
    * @Param: []
     * @return: void  
    * @Author: Jet.Chen
     * @Date: 2019-08-05 20:55 
    */
//    @Transactional(propagation = Propagation.SUPPORTS)
//    @Transactional(propagation = Propagation.MANDATORY)
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateB(){
        Optional<Customer> customerOpt = customerRepository.findById(2);
        if (!customerOpt.isPresent()) return;
        Customer customer = customerOpt.get();
        customer.setRemark("update B");
        customerRepository.save(customer);
    }

   /**
    * @Description: 事务 C  
   * @Param: []
    * @return: void  
   * @Author: Jet.Chen
    * @Date: 2019-08-05 20:56 
   */
//    @Transactional(propagation = Propagation.SUPPORTS)
   @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateC(){
        Optional<Customer> customerOpt = customerRepository.findById(3);
        if (!customerOpt.isPresent()) return;
        Customer customer = customerOpt.get();
        customer.setRemark("update C");
        customerRepository.save(customer);
        int a = 1/0;
    }

}
