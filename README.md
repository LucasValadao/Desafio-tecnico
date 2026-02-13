# Desafio-tecnico
Desafio técnico referente a vaga de Desenvolvedor(a) Backend Java Pleno

## 1 - Clonar o projeto
```bash 
git clone https://github.com/LucasValadao/Desafio-tecnico.git
cd desafio-tecnico
```

## 2 - Buildar o container do Docker
 ```bash 
 docker compose up --build
 ```

## 3 - Acessar o Swagger no localhost para testar os endpoints criados.
http://localhost:8080/swagger-ui/index.html

## 4 - Em caso de erro ao montar o container, repetir o passo da montagem.
```bash 
docker compose down
```
E depois novamente:
```bash 
docker compose up --build
```

E tentar acessar novamente o http://localhost:8080/swagger-ui/index.html

## Exemplo de body funcional para o endpoint POST /coupon:
```json
{
    "code": "ABC-127##",
    "description": "Teste2",
    "discountValue": 10,
    "expirationDate": "2026-11-04T17:14:45.180Z",
    "published": true
}
```
