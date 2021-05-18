package com.squadatena.wishlist.controller;
import static org.assertj.core.api.Assertions.assertThat;

import com.squadatena.wishlist.entity.Client;
import com.squadatena.wishlist.service.ClientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;



@SpringBootTest
@Transactional
@RunWith(SpringRunner.class)

public class ClientServiceTest {

@Autowired
ClientService clientService;

    //Salvar Cliente
    @Test
    public void saveClient(){

        //Preciso de salvar um cliente no banco
        Client client = new Client();
        client.setName("Poliana Pereira Andrade");
        client.setCpf("07249755609");
        client.setAddress("Rua Ovideo Bradamante Toledo");

        //Quando cliente for salvo
        Client saveClient = clientService.saveClient(client);

        //Resultado não é vazio
        assertThat(saveClient).isNotNull();
        assertThat(saveClient.getId()).isNotNull();
        assertThat(saveClient.getId()).isEqualTo(1);
    }

    //Buscar lista de clientes
    @Test
    public void getClientID(){

        List<Client> list = clientService.clientList();

        //Resultado retornar uma lista de cliente
        assertThat(clientService.clientList()).isEqualTo(list);

    }

    //Buscar o cliente dado um id
    @Test
    public void searchClientByID(){

        //Quando cliente for salvo
        Optional<Client> searchClient = clientService.searchById(1L);

            if (searchClient.isPresent()) {

                //Resultado retornar uma lista de cliente
                assertThat(clientService.searchById(1L)).isEqualTo(searchClient);
            }
    }
}

