package com.example.appfordisplaying.view.viewModels

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appfordisplaying.view.database.ItemDatabase
import com.example.appfordisplaying.view.repository.ListUseCase
import com.example.appfordisplaying.view.models.Item
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FragmentViewModel(private val listUseCase: ListUseCase, application: Application) :
    ViewModel() {
    private val _itemList = MutableLiveData<List<Item>>()
    val itemList: LiveData<List<Item>> = _itemList

    fun loadItemList() {
        viewModelScope.launch {
            try {
                _itemList.value = listUseCase.loadItemList()
                getAllUsers()
            } catch (e: Exception) {
                if (database.listEmpty() != null) {
                    getAllUsers()
                } else {
                    _itemList.value = listOf(Item("no connection: ${e.message}", ""))
                }
            }
        }
    }

    private val database = ItemDatabase.getInstance(application).itemDatabaseDao

    private fun getAllUsers() {
        viewModelScope.launch(Dispatchers.Main) {
            if (database.listEmpty() == null) {
                for (itemOne in itemList.value!!) {
                    database.insert(itemOne)
                }
            }
            _itemList.value = database.getAllItems()
        }
    }

    private fun deleteUser(item: Item) {
        viewModelScope.launch(Dispatchers.Main) {
            database.delete(item)
        }
    }
}