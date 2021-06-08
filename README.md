# spring-challenge

### Tecnologias
- Java11
- Spring-Boot 2.5.0

### Rodando a aplicação
- Para iniciar a aplicação a partir da linha de comando basta estar no diretório principal e rodar o seguinte comando: 
  ####   `mvn spring-boot:run`
  
### Requisições
#### Criar um comprador
- Para criar um comprador é necessário passar seu nome na URL
  ##### `POST localhost:8080/buyer/createBuyer?name=buyer1`

#### Criar um vendedor
- Para criar um vendedor é necessário passar seu nome na URL
  #####  `POST localhost:8080/seller/createSeller?name=a`

#### Seguir um vendedor
- Para seguir um vendedor é necessário passar o ID do comprador e o ID do vendedor na URL (ambos IDs são fornecidos ao criar os usuários)
  ##### `POST localhost:8080/buyer/1/follow/1/`
  
#### Contagem de seguidores de um vendedor
- Para verificar a contagem de seguidores de um vendedor é necessário ter o ID do vendedor na URL
  ##### `GET localhost:8080/seller/1/followers/count`

#### Lista de compradores seguidores de um vendedor
- Para verificar a lista de seguidores de um vendedor é necessário ter o ID do vendedor e a definição da ordem ("name_asc" ou "name_desc") na URL
  ##### `GET localhost:8080/seller/1/followers/list?order=name_asc`

#### Lista de vendedores seguidos por um comprador
- Para verificar a lista vendedores seguidos por um comprador é necessário ter o ID do comprador e a definição da ordem ("name_asc" ou "name_desc") na URL
  ##### `GET localhost:8080/buyer/1/following/list?order=name_desc`
  
#### Criação de uma publicação por um vendedor
- Para um vendedor criar a publicação de um produto é necessário usar a seguinte URL e o seguinte body
  ##### `POST localhost:8080/products/newpost`
  ##### 
        { 
            "sellerId": "1",
            "date": "12-12-2018",
            "productName": "produto1",
            "productType": "tipo teste",
            "productBrand": "marca teste",
            "productColor": "cor teste",
            "productNotes": "notes teste",
            "category": "2",
            "price": "20.0"
        }
        

#### Lista de posts dos vendedores que um comprador segue
- Para verificar a lista de posts dos vendedores que um comprador segue é necessário ter o ID do comprador e a definição da ordem ("date_asc" ou "date_desc") na URL
  ##### `GET localhost:8080/products/followed/1/list?order=date_asc`
  
#### Deixar de seguir um vendedor
- Para deixar de seguir um vendedor é necessário passar o ID do comprador e o ID do vendedor na URL (ambos IDs são fornecidos ao criar os usuários)
  ##### `POST localhost:8080/buyer/1/unfollow/1`  
  
  
#### Criação de uma publicação promocional por um vendedor
- Para um vendedor criar a publicação de um produto é necessário usar a seguinte URL e o seguinte body  
  #### `POST localhost:8080/products/newpromopost`
  #### 
      { 
        "sellerId": "1",
        "date": "12-12-2018",
        "productName": "produto1",
        "productType": "tipo teste",
        "productBrand": "marca teste",
        "productColor": "cor teste",
        "productNotes": "notes teste",
        "category": "2",
        "price": "20.0",
        "haspromo": true,
        "discount": "0.25"
    }
    

#### Contagem de publicações promocionais de um vendedor
- Para verificar a contagem publicações promocionais de um vendedor é necessário ter o ID do vendedor na URL
  ##### `GET localhost:8080/products/1/countPromo/`

#### Lista de posts promocionais de um determinado vendedor
- Para verificar a lista de posts promocionais de um determinado vendedor é necessário ter seu ID na URL
  ##### `GET localhost:8080/products/1/list/`
  


  
