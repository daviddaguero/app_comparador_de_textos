package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.ActivityMainBinding  // Importa tu clase de View Binding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MyCustomViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializa el View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Inicializa el ViewModel
        viewModel = ViewModelProvider(this).get(MyCustomViewModel::class.java)

        // Configura un observador para la propiedad LiveData en el ViewModel
        viewModel.comparisonResult.observe(this, Observer { result ->
            binding.resultTextView.text = result  // Actualiza la vista con el resultado utilizando View Binding
        })

        // Configura un listener para el botón de comparación
        binding.compareButton.setOnClickListener {
            val text1 = binding.editText1.text.toString()
            val text2 = binding.editText2.text.toString()

            // Llama al método en el ViewModel para comparar las cadenas
            viewModel.compareStrings(text1, text2)
        }
    }
}
