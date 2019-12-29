package br.com.alessanderleite.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.alessanderleite.entities.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

}
