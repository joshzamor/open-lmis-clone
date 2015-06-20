/*
 * This program is part of the OpenLMIS logistics management information system platform software.
 * Copyright © 2013 VillageReach
 *
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU Affero General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 *  
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Affero General Public License for more details.
 * You should have received a copy of the GNU Affero General Public License along with this program.  If not, see http://www.gnu.org/licenses.  For additional information contact info@OpenLMIS.org. 
 */

package org.openlmis.core.upload;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openlmis.core.domain.ProductCategory;
import org.openlmis.core.service.ProductCategoryService;
import org.openlmis.db.categories.UnitTests;
import org.openlmis.upload.model.AuditFields;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
@Category(UnitTests.class)
public class ProductCategoryPersistenceHandlerTest {



  @Test
  public void shouldSaveImportedProductCategory() throws Exception {
    ProductCategoryService productCategoryService = mock(ProductCategoryService.class);
    ProductCategory productCategory = new ProductCategory();

    new ProductCategoryPersistenceHandler(productCategoryService).execute(productCategory, 0, new AuditFields(1L, null));
    verify(productCategoryService).save(productCategory);
  }
}

