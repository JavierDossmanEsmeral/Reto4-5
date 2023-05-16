package com.grupoG32.reto4.repository;

import com.grupoG32.reto4.model.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel,Integer> {

    @Query(value = "SELECT client.*,count(*) AS count_status FROM client\n" +
            "INNER JOIN reservation\n" +
            "ON client.id_client = reservation.id_client\n" +
            "WHERE status = 'completed'\n" +
            "GROUP BY client.id_client\n" +
            "ORDER BY count_status DESC",nativeQuery = true)
    List<ClientModel> reportClient();
}
