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
        assertThat(saveClient.getName()).isEqualTo("Poliana Pereira Andrade");
        assertThat(saveClient.getAddress()).isEqualTo("Rua Ovideo Bradamante Toledo");
        assertThat(saveClient.getCpf()).isEqualTo("07249755609");
    }

    //Buscar lista de clientes
    @Test
    public void getClientID(){

        Client client = new Client();
        client.setName("Poliana Pereira Andrade");
        client.setCpf("07249755609");
        client.setAddress("Rua Ovideo Bradamante Toledo");

        Client saveClient = clientService.saveClient(client);

        List<Client> list = clientService.clientList();

        //Resultado retornar uma lista de cliente
        assertThat(list.contains(saveClient)).isTrue();

    }

    //Buscar o cliente dado um id
    @Test
    public void searchClientByID(){

        Client client = new Client();
        client.setName("Poliana Pereira Andrade");
        client.setCpf("07249755609");
        client.setAddress("Rua Ovideo Bradamante Toledo");

        Client saveClient = clientService.saveClient(client);
        Optional<Client> foundClient = clientService.searchById(client.getId());

        assertThat(foundClient.get()).isEqualTo(client);
    }

    //Buscar o cliente dado um id
    @Test
    public void updateClientByID(){

        Client client = new Client();
        client.setName("Poliana Pereira Andrade");
        client.setCpf("07249755609");
        client.setAddress("Rua Ovideo Bradamante Toledo");

        Client saveClient = clientService.saveClient(client);

        Client client1 = new Client();
        client1.setName("Maria");
        client1.setCpf("07249755609");
        client1.setAddress("Rua Ovideo Bradamante Toledo");

        Client saveClient1 = clientService.updateClient(client1);

        assertThat(saveClient1.getName()).isEqualTo("Maria");
    }
}

