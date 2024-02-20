package icesi.edu.co.listasvm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import icesi.edu.co.listasvm.databinding.PostLayoutBinding
import icesi.edu.co.listasvm.model.Post

class PostAdapter(var data: ArrayList<Post>) : RecyclerView.Adapter<PostVH>() {

    //Listeners
    var likeButtonAction: ((Post) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_layout, parent, false)
        return PostVH(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: PostVH, position: Int) {
        holder.usernameTV.text = data[position].username
        holder.captionTV.text = data[position].caption
        holder.likeButton.setOnClickListener {
            likeButtonAction?.let {
                it(data[position])
            }
        }
        holder.likescaptionTV.text = "${data[position].likes} likes"
    }


}

class PostVH(root: View) : ViewHolder(root) {
    private val binding = PostLayoutBinding.bind(root)
    val usernameTV = binding.usernameTV
    val captionTV = binding.captionTV
    val likeButton = binding.likeButton
    val likescaptionTV = binding.likescaptionTV
}