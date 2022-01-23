package net.n_nichidai

import com.mongodb.client.MongoClient
import com.mongodb.client.MongoDatabase
import org.litote.kmongo.KMongo
import org.litote.kmongo.getCollection
import java.util.*

data class paper(var id: String, var date: Date, var title: String, var url: String, var thumbnail: String)
data class link(var id: String, var title: String, var url: String)
data class category(var id: String, var name: String)
data class article(var id: String, var date: Date, var title: String, var body: String, var category: category, var tags: List<tag>)
data class tag(var id: String, var name: String)
data class commentArticle(var id: String, var articleId: String, var name: String, var body: String)
data class column(var id: String, var title: String, var body: String, var comment: String)
data class commentColumn(var id: String, var columnId: String, var name: String, var body: String)
data class writer(var id: String, var name: String, var uname: String, var password: String, var email: String, var body: String)

class MonDB {
    var client: MongoClient? = null
    var database: MongoDatabase? = null

    init {
        try {
            this.client = KMongo.createClient("mongodb+srv://mizofumi:qma2HZT@cyv@myu3yvg@cluster0.f8urx.mongodb.net/NNPBroadCast?retryWrites=true&w=majority")
            this.database =  client!!.getDatabase("NNPBroadCast")
        } catch (e: Exception) {
            throw RuntimeException("DB Connection Failed...")
        }
    }

    fun insertArticle(article: article) {
        database!!.getCollection<article>().insertOne(article)
    }

    fun insertColumn(column: column) {
        database!!.getCollection<column>().insertOne(column)
    }

    fun close() {
        client!!.close()
    }

}