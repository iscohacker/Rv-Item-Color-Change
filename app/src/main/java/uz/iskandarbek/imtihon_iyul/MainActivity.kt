package uz.iskandarbek.imtihon_iyul

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import uz.iskandarbek.imtihon_iyul.Adapter.RvAdapter
import uz.iskandarbek.imtihon_iyul.databinding.ActivityMainBinding
import uz.iskandarbek.imtihon_iyul.models.User

class MainActivity : AppCompatActivity() {
    lateinit var list: ArrayList<User>
    lateinit var RvAdapter: RvAdapter
    private val selectedColors = MutableList(100) { Color.parseColor("#FFFFFF") }// .
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        loadData()

        binding.rv.adapter = RvAdapter(list)
    }

    private fun loadData() {
        list = ArrayList()

        for (i in 0..50) {
            list.add(User(Color.parseColor("#1E88E5")))
        }
    }
}