/*
 * Copyright © 2013 VillageReach. All Rights Reserved. This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0.
 *
 * If a copy of the MPL was not distributed with this file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.openlmis.shipment;

import lombok.Data;
import org.openlmis.core.exception.DataException;
import org.openlmis.order.dto.ShipmentLineItemDTO;
import org.openlmis.shipment.domain.ShipmentLineItem;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.apache.commons.lang3.StringUtils.isBlank;

@Data
@Component
public class ShipmentLineItemTransformer {

  public ShipmentLineItem transform(ShipmentLineItemDTO shipmentLineItemDTO,
                                    String packedDateFormat,
                                    String shippedDateFormat, Date creationDate) throws DataException {

    checkMandatory(shipmentLineItemDTO);

    ShipmentLineItem lineItem = new ShipmentLineItem();

    try {
      setMandatoryFields(lineItem, shipmentLineItemDTO);
      setOptionalFields(lineItem, shipmentLineItemDTO, packedDateFormat, shippedDateFormat, creationDate);
    } catch (Exception e) {
      throw new DataException("wrong.data.type");
    }

    return lineItem;
  }

  private void setOptionalFields(ShipmentLineItem lineItem, ShipmentLineItemDTO dto,
                                 String packedDateFormat, String shippedDateFormat, Date creationDate)
    throws ParseException {

    if (!isBlank(dto.getCost())) {
      lineItem.setCost(new BigDecimal(dto.getCost().trim()));
    }

    Date packedDate = (!isBlank(dto.getPackedDate())) ? parseDate(packedDateFormat, dto.getPackedDate().trim()) : creationDate;
    lineItem.setPackedDate(packedDate);

    if (!isBlank(dto.getShippedDate())) {
      lineItem.setShippedDate(parseDate(shippedDateFormat, dto.getShippedDate()));
    }
  }

  private Date parseDate(String dateFormat, String date) throws ParseException {
    if (dateFormat.length() != date.length()) {
      throw new DataException("wrong.data.type");
    }
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
    simpleDateFormat.setLenient(false);
    return simpleDateFormat.parse(date);
  }

  private void setMandatoryFields(ShipmentLineItem lineItem, ShipmentLineItemDTO shipmentLineItemDTO) {
    lineItem.setProductCode(shipmentLineItemDTO.getProductCode().trim());
    lineItem.setOrderId(Long.valueOf(shipmentLineItemDTO.getOrderId().trim()));
    lineItem.setQuantityShipped(Integer.valueOf(shipmentLineItemDTO.getQuantityShipped().trim()));
  }

  private void checkMandatory(ShipmentLineItemDTO shipmentLineItemDTO) {
    if (isBlank(shipmentLineItemDTO.getProductCode()) ||
      isBlank(shipmentLineItemDTO.getOrderId()) ||
      isBlank(shipmentLineItemDTO.getQuantityShipped())) {

      throw new DataException("mandatory.field.missing");
    }
  }
}
