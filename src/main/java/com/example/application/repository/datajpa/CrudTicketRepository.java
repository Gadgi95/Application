package com.example.application.repository.datajpa;

import com.example.application.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
@Transactional(readOnly = true)
public interface CrudTicketRepository extends JpaRepository<Ticket, Integer> {

//    @Modifying
//    @Query("INSERT INTO Ticket (user_id, name, status) SELECT tt.user_id, tt.name, tt.status FROM TicketTo tt")
//    Ticket save(Ticket entity);

    @Query("SELECT t FROM Ticket t WHERE t.user.id=:userId ORDER BY t.creationDate DESC")
    List<Ticket> getAll(@Param("userId") int userId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Ticket t WHERE t.id=:id AND t.user.id=:user_id")
    int delete(@Param("id") int id, @Param("user_id") int user_id);

    @Modifying
    @Transactional
    @Query("DELETE FROM Ticket t WHERE t.id=:id")
    int deleteForAdmin(@Param("id") int id);

    @Query("SELECT t FROM Ticket t WHERE t.id=:id")
    Ticket findById(@Param("id") int id);

    @Query("SELECT t from Ticket t WHERE t.user.id=:userId AND t.creationDate >= :startDate AND t.creationDate < :endDate ORDER BY t.creationDate DESC")
    List<Ticket> getBetweenHalfOpen(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate, @Param("userId") int userId);

//    @EntityGraph(attributePaths = {"tickets_materials"}, type = EntityGraph.EntityGraphType.LOAD)
//    @Query("SELECT t FROM Ticket t INNER JOIN t.materials m WHERE t.id=:id AND t.user.id=:userId AND t.id=m.ticket.id")
//    Ticket getWithMaterial(@Param("id") int id, @Param("userId") int userId, List<Material> materialList);
}
