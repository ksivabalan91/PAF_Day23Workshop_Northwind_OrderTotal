-- day 23 workshop
use northwind;

select od.id as order_id, od.order_date, od.customer_id, odd.quantity, odd.unit_price, odd.discount, pd.product_name, pd.standard_cost,
odd.quantity*odd.unit_price*(1-odd.discount) as sub_total,
odd.quantity*pd.standard_cost as sub_cost_price,
sum(sub_total) over (partition by od.id) as grand_total,
sum(sub_cost_price) over (partition by od.id) as grand_cost_price
from orders as od
left join order_details as odd
on od.id=odd.order_id
left join  products as pd
on pd.id=odd.product_id
where od.id=31;

select od.id as order_id, od.order_date, od.customer_id, odd.quantity, odd.unit_price, odd.discount, pd.product_name, pd.standard_cost,
odd.quantity*odd.unit_price*(1-odd.discount) as sub_total,
odd.quantity*pd.standard_cost as sub_cost_price,
sum(odd.quantity*odd.unit_price*(1-odd.discount)) over (partition by od.id) as grand_total,
sum(odd.quantity*pd.standard_cost) over (partition by od.id) as grand_cost_price
from orders as od
left join order_details as odd
on od.id=odd.order_id
left join  products as pd
on pd.id=odd.product_id
where od.id=31;