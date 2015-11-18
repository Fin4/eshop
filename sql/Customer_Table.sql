SELECT eshop.products.name,  SUM(ORDER_ITEMS.QUANTITY) AS Quantity FROM
  eshop.order_items INNER JOIN eshop.products ON eshop.order_items.product_id = eshop.products.id
  INNER JOIN  eshop.orders ON eshop.order_items.order_id = eshop.orders.id
WHERE eshop.orders.customer_id = 1
GROUP BY eshop.products.name