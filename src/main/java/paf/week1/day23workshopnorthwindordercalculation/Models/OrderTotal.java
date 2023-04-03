package paf.week1.day23workshopnorthwindordercalculation.Models;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderTotal {
    private int orderId;
    private Date orderDate;
    private int customerId;
    private float quantity;    
    private float unitPrice;
    private float discount;
    private String productName;
    private float standardCost;
    private float subTotal;
    private float subCostPrice;
    private float grandTotal;
    private float grandCostPrice;
}
