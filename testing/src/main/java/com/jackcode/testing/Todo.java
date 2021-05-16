package com.jackcode.testing;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
/**
 * Giả sử chúng ta có một hệ thống quản lý công việc
 */
public class Todo {
    private int id;
    private String title;
    private String detail;
}
