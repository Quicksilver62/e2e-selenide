package e2e.selenide.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Users {

    CM_USER11("cm_user11", "Password#30", "Пушкин Александр Сергеевич"),
    CM_USER12("cm_user12", "Password#31", "Лермонтов Юрий Михайлович"),
    CM_USER2("cm_user2", "1", "Клиентский Менеджер Два")
    ;

    private final String username;
    private final String password;
    private final String description;

}
