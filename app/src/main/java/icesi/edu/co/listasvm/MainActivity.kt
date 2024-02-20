package icesi.edu.co.listasvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import icesi.edu.co.listasvm.databinding.ActivityMainBinding
import icesi.edu.co.listasvm.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    val viewModel: MainViewModel by viewModels()
    val adapter = PostAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.recycler.setHasFixedSize(true)
        binding.recycler.layoutManager = LinearLayoutManager(this)
        binding.recycler.adapter = adapter
        adapter.likeButtonAction = { post ->
            viewModel.addLike(post)
        }


        viewModel.username.observe(this) { username ->
            binding.textView.text = username
        }

        //Prohibido
        //binding.textView.text = viewModel.username.value
        viewModel.postList.observe(this) { posts ->
            adapter.data = posts
            adapter.notifyDataSetChanged()
        }

        binding.button.setOnClickListener {
            viewModel.changeUsername("@domic0620")
            viewModel.addPost("@domic0620", "Lorem ipsum asdasd asd asd asd as da das das d")
        }

    }
}