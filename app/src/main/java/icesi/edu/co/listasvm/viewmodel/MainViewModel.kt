package icesi.edu.co.listasvm.viewmodel

import android.view.Display.Mode
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import icesi.edu.co.listasvm.PostVH
import icesi.edu.co.listasvm.model.Post

class MainViewModel : ViewModel() {

    var username: MutableLiveData<String> = MutableLiveData("Loading...")

    var postArray = arrayListOf<Post>()
    var postList:MutableLiveData<ArrayList<Post>> = MutableLiveData(postArray)


    fun addPost(username:String, caption:String){
        val post = Post(caption, username, 0)
        postArray.add(post)
        //Notificar a la vista que postList cambió
        postList.value = postArray
    }


    fun changeUsername(newusername:String){
        username.value = newusername
    }

    fun addLike(post: Post) {
        val postIndex = postArray.indexOf(post)
        postArray[postIndex].likes++
        postList.value = postArray
    }

}