package azalia.app.smartmagazine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.json.JSONArray
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL


class LinkEnterActivity : AppCompatActivity() {

    lateinit var editText: EditText
    lateinit var result: TextView
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_link_enter)

        editText = findViewById(R.id.editText) as EditText
        result = findViewById(R.id.textview) as TextView
        button = findViewById(R.id.analiz) as Button


                button.setOnClickListener {
                    result.text = read_json(editText.text.toString()).toString()
                }


    }



    data class GenreDTO( val name: String)

    val mapper = ObjectMapper().registerKotlinModule()
    var arr = arrayListOf<String>()

    fun read_json(args: String): ArrayList<String> {
        var json : String? = HttpResponses.GetRepositories(editText.text.toString())

            val inputStream: InputStream = assets.open(json.toString())
            json = inputStream.bufferedReader().use {it.readLine()}

            var jsonArray = JSONArray(json)

            for (i in 0..jsonArray.length()-1){
                var jsonobj = jsonArray.getJSONObject(i)
                arr.add(jsonobj.getString("name"))

    }
        return arr
    }}
//    fun main(args: String): MutableList<String> {
//        val content = mutableListOf<String>()
//        val obj: List<GenreDTO> = mapper.readValue(HttpResponses.GetRepositories(editText.text.toString()))
//        obj.forEach {
//            content.add(it.name)
//        }
//        return content
//    }

