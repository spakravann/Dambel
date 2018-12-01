package com.faraa.sohrabpakravan.dambel.Models;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class ProgramGroupModel extends ExpandableGroup<ProgramChildModel> {

    private String progress;
    private String title;
    private List<ProgramChildModel> products;


    public ProgramGroupModel(String _progress,String _title, List<ProgramChildModel> _items) {
        super(_title, _items);
        _items = products;
        progress = _progress;
        title = _title;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public String getProgress() {
        return progress;
    }

    public void setProducts(List<ProgramChildModel> products) {
        this.products = products;
    }

    public List<ProgramChildModel> getProducts() {
        return products;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
