Essa é uma API REST que permite criar, ler, atualizar e deletar informações de pessoas. A entidade de pessoa possui os atributos id, nome, data de nascimento e endereços. A entidade de endereço possui os atributos id, logradouro, cep, número, cidade e um indicador se é o endereço principal.

Endpoints:

    GET /pessoas: retorna uma lista de todas as pessoas
    GET /pessoas/{id}: retorna a pessoa com o id especificado
    POST /pessoas: cria uma nova pessoa com as informações enviadas no corpo da requisição
    PUT /pessoas/{id}: atualiza a pessoa com o id especificado com as informações enviadas no corpo da requisição
    DELETE /pessoas/{id}: deleta a pessoa com o id especificado
    GET /pessoas/{id}/enderecos: retorna a lista de endereços da pessoa com o id especificado
    POST /pessoas/{id}/enderecos: adiciona um novo endereço à pessoa com o id especificado, com as informações enviadas no corpo da requisição
    PUT /pessoas/{id}/enderecos/{idEndereco}: atualiza o endereço com o idEndereco da pessoa com o id especificado com as informações enviadas no corpo da requisição
    DELETE /pessoas/{id}/enderecos/{idEndereco}: deleta o endereço com o idEndereco da pessoa com o id especificado