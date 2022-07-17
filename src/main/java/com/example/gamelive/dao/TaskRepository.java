package com.example.gamelive.dao;

import com.example.gamelive.model.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query(
            value = "SELECT task.* " +
                    "from task as t " +
                    "where t.user_id = :user_id and " +
                    "t.start_point = :start_point and ",
            nativeQuery = true
    )
    public List<Task> getTasksByUserIdAndStartPoint(
            @Param("user_id") Long userId,
            @Param("start_point") Date startPoint
    );

    @Query(
            value =
                    "update task " +
                            "set isPerfomed = true, " +
                            "lead_time = current_timestamp()" +
                            "where task_id = :task_id",
            nativeQuery = true)
    public void savePerformOfTask(@Param("task_id") Long taskId);
}