package com.example.onlinestore.ui.productsdetails

import com.example.onlinestore.data.model.*

object ModelWrapper {

    fun detailsToCart(details: ProductListModel?, count: Int = 0): CartProductListModel {
        return CartProductListModel(
            id = details?.id,
            title = details?.title,
            full_title = details?.full_title,
            images = details?.images,
            image = details?.image,
            price = details?.price,
            old_price = details?.old_price,
            favorite = details?.favorite,
            description = details?.description,
            specification = details?.specification,
          //  related_product = details?.related_product,
            rank = details?.rank,
            count = count
        )
    }

    fun detailsToRelatedProduct(details: RelatedProductModel?, count: Int = 0): CartProductListModel {
        return CartProductListModel(
         //   id = details?.id,
            title = details?.title,
            full_title = details?.full_title,
            images = details?.images,
            image = details?.image,
            price = details?.priceNew,
            old_price = details?.old_price,
            favorite = details?.favorite,
            description = details?.description,
            specification = details?.specification,
            related_product = null,
            rank = details?.rank,
            count = count
        )
    }
}
