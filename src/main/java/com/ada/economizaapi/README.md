# Economiza API

## Rotas:

## - Produto:

-----

## GET /produto

### ENTRADA: --

### SAÍDA:
STATUS 200 - OK
#### - Lista de todos os produtos

-----
## GET /produto/id

### ENTRADA: --

### SAÍDA:
STATUS 200 - OK

```
{
    "id": 1,
    "nome": "produto",
    "marca": "marca",
    "descricao": "Um produto modelo"
}
```

---

## POST /produto

### ENTRADA:

```
{
    "nome": "produto",
    "marca": "marca",
    "descricao": "Um produto modelo"
}
```

### SAÍDA:
STATUS 201 - CREATED

```
{
    "id": 1,
    "nome": "produto",
    "marca": "marca",
    "descricao": "Um produto modelo"
}
```

---

## PUT /produto/id

### ENTRADA:

```
{
    "nome": "produto alterado",
    "marca": "marca",
    "descricao": "Um produto modelo"
}
```

### SAÍDA:
STATUS 200 - OK

```

{
    "id": 1,
    "nome": "produto alterado",
    "marca": "marca",
    "descricao": "Um produto modelo"
}
```
-----
## DELETE /produto/id

### ENTRADA: --

### SAÍDA:
STATUS 204 - NO CONTENT


## - Mercado:

-----

## GET /mercado

### ENTRADA: --

### SAÍDA:
STATUS 200 - OK
#### - Lista de todos os mercados

-----
## GET /mercado/id

### ENTRADA: --

### SAÍDA:
STATUS 200 - OK

```
{
    "id": 1,
    "nome": "mercado modelo",
    "localizacao": {
        "id": 2,
        "coordenadas": "-35.88554745853871, -7.227417342275939"
    }
}
```

---

## POST /mercado

### ENTRADA:
OBS.: A localização é uma String com as coordenadas composta da seguinte forma:
"longitude, latitude" (ordem inversa das coordenadas do maps, que mostra latitude, longitude)

OBS 2: Caso queira realizar a buscar das coordenadas no google maps para conferência durante a correção, só inverter e colocar na busca do maps sem as aspas (ex.: -7.227417342275939, -35.88554745853871)
```
{
    "nome": "mercado",
    "localizacao": "-35.88554745853871, -7.227417342275939",
}
```

### SAÍDA:
STATUS 201 - CREATED

```
{
    "id": 1,
    "nome": "mercado modelo",
    "localizacao": {
        "id": 1,
        "coordenadas": "-35.88554745853871, -7.227417342275939"
    }
}
```

---

## PUT /mercado/id

### ENTRADA:

```
{
    "nome": "mercado novo",
    "localizacao": "-35.88554745853871, -7.227417342275939",
}
```

### SAÍDA:
STATUS 200 - OK

```

{
    "id": 1,
    "nome": "mercado atualizado",
    "localizacao": {
        "id": 1,
        "coordenadas": "-35.88554745853871, -7.227417342275939"
    }
}
```
-----
## DELETE /mercado/id

### ENTRADA: --

### SAÍDA:
STATUS 204 - NO CONTENT

## - Pessoa:

-----
## GET /pessoa/id

### ENTRADA: --

### SAÍDA:
STATUS 200 - OK

```
{
    "id": 1,
    "nome": "João",
    "localizacao": {
        "id": 1,
        "coordenadas": "-35.87651926331219, -7.221210343867755"
    },
    "custoPorDistancia": 2.4
}
```

---

## POST /pessoa

### ENTRADA:

```
{
    "nome": "João",
    "localizacao": "-35.87651926331219, -7.221210343867755",
    "custoPorDistancia": 2.4
}
```

### SAÍDA:
STATUS 201 - CREATED

```
{
    "id": 1,
    "nome": "João",
    "localizacao": {
        "id": 1,
        "coordenadas": "-35.87651926331219, -7.221210343867755"
    },
    "custoPorDistancia": 2.4
}
```

---

## PUT /pessoa/id

### ENTRADA:

```
{
    "nome": "João",
    "localizacao": "-35.87651926331219, -7.221210343867755",
    "custoPorDistancia": 2.7
}
```

### SAÍDA:
STATUS 200 - OK

```

{
    "id": 1,
    "nome": "João",
    "localizacao": {
        "id": 1,
        "coordenadas": "-35.87651926331219, -7.221210343867755"
    },
    "custoPorDistancia": 2.7
}
```
-----
## DELETE /pessoa/id

### ENTRADA: --

### SAÍDA:
STATUS 204 - NO CONTENT