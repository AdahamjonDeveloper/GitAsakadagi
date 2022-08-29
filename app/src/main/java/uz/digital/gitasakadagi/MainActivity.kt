package uz.digital.gitasakadagi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.digital.gitasakadagi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var tasbeh = 0
        var counter = 0

        if (PrefManager.getCounter(this)!= "0 "){
            counter = PrefManager.getCounter(this).toInt()
            binding.tvCounter.text = counter.toString()

        }

        if (PrefManager.getCaChe(this) != "0") {
            tasbeh = PrefManager.getCaChe(this).toInt()
            binding.tvTasbeh.text = tasbeh.toString()
        }




        binding.btnSanoq.setOnClickListener {

            tasbeh++
            binding.tvTasbeh.text = tasbeh.toString()
            if (tasbeh == 33) {
                counter++
                tasbeh = 0
                binding.tvCounter.text = counter.toString()
                when (binding.tvCounter.text.toString().toInt() % 3) {
                    0 -> {
                        binding.btnSanoq.text = "Subhanalloh"
                    }
                    1 -> {
                        binding.btnSanoq.text = "Alhamdulillah"
                    }
                    2 -> {
                        binding.btnSanoq.text = "Allohu akbar"
                    }
                }
            }

            PrefManager.saveCache(this, binding.tvTasbeh.text.toString())
            PrefManager.saveCounter(this, binding.tvCounter.text.toString())


        }



        binding.delete.setOnClickListener {

            PrefManager.saveCache(this, "0")
            PrefManager.saveCounter(this,"0")
            tasbeh = 0
            counter = 0
            binding.tvCounter.text = counter.toString()
            binding.tvTasbeh.text = tasbeh.toString()
            binding.btnSanoq.text = "SybhanAlloh"
            binding.tvTasbeh.text = "Bismillah"
        }


    }


}
