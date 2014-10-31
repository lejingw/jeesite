package com.thinkgem.jeesite.modules.operate.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thinkgem.jeesite.modules.sys.utils.DictUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import com.thinkgem.jeesite.modules.operate.entity.Sale;
import com.thinkgem.jeesite.modules.operate.service.SaleService;

/**
 * 销量Controller
 * @author lejingw
 * @version 2014-10-31
 */
@Controller
@RequestMapping(value = "${adminPath}/operate/sale")
public class SaleController extends BaseController {

	@Autowired
	private SaleService saleService;
	
	@ModelAttribute
	public Sale get(@RequestParam(required=false) String id) {
		if (StringUtils.isNotBlank(id)){
			return saleService.get(id);
		}else{
			return new Sale();
		}
	}

    @RequiresPermissions({"operate:sale:view:day"})
    @RequestMapping(value = {"day"})
    public String dayList(Sale sale, HttpServletRequest request, HttpServletResponse response, Model model){
        return list(sale, false, request, response, model);
    }

	@RequiresPermissions({"operate:sale:view:month"})
	@RequestMapping(value = {"month"})
	public String list(Sale sale, HttpServletRequest request, HttpServletResponse response, Model model){
        return list(sale, true, request, response, model);
    }

    private String list(Sale sale, boolean monthFlag, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user = UserUtils.getUser();
		if (!user.isAdmin()){
			sale.setCreateBy(user);
		}
        String channelAppKey = DictUtils.getDictValue(user.getLoginName(), "user_channel_mapping", "");
        sale.setSaleChannelType(channelAppKey);
        sale.setDayPattern(monthFlag?"'%Y-%m'":"'%Y-%m-%d'");
        Page<Sale> page = saleService.find(new Page<Sale>(request, response), sale);
        model.addAttribute("page", page);
        model.addAttribute("sale", sale);
		return "modules/" + "operate/saleList";
	}
}
