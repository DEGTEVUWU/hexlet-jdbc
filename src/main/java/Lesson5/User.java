package Lesson5;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User{
    private Long Id;
    private String name;
    private String phone;

    User(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}
