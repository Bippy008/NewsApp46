package kg.geektech.newsapp46

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kg.geektech.newsapp46.databinding.PagerBoardBinding

class BoardAdapter : RecyclerView.Adapter<BoardAdapter.ViewHolder>() {

    private val titles = arrayOf("Салам", "Привет", "Хелло")
    private val images = arrayOf("https://i.imgur.com/UyDIhV3.png",
        "https://i.imgur.com/WzYLZIf.png",
        "https://i.imgur.com/R5BGJ1a.png")

    inner class ViewHolder(private var binding: PagerBoardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.boardTitle.text = titles[position]
            Glide.with(binding.boardImage).load(images[position]).into(binding.boardImage)
            if (position == titles.size-1) {
                binding.btnStart.visibility = View.VISIBLE
            } else {
                binding.btnStart.visibility = View.GONE
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(PagerBoardBinding.inflate(LayoutInflater.from
            (parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount() = titles.size
}