/**
 * Most of the code in the Qalingo project is copyrighted Hoteia and licensed
 * under the Apache License Version 2.0 (release version 0.7.0)
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *                   Copyright (c) Hoteia, 2012-2013
 * http://www.hoteia.com - http://twitter.com/hoteia - contact@hoteia.com
 *
 */
package org.hoteia.qalingo.core.solr.service;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrServerException;
import org.hoteia.qalingo.core.domain.ProductMarketing;
import org.hoteia.qalingo.core.solr.response.ProductMarketingResponseBean;

public interface ProductMarketingSolrService {

	/**
	 * Adds the or update product marketing.
	 *
	 * @param productMarketing the product marketing
	 * @throws SolrServerException the solr server exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	void addOrUpdateProductMarketing(ProductMarketing productMarketing) throws SolrServerException, IOException;
	
	/**
	 * Search product.
	 *
	 * @param searchBy the search by
	 * @param searchText the search text
	 * @param facetField the facet field
	 * @return the product response bean
	 * @throws SolrServerException the solr server exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	ProductMarketingResponseBean searchProductMarketing(String searchBy,String searchText, String facetField) throws SolrServerException, IOException;
	
	/**
	 * Search product.
	 *
	 * @return the product response bean
	 * @throws SolrServerException the solr server exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	ProductMarketingResponseBean searchProductMarketing() throws SolrServerException, IOException;
	
}