package org.primefaces.test;

import java.io.Serializable;
import jakarta.faces.view.ViewScoped;

import jakarta.inject.Named;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import org.primefaces.event.data.FilterEvent;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.MatchMode;

import lombok.Data;

@Data
@Named
@ViewScoped
public class OfficeLayerView implements Serializable {
    String globalFilterValue;

    String columnFilterValue;
    List<OfficeLayer> officeLayerList = new ArrayList<>();

    void insertInitialData() {
        officeLayerList.add(new OfficeLayer("Abul", "AbulLocale"));
        officeLayerList.add(new OfficeLayer("Babul", "BabulLocale"));
        officeLayerList.add(new OfficeLayer("Jon", "JonLocale"));
        officeLayerList.add(new OfficeLayer("Don", "DonLocale"));
        officeLayerList.add(new OfficeLayer("Sara", "SaraLocale"));
        officeLayerList.add(new OfficeLayer("Fino", "FinoLocale"));
        officeLayerList.add(new OfficeLayer("Greg", "GregLocale"));
        officeLayerList.add(new OfficeLayer("Hasina", "HasinaLocale"));
        officeLayerList.add(new OfficeLayer("Sherlock", "SherlockLocale"));
        officeLayerList.add(new OfficeLayer("Arya", "AryaLocale"));
        officeLayerList.add(new OfficeLayer("Hound", "HoundLocale"));
        officeLayerList.add(new OfficeLayer("Denerys", "DenerysLocale"));
    }

    public void onLoad() {
        System.out.println("init");
        insertInitialData();
    }

    public void onFilter(FilterEvent event) {
        // update the filterMeta map on Filter event
        Map<String, FilterMeta> filterBy = event.getFilterBy();

        if (columnFilterValue != null) {
            FilterMeta filterMeta = FilterMeta.builder().field("name").filterValue(columnFilterValue)
                    .matchMode(MatchMode.CONTAINS).build();
            event.getFilterBy().put("name", filterMeta);
        }

        // update the globalFilter creatd by inputHidden component.
        if (globalFilterValue != null) {
            filterBy.get(FilterMeta.GLOBAL_FILTER_KEY).setFilterValue(globalFilterValue);
        }

        System.out.println("column filter value: " + columnFilterValue + '\n' + "global filter value: " + globalFilterValue);
        System.out.println(filterBy);
    }

}