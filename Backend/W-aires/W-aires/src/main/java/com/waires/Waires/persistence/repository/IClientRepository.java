package com.waires.Waires.persistence.repository;

import com.waires.Waires.persistence.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IClientRepository extends JpaRepository<Client, String> {

    @Query(value = "SELECT client FROM Client client WHERE client.numDocumento = :numDocumento", nativeQuery = false)
    public Optional<Client> obtenerClienteDocumento(@Param("numDocumento") String numDocumento);
}
