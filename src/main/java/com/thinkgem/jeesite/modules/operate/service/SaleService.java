package com.thinkgem.jeesite.modules.operate.service;

import com.thinkgem.jeesite.modules.operate.dao.MyBatisSaleDao;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.BaseService;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.operate.entity.Sale;
import com.thinkgem.jeesite.modules.operate.dao.SaleDao;

/**
 * 销量Service
 * @author lejingw
 * @version 2014-10-31
 */
@Component
@Transactional(readOnly = true)
public class SaleService extends BaseService {

	@Autowired
	private SaleDao saleDao;
    @Autowired
    private MyBatisSaleDao myBatisSaleDao;
	
	public Sale get(String id) {
		return saleDao.get(id);
	}
	
	public Page<Sale> find(Page<Sale> page, Sale sale) {
        sale.setPage(page);
		page.setList(myBatisSaleDao.find(sale));
        return page;

//		DetachedCriteria dc = saleDao.createDetachedCriteria();
//		if (StringUtils.isNotEmpty(sale.getName())){
//			dc.add(Restrictions.like("name", "%"+sale.getName()+"%"));
//		}
//		dc.add(Restrictions.eq(Sale.FIELD_DEL_FLAG, Sale.DEL_FLAG_NORMAL));
//		dc.addOrder(Order.desc("id"));
//		return saleDao.find(page, dc);
	}
	
}
