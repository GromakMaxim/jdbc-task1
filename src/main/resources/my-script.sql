select product_name
from orders
         join customers on customer_id = customers.id
where customers.name like :name