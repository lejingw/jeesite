package com.thinkgem.jeesite.modules.operate.dao;

import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.operate.entity.Sale;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lejingw on 2014/10/31.
 */
@MyBatisDao
public interface MyBatisSaleDao {
    List<Sale> find(Sale sale);
}
