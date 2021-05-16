package com.jackcode.testingtwo;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)

/**
* @DataJpaTest : Anotation này Để test các thao tác với Database, Spring Boot
* @DataJpaTest : có tác dụng khởi tạo các Bean cần thiết cho tầng Repository.
* Ngoài ra, nó không khởi tạo thêm các Bean thừa thãi nào khác. (Chuyên biệt hơn @SpringBootTest)
**/
@DataJpaTest

/**
 * để chuẩn bị dữ liệu cho Test đó là sử dụng annotation @Sql
 * @Sql có tác dụng load một hoặc nhiều file scripts sql lên và thực thi.
 * Để chạy nhiều file sql cùng lúc --> sử dụng @SqlGroup
 */
public class SqlAnnotationTest {
    @Autowired
    private TodoRepository todoRepository;

    @Test
    @Sql("/createTodo.sql")
    public void testTodoRepositoryBySqlSchema() {
        Assertions.assertThat(todoRepository.findAll()).hasSize(2);
        Assertions.assertThat(todoRepository.findById(1).getTitle()).isEqualTo("Todo-1");
    }

}
