package com.example.onlinestore.data.model

data class SpecsModel(
    val title: String,
    val specs: ArrayList<FeaturesModel>
){
    companion object{
        fun generateMemory() = SpecsModel("Memory", FeaturesModel.generateFeaturesData())
        fun generateDisplay() = SpecsModel("Display", FeaturesModel.generateFeaturesData())
        fun generateCamera() = SpecsModel("Camera", FeaturesModel.generateFeaturesData())
        fun generateOS() = SpecsModel("OS", FeaturesModel.generateFeaturesData())
        fun generateBatteries() = SpecsModel("Batteries", FeaturesModel.generateFeaturesData())
    }
}

data class FeaturesModel(
    val title: String,
    val features: String,
){
    companion object{
        fun generateFeaturesData(): ArrayList<FeaturesModel> {
            val list = arrayListOf<FeaturesModel>()
            list.add(FeaturesModel("RAM", "128 GB"))
            list.add(FeaturesModel("Display technology", "Super AMOLED"))
            list.add(FeaturesModel("Front camera", "Front"))

            return list
        }
    }
}