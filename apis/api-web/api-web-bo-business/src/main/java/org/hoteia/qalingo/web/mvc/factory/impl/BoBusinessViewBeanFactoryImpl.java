/**
 * Most of the code in the Qalingo project is copyrighted Hoteia and licensed
 * under the Apache License Version 2.0 (release version 0.7.0)
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *                   Copyright (c) Hoteia, 2012-2013
 * http://www.hoteia.com - http://twitter.com/hoteia - contact@hoteia.com
 *
 */
package org.hoteia.qalingo.web.mvc.factory.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.hoteia.qalingo.core.domain.Localization;
import org.hoteia.qalingo.core.domain.enumtype.BoUrls;
import org.hoteia.qalingo.core.i18n.enumtype.ScopeWebMessage;
import org.hoteia.qalingo.core.pojo.RequestData;
import org.hoteia.qalingo.core.web.mvc.factory.impl.BackofficeViewBeanFactoryImpl;
import org.hoteia.qalingo.core.web.mvc.viewbean.MenuViewBean;

/**
 * 
 */
public class BoBusinessViewBeanFactoryImpl extends BackofficeViewBeanFactoryImpl {

	/**
	 * @throws Exception 
	 * 
	 */
	@Override
	public List<MenuViewBean> buildMenuViewBeans(final RequestData requestData) throws Exception {
		final HttpServletRequest request = requestData.getRequest();
		final Localization localization = requestData.getMarketAreaLocalization();
		final Locale locale = localization.getLocale();
		final String currentUrl = requestUtil.getCurrentRequestUrl(request);
		
		final List<MenuViewBean> menuViewBeans = new ArrayList<MenuViewBean>();
		
		MenuViewBean menu = new MenuViewBean();
		if(currentUrl.contains("home")){
			menu.setCssClass("active");
		}
		menu.setCssIcon("icon-home");
		menu.setName(getSpecificMessage(ScopeWebMessage.HEADER_MENU, "home", locale));
		menu.setUrl(backofficeUrlService.generateUrl(BoUrls.HOME, requestData));
		menuViewBeans.add(menu);

		menu = new MenuViewBean();
		if(currentUrl.contains("catalog")){
			menu.setCssClass("dropdown active");
		} else {
			menu.setCssClass("dropdown");
		}
		menu.setCssIcon("icon-sitemap");
		menu.setName("Catalog");
		menuViewBeans.add(menu);
		
		MenuViewBean subMenu = new MenuViewBean();
		subMenu.setName("Manage Master Catalog");
		subMenu.setUrl(backofficeUrlService.generateUrl(BoUrls.MASTER_CATALOG, requestData));
		menu.getSubMenus().add(subMenu);
		
		subMenu = new MenuViewBean();
		subMenu.setName("Manage Virtual Catalog");
		subMenu.setUrl(backofficeUrlService.generateUrl(BoUrls.VIRTUAL_CATALOG, requestData));
		menu.getSubMenus().add(subMenu);
		
        menu = new MenuViewBean();
        menu.setCssIcon("icon-building");
        menu.setName("Warehouse");
        menu.setUrl(backofficeUrlService.generateUrl(BoUrls.WAREHOUSE_LIST, requestData));
        menuViewBeans.add(menu);
        
        menu = new MenuViewBean();
        menu.setCssIcon("icon-usd");
        menu.setName("Price");
        menu.setUrl(backofficeUrlService.generateUrl(BoUrls.PRICE_LIST, requestData));
        menuViewBeans.add(menu);
        
		menu = new MenuViewBean();
		menu.setCssIcon("icon-money");
		menu.setName("Promotion");
		menu.setUrl(backofficeUrlService.generateUrl(BoUrls.RULE_LIST, requestData));
		menuViewBeans.add(menu);

		menu = new MenuViewBean();
		menu.setCssIcon("icon-truck");
		menu.setName("Shipping");
		menu.setUrl(backofficeUrlService.generateUrl(BoUrls.DELIVERY_METHOD_LIST, requestData));
		menuViewBeans.add(menu);
		
		menu = new MenuViewBean();
		menu.setCssIcon("icon-shopping-cart");
		menu.setName("Orders");
		menu.setUrl(backofficeUrlService.generateUrl(BoUrls.ORDER_LIST, requestData));
		menuViewBeans.add(menu);
		
		menu = new MenuViewBean();
		menu.setCssIcon("icon-group");
		menu.setName("Customers");
		menu.setUrl(backofficeUrlService.generateUrl(BoUrls.CUSTOMER_LIST, requestData));
		menuViewBeans.add(menu);
		
		menu = new MenuViewBean();
        menu.setCssIcon(" icon-map-marker");
		menu.setName("Retailers");
		menu.setUrl(backofficeUrlService.generateUrl(BoUrls.RETAILER_LIST, requestData));
        menuViewBeans.add(menu);
		
		return menuViewBeans;
	}
	
}