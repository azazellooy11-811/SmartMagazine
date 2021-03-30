package azalia.app.smartmagazine

import java.net.HttpURLConnection
import java.net.URL

public class HttpResponses {

    companion object {

        fun GetRepositories(author: String) :String{
            val url = URL("https://api.github.com/users/$author/repos")
            var result=""
            with(url.openConnection() as HttpURLConnection) {
                requestMethod = "GET" // optional default is GET
               // println("\nSent 'GET' request to URL : $url; Response Code : $responseCode")
                inputStream.bufferedReader().use {
                    it.lines().forEach { line ->
                        result+=line
                    }
                }
            }
            return result
        }


    fun GetCommits(author: String, repositories: Array<String>) {
        val url = URL("https://api.github.com/repos/$author/$repositories/commits?author=$author")

        with(url.openConnection() as HttpURLConnection) {
            requestMethod = "GET" // optional default is GET

            println("\nSent 'GET' request to URL : $url; Response Code : $responseCode")

            inputStream.bufferedReader().use {
                it.lines().forEach { line ->
                    println(line)
                }
            }
        }
    }
 }
}

