package cn.jet.leetcode.spring.transactional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Integer> {
}
