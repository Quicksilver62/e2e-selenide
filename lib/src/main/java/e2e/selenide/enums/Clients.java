package e2e.selenide.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Clients {

    BELYAEV("67945041665", "1", "Беляев", "Станислав", "Григорьевич"),
    MIKVABIYA("139207069719", "1", "Миквабия", "Людмила", "Багратовна"),
    KHAMATSHIN("33534883660", "1", "Хаматшин", "Дамир", "Ришатович"),
    KHALYAPOVA("33527921451", "1", "Халяпова", "Елена", "Михайловна"),
    ;

    private final String cftId;
    private final String crmId;
    private final String lastName;
    private final String firstName;
    private final String midName;

}
