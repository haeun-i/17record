package com.example.demo.repository;
import com.example.demo.domain.Artist;
import com.example.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Long>{
	User findById(long id);
	void deleteById(Long id);
	
	@Query(value="select * from User where user_logid = :logid", nativeQuery = true)
    User findbylogid(@Param("logid")String logid);
	
}
