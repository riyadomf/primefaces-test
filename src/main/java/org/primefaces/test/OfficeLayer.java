package org.primefaces.test;

import lombok.Data;

@Data
public class OfficeLayer {
    private Long id;


    private String name;

    private String nameLocale;

    public OfficeLayer(String name, String nameLocale) {
        this.name = name;
        this.nameLocale = nameLocale;
    }
}
