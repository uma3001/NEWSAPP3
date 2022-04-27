package com.example.newsapp



class FavoRepositry(private val itemDao: ItemDao) {

    suspend fun insert(dataitem:DataItem){
        itemDao.insert(dataitem)
    }
    suspend fun delete(dataitem:DataItem){
        itemDao.delete(dataitem)
    }
    fun getall(dataitem:DataItem){
        itemDao.getall(dataitem)
    }
}
//val currentnumber:MutableLiveData<Int> by lazy {
//        MutableLiveData<Int>()
//    val allWords: Flow<List<Items>> = itemDao.getAlphabetizedWords()