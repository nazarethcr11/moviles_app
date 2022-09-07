package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var questions: ArrayList<Question>
    var pos=0
    var points=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadQuestion()
        setupView()
    }

    private fun loadQuestion() {
        questions= ArrayList()


        questions.add(Question("Es lima capital de Peru?",true))
        questions.add(Question("Es el pisco de Chile?",false))
        questions.add(Question("Es callao region de Peru?",true))
        questions.add(Question("Es uruguay pais de latinoamerica?",true))
        questions.add(Question("Es china pais hispanohablante",false))

    }

    private fun setupView(){
        val btYes=findViewById<Button>(R.id.btyes)
        val btNo=findViewById<Button>(R.id.btno)
        val textView=findViewById<TextView>(R.id.tvquestion)
        val btSig=findViewById<Button>(R.id.btSiguiente)
        val textView2=findViewById<TextView>(R.id.tvPointdNumber)


        textView.text=questions[0].sentence
        btSig.setOnClickListener{
            pos++
            if (pos>=questions.size){
                pos=0
            }
            textView.text=questions[pos].sentence
            textView2.text=points.toString()
        }


        btYes.setOnClickListener{
            if (questions[pos].answer==true) {
                Toast.makeText(this, "correcto", Toast.LENGTH_LONG).show()
                points++
            }
            else{
                Toast.makeText(this,"incorrecto", Toast.LENGTH_LONG).show()
            }
        }
        btNo.setOnClickListener{
            if (questions[pos].answer==true) {
                Toast.makeText(this, "Incorrecto", Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(this,"correcto", Toast.LENGTH_LONG).show()
                points++
            }
        }
    }
}