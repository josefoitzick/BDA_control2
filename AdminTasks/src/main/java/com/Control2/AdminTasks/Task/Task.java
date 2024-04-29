package com.Control2.AdminTasks.Task;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    private Long id;

    private Long id_usertask;
    String title;
    String description;
    boolean completed;
    LocalDate due_date;

}
