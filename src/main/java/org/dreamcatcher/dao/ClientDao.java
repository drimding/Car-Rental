package org.dreamcatcher.dao;

import org.dreamcatcher.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by drimcatcher on 07.06.2016.
 */
public interface ClientDao extends JpaRepository<Client, Integer> {

}
