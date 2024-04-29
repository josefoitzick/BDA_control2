package Task;

import java.util.List;

public interface TaskRepository {
    Task save(Task task);
    List<Task> findAll();
    List<Task> findByUserId(Long userId);
    Task update(Task task);
    void deleteById(Long id);
    Task findById(Long id);

}
