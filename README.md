# e-commerce
Simulacion de carrito de compras para prueba tecnica. 

Todo lo desarrollado se encuentra en branch development.
Con 'docker compose up -d' iniciamos los contenedores. 

Servicios desarrollados: 
POST http://localhost:8080/new-cart
Query Params: userId - cartType

DELETE http://localhost:8080/{productId}/delete/{userId}
Query Params: userId
Path variable: productId

GET http://localhost:8080/product-list

GET http://localhost:8080/orders
Query Params: userId

POST http://localhost:3000/make-order
Query Params: userId



