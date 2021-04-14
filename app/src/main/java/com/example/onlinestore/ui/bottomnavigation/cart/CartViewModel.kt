package com.example.onlinestore.ui.bottomnavigation.cart

import android.text.Editable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlinestore.data.local.OnlineStoreDataBase
import com.example.onlinestore.data.test.CartProductListModel
import com.example.onlinestore.data.test.OrderProductListModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CartViewModel(private val db: OnlineStoreDataBase) : ViewModel() {

    fun getData() = db.getCart().getAllObservable()
    val totalSumm = MutableLiveData<Int>()

    fun totalSum(list: List<CartProductListModel>) {
        var summ = 0
        list.forEach {
            val price = it.price?.replace("$", "")
            summ += price?.toInt() ?: 0 * it.count
        }
        totalSumm.postValue(summ)
    }

    fun createOrder(
        statePickup: Boolean,
        stateDelivery: Boolean,
        adress: Editable,
        deliveryData: Editable,
        stateCreditCard: Boolean,
        stateCash: Boolean
    ) {
        val data = OrderProductListModel()
        data.pickup = statePickup.toString()
        data.dilivery = stateDelivery.toString()
        data.adress = adress.toString()
        data.data = deliveryData.toString()
        data.creditCard = stateCreditCard
        data.cash = stateCash.toString()
        data.product = getData().value
        data.totalSum = totalSumm.value


        viewModelScope.launch(Dispatchers.Default) {
            runCatching {
                db.getOrder().insert(data)
            }.onFailure {
            }
        }
    }

    fun deleteItem(it: CartProductListModel) {
        viewModelScope.launch(Dispatchers.Default) {
            runCatching {
                db.getCart().delete(it)
            }.onFailure {
            }
        }
    }
}