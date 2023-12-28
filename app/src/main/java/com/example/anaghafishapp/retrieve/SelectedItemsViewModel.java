package com.example.anaghafishapp.retrieve;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.anaghafishapp.retrieve.Product;

import java.util.List;

public class SelectedItemsViewModel extends ViewModel {
    private MutableLiveData<List<Product>> selectedItems = new MutableLiveData<>();

    public MutableLiveData<List<Product>> getSelectedItems() {
        return selectedItems;
    }

    public void setSelectedItems(List<Product> items) {
        selectedItems.setValue(items);
    }
}
