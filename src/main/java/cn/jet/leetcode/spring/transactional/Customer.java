package cn.jet.leetcode.spring.transactional;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 *    *@ClassName: Customer
 *
 * @Description:
 * @Author: Jet.Chen
 * @Date: 2019-08-05 20:41
 * @Version: 1.0
 **/
@Entity
@Data
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String name;

    private  String remark;
}
