#language:es
#encoding:UTF-8
#Author:japacheco914@gmail.com

Característica: Yo como usuario de la pagina Saucedemo quiero validar el correcto proceso de compra de un articulo


 Antecedentes:
   Dado se encuentre en la pagina inicial


Escenario: Deseo validar el correcto funcionamiento de la pagina home
   Cuando se ingresan las credenciales registradas
   Entonces puede ver todos los productos disponibles


Escenario: Deseo agregar un producto al carrito de compras y validar que fue agregado
  Cuando se agrega un producto de la pagina al carrito
  Entonces se valida que el producto en el carrito corresponde con el agregado


 Escenario: Deseo realizar la compra del producto y me sea enviado
   Cuando se realiza el proceso de checkout para la compra del producto
   Entonces se valida el precio final sea el correcto
   Y se recibe un mensaje de compra exitosa