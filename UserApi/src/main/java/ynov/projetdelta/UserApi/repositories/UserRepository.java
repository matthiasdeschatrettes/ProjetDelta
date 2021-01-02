package ynov.projetdelta.UserApi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ynov.projetdelta.UserApi.model.User;
import ynov.projetdelta.UserApi.repositories.UserRepository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}