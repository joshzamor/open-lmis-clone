/*
 * This program is part of the OpenLMIS logistics management information system platform software.
 * Copyright © 2013 VillageReach
 *
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU Affero General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 *  
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Affero General Public License for more details.
 * You should have received a copy of the GNU Affero General Public License along with this program.  If not, see http://www.gnu.org/licenses.  For additional information contact info@OpenLMIS.org. 
 */

package org.openlmis.web.form;

import org.openlmis.core.domain.FacilityTypeApprovedProduct;

import java.util.ArrayList;

/**
 * FacilityTypeApprovedProduct represents the product approved by the facility type for a particular program. Also defines contract for upload of this
 * mapping. Facility type, program code, product code and maximum months of stock that can be stocked for this product by
 * the facility type is mandatory for upload of such mapping.
 */
public class FacilityTypeApprovedProductList extends ArrayList<FacilityTypeApprovedProduct> {

}